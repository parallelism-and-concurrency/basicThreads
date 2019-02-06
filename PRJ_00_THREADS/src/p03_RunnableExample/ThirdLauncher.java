package p03_RunnableExample;

public class ThirdLauncher {
	
	public static void main (String [] args) {
		
		Thread a, b, c;
		
		System.out.println("Main starts here");
        System.out.println("\nAvailable processors: "+
                           Runtime.getRuntime().availableProcessors());
        System.out.println();
		
		a = new Thread(new RunnablePrimeCalculator("A", 100000));
		b = new Thread(new RunnablePrimeCalculator("   B", 100000));
		c = new Thread(new RunnablePrimeCalculator("      C", 100000));
		
		a.start(); 
		b.start();
		c.start();
		
		// wait until all three threads have finished their work
		try {
			a.join(); b.join(); c.join();
		}
		catch(InterruptedException ex) {};
		
		System.out.println("\nAll threads done");
		System.out.println("Main ends here");
	}

}
