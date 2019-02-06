package p04_GUIExample;

import java.awt.*;
import javax.swing.JTextArea;

public class DisplayPrimeCalculator extends Thread {
	// when run, compute prime numbers up to limit

	private int limit;
	private JTextArea display; // these threads have a display of their own

	public DisplayPrimeCalculator(JTextArea display, int limit) {
		this.limit = limit;
		this.display = display;
	}

	@Override
	public void run() {
		for (int i = 2; i <= limit; i++) {
			if (isPrime(i)) {
				final int val = i;
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						display.append(val + "\n");
						// force scroll down so that movement is apparent
						display.setCaretPosition(display.getDocument().getLength());
					}
				});
			}
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				display.append("  DONE !!!");
			}
		});

	}

	private boolean isPrime(int num) {
		for (int factor = 2; factor <= num / 2; factor++) {
			if (num % factor == 0) {
				return false;
			}
		}
		return true;
	}
}
