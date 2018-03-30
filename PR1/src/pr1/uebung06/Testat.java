package pr1.uebung06;

import static pr.MakeItSimple.println;
import static pr.MakeItSimple.readInt;
import static pr.MakeItSimple.readString;

public class Testat {

	static char[] alphabet = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
			'S', 'T', 'V', 'U', 'W', 'X', 'Y', 'Z' };

	static String encrypt(String originalText, int shift) {
		char[] messege = originalText.toCharArray();
		char[] alphabetShifted = new char[alphabet.length];
		boolean isInArray = false;
		String encrypted = "";
		int positionBegining = 0;
		for (int position = 0; position < alphabet.length; position++) {
			if (position + shift < alphabet.length) {
				alphabetShifted[position] = alphabet[position + shift];
			} else if (position + shift >= alphabet.length && positionBegining < shift) {
				alphabetShifted[position] = alphabet[positionBegining];
				positionBegining++;
			}

		}
		for (int positionM = 0; positionM < messege.length; positionM++) {
			for (int positionA = 0; positionA < alphabet.length; positionA++) {
				if(isInArray){
					isInArray=false;
				}
				else if (messege[positionM] == alphabet[positionA]) {
					isInArray = true;
					encrypted = encrypted + alphabetShifted[positionA];
				}
				
				
			}
			if (!isInArray) {
				encrypted = encrypted + messege[positionM];
				
			}
			
		}
		return encrypted;

	}

	public static void main(String[] args) {
		println("Bitte geben sie Eine zahl zwischen 1 und 26 und ein nachricht die verschlusselt werden soll ein");
		int number = readInt();
		String messege = readString();
		String encryptedMessege = (encrypt(messege, number));
		println(encryptedMessege);

	}

}
