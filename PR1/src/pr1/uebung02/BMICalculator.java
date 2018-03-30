package pr1.uebung02;

import static pr.MakeItSimple.println;
import static pr.MakeItSimple.readDouble;
import static pr.MakeItSimple.readString;

public class BMICalculator {

	public static void main(String[] args) {

		double gewicht;
		double große;
		double BMI = 0;

		println("Bitte Körpergewicht in Kilogramm (kg) im Bereich von 30-300 eingeben: ");
		gewicht = readDouble();

		if (gewicht < 30 || gewicht > 300) {
			println("Ungültige Eingabe!");
		}

		println("Bitte Körpergröße in Centimeter (cm) im Bereich von 120-250 eingeben: ");
		große = readDouble();

		if (große < 120 || große > 250) {
			println("Ungültige Eingabe!");
		}

		BMI = gewicht / ((große / 100) * (große / 100));

		String geschlecht;
		println("Bitte Geschlecht (m/w) eingeben: ");
		geschlecht = readString();

		if (geschlecht.equals("m")) {
			if (BMI >= 20 && BMI <= 25) {
				println("Sie haben Normalgewicht. Ihr BMI beträgt: " + BMI);
			} else if (BMI < 20) {
				println("Sie haben Untergewicht. Ihr BMI beträgt " + BMI);
			} else if (BMI > 25) {
				println("Sie haben Übergewicht. Ihr BMI beträgt " + BMI);
			}
		} else if (geschlecht.equals("w")) {
			if (BMI >= 19 && BMI <= 24) {
				println("Sie haben Normalgewicht. Ihr BMI beträgt: " + BMI);
			} else if (BMI < 19) {
				println("Sie haben Untergewicht. Ihr BMI beträgt: " + BMI);
			} else if (BMI > 24) {
				println("Sie haben Übergewicht. Ihr BMI beträgt: " + BMI);
			}
		} else
			println("Kein Geschlecht angegeben!");

	}

}
