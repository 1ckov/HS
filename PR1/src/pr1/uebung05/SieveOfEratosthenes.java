package pr1.uebung05;

import static pr.MakeItSimple.print;
import static pr.MakeItSimple.println;
import static pr.MakeItSimple.readInt;

import pr.MakeItSimple.PRException;

public class SieveOfEratosthenes {

	static boolean[] calculatePrimes(int number) {
		boolean[] primeChecker = new boolean[number + 1];

		// Setzt alle Elemente der Array auser die 2 ersten auf true
		for (int position = 2; position < primeChecker.length; position++)
			primeChecker[position] = true;

		/*
		 * Der erste loop sorgt dafür dass die teiler nicht Wurzel n
		 * Überschreiten
		 */
		for (int divider = 2; divider <= (int) Math.sqrt(number); divider++) {
			// Der if hier sorgt das wir keine nicht primar zahlen als teiler
			// nehmen
			if (primeChecker[divider]) {
				for (int powerOf = (int) Math.pow(divider, 2); powerOf <= number; powerOf += divider) {
					if (powerOf % divider == 0)
						primeChecker[powerOf] = false;
				}
			}
		}

		return primeChecker;
	}

	public static void main(String[] args) {
		int number = 0;
		println("Bitte geben sie eine Zahl Grosser als 2 ein");
		number = readInt();
		if (number < 2)
			throw new PRException("Die eingegebene zahl ist kleiner als 2 also ist die keine Primzahl" + number);
		boolean[] primeNumbers = calculatePrimes(number);
		for (int counter = 0; counter < primeNumbers.length; counter++) {
			if (primeNumbers[counter] == true) {
				print(counter + ": ");
				println(primeNumbers[counter]);
			}
		}

	}

}
