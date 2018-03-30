package pr1.uebung02;

import static pr.MakeItSimple.println;
import static pr.MakeItSimple.readDouble;
import static pr.MakeItSimple.readString;

public class BloodAlcoholContentWatson {

	public static void main(String[] args) {

		double alkInGramm;
		double gewicht;
		double alter;
		double großeCm;
		double alkImBlut = 0;
		double dichteBlut = 1.055;
		double GKW = 0;

		println("Bitte Körpergewicht in Kilogramm (kg) eingeben: ");
		gewicht = readDouble();

		println("Bitte die aufgenommene Masse des Alkohols in Gramm (g) eingeben: ");
		alkInGramm = readDouble();

		println("Bitte Körpergröße in Centimeter (cm) eingeben: ");
		großeCm = readDouble();

		String geschlecht = "";
		while (!geschlecht.equals("m") || !geschlecht.equals("w")) {
			println("Bitte Geschlecht (m/w) eingeben: ");
			geschlecht = readString();
		}

		if (geschlecht.equals("m")) {
			println("Bitte Alter eingeben: ");
			alter = readDouble();

			GKW = 2.447 - (0.09516 * alter) + (0.1074 * großeCm) + (0.3362 * gewicht);
			alkImBlut = (0.8 * alkInGramm) / (GKW * dichteBlut);
			println("Eine männliche Person hat den Eingaben zufolge eine Blutalkoholkonzentration von: " + alkImBlut
					+ " ‰");

		}
		else if (geschlecht.equals("w")) {
			GKW = 0.203 - (0.07) + (0.1069 * großeCm) + (0.2466 * gewicht);
			alkImBlut = (0.8 * alkInGramm) / (GKW * dichteBlut);
			println("Eine weibliche Person hat den Eingaben zufolge eine Blutalkoholkonzentration von: " + alkImBlut
					+ " ‰");

		}
	}

}
