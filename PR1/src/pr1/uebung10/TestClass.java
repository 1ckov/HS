package pr1.uebung10;

import static pr.MakeItSimple.*;

public class TestClass {
	private static void testMethods() {
		Song first = new Song2("It Don't Matter To Me;Hello, I Must Be Going;Phil Collins");
		Song second = new Song2("Dark Eyed Cajun Woman;Rock & Riesling;Elephant");
		Song third = new Song2("Turn That Damn Thing Off;Kiss & Ride;Jaimi Faulkner");
		Song fourth = new Song2("Scarecrow;Early Singles;Pink Floyd");
		OrderedList liste = new LinkedList();
		liste.insert(first);
		liste.delete(0);
		System.out.println(liste.size());
		liste.insert(first);
		liste.insert(second);
		liste.insert(third);
		liste.insert(fourth);
		System.out.println((liste.get(0)).toString());
		System.out.println((liste.get(1)).toString());
		System.out.println((liste.get(2)).toString());
		System.out.println((liste.get(3)).toString());
		liste.delete(0);
		System.out.println(liste.size());
		System.out.println(liste.indexOf(third.getSongName()));

	}

	private static void testWithTextFile() {
		String[] testContent = readStringArray("src/pr1/uebung10/U10 songs.txt");
		OrderedList list = new LinkedList();
		for (String song : testContent) {
			list.insert(new Song2(song));
		}
		for (int i = 0; i < testContent.length; i++) {
			System.out.println(list.get(i) + " " + (i + 1));
		}
	}

	public static void main(String[] args) {
		testMethods();
//		testWithTextFile();

	}

}
