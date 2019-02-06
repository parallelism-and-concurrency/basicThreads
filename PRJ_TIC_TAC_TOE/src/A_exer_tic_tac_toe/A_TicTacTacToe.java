package A_exer_tic_tac_toe;

public class A_TicTacTacToe {
	
	public static void main (String [] args)  {	
		
		/* COMPLETE */
		Shared shared = new Shared();
		Tic tic = new Tic(shared);
		Tac tac = new Tac(shared);
		Toe toe = new Toe(shared);

		tic.start();
		tac.start();
		toe.start();

		try{
			Thread.sleep(5000);
		}
		catch (InterruptedException ie) {}

		tic.stop();
		tac.stop();
		toe.stop();
	}
}

class Shared {
	 /*
	 ...an object that encapsulates three boolean attributes (they may be public) 
	 and nothing more
	 */
	 public boolean ticCanPrint = true;
	 public boolean isTicCanPr

}

class Tic extends Thread {
	// endlessly prints TIC-
	
	private Shared sharedObject;
	
	/* COMPLETE */
}

class Tac extends Thread {
	// endlessly prints TAC (and tac)
	
	private Shared sharedObject;
	// anything else? 
	
	/* COMPLETE */
	
}

class Toe extends Thread {
	// endlessly prints -TOE
	
	private Shared sharedObject;
	
	/* COMPLETE */
	
}

