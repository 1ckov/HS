package pr1.uebung08;

import static pr.MakeItSimple.readInt;
import static pr.MakeItSimple.readString;

import pr.MakeItSimple.PRException;

public class BigIntV1 {
	private int[] feld;
	/**
	 * Die big int speichert Grosse int werte.
	 * @param ziffern Eine String die zur BigInt werden soll.
	 */
	public BigIntV1(String ziffern) {
		if(ziffern==""){
			//If String is Empty
			throw new PRException("Ihr habt einen lehren String übergeben");
		}
		else {
			//Checks if String contains only 0's
			boolean nurNullen;
			//if First is 0
			if (ziffern.charAt(0) == '0') {
				nurNullen = true;
				//Checks the rest of the Array
				for (int i = 0; ziffern.length() < i; i++) {
					if (ziffern.charAt(i) != 0) {
						nurNullen = false;
					}
				}
			} else {
				//If there are numbers diffrent from 0;
				nurNullen = false;
			}
			//If The number is 0;
			if (nurNullen) {
				feld = new int[1];
				feld[0] = 0;
			} else {
				int counter = 0;
				int positionF = 0;
				
				boolean bigger0Found = false;
				// geht den String durch und merkt sich die Zahl der Ziffern;
				for (int i = 0; i < ziffern.length(); i++) {
					if (ziffern.charAt(i) < '0' || ziffern.charAt(i) > '9') {
						throw new PRException("Ungültige Ziffer!");
					}
					// Ignores leading 0's;
					else if (ziffern.charAt(i) >= '0' && ziffern.charAt(i) <= '9') {
						if (ziffern.charAt(i) > '0') {
							bigger0Found = true;
						}
						if (bigger0Found) {
							counter++;
						}

					}
				}

				// speichert die null wenn sie die einziege zahl ist
				// if(ziffern.length() == 1 && ziffern.charAt(0) == '0'){
				// feld = new int[1];
				// feld[0] = 0;
				// }
				feld = new int[counter];
				bigger0Found = false;
				// speichert alle gültigen ziffern
				for (int position = 0; position < ziffern.length(); position++) {
					if (ziffern.charAt(position) >= '0' && ziffern.charAt(position) <= '9') {
						if (ziffern.charAt(position) > '0') {
							bigger0Found = true;
						}
						if (bigger0Found) {
							feld[positionF] = ziffern.charAt(position) - 48;
							positionF++;
						}
					}
				}
			}
		}
	}

	/**
	 * Addiert Zwei BigInts zussamen
	 * @param number Die zahl die zu der ersten hinzugefuegt werden soll
	 */
	void add(BigIntV1 number) {
		int laengeL = 0;
		//Das Laengare Element wird als laengeL gespeichert
		if(this.feld.length < number.length()){
			laengeL = number.length()-1;

		}
		else {
			laengeL = feld.length-1;
		}
		//der neue array nimmt die laenge von dem laengeren array
		int[] feld2 = new int[laengeL+2];
		//geht alle positionen der speicher array durch
		for(int position = 1; position <= laengeL+1; position++){
			//bis zahl 1 und 2 noch positionen haben
			if(number.length() - position >= 0 && feld.length - position >= 0){
				if(((feld[feld.length  - position] + number.feld[number.length() - position] + feld2[feld2.length-position]) > 9)){
					feld2[feld2.length-position] = (feld[feld.length - position] + number.feld[number.length() - position] + feld2[feld2.length - position]) % 10;
					feld2[(feld2.length-position)-1] += 1;
				}
				else {
					feld2[feld2.length-position]=(feld[feld.length - position] + number.feld[number.length() - position] + feld2[feld2.length-position]);
				}
			}
			//falls zahl 2 kleiner ist
			else if(number.length() - position < 0){
				if(feld2[feld2.length-position] + feld[feld.length-position] > 9){
					feld2[feld2.length-position] = (feld2[feld2.length-position] + feld[feld.length-position])%10;
					feld2[(feld2.length-position)-1] += 1;  
				}
				else {
					feld2[feld2.length-position] += feld[feld.length-position];
				}
					
				  
			}
			//fals zahl 1 kleiner ist
			else if(feld.length - position < 0){
				  
				if(feld2[feld2.length-position] + number.feld[number.length()-position] > 9){
					feld2[feld2.length-position] = (feld2[feld.length-position] + number.feld[number.length()-position])%10;
					feld2[(feld2.length-position)-1] += 1;  
				}
				else {
					feld2[feld2.length-position] += number.feld[number.length()-position];
				}
			}
		}//falls es keine fuhrenden 0-en gibt
		if (feld2[0] != 0) {
			feld = feld2;
		}//falls doch
		else if ( feld2[0] == 0 && feld2.length == 1){
			feld = feld2;
		}
		else {
			int[] feld3 = new int[feld2.length-1];
			for (int positionF2 = 1; positionF2 < feld2.length; positionF2++ ){
				feld3[positionF2 - 1] = feld2[positionF2];
			}
			feld = feld3;
		}



	}

	/**
	 * Gibt eine array zurueck
	 * @return eine int Array zuruck
	 */
	int[] getDigits(){
		int[] gottenDigits = new int[feld.length];
		for(int i = 0; i < feld.length; i++){
			gottenDigits[i] = feld[i];
		}
		return gottenDigits;
	}

	/**
	 * Wandelt eine BigInt zum String um
	 */
	@Override
	public String toString() {
		String intToString = "";
		for (int position = 0; position <feld.length; position++){
			intToString += feld[position];
		}
		return intToString;
	}

	/**
	 * Gibt die laenge einer BigInt zuruck
	 * @return Laenge Der zahl an;
	 */
	int length() {

		return feld.length;
	}

	/**
	 * Vergleicht zwei BigInts.
	 * @param number Die zahl die vergleicht werden soll
	 * @return ob die zwei zahlen gleich sind
	 */
	boolean equals(BigIntV1 number){
		boolean isEqual = true;
		if(number.length() < feld.length){
			return !isEqual;
		}
		else if(number.length() == feld.length){
			for(int position = 0;position < feld.length; position++){
				if (number.feld[position]!=feld[position]) {
					isEqual = false;
				}
			}
		}
		return isEqual;
	}

	public static void main(String[] args) {
		int choice = 0;
		do{
			System.out.println("Geben Sie eine function ein: \n"
					+ "1 - zahl Ausgeben; \n" 
					+ "2 - Zahl an einer bestimmten postion ausgeben; \n"
					+ "3 - Laenge der zahl ausgeben \n"
					+ "4 - Vergleiche 2 zahlen \n"
					+ "5 - Addieren von 2 Zahlen \n"
					+ "6 - Verlassen des programms \n");
			choice = readInt();
			if (choice == 1){
				System.out.println("Geben sie eure zahl ein: ");
				BigIntV1 zahl = new BigIntV1(readString());
				System.out.println(zahl.toString());

			}
			else if (choice == 2){
				System.out.println("Geben sie eure zahl ein: ");
				BigIntV1 zahl = new BigIntV1(readString());
				System.out.println("Geben sie die position ein: ");
				int position = readInt();
				System.out.println(zahl.getDigits()[position]);
			}
			else if (choice == 3){
				System.out.println("Geben sie eure zahl ein: ");
				BigIntV1 zahl = new BigIntV1(readString());
				System.out.println(zahl.length());
			}
			else if (choice == 4){
				System.out.println("Geben sie eure zahl ein: ");
				BigIntV1 zahl1 = new BigIntV1(readString());
				System.out.println("Geben sie eure zahl zum vergleichen ein");
				BigIntV1 zahl2 = new BigIntV1(readString());
				boolean sindGleich = zahl1.equals(zahl2);
				if (sindGleich) {
					System.out.println("Die Zahlen sind gleich!");
				}
				else { 
					System.out.println("Die Zahlen sind vershieden!");
				}
			}
			else if (choice == 5){
				System.out.println("Geben sie eure zahl ein: ");
				BigIntV1 zahl1 = new BigIntV1(readString());
				System.out.println("Geben sie eure zahl zum addieren ein: ");
				BigIntV1 zahl2 = new BigIntV1(readString());
				zahl1.add(zahl2);
				System.out.println(zahl1.toString());
			}
		}while(choice != 6);


	}

}
