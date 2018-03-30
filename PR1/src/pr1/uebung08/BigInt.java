package pr1.uebung08;

import static pr.MakeItSimple.*;

public class BigInt {
	private int[] field;

	public BigInt(String number) {
		// Check if number is not an empty String;
		if (number.equals("")) {
			throw new PRException("The String is not empty");
		}

		// Check if String contains anything else then numbers;
		for (int i = 0; i < number.length(); i++) {
			if (number.charAt(i) < '0' || number.charAt(i) > '9') {
				throw new PRException("The String is not a valid number");
			}
		}

		// Check for leading 0's;
		boolean leading0 = true;
		int zeroCount = 0;

		for (int i = 0; i < number.length() && leading0; i++) {
			if (number.charAt(i) != '0') {
				// Stops the loop when it finds number > 0;
				leading0 = false;
			}
			else {
				// If 0 is found numberStart incriments;
				zeroCount++;
			}
		}

		// If only number is 0
		if (number.length() - zeroCount == 0) {
			field = new int[1];
			field[0] = 0;
		}
		else {
			// Count digits;
			field = new int[number.length() - zeroCount];

			// Saves digits in an array
			for (int i = 0 + zeroCount; i < number.length(); i++) {
				// the 48 is used to turn the char into the actual number;
				field[i - zeroCount] = number.charAt(i) - 48;
			}
		}
	}

	public int length() {
		return this.field.length;
	}

	public void add(BigInt number) {
		// assignes the fields new names so its easier to distinguish;
		int[] longerNumber;
		int[] shorterNumber;
		int longerLength;
		int shorterLength;

		// if This number is bigger;

		// If this number is longer
		if (this.field.length > number.field.length) {
			longerNumber = this.field;
			shorterNumber = number.field;
			longerLength = this.field.length;
			shorterLength = number.field.length;
		}
		// If other number is longer
		else if (this.field.length < number.field.length) {
			longerNumber = number.field;
			shorterNumber = this.field;
			longerLength = number.field.length;
			shorterLength = this.field.length;
		}
		// If they are the same doesnt matter
		else {
			longerNumber = this.field;
			shorterNumber = number.field;
			longerLength = this.field.length;
			shorterLength = number.field.length;
		}
		// new Array with size of bigger array +1
		int boxes = longerLength + 1;
		int[] newNumber = new int[boxes];

		for (int i = boxes - 1; i > 0; i--) {
			// while both numbers still have digits to add
			if (shorterLength >= 1 && longerLength >= 1) {
				if (newNumber[i] + longerNumber[longerLength - 1] + shorterNumber[shorterLength - 1] > 9) {
					newNumber[i] = (newNumber[i] + longerNumber[longerLength - 1] + shorterNumber[shorterLength - 1])
							% 10;
					newNumber[i - 1] += 1;
				}
				else {
					newNumber[i] = newNumber[i] + longerNumber[longerLength - 1] + shorterNumber[shorterLength - 1];
				}
			}
			// when the shorter number's digits run out;
			else {
				if (newNumber[i] + longerNumber[longerLength - 1] > 9) {
					// puts the leftover digit at the current position
					newNumber[i] = (newNumber[i] + longerNumber[longerLength - 1]) % 10;
					// puts the exces number 1 position infront
					newNumber[i - 1] += 1;
				}
				else {
					newNumber[i] = newNumber[i] + longerNumber[longerLength - 1];
				}
			}

			longerLength--;
			shorterLength--;
		}
		// If the first position of out new number is 0;
		if (newNumber[0] == 0 && newNumber.length > 1) {
			int[] newerNumber = new int[newNumber.length - 1];
			// Copy everything into a new array exept it;
			for (int i = 0; i < newerNumber.length; i++) {
				newerNumber[i] = newNumber[i + 1];
			}
			this.field = newerNumber;
		}
		else if (newNumber[0] > 0 || newNumber.length == 1) {
			this.field = newNumber;
		}
	}

	/**
	 * @return - the BigInt as an array;
	 */
	public int[] getDigits() {
		int[] gottenDigits = new int[field.length];
		for (int i = 0; i < gottenDigits.length; i++) {
			gottenDigits[i] = field[i];
		}
		return gottenDigits;
	}

	/**
	 * Returns the BigInt as a Strting
	 */
	@Override
	public String toString() {
		String numberToString = "";
		for (int i = 0; i < field.length; i++) {
			numberToString += field[i];
		}
		return numberToString;

	}

	/**
	 * Compares the two BigInt's
	 * 
	 * @param number
	 *            - A big Int ;
	 * @return True if they are equal false if not;
	 */
	public boolean equals(BigInt number) {
		if (number.length() != this.length()) {
			return false;
		}
		else {
			for (int i = 0; i < number.field.length; i++) {
				if (this.field[i] == number.field[i] && i == number.length() - 1) {
					return true;
				}
				else if (this.field[i] != number.field[i]) {
					return false;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {

		int choice = 0;
		do {
			System.out.println("Geben Sie eine function ein: \n" + "1 - zahl Ausgeben; \n"
					+ "2 - Zahl an einer bestimmten postion ausgeben; \n" + "3 - Laenge der zahl ausgeben \n"
					+ "4 - Vergleiche 2 zahlen \n" + "5 - Addieren von 2 Zahlen \n" + "6 - Verlassen des programms \n");
			choice = readInt();
			if (choice == 1) {
				System.out.println("Geben sie eure zahl ein: ");
				BigInt zahl = new BigInt(readString());
				System.out.println(zahl.toString());

			}
			else if (choice == 2) {
				System.out.println("Geben sie eure zahl ein: ");
				BigInt zahl = new BigInt(readString());
				System.out.println("Geben sie die position ein: ");
				int position = readInt();
				System.out.println(zahl.getDigits()[position]);
			}
			else if (choice == 3) {
				System.out.println("Geben sie eure zahl ein: ");
				BigInt zahl = new BigInt(readString());
				System.out.println(zahl.length());
			}
			else if (choice == 4) {
				System.out.println("Geben sie eure zahl ein: ");
				BigInt zahl1 = new BigInt(readString());
				System.out.println("Geben sie eure zahl zum vergleichen ein");
				BigInt zahl2 = new BigInt(readString());
				boolean sindGleich = zahl1.equals(zahl2);
				if (sindGleich) {
					System.out.println("Die Zahlen sind gleich!");
				}
				else {
					System.out.println("Die Zahlen sind vershieden!");
				}
			}
			else if (choice == 5) {
				System.out.println("Geben sie eure zahl ein: ");
				BigInt zahl1 = new BigInt(readString());
				System.out.println("Geben sie eure zahl zum addieren ein: ");
				BigInt zahl2 = new BigInt(readString());
				zahl1.add(zahl2);
				System.out.println(zahl1.toString());
			}
		} while (choice != 6);
	}

}
