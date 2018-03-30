package pr1.uebung04;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TicTacToe extends JFrame {

	private static final String EMPTY  = "";
	private static final String CROSS  = "X";
	private static final String CIRCLE = "O";
	private String currentSymbol = CROSS;
	private JButton[][] fields;

	TicTacToe() {
		super("Tic Tac Toe");
		setLayout(new GridLayout(3, 3));
		fields = new JButton[3][3];
		for (int row = 0; row < fields.length; row++) {
			for (int col = 0; col < fields[row].length; col++) {
				fields[row][col] = new JButton(EMPTY);
				fields[row][col].setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 36));
				fields[row][col].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						((JButton) e.getSource()).setText(currentSymbol);
						if (success(fields[0][0].getText(), fields[0][1].getText(), fields[0][2].getText(), fields[1][0].getText(), fields[1][1].getText(), fields[1][2].getText(), fields[2][0].getText(), fields[2][1].getText(), fields[2][2].getText())) {
							JOptionPane.showMessageDialog(TicTacToe.this, "Spieler '" + currentSymbol + "' hat gewonnen", "Gewonnen!", JOptionPane.INFORMATION_MESSAGE);
							System.exit(0);
						} else if (draw(fields[0][0].getText(), fields[0][1].getText(), fields[0][2].getText(), fields[1][0].getText(), fields[1][1].getText(), fields[1][2].getText(), fields[2][0].getText(), fields[2][1].getText(), fields[2][2].getText())) {
							JOptionPane.showMessageDialog(TicTacToe.this, "Das Spiel endete leider unentschieden", "Unentschieden!", JOptionPane.INFORMATION_MESSAGE);
							System.exit(0);
						} else {
							toggleSymbol();
						}
					}
				});
				add(fields[row][col]);
			}
		}

		setSize(300, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	void toggleSymbol () {
		if (currentSymbol.equals(CROSS))
			currentSymbol = CIRCLE;
		else
			currentSymbol = CROSS;
	}

	static boolean success(String topLeft, String topCenter, String topRight, String middleLeft, String middleCenter, String middleRight, String bottomLeft, String bottomCenter, String bottomRight) {
		if((topLeft == topRight && topLeft != EMPTY && topLeft == topCenter) || (topLeft == middleLeft && bottomLeft != EMPTY && topLeft == bottomLeft )||
				(topLeft == middleCenter && topLeft!=EMPTY && topLeft==bottomRight) || (middleLeft == middleCenter && middleLeft!= EMPTY && middleLeft == middleRight) ||
				(bottomLeft == middleCenter && bottomLeft != EMPTY && bottomLeft == topRight )|| (bottomLeft == bottomCenter && bottomCenter!= EMPTY && bottomLeft == bottomRight)||
				(topCenter == middleCenter && middleCenter != EMPTY && topCenter == bottomCenter) || (topRight == middleRight && bottomRight!= EMPTY && topRight == bottomRight)) {
			return true;
		}
		return false;
	}
	/*static boolean success(String topLeft, String topCenter, String topRight, String middleLeft, String middleCenter, String middleRight, String bottomLeft, String bottomCenter, String bottomRight) {
		String[][] board = {
				{topLeft, topCenter, topRight},
				{middleLeft, middleCenter, middleRight},
				{bottomLeft, bottomCenter, bottomRight}};

		//uberprüft spalten und reihen
		for(int i = 0; i < 3; i++) {
			if(board[0][i] == board [1][i] && board[0][i] == board[2][i] && board[0][i] != EMPTY) {
				return true;
			}
			if(board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] != EMPTY) {
				return true;
			}
		}

		//uberprüft die diagonale

		int symbolTopLeftCounter = 0;
		int symbolTopRightCounter = 0;
		for(int i = 1; i < 3; i++) {
			if(topLeft!=EMPTY && board[i][i] == topLeft) {
				symbolTopLeftCounter++;
			}

			if(topRight!= EMPTY && board[i][2 - i] == topRight) {
				symbolTopRightCounter++;
			}
		}

		if(symbolTopLeftCounter == 2 || symbolTopRightCounter == 2) {
			return true;
		}

		return false;
	}*/

	static boolean draw(String topLeft, String topCenter, String topRight, String middleLeft, String middleCenter, String middleRight, String bottomLeft, String bottomCenter, String bottomRight) {
		String[] field = {topLeft, topCenter ,topRight ,middleLeft ,middleCenter ,middleRight ,bottomLeft ,bottomRight ,bottomCenter};
		for(int i=0 ;i<9 ;i++){
			if(field[i]==EMPTY){
				return false;
			}
		}
		if(!success(topLeft,topCenter,topRight,middleLeft,middleCenter,middleRight,bottomLeft,bottomCenter,bottomRight)){
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		new TicTacToe().setVisible(true);
	}

}