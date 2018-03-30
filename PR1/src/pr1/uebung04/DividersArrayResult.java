package pr1.uebung04;

import static pr.MakeItSimple.print;
import static pr.MakeItSimple.println;
import static pr.MakeItSimple.readInt;

import pr.MakeItSimple.PRException;

public class DividersArrayResult {
	/**
	 * Determines the deviders of the given number.
	 * 
	 * @param i
	 *            - The number which dividers are supposed to be found.
	 * @return Array with the dividers of the given number.
	 */
	static int[] calculateDividers(int i) {
		
		int[] dividers = new int[500];
		int counter = 0;
		
		for (int divider = 1; divider <= i; divider++) {
			if (i % divider == 0) {
				dividers[counter] = divider;
				counter++;
			}
		}
		
		return dividers;
	}
	/**
	 * 
	 * @param yourNumber - Your number.
	 * @return true or false depending on if your number is a prime number or not.
	 */
	static boolean isPrime(int yourNumber) {
		boolean prime = true;
		for (int divider = 2; divider <= Math.sqrt(yourNumber); divider++) {
			if (yourNumber % divider == 0)
				prime = false;
		}
		return prime;
	}

	public static void main(String[] args) {
		int number = 0;
		println("Geben sie eine beliebige natürliche zahl ein");
		number = readInt();

		println(isPrime(number));

		if (number <= 0) {
			throw new PRException("Ungültige ausgabe " + number);
		}
		else if (number > 0) {
			int[] dividers = calculateDividers(number);

			// Hier printen wir die Werte großer als 0 aus der Array raus.
			for (int i = 0; i < dividers.length && dividers[i] > 0; i++) {
				print(dividers[i] + " ");
			}
		}
	}
}