package pr1.uebung03;

import static pr.MakeItSimple.println;
import static pr.MakeItSimple.readInt;

/**
 * Checks if the given number is a Palindrome (Spells the same no matter if read
 * front to back or opposite);
 * 
 * @author Aleksandar
 *
 */
public class PalindromeNumber {

	public static void main(String[] args) {
		int counter = 0;
		// Menu
		while (counter == 0) {

			int yourNumber = 0;
			println("Geben sie eine x-belibige zahl an: ");
			yourNumber = readInt();
			int[] numberStorage = new int[10];
			int i = 0;
			
			//Checks if number is within bounds;
			if (yourNumber > 0 && yourNumber < 2000000000) {
				
				//Saves each digit in a seperate array Slot;
				while (yourNumber > 0) {
					numberStorage[i] = yourNumber % 10;
					yourNumber = yourNumber / 10;
					i++;
				}

				int j = 0;
				//Compares the first and last digits of number;
				while (i >= 1 && i != j && i - 1 > j) {
					if (numberStorage[i - 1] == numberStorage[j]) {
						i--;
						j++;
					}
					else {
						println("Die eingegebene Zahl ist kein Palindrom");
						break;
					}
				}
				//if the loop has cycled past the middle or stopped there its a palindrome;
				if (i - 1 < j || i - 1 == j) {
					println("Die eingegebene Zahl ist ein Palindrom");
				}
			}
			else
				println("Ungültige Eingabe");
			System.out.println("Um das Programm zu verlassen geben sie eine zahl != 0;\n"
					+ "Um noch eine Zahl zu prüfen geben sie 0 ein;");
			counter = readInt();
			
		}
	}

}
