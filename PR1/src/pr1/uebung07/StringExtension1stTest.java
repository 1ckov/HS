package pr1.uebung07;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringExtension1stTest {

	@Test
	public void toUpperExample() {
		assertEquals("VIEL ERFOLG BEI DER AUFGABE!", StringExtension.toUpper("Viel Erfolg bei der Aufgabe!"));
	}

	@Test
	public void toUpperRecursiveExample() {
		assertEquals("VIEL ERFOLG BEI DER AUFGABE!", StringExtension.toUpperRecursive("Viel Erfolg bei der Aufgabe!"));
	}
	

	
	@Test
	public void scanExample() {
		assertEquals(7, StringExtension.scan("Hello, world! This world is cool!", "world"));
	}
	
	
	
	@Test
	public void splitExample() {
		assertArrayEquals(new String[]{"Banane","Apfel","Birne"}, StringExtension.split("Banane,Apfel,Birne", ','));
	}
	
}