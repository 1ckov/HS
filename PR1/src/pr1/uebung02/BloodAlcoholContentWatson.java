package pr1.uebung02;

import static pr.MakeItSimple.println;
import static pr.MakeItSimple.readDouble;
import static pr.MakeItSimple.readString;

public class BloodAlcoholContentWatson {

	public static void bldAlcConWat(double alkInGramm, double gewicht, double grosseCm,String geschlecht){
		double alkImBlut = 0;
		double dichteBlut = 1.055;
		double GKW = 0;
		if (geschlecht.equals("m")) {
			println("Bitte Alter eingeben: ");
			double alter = readDouble();

			GKW = 2.447 - (0.09516 * alter) + (0.1074 * grosseCm) + (0.3362 * gewicht);
			alkImBlut = (0.8 * alkInGramm) / (GKW * dichteBlut);
			println("Eine männliche Person hat den Eingaben zufolge eine Blutalkoholkonzentration von: " + alkImBlut
					+ " ‰");

		}
		else if (geschlecht.equals("w")) {
			GKW = 0.203 - (0.07) + (0.1069 * grosseCm) + (0.2466 * gewicht);
			alkImBlut = (0.8 * alkInGramm) / (GKW * dichteBlut);
			println("Eine weibliche Person hat den Eingaben zufolge eine Blutalkoholkonzentration von: " + alkImBlut
					+ " ‰");

		}
	}
	
	public static void main(String[] args) {

		double gewicht, alkInGramm, grosseCm;

		println("Bitte Körpergewicht in Kilogramm (kg) eingeben: ");
		gewicht = readDouble();

		println("Bitte die aufgenommene Masse des Alkohols in Gramm (g) eingeben: ");
		alkInGramm = readDouble();

		println("Bitte Körpergröße in Centimeter (cm) eingeben: ");
		grosseCm = readDouble();

		String geschlecht = "";
		println("Bitte Geschlecht (m/w) eingeben: ");
		geschlecht = readString();
		
		bldAlcConWat(alkInGramm, gewicht, grosseCm, geschlecht);
	}
}

