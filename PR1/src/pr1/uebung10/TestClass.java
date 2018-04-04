package pr1.uebung10;
import static pr.MakeItSimple.readStringArray;

import pr1.uebung07.StringExtension;

public class TestClass {

	public static void main(String[] args) {
//		String name = "Hello Darkness";
//		String album = "Some Album";
//		String[] artists = {"Simon", "Garfunkel"};
//		String name1 = "Hallo Darkness";
//		String album1 = "Same Albusdadm";
//		String[] artists1 = {"Simson", "Garfunskel"};
//		String name2 = "Hbllo Darkness";
//		String album2 = "Soee Album";
//		String[] artists2 = {"Simon", "Garfunkel"};
//		ISong third = new Song(name2,album2,artists2);
//		ISong second = new Song(name1,album1,artists1);
//		ISong first = new Song(name,album,artists);
//		String test = first.getSongName();
//		System.out.println(test);
//		OrderedList liste = new LinkedList();
//		liste.add(first);
//		liste.add(second);
//		liste.add(third);
//		liste.add(second);
//		System.out.println((liste.get(3)).toString());
//		
//		String[] testContent = readStringArray("src/pr1/uebung10/U10 songs.txt");
//		System.out.println(testContent[0]);
//		LinkedList list = new LinkedList();
//		for (String s : testContent) {
//			list.add(new Song(s));
//		}
//		System.out.println(list.get(3).toString());
		String[] testContent = readStringArray("src/pr1/uebung10/U10 songs.txt");
		OrderedList list = new ArrayList();
		for(String song : testContent){
			list.insert(new Song2(song));
		}
		for(int i = 0; i < testContent.length; i++){
			System.out.println(list.get(i) + " " + i);
		}
	}

}
