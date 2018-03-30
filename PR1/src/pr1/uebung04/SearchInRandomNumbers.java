package pr1.uebung04;

import static pr.MakeItSimple.print;
import static pr.MakeItSimple.println;
import static pr.MakeItSimple.readInt;

import pr.MakeItSimple.PRException;

public class SearchInRandomNumbers {

	static int[] generate(int i){

		//Hier erschafen wir die Ausnahme falls die Anzahl der felder kleiner als 0 ist.
		if(i<0)
			throw new PRException("Ungültiger Parameter: " + i);


		int[] randomNumbers = new int[i];

		//Hier fuhlen wir unsere array mit der angegebenen Anzahl an Zuffalszahlen im bereich von 1 bis 1000.
		for (int j = 0; j < i ;j++){
			randomNumbers[j] = (int)(Math.random()*1000)+1;
		}
		//ich benutze 1000 weil das Beispiel mit dem Lottozahlen so besagt ,ich glaube aber das wir in diesen fall 999 benutzen sollten.

		return randomNumbers;
	}

	static int[] searchAll(int[] j , int i){

		int matches = 0;
		int counter = 0;
		//Die erste for Schleife samelt die Anzahl der Treffer
		for(int y = 0;y < j.length; y++){
			if(j[y] == i){
				matches++;
			}
		}
		//Die zweite for Schleife gebt die gefundenen Positionen in dem Array ein  
		int[] matchesFound = new int[matches];
		for(int p = 0 ; p < j.length ; p++){
			if(j[p] == i){
				matchesFound[counter] = p;
				counter++;
			}
		}
		//Jetzt geben wir die array als Ergebness zurück
		return matchesFound;
	}

	static int searchFirst(int[] j , int i){
		boolean find = false;
		int result = 0;
		//Diese for Schleife fangt bei der ersten Position des Arrays an
		for(int a = 0; a<j.length; a++ ){
			if(find == false && j[a] == i){
				find = true;
				result = a;
			}
		}
		if(result==0){
			throw new PRException("Keine Treffer" + i);
		}
		return result;

	}

	
	static int searchLast(int[] j , int i){

		int d = 0;
		boolean b = false;
		//Diese for Schleife fangt bei der letzten Position des Arrays an um Zeit zu sparen
		for(int a = j.length-1 ; b == false ; a-- ){
			if(j[a] == i){
				b = true;
				d = a;
			}
		}
		if(d == 0)
			throw new PRException("Keine treffer gefunden" + i);
		return d;
	}



	public static void main(String[] args) {
		// Hier verienbaren wir die Die Anzahl der Positionen.
		int numberCount = 0;
		println("Geben sie die anzahl der Zahlen an: ");
		numberCount=readInt();

		//Hier vereinbaren wir die Zahl nach der wir suchen.

		int numberToSearch = 0;
		println("Geben sie die Zahl die gesucht werden soll: ");
		numberToSearch=readInt();

		//Hier übergeben wir das Ergebniss aus der methode an unsesrer neuershafenen array.

		int[] randomNumbers = generate(numberCount);

		//Hier schreiben wir die Ergebnesse aus unserer zweiten Funktion in unserer neuerschafenen Array rein.

		int[] matchesFound = searchAll(randomNumbers , numberToSearch);


		println(searchFirst(randomNumbers , numberToSearch));

		//Hier rufen wir unsere letze Funktion ab und schreiben den wert in die Console raus 
		println(searchLast(randomNumbers , numberToSearch));

		//Hier uberprüfen wir ob unsere Array uberhaupt Elemente hat und falls ja, schreiben wir sie in der console raus.

		if(matchesFound.length>0){

			for(int i = 0 ;i < matchesFound.length; i++ ){
				print(matchesFound[i]);
			}
		}


	}

}

