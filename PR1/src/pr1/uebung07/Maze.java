package pr1.uebung07;

import static pr.MakeItSimple.print;
import static pr.MakeItSimple.println;

public class Maze {
	static int lastKnownR = 0;
	static int lastKnownC = 0;

	/**
	 * 
	 * @param field
	 */
	static void findWay(char[][] field) {
		boolean entranceFound = false;
		int startingRow = 0;
		int startingColumn = 0;
		// sucht nach dem eingang
		for (int positionRow = 0; positionRow < field.length && entranceFound == false; positionRow++) {
			for (int positionColumn = 0; positionColumn < field[positionRow].length
					&& entranceFound == false; positionColumn++) {
				if (field[positionRow][positionColumn] == 'S') {
					entranceFound = true;
					startingRow = positionRow;
					startingColumn = positionColumn;
				}
			}
		}
		findWayRecursive(field, startingRow, startingColumn);
	}

	static boolean findWayRecursive(char[][] field, int row, int col) {
		// Speichere den wert meiner statichen variablen local
		int lastKnownI = lastKnownR;
		int lastKnownY = lastKnownC;
		// falls wir den eingang gefunden haben
		if ((field.length - 1 == row || row == 0 || field[row].length - 1 == col || col == 0)
				&& field[row][col] != 'S') {
			if (field[row][col] == ' ') {
				println("row = " + row + "; col = " + col);
				field[row][col] = 'E';
				return true;
			}
		}
		// falls wir am anfang sind oder in einem lehren feld
		if (field[row][col] == ' ' || field[row][col] == 'S') {

			if (row + 1 < field.length && field[row + 1][col] == ' ' && (row + 1 != lastKnownI)) { // laeuft
																									// 1
																									// nach
																									// unten
				lastKnownR = row;
				lastKnownC = col;

				if (findWayRecursive(field, row + 1, col)) {
					field[row][col] = '.';
					return true;
				}
			}
			if (col + 1 < field[row].length && field[row][col + 1] == ' ' && (col + 1 != lastKnownY)) {// laeuft
																										// 1
																										// nach
																										// rechts
				lastKnownC = col;
				lastKnownR = row;

				if (findWayRecursive(field, row, col + 1)) {
					field[row][col] = '.';
					return true;
				}
			}
			if (row - 1 >= 0 && field[row - 1][col] == ' ' && (row - 1 != lastKnownI)) { // laeuft
																							// 1
																							// nach
																							// unten
				lastKnownR = row;
				lastKnownC = col;

				if (findWayRecursive(field, row - 1, col)) {
					field[row][col] = '.';
					return true;
				}

			}
			if (col - 1 >= 0 && field[row][col - 1] == ' ' && (col - 1 != lastKnownY)) { // laeuft
																							// 1
																							// nach
																							// links
				lastKnownR = row;
				lastKnownC = col;

				if (findWayRecursive(field, row, col - 1)) {
					field[row][col] = '.';
					return true;
				}

			}
		}
		return false;
	}

	public static void main(String[] args) {
		// println("Geben sie die Anzahl der Spalten an: ");
		// int columns = readInt();
		// println("Geben sie die Anzahl der Reihen an: ");
		// int rows = readInt();

		char[][] maze = { { '*', '*', '*', '*', '*', '*', '*', '*' }, { '*', '*', '*', '*', '*', '*', '*', '*' },
				{ '*', ' ', ' ', ' ', ' ', ' ', ' ', ' ' }, { '*', '*', ' ', '*', '*', '*', '*', '*' },
				{ '*', '*', ' ', ' ', ' ', '*', ' ', '*' }, { 'S', ' ', ' ', '*', ' ', ' ', ' ', '*' },
				{ '*', '*', '*', '*', '*', '*', '*', '*' } };
		findWay(maze);
		for (int row = 0; row < maze.length; row++) {
			for (int col = 0; col < maze[row].length; col++) {
				print(maze[row][col] + "\t");

			}
			println("");
		}
	}

}
