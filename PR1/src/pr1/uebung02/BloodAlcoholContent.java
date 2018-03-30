package pr1.uebung02;

import static pr.MakeItSimple.println;
import static pr.MakeItSimple.readDouble;
import static pr.MakeItSimple.readString;

public class BloodAlcoholContent {
	/**
	 * 
	 * @param sex
	 *            - m(Male) or f(female);
	 * @param g
	 *            - Alcohol consumed in gramms;
	 * @param w
	 *            - Weight;
	 * @param rM
	 *            - Res. Faktor in Males;
	 * @param rW
	 *            - Res.Faktor in Females;
	 * @return - The Promiles of alcohol in your system;
	 */
	static double bloodAlcCalc(String sex, double g, double w, double rM, double rW) {
		if (sex.equals("m"))
			return g / (w * rM);
		else
			return g / (w * rW);
	}

	public static void main(String[] args) {

		double alkImBlut;
		double alkInGramm;
		double gewicht;
		double rfaktorW = 0.6;
		double rfaktorM = 0.7;

		println("Bitte Körpergewicht in Kilogramm (kg) eingeben: ");
		gewicht = readDouble();

		println("Bitte die aufgenommene Masse des Alkohols in Gramm (g) eingeben: ");
		alkInGramm = readDouble();
		// Has To be m or w;
		String geschlecht = "";
		while (!geschlecht.equals("m") || !geschlecht.equals("w")) {
			println("Bitte Geschlecht (m/w) eingeben: ");
			geschlecht = readString();
		}
		if (geschlecht.equals("m") || geschlecht.equals("w")) {
			alkImBlut = bloodAlcCalc(geschlecht, alkInGramm, gewicht, rfaktorM, rfaktorW);
			println("Sie Haben " + alkImBlut + "‰ im Blut");
		}
		else
			println("Falsche Geschlechts eingabe");
		/*
		 * if (geschlecht.equals("m")) { alkImBlut = (alkInGramm / (gewicht *
		 * rfaktorM)); println(
		 * "Eine männliche Person hat den Eingaben zufolge eine Blutalkoholkonzentration von: "
		 * + alkImBlut + " ‰");
		 * 
		 * } else if (geschlecht.equals("w")) { alkImBlut = (alkInGramm /
		 * (gewicht * rfaktorW)); println(
		 * "Eine weibliche Person hat den Eingaben zufolge eine Blutalkoholkonzentration von: "
		 * + alkImBlut + " ‰");
		 * 
		 * } else { println(
		 * "Der eingegebene Reduktionsfaktor ist nicht vorhanden!"); }
		 */
	}

}
