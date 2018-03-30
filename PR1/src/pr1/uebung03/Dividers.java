package pr1.uebung03;

import static pr.MakeItSimple.print;
import static pr.MakeItSimple.println;
import static pr.MakeItSimple.readInt;

import pr.MakeItSimple.PRException;

/**
 * Finds all deviders of a given number;
 * 
 * @author Aleksandar
 *
 */
public class Dividers {

	public static void main(String[] args) {
		int zahl;
		println("Bitte eine x-beliebige ganze Zahl eingeben: ");
		zahl = readInt();

		int ergebniss;
		int zehler = zahl;

		// Number bigger 0
		System.out.print("Die teiler Der zahl " + zehler + " sind: ");
		if (zahl > 0) {
			// While zehler bigger 0
			while (zehler > 0) {
				// if modulo is 0
				ergebniss = zahl % zehler;
				// print number to console
				if (ergebniss == 0) {
					print(zehler + " ");
				}
				zehler--;
			}
		}
		else if (zahl <= 0) {
			throw new PRException("Ungültige Zahl eingegeben!");
		}
		System.out.print(";");
	}
}
