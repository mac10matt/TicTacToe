import javax.swing.SwingUtilities;

/*
 * Programmed by: Matthew Misenheimer
 */


public class Main {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new TicTacToeGUI();
			}
		});
	}
}
