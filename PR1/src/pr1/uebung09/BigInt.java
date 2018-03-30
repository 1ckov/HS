//package pr1.uebung09;
//
//import static pr.MakeItSimple.readInt;
//import static pr.MakeItSimple.readString;
//
//import pr.MakeItSimple.PRException;
//
//public class BigInt {
//	private int[] feld;
//	/**
//	 * Die big int speichert Grosse int werte.
//	 * @param ziffern Eine String die zur BigInt werden soll.
//	 */
//	public BigInt(String ziffern) {
//		if(ziffern==""){
//			throw new PRException("Ihr habt einen lehren String übergeben");
//		}
//		else {
//			boolean nurNullen;
//			if (ziffern.charAt(0) == '0') {
//				nurNullen = true;
//				for (int i = 0; i < ziffern.length() ; i++) {
//					if (ziffern.charAt(i) != '0') {
//						nurNullen = false;
//					}
//				}
//			} 
//			else {
//				nurNullen = false;
//			}
//
//			if (nurNullen) {
//				feld = new int[1];
//				feld[0] = 0;
//			} 
//			else {
//				int counter = 0;
//				int positionF = 0;
//				boolean bigger0Found = false;
//				// geht den String durch und merkt sich die Zahl der Ziffern
//				for (int i = 0; i < ziffern.length(); i++) {
//					if (ziffern.charAt(i) < '0' || ziffern.charAt(i) > '9') {
//						throw new PRException("Ungültige Ziffer!");
//					}
//					// ignoriert führende 0-en
//					else if (ziffern.charAt(i) >= '0' && ziffern.charAt(i) <= '9') {
//						if (ziffern.charAt(i) > '0') {
//							bigger0Found = true;
//						}
//						if (bigger0Found) {
//							counter++;
//						}
//
//					}
//				}
//
//				// speichert die null wenn sie die einziege zahl ist
//				// if(ziffern.length() == 1 && ziffern.charAt(0) == '0'){
//				// feld = new int[1];
//				// feld[0] = 0;
//				// }
//				feld = new int[counter];
//				bigger0Found = false;
//				// speichert alle gültigen ziffern
//				for (int position = 0; position < ziffern.length(); position++) {
//					if (ziffern.charAt(position) >= '0' && ziffern.charAt(position) <= '9') {
//						if (ziffern.charAt(position) > '0') {
//							bigger0Found = true;
//						}
//						if (bigger0Found) {
//							feld[positionF] = ziffern.charAt(position) - 48;
//							positionF++;
//						}
//					}
//				}
//			}
//		}
//	}
//
//	/**
//	 * Addiert Zwei BigInts zussamen
//	 * @param number Die zahl die zu der ersten hinzugefuegt werden soll
//	 */
//	void add(BigInt number) {
//		int laengeL = 0;
//		//Das Laengare Element wird als laengeL gespeichert
//		if(this.feld.length < number.length()){
//			laengeL = number.length()-1;
//
//		}
//		else {
//			laengeL = feld.length-1;
//		}
//		//der neue array nimmt die laenge von dem laengeren array
//		int[] feld2 = new int[laengeL+2];
//		//geht alle positionen der speicher array durch
//		for(int position = 1; position <= laengeL+1; position++){
//			//bis zahl 1 und 2 noch positionen haben
//			if(number.length() - position >= 0 && feld.length - position >= 0){
//				if(((feld[feld.length  - position] + number.feld[number.length() - position] + feld2[feld2.length-position]) > 9)){
//					feld2[feld2.length-position] = (feld[feld.length - position] + number.feld[number.length() - position] + feld2[feld2.length - position]) % 10;
//					feld2[(feld2.length-position)-1] += 1;
//				}
//				else {
//					feld2[feld2.length-position]=(feld[feld.length - position] + number.feld[number.length() - position] + feld2[feld2.length-position]);
//				}
//			}
//			//falls zahl 2 kleiner ist
//			else if(number.length() - position < 0){
//				if(feld2[feld2.length-position] + feld[feld.length-position] > 9){
//					feld2[feld2.length-position] = (feld2[feld2.length-position] + feld[feld.length-position])%10;
//					feld2[(feld2.length-position)-1] += 1;  
//				}
//				else {
//					feld2[feld2.length-position] += feld[feld.length-position];
//				}
//					
//				  
//			}
//			//fals zahl 1 kleiner ist
//			else if(feld.length - position < 0){
//				  
//				if(feld2[feld2.length-position] + number.feld[number.length()-position] > 9){
//					feld2[feld2.length-position] = (feld2[feld.length-position] + number.feld[number.length()-position])%10;
//					feld2[(feld2.length-position)-1] += 1;  
//				}
//				else {
//					feld2[feld2.length-position] += number.feld[number.length()-position];
//				}
//			}
//		}//falls es keine fuhrenden 0-en gibt
//		if (feld2[0] != 0) {
//			feld = feld2;
//		}//falls doch
//		else if ( feld2[0] == 0 && feld2.length == 1){
//			feld = feld2;
//		}
//		else {
//			int[] feld3 = new int[feld2.length-1];
//			for (int positionF2 = 1; positionF2 < feld2.length; positionF2++ ){
//				feld3[positionF2 - 1] = feld2[positionF2];
//			}
//			feld = feld3;
//		}
//
//
//
//	}
//
//	/**
//	 * Gibt eine array zurueck
//	 * @return eine int Array zuruck
//	 */
//	int[] getDigits(){
//		int[] gottenDigits = new int[feld.length];
//		for(int i = 0; i < feld.length; i++){
//			gottenDigits[i] = feld[i];
//		}
//		return gottenDigits;
//	}
//
//	/**
//	 * Wandelt eine BigInt zum String um
//	 */
//	@Override
//	public String toString() {
//		String intToString = "";
//		for (int position = 0; position <feld.length; position++){
//			intToString += feld[position];
//		}
//		return intToString;
//	}
//
//	/**
//	 * Gibt die laenge einer BigInt zuruck
//	 * @return Laenge Der zahl an;
//	 */
//	int length() {
//
//		return feld.length;
//	}
//
//	/**
//	 * Vergleicht zwei BigInts.
//	 * @param number Die zahl die vergleicht werden soll
//	 * @return ob die zwei zahlen gleich sind
//	 */
//	boolean equals(BigInt number){
//		boolean isEqual = true;
//		if(number.length() < feld.length){
//			return !isEqual;
//		}
//		else if(number.length() == feld.length){
//			for(int position = 0;position < feld.length; position++){
//				if (number.feld[position]!=feld[position]) {
//					isEqual = false;
//				}
//			}
//		}
//		return isEqual;
//	}
//	
//	void times (BigInt number){
//		BigInt counter = new BigInt("0");
//		BigInt eins = new BigInt("1");
//		boolean bla = true;
//		int i = 0;
//		while(bla){
//			counter.add(eins);
//			i++;
//			if(this.equals(counter)){
//				bla = false;
//			}
//			
//		}
//		int k = 1;
//		while(k < i){
//			this.add(number);
//			k++;
//		}
//		
//		
//		
//	}
//	boolean greater(BigInt number){
//		boolean isGreater = false;
//		//Vergleicht die grosse der beiden BigInts
//		if(number.length() > feld.length){
//			isGreater = true;
//		}
//		else if(number.length() == feld.length){
//			for (int i = 0;i < feld.length && !isGreater; i++){
//				if(number.feld[i] > feld[i]){
//					isGreater = true;
//				}
//				else if (number.feld[i]<feld[i]){
//					break;
//				}
//			}
//		}
//		return isGreater;
//	}
//
//	public static void main(String[] args) {
//		int choice = 0;
//		
//		do{
//			System.out.println("Geben Sie eine function ein: \n"
//					+ "1 - zahl Ausgeben; \n" 
//					+ "2 - Zahl an einer bestimmten postion ausgeben; \n"
//					+ "3 - Laenge der zahl ausgeben \n"
//					+ "4 - Vergleiche 2 zahlen \n"
//					+ "5 - Addieren von 2 Zahlen \n"
//					+ "6 - Verlassen des programms \n");
//			choice = readInt();
//			if (choice == 1){
//				System.out.println("Geben sie eure zahl ein: ");
//				BigInt zahl = new BigInt(readString());
//				System.out.println(zahl.toString());
//
//			}
//			else if (choice == 2){
//				System.out.println("Geben sie eure zahl ein: ");
//				BigInt zahl = new BigInt(readString());
//				System.out.println("Geben sie die position ein: ");
//				int position = readInt();
//				System.out.println(zahl.getDigits()[position]);
//			}
//			else if (choice == 3){
//				System.out.println("Geben sie eure zahl ein: ");
//				BigInt zahl = new BigInt(readString());
//				System.out.println(zahl.length());
//			}
//			else if (choice == 4){
//				System.out.println("Geben sie eure zahl ein: ");
//				BigInt zahl1 = new BigInt(readString());
//				System.out.println("Geben sie eure zahl zum vergleichen ein");
//				BigInt zahl2 = new BigInt(readString());
//				boolean sindGleich = zahl1.equals(zahl2);
//				if (sindGleich) {
//					System.out.println("Die Zahlen sind gleich!");
//				}
//				else { 
//					System.out.println("Die Zahlen sind vershieden!");
//				}
//			}
//			else if (choice == 5){
//				System.out.println("Geben sie eure zahl ein: ");
//				BigInt zahl1 = new BigInt(readString());
//				System.out.println("Geben sie eure zahl zum addieren ein: ");
//				BigInt zahl2 = new BigInt(readString());
//				zahl1.add(zahl2);
//				System.out.println(zahl1.toString());
//			}
//			else if (choice == 6){
//				System.out.println("Geben sie eure zahl ein: ");
//				BigInt zahl1 = new BigInt(readString());
//				System.out.println("Geben sie eure zahl zum addieren ein: ");
//				BigInt zahl2 = new BigInt(readString());
//				zahl1.times(zahl2);
//				System.out.println(zahl1.toString());
//			}
//		}while(choice != 7);
//
//
//	}
//
//}
package pr1.uebung09;

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
	/**
	 * Returns the Number of Digits a BigInt has;
	 * @return the Length value of the BigInt Field Array;
	 */
	public int length() {
		return this.field.length;
	}

	/**
	 * Add's the values of two BigInt numbers together and stores the value in the first BigInt;
	 * @param number - A BigInt value that should be added to the first;
	 */
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
				else if (this.field[i] != number.field[i]){
					return false;
				}
			}
		}
		return false;
	}

	/**
	 * Compares two BigInt numbers;
	 * @param number - Must be a BigInt value;
	 * @return - True if the first number is greater than the second;
	 */
	boolean greater(BigInt number){
		if(this.equals(number)){
			return false;
		}
		else {
			for (int i = 0; i < field.length;i++) {
				if(this.field[i] > number.field[i]){
					return true;
				}
				else if(this.field[i] < number.field[i]){
					return false;
				}
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @param number
	 */
	void times(BigInt number) {
		//Checks if the multiplikation has to be done by 0;
		if((this.length() == 1 && this.getDigits()[0] == 0) || (number.length() == 1 && number.getDigits()[0] == 0)){
			this.field = new int[1];
			//In which case it returns zero;
			this.field[0] = 0;
		}
		else {
			int length;
			
			if(this.greater(number)){
				length = this.length();
			}
			else{
				length = number.length();
			}
			//gives u the exact length of the new number;
			length = (length / 2) + (length % 2);
			long m = (long)Math.pow(10, length); 
			
		}
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
				BigInt zahl = new BigInt(readString());
				System.out.println(zahl.toString());

			}
			else if (choice == 2){
				System.out.println("Geben sie eure zahl ein: ");
				BigInt zahl = new BigInt(readString());
				System.out.println("Geben sie die position ein: ");
				int position = readInt();
				System.out.println(zahl.getDigits()[position]);
			}
			else if (choice == 3){
				System.out.println("Geben sie eure zahl ein: ");
				BigInt zahl = new BigInt(readString());
				System.out.println(zahl.length());
			}
			else if (choice == 4){
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
			else if (choice == 5){
				System.out.println("Geben sie eure zahl ein: ");
				BigInt zahl1 = new BigInt(readString());
				System.out.println("Geben sie eure zahl zum addieren ein: ");
				BigInt zahl2 = new BigInt(readString());
				zahl1.add(zahl2);
				System.out.println(zahl1.toString());
			}
		}while(choice != 6);
	}

}

