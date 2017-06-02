import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class TicTacToeGUI extends JFrame {
	private Container pane;
	private String currentPlayer;
	private JButton[][] board;
	private boolean hasWinner;
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem quit;
	private JMenuItem newGame;

	// sets up tic tac toe board GUI with all it's features

	public TicTacToeGUI() {
		super();
		pane = getContentPane();
		pane.setLayout(new GridLayout(3, 3));
		setTitle("Tic Tac Toe");
		setSize(750, 750);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		currentPlayer = "X";
		board = new JButton[3][3];
		hasWinner = false;
		initializeBoard();
		initializeMenuBar();

	}

	// Initializes the menu bar with options to quit or begin a new game

	private void initializeMenuBar() {
		menuBar = new JMenuBar();
		menu = new JMenu("File");

		newGame = new JMenuItem("New Game");
		newGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetBoard();
			}
		});
		quit = new JMenuItem("Quit");
		quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		menu.add(newGame);
		menu.add(quit);
		menuBar.add(menu);
		setJMenuBar(menuBar);
	}

	// resets board when a new game is started initializes player X to begin

	private void resetBoard() {
		currentPlayer = "X";
		hasWinner = false;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j].setText("");
				;
			}
		}
	}

	// initializes the board for the game

	private void initializeBoard() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				JButton btn = new JButton();
				btn.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 100));
				board[i][j] = btn;
				btn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (((JButton) e.getSource()).getText().equals("") && hasWinner == false) {
							btn.setText(currentPlayer);
							hasWinner();
							togglePlayer();
						}
					}
				});
				pane.add(btn);
			}
		}
	}

	// if players 'X' goes toggles to 'O' turn if 'O' goes toggles to 'X' turn

	private void togglePlayer() {
		if (currentPlayer.equals("X"))
			currentPlayer = "O";
		else
			currentPlayer = "X";

	}

	// checks if a player has won vertically, horizontally, or diagonally

	private void hasWinner() {
		if (board[0][0].getText().equals(currentPlayer) && board[1][0].getText().equals(currentPlayer)
				&& board[2][0].getText().equals(currentPlayer)) {
			JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won vertically");
			hasWinner = true;
		} else if (board[0][1].getText().equals(currentPlayer) && board[1][1].getText().equals(currentPlayer)
				&& board[2][1].getText().equals(currentPlayer)) {
			JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won vertically");
			hasWinner = true;
		} else if (board[0][2].getText().equals(currentPlayer) && board[1][2].getText().equals(currentPlayer)
				&& board[2][2].getText().equals(currentPlayer)) {
			JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won vertically");
			hasWinner = true;
		} else if (board[0][0].getText().equals(currentPlayer) && board[0][1].getText().equals(currentPlayer)
				&& board[0][2].getText().equals(currentPlayer)) {
			JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won horizontally");
			hasWinner = true;
		} else if (board[1][0].getText().equals(currentPlayer) && board[1][1].getText().equals(currentPlayer)
				&& board[1][2].getText().equals(currentPlayer)) {
			JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won horizontally");
			hasWinner = true;
		} else if (board[2][0].getText().equals(currentPlayer) && board[2][1].getText().equals(currentPlayer)
				&& board[2][2].getText().equals(currentPlayer)) {
			JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won horizontally");
			hasWinner = true;
		} else if (board[0][0].getText().equals(currentPlayer) && board[1][1].getText().equals(currentPlayer)
				&& board[2][2].getText().equals(currentPlayer)) {
			JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won diagonally");
			hasWinner = true;
		} else if (board[2][0].getText().equals(currentPlayer) && board[1][1].getText().equals(currentPlayer)
				&& board[0][2].getText().equals(currentPlayer)) {
			JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won diagonally");
			hasWinner = true;
		}
	}
}
