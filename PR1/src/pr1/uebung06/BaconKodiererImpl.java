package pr1.uebung06;

import static pr.MakeItSimple.println;
import static pr.MakeItSimple.readInt;
import static pr.MakeItSimple.readString;

import pr.MakeItSimple.PRException;

public class BaconKodiererImpl {

	static String[] BaconBinary = { "kkkkk", "kkkkg", "kkkgk", "kkkgg", "kkgkk", "kkgkg", "kkggk", "kkggg", "kgkkk",
			"kgkkg", "kgkgk", "kgkgg", "kggkk", "kggkg", "kgggk", "kgggg", "gkkkk", "gkkkg", "gkkgk", "gkkgg", "gkgkk",
			"gkgkg", "gkggk", "gkggg" };

	static String reinigeNachricht(String nachricht) {
		nachricht = nachricht.toLowerCase();

		String[] germanLetters = { "ü", "ä", "ö", "ß" };
		String[] englishAlternatives = { "UE", "AE", "OE", "SS" };
		// Guckt für alle deutschen buchstaben und wechselt die
		for (int position = 0; position < 4; position++) {
			nachricht = nachricht.replaceAll(germanLetters[position], englishAlternatives[position]);

		}
		
		nachricht = nachricht.toUpperCase();
		// Entfernt alle nicht zeichen die nicht buchstaben sind;
		nachricht = nachricht.replaceAll("\\W+", "");
		nachricht = nachricht.trim();
		return nachricht;

	}

	static String kodiereNachricht(String gereinigteNachricht) {
		char[] nachrichtToCode = gereinigteNachricht.toCharArray();

		char[] alphabet = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
				'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
		String codedMessege = "";
		// Überpruft ob die Nachricht nur aus buchstaben besteht.
		// int checker = 0;
		// for (int positionN = 0; positionN < nachrichtToCode.length;
		// positionN++) {
		// for (int positionA = 0; positionA < alphabet.length; positionA++) {
		// if (nachrichtToCode[positionN] == alphabet[positionA]) {
		// checker++;
		// }
		// }
		// if (checker - 1 != positionN) {
		// throw new PRException(
		// "Sie haben ein Symbol eigegeben ,das nicht erlaubt ist: " +
		// nachrichtToCode[positionN]);
		// }
		//
		// }
		for (int positionN = 0; positionN < nachrichtToCode.length; positionN++) {
			if ((nachrichtToCode[positionN]>='A' && nachrichtToCode[positionN]<='Z')) {
				throw new PRException(
						"Sie haben ein Symbol eigegeben ,das nicht erlaubt ist: " + nachrichtToCode[positionN]);
			}
		}
		// Ubersetz die nachrticht in binear um;
		for (int positionN = 0; positionN < nachrichtToCode.length; positionN++) {
			for (int positionA = 0; positionA < alphabet.length; positionA++) {
				if (positionA < 9 && alphabet[positionA] == nachrichtToCode[positionN]) {
					codedMessege = codedMessege + BaconBinary[positionA];
				} else if (positionA >= 9 && positionA < 21 && alphabet[positionA] == nachrichtToCode[positionN]) {
					codedMessege = codedMessege + BaconBinary[positionA - 1];
				} else if (positionA >= 21 && alphabet[positionA] == nachrichtToCode[positionN]) {
					codedMessege = codedMessege + BaconBinary[positionA - 2];
				}
			}
		}
		return codedMessege;
	}

	static String dekodiereNachricht(String binaerCode) {

		char[] binearArray = binaerCode.toCharArray();
		char[] alphabet = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
				'T', 'U', 'W', 'X', 'Y', 'Z' };
		int positionArray = 0;

		String[] binearToBeDecoded = new String[binearArray.length / 5];

		// Geht durch alle elemente von dem binear Array durch ;
		for (int position = 0; position < binearArray.length / 5; position++) {
			String binearToSave = "";
			// Wandelt den char in einen string array um;
			for (int positionB = position * 5; positionB < position * 5 + 5; positionB++) {
				binearToSave += binearArray[positionB];
			}
			binearToBeDecoded[positionArray] = binearToSave;
			positionArray++;
		}
		String binearToPrint = "";
		// Geht die elemente von BinearToBeDecoded Durch
		for (int positionBTBD = 0; positionBTBD < binearToBeDecoded.length; positionBTBD++) {
			boolean isBinaryKnown = false;
			// Wandelt den koddierten String in einen unkodierten string um
			for (int positionCL = 0; positionCL < BaconBinary.length; positionCL++) {
				if (binearToBeDecoded[positionBTBD].equals(BaconBinary[positionCL])) {
					binearToPrint += alphabet[positionCL];
					isBinaryKnown = true;
				}
			}
			if (!isBinaryKnown) {
				binearToPrint += "#";

			}
		}

		return binearToPrint;
	}

	static String versteckeNachricht(String nachricht, String traegerMedium) {
		// Überpfruft ob die nachricht leer ist
		if (nachricht.equals(""))
			return traegerMedium;
		else {
			String messege = reinigeNachricht(nachricht);
			String codedMessege = kodiereNachricht(messege);
			char[] storageMedia = traegerMedium.toCharArray();
			char[] codedChars = codedMessege.toCharArray();

			int positionT = 0;
			// Überpruft ob das Traeger medium Gross genug ist
			if (storageMedia.length >= codedChars.length) {
				for (int positionC = 0; positionC < codedChars.length; positionC++){
					//Überpruft ob die jetziege postion in storage media ein buchstabe ist
					while((!Character.isLetter(storageMedia[positionT])) || storageMedia[positionT] =='ß'){
						positionT++;
					}
					if (codedChars[positionC] == 'k') {
						storageMedia[positionT] = Character.toLowerCase(storageMedia[positionT]);
						positionT++;
					} else if (codedChars[positionC] == 'g') {
						storageMedia[positionT] = Character.toUpperCase(storageMedia[positionT]);
						positionT++;
					}
				}
//				for (int position = 0; position < codedChars.length; position++) {
//					if ((((storageMedia[position] >= (int) 'A' && storageMedia[position] <= (int) 'Z')
//							&& (storageMedia[position] >= (int) 'a' && storageMedia[position] <= (int) 'z'))
//							|| storageMedia[position] == ('Ä') || storageMedia[position] == ('ä')
//							|| storageMedia[position] == ('Ö') || storageMedia[position] == ('ö')
//							|| storageMedia[position] == ('Ü') || storageMedia[position] == ('ü')
//							) && positionC < codedChars.length) {
//						if ((int) codedChars[positionC] == 'k') {
//							storageMedia[position] = Character.toLowerCase(storageMedia[position]);
//							positionC++;
//						} else if (codedChars[positionC] == 'g') {
//							storageMedia[position] = Character.toUpperCase(storageMedia[position]);
//							positionC++;
//						}
//					}
//				}

			} else {
				throw new PRException("Das Träger Medium ist zu klein für diese nachricht");
			}

			String codedStorageMedia = new String(storageMedia);
			return codedStorageMedia;
		}
	}

	static String zeigeNachricht(String steganogramm) {
		char[] codedMessege = steganogramm.toCharArray();
		String codedLetters = "";

		for (int positionC = 0; positionC < steganogramm.length(); positionC++) {
			if ((codedMessege[positionC] >= 'A' && codedMessege[positionC] <= 'Z')
					|| codedMessege[positionC] == ('Ä') || codedMessege[positionC] == ('Ö')
					|| codedMessege[positionC] == ('Ü')) {
				codedLetters += 'g';
			} else if ((codedMessege[positionC] >= 'a' && codedMessege[positionC] <= 'z')
					|| codedMessege[positionC] == ('ä') || codedMessege[positionC] == ('ö')
					|| codedMessege[positionC] == ('ü')) {
				codedLetters += 'k';
			}
		}
		String decodedMessege = dekodiereNachricht(codedLetters);
		return decodedMessege;
	}

	public static void main(String[] args) {
		int choice = 0;
		do {
			println("Bitte wählen sie eine funktion aus : 1-Nachricht verstecken ,2-Nachricht entschlusseln, 3 - Demo zeigen, 4-Program Beenden.");
			choice = readInt();
			if (choice == 1) {
				println("Bitte geben sie eure nachricht zu verstecken ein");
				String messege = readString();
				println("Bitte geben sie eur Traegermedium ein");
				String storageMedia = readString();
				println(versteckeNachricht(messege, storageMedia));
			} else if (choice == 2) {
				println("Bitte geben Sie eure verschlusselte nachricht ein");
				String steganogramm = readString();
				println(zeigeNachricht(steganogramm));

			} else if (choice == 3) {
				String messege = ("Treffen uns um drei Uhr am Bahnhof!");
				String storageMedia = ("Mein Name ist Juan Sanchez Villa-Lobos Ramirez, oberster Metallurge am Hofe König Karl V. von Spanien; ich wurde 896 vor Christus in Ägypten geboren und bin unsterblich seit 846 vor Christus.");
				String steganogramm = versteckeNachricht(messege, storageMedia);
				println(steganogramm);
				println(zeigeNachricht(steganogramm));
			}
		} while (choice != 4);
	}

	/*
	 * String steganogramm = BaconKodiererImpl.versteckeNachricht(
	 * "Treffen uns um drei Uhr am Bahnhof!",
	 * "Am Anfang schuf Gott Himmel und Erde. Und die Erde war wüst und leer, und es war finster auf der Tiefe; und der Geist Gottes schwebte auf dem Wasser. Und Gott sprach: Es werde Licht! und es ward Licht."
	 * ); assertEquals(
	 * "Am aNfAng schuF gott HiMmeL uNd eRde. uND diE erDE wAR wüSt unD LeeR, UnD eS War fINSter auf Der tIefe; Und DEr gEIST gottes schwEbTE auf dEm wasser. UND gOTt sprACH: eS WeRde LiCht! und es ward Licht."
	 * , steganogramm);
	 */

}
