package pr1.uebung07;

import static pr.MakeItSimple.println;
import static pr.MakeItSimple.readInt;
import static pr.MakeItSimple.readString;

import pr.MakeItSimple.PRException;

public class StringExtension {
	/**
	 * Die methode wandelt alle buchstaben in einen String zu grossen um.
	 * 
	 * @param text
	 *            Der String der Gross gemacht werden soll
	 * @return gibt ein String nur mit grossbuchstaben zuruck
	 */
	static String toUpper(String text) {
		char[] storage = text.toCharArray();
		int offset = 'A' - 'a';
		for (int position = 0; position < storage.length; position++) {
			if ((storage[position] >= 'a' && storage[position] <= 'z')
					|| storage[position] == 'ä' || storage[position] == 'ö' || storage[position] == 'ü') {
				storage[position] = (char) (storage[position] + offset);
			}
		}
		String textModified = new String(storage);
		return textModified;
	}

	/**
	 * Die methode nimmt einen satz und wandelt in so um das er nur
	 * grossbuchstaben hat,und benutzt keine schelifen.
	 * 
	 * @param text
	 *            Der text dessen Elemente zu grossbuchstaben gemacht werden
	 *            sollen.
	 * @return gibt ein String nur mit grossbuchstaben zuruck
	 */
	static String toUpperRecursive(String text) {
		char[] storage = text.toCharArray();
		int position = 0;
		char[] charArrayToBeConverted = toUpperHelper(storage, position);
		String upperText = new String(charArrayToBeConverted);
		return upperText;
	}

	static char[] toUpperHelper(char[] storage, int position) {
		int offset = 'A' - 'a';
		if (position < storage.length) { //bis ganze satz durch ist
			//wandelt kleine in grosse buchstaben um
			if (storage[position] >= 'a' && storage[position] <= 'z') {
				storage[position] += offset;
				return toUpperHelper(storage, position + 1);
			} else
				return toUpperHelper(storage, position + 1);
		} else
			return storage;

	}

	/**
	 * Die Methode sucht nach einen bestimmten String in einen andaren String.
	 * 
	 * @param text
	 *            Ist der Eigentliche text.
	 * @param needle
	 *            Ist der String der gefunden Werden soll.
	 * @return Gibt Die erste position des gesuchten Strings in den eigentlichen
	 *         String an.
	 */
	static int scan(String text, String needle) {
		boolean isNeedleFound = false;
		int positionNeedle = 0;
		int firstPositionNeedleFound = 0;
		//wenn die string leer ist
		if (needle.equals("")) {
			throw new PRException("Sie haben einen lehren String eingegeben");
		} else {
			//durchgeht den string bis Nadel gefunden
			for (int position = 0; position < text.length() && !isNeedleFound; position++) { 
				//bis der ganze substring ausgelesen wird
				if (positionNeedle < needle.length() && text.charAt(position) == needle.charAt(positionNeedle)) { 
					positionNeedle++;	// wird +1 grosser
					
				}
				else if (positionNeedle == needle.length()) { 
					isNeedleFound = true;
					//needle.length() auch
					firstPositionNeedleFound = position - needle.length();
				}
			}
		}

		if (isNeedleFound) {
			return firstPositionNeedleFound;
		} else
			throw new PRException("Das gesuchte Element wurde nicht im String gefunden");

	}

	/**
	 * Die Methode nimt einen String und teilt ihn in mehraren kleinen Strings
	 * auf.
	 * 
	 * @param text
	 *            ist der Text der aufgetailt werden soll.
	 * @param delimiter
	 *            sind die Stellen an denen der text aufgeteilt werden soll
	 * @return Gibt uns einen String array mit elementen, die Strings die
	 *         aufgeteilt sind
	 */
	public static String[] split(String text, char delimiter) {
		char[] textToChars = text.toCharArray();
		int counter = 1;
		//zehlt in vielen teilen man den string zerlegt
		for (int position = 0; position < textToChars.length; position++) {
			if (textToChars[position] == delimiter) {
				counter++;
			}
		}
		String storage = "";
		int positionText = 0;
		String[] splitedText = new String[counter];
		for (int position = 0; position < textToChars.length; position++) {
			if (textToChars[position] != delimiter) {//speichert alle elemente bis zum delimeter
				storage += textToChars[position];
				splitedText[positionText] = storage;//losht inhalt von string
			} else if (textToChars[position] == delimiter) {
				storage = "";
				positionText++;
			}

		}
		return splitedText;
	}

	public static void main(String[] args) {
		int angabe = 0;
		do {
			println("Geben Sie eine function ein: "+"\n" + "1 - Wandelt die Buchstaben eines textes zu grossbuchstaben um; " + "\n"
					+ "2 - Durchsucht string A nach string B;"+"\n" + "3 - Teilt einen String auf;" + "\n"
					+ "4 - Programm Stoppen;"+"\n");
			angabe = readInt();
			if (angabe == 1) {
				println("Geben sie eine nachricht ein");
				String text = readString();
				println(toUpperRecursive(text));
			} else if (angabe == 2) {
				println("Geben sie String A an");
				String text = readString();
				println("Geben sie String B an");
				String needle = readString();
				println(scan(text, needle));
			} else if (angabe == 3) {
				println("Geben sie eine nachricht ein");
				String text = readString();
				println("Geben sie das element an, das die Strings trennen soll.");
				String character = readString();
				char[] delimeter = character.toCharArray();
				String[] splitedText = (split(text, delimeter[0]));
				for (int position = 0; position < splitedText.length; position++) {
					println(splitedText[position]);
				}
			}
		} while (angabe < 4);

	}

}
