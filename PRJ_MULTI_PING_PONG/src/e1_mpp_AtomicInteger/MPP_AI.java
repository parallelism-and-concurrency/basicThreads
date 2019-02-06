package e1_mpp_AtomicInteger;

import java.util.concurrent.atomic.AtomicInteger;


public class MPP_AI {

	public static final int CAN_PING = 1; // use this value to indicate that "one thread can ping" 
	public static final int CAN_PONG = 2; // use this value to indicate that "one thread can pong"
	public static final int WRITING = 3; // use this value to indicate that "one thread is writing something"
	
	public static void main (String [] args) throws InterruptedException {
		
		AtomicInteger shared;

		/* COMPLETE */

		shared = new AtomicInteger(CAN_PING);

		Ping [] thePings = new Ping[10];
		Pong [] thePongs = new Pong[10];
		
		for (int i=0; i<thePings.length; i++) {
			thePings[i] = new Ping(i, shared);
			thePongs[i] = new Pong(i, shared);
			thePings[i].start();
			thePongs[i].start();
		}
		
		Thread.sleep(5000);
		
		for (int i=0; i<thePings.length; i++) {
			thePings[i].stop();
			thePongs[i].stop();
		}
		
	}
	
}

class Ping extends Thread {
	
	private int id;
	private AtomicInteger shared;
	
	public Ping (int id, AtomicInteger shared) {
		this.id = id;
		this.shared = shared;
	}
	
	public void run ()  {
		while (true) {
			/* COMPLETE */
			while(!shared.compareAndSet(1,3)) {
				Thread.yield();
			}
			System.out.print("PING(" + id + ")  ");
			shared.set(MPP_AI.CAN_PONG);
		}
	}
	
}

class Pong extends Thread {
	
	private int id;
	private AtomicInteger shared;
	
	public Pong (int id, AtomicInteger shared) {
		this.id = id;
		this.shared = shared;
	}
	/* COMPLETE */

	public void run ()  {
		while (true) {
			/* COMPLETE */
			while(!shared.compareAndSet(2,3)) {
				Thread.yield();
			}
			System.out.println("PONG(" + id + ")");
			shared.set(MPP_AI.CAN_PING);
		}
	}

}