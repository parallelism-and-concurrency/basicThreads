package e2_mpp_AtomicBooleans;

import java.util.concurrent.atomic.AtomicBoolean;

public class MPP_AB {

private static boolean canPing = true, canPong = false;

public static void main (String [] args) throws InterruptedException {
		
		/* COMPLETE */

		AtomicBoolean shared = new AtomicBoolean(canPing);

		Ping []thePings = new Ping[10];
		Pong []thePongs = new Pong[10];

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
	
	/* COMPLETE */
	private int id;
	private AtomicBoolean shared;

	public Ping(int id, AtomicBoolean shared) {
		this.id = id;
		this.shared = shared;
	}

	public void run ()  {
		/* COMPLETE */

		while(true) {
			while(!shared.compareAndSet(true, false)) {
				Thread.yield();
			}
			System.out.print("PING(" + id + ")  ");
			shared.set(true);
		}

	}
}

class Pong extends Thread {
	
	/* COMPLETE */

	private int id;
	private AtomicBoolean shared;

	public Pong(int id, AtomicBoolean shared) {
		this.id = id;
		this.shared = shared;
	}

	public void run () {
		/* COMPLETE */
		while(true) {
			while(!shared.compareAndSet(true, false)) {
				Thread.yield();
			}
			System.out.println("PONG(" + id + ")  ");
			shared.set(true);
		}
	}
}