package pr1.uebung03;

import static pr.MakeItSimple.print;
import static pr.MakeItSimple.println;
import static pr.MakeItSimple.readInt;

import pr.MakeItSimple.PRException;
/**
 * Finds all deviders of a given number and uses arrays;
 * @author Aleksandar
 *
 */
public class DividersArray {

	public static void main(String[] args) {
		int zahl;
		int summe;
		int[] dividers = new int[35];

		println("Bitte eine x-beliebige ganze Zahl eingeben: ");

		zahl = readInt();
		int zehler = zahl;
		int position = 0;
		
		print("Die teiler der Zahl " + zehler + " sind: ");
		// Falls zahl > 0;
		if (zahl > 0) {
			while (zehler > 0) {
				summe = zahl % zehler;
				// Zahlen werden in array gespeichert;
				if (summe == 0) {
					dividers[position] = zehler;
					position++;
				}
				zehler--;
			}
		}
		else if (zahl <= 0) {
			throw new PRException("Ungültige Zahl eingegeben");
		}
		int i = 0;
		//Artificial For-each loop;
		while (position - 1 > i) {
			print(dividers[i] + ", ");
			i++;
		}
		print(dividers[i] + ";");
	}

}
