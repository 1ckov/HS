package pr1.uebung06;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import pr.MakeItSimple.PRException;

public class BaconKodiererBaseMethodsTest {
	
	/*
	 * Reinigen
	 */
	
	@Test
	public void reinigeSonderzeichen() throws Exception {
		assertEquals("HALLOWELT", 
				BaconKodiererImpl.reinigeNachricht("\n\n\t %$_*'Hal lo~'?@Welt'! #"));
	}

	@Test
	public void reinigeUmlaute() throws Exception {
		assertEquals("AEOEUESSAEOEUE", 
				BaconKodiererImpl.reinigeNachricht("äöüßÄÖÜ"));
	}

	@Test
	public void reinigeLeerstring() throws Exception {
		assertEquals("", 
				BaconKodiererImpl.reinigeNachricht(""));
	}

//	@Test(expected=PRException.class)
//	public void reinigeNull() throws Exception {
//		BaconKodierer.reinigeNachricht(null);
//	}
	
	
	/*
	 * Kodieren
	 */
	
	final static String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	final static String ALPHABET_BINÄR = "kkkkkkkkkgkkkgkkkkggkkgkkkkgkgkkggkkkgggkgkkkkgkkkkgkkgkgkgkkgkggkggkkkggkgkgggkkgggggkkkkgkkkggkkgkgkkgggkkgggkgkkgkgkggkggkgkggg";
	final static String ALPHABET_DEKODIERT = "ABCDEFGHIIKLMNOPQRSTUUWXYZ";

	@Test
	public void kodiereKomplettesAlphabet() throws Exception {
		assertEquals(ALPHABET_BINÄR, 
				BaconKodiererImpl.kodiereNachricht(ALPHABET));
	}

	@Test
	public void kodiereLeerstring() throws Exception {
		assertEquals("", 
				BaconKodiererImpl.kodiereNachricht(""));
	}

	@Test(expected=PRException.class)
	public void kodiereKleinbuchstaben() throws Exception {
		BaconKodiererImpl.kodiereNachricht("a");
	}

	@Test(expected=PRException.class)
	public void kodiereSonderzeichen() throws Exception {
		BaconKodiererImpl.kodiereNachricht("*");
	}

//	@Test(expected=PRException.class)
//	public void kodiereNull() throws Exception {
//		BaconKodierer.kodiereNachricht(null);
//	}
	
	
	/*
	 * Dekodieren
	 */

	@Test
	public void dekodiereLeerstring() throws Exception {
		assertEquals("", 
				BaconKodiererImpl.dekodiereNachricht(""));
	}

	@Test
	public void dekodiereKomplettesAlphabet() throws Exception {
		assertEquals(ALPHABET_DEKODIERT, 
				BaconKodiererImpl.dekodiereNachricht(ALPHABET_BINÄR));
	}

	@Test
	public void dekodiereKomplettesAlphabetPlus1Bit() throws Exception {
		assertEquals(ALPHABET_DEKODIERT, 
				BaconKodiererImpl.dekodiereNachricht(ALPHABET_BINÄR + "k"));
	}

	@Test
	public void dekodiereKomplettesAlphabetPlus2Bit() throws Exception {
		assertEquals(ALPHABET_DEKODIERT, 
				BaconKodiererImpl.dekodiereNachricht(ALPHABET_BINÄR + "kk"));
	}

	@Test
	public void dekodiereKomplettesAlphabetPlus3Bit() throws Exception {
		assertEquals(ALPHABET_DEKODIERT, 
				BaconKodiererImpl.dekodiereNachricht(ALPHABET_BINÄR + "kkk"));
	}

	@Test
	public void dekodiereKomplettesAlphabetPlus4Bit() throws Exception {
		assertEquals(ALPHABET_DEKODIERT, 
				BaconKodiererImpl.dekodiereNachricht(ALPHABET_BINÄR + "kkkk"));
	}

	@Test
	public void dekodiere1Bit() throws Exception {
		assertEquals("", 
				BaconKodiererImpl.dekodiereNachricht("k"));
	}

	@Test
	public void dekodiere2Bit() throws Exception {
		assertEquals("", 
				BaconKodiererImpl.dekodiereNachricht("kk"));
	}

	@Test
	public void dekodiere3Bit() throws Exception {
		assertEquals("", 
				BaconKodiererImpl.dekodiereNachricht("kkk"));
	}

	@Test
	public void dekodiere4Bit() throws Exception {
		assertEquals("", 
				BaconKodiererImpl.dekodiereNachricht("kkkk"));
	}

	@Test
	public void dekodiere5Bit() throws Exception {
		assertEquals("A", 
				BaconKodiererImpl.dekodiereNachricht("kkkkkk"));
	}


	@Test
	public void dekodiereAlleUngültigenSequenzen() throws Exception {
		assertEquals("########", 
				BaconKodiererImpl.dekodiereNachricht("ggkkkggkkgggkgkggkgggggkkgggkgggggkggggg"));
	}

//	@Test(expected=PRException.class)
//	public void dekodiereNull() throws Exception {
//		BaconKodierer.dekodiereNachricht(null);
//	}

}
