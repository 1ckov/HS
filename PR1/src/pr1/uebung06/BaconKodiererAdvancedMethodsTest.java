package pr1.uebung06;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import pr.MakeItSimple.PRException;

public class BaconKodiererAdvancedMethodsTest {
	
	/*
	 * Verstecken
	 */
	
	@Test
	public void versteckeNachricht1() throws Exception {
		String steganogramm = BaconKodiererImpl.versteckeNachricht("Wikipedia",
				"Dies ist eine fast unauffÄllige Nachricht, oder etwa nicht?");
		assertEquals(
				"DiEs isT eine FasT uNauffÄLLige NachriCHt, Oder etwa nicht?",
				steganogramm);
	}

	@Test
	public void versteckeNachricht2() throws Exception {
		String steganogramm = BaconKodiererImpl.versteckeNachricht(
						"Treffen uns um drei Uhr am Bahnhof!",
						"Am Anfang schuf Gott Himmel und Erde. Und die Erde war wüst und leer, und es war finster auf der Tiefe; und der Geist Gottes schwebte auf dem Wasser. Und Gott sprach: Es werde Licht! und es ward Licht.");
		assertEquals(
				"Am aNfAng schuF gott HiMmeL uNd eRde. uND diE erDE wAR wüSt unD LeeR, UnD eS War fINSter auf Der tIefe; Und DEr gEIST gottes schwEbTE auf dEm wasser. UND gOTt sprACH: eS WeRde LiCht! und es ward Licht.",
				steganogramm);
	}

//	@Test
//	public void versteckeLeereNachrichtInLeeremTrägermedium() throws Exception {
//		assertEquals("",
//				BaconKodierer.versteckeNachricht("", ""));
//	}

	@Test(expected=PRException.class)
	public void versteckeNichtleereNachrichtInLeeremTrägermedium() throws Exception {
		BaconKodiererImpl.versteckeNachricht("Wikipedia", "");
	}

	@Test
	public void versteckeLeerstringAlsNachricht() throws Exception {
		String steganogramm = BaconKodiererImpl.versteckeNachricht("",
				"Dies ist eine fast unauffällige Nachricht, oder etwa nicht?");
		assertEquals(
				"Dies ist eine fast unauffällige Nachricht, oder etwa nicht?",
				steganogramm);
	}

//	@Test(expected=PRException.class)
//	public void versteckeNullNachricht() throws Exception {
//		BaconKodierer.versteckeNachricht(null,
//				"Dies ist eine fast unauffällige Nachricht, oder etwa nicht?");
//	}

//	@Test(expected=PRException.class)
//	public void versteckeNachrichtInNullTrägermedium() throws Exception {
//			BaconKodierer.versteckeNachricht("Wikipedia", null);
//	}

	@Test(expected=PRException.class)
	public void versteckeNachrichtInZuKurzemTrägermedium() throws Exception {
			BaconKodiererImpl.versteckeNachricht("AB", "HalloHall");
	}

	@Test
	public void versteckeNachrichtInGenauPassendemTrägermedium() throws Exception {
		assertEquals("hallohällO", 
				BaconKodiererImpl.versteckeNachricht("AB", "HalloHällo"));
	}

	@Test
	public void versteckeNachrichtInTrägermediumMitZusätzlichemGroßbuchstaben() throws Exception {
		assertEquals("hallohallOX", 
				BaconKodiererImpl.versteckeNachricht("AB", "HalloHalloX"));
	}

	@Test
	public void versteckeNachrichtInTrägermediumMitZusätzlichemKleinbuchstaben() throws Exception {
		assertEquals("hallohallOx", 
				BaconKodiererImpl.versteckeNachricht("AB", "HalloHallox"));
	}

	@Test
	public void versteckeNachrichtInTrägermediumMitZusätzlichemSonderzeichen() throws Exception {
		assertEquals("hallohallO!", 
				BaconKodiererImpl.versteckeNachricht("AB", "HalloHallo!"));
	}

	@Test
	public void versteckeNachrichtInTrägermediumMitZusätzlichemSZ() throws Exception {
		assertEquals("hallohallOß", 
				BaconKodiererImpl.versteckeNachricht("AB", "HalloHalloß"));
	}

	@Test
	public void versteckeNachrichtInTrägermediumMitKleinenUmlautenInDerMitte() throws Exception {
		assertEquals("hallohÄÖÜA", 
				BaconKodiererImpl.versteckeNachricht("AQ", "HalloHäöüa"));
	}

	@Test
	public void versteckeNachrichtInTrägermediumMitGroßenUmlautenInDerMitte() throws Exception {
		assertEquals("hallohäöüA", 
				BaconKodiererImpl.versteckeNachricht("AB", "HalloHÄÖÜa"));
	}

	@Test
	public void versteckeNachrichtInTrägermediumMitSZInDerMitte() throws Exception {
		assertEquals("halloßhallO", 
				BaconKodiererImpl.versteckeNachricht("AB", "HalloßHallo"));
	}

	@Test
	public void versteckeNachrichtInTrägermediumMitSonderzeichenInDerMitte() throws Exception {
		assertEquals("hallo!hallO", 
				BaconKodiererImpl.versteckeNachricht("AB", "Hallo!Hallo"));
	}

	@Test
	public void versteckeNachrichtInTrägermediumMitLeerzeichenInDerMitte() throws Exception {
		assertEquals("hallo hallO", 
				BaconKodiererImpl.versteckeNachricht("AB", "Hallo Hallo"));
	}
	
	
	/*
	 * Zeigen
	 */


	@Test
	public void zeigeNachricht1() throws Exception {
		String steganogramm = "DiEs isT eine FasT uNauffÄLLige NachriCHt, Oder etwa nicht?";
		assertEquals("WIKIPEDIA", 
				BaconKodiererImpl.zeigeNachricht(steganogramm));
	}

	@Test
	public void zeigeNachricht2() throws Exception {
		String steganogramm = "Am aNfAng schuF gott HiMmeL uNd eRde. uND diE erDE wAR wüSt unD LeeR, UnD eS War fINSter auf Der tIefe; Und DEr gEIST gottes schwEbTE auf dEm wasser. UND gOTt sprACH: eS WeRde LiCht! und es ward Licht.";
		assertEquals("TREFFENUNSUMDREIUHRAMBAHNHOFAAI", 
				BaconKodiererImpl.zeigeNachricht(steganogramm));
	}
	
	@Test
	public void zeigeNachrichtAusLeerstring() throws Exception {
		assertEquals("",
				BaconKodiererImpl.zeigeNachricht(""));
	}

	@Test
	public void zeigeNachrichtAus1BitSteganogramm() throws Exception {
		assertEquals("",
				BaconKodiererImpl.zeigeNachricht("a"));
	}

	@Test
	public void zeigeNachrichtAus2BitSteganogramm() throws Exception {
		assertEquals("",
				BaconKodiererImpl.zeigeNachricht("ab"));
	}

	@Test
	public void zeigeNachrichtAus3BitSteganogramm() throws Exception {
		assertEquals("",
				BaconKodiererImpl.zeigeNachricht("abc"));
	}

	@Test
	public void zeigeNachrichtAus4BitSteganogramm() throws Exception {
		assertEquals("",
				BaconKodiererImpl.zeigeNachricht("abcd"));
	}

	@Test
	public void zeigeNachrichtAus5BitSteganogramm() throws Exception {
		assertEquals("A",
				BaconKodiererImpl.zeigeNachricht("abcde"));
	}

//	@Test(expected=PRException.class)
//	public void zeigeNachrichtAusNullSteganogramm() throws Exception {
//			BaconKodierer.zeigeNachricht(null);
//	}

	@Test
	public void zeigeNachrichtAusGenauPassendemTrägermedium() throws Exception {
		assertEquals("AB",
				BaconKodiererImpl.zeigeNachricht("hallohällO"));
	}

	@Test
	public void zeigeNachrichtAusTrägermediumMitZusätzlichemGroßbuchstaben() throws Exception {
		assertEquals("AB",
				BaconKodiererImpl.zeigeNachricht("hallohallOX"));
	}

	@Test
	public void zeigeNachrichtAusTrägermediumMitZusätzlichemKleinbuchstaben() throws Exception {
		assertEquals("AB",
				BaconKodiererImpl.zeigeNachricht("hallohallOx"));
	}

	@Test
	public void zeigeNachrichtAusTrägermediumMitZusätzlichemSonderzeichen() throws Exception {
		assertEquals("AB",
				BaconKodiererImpl.zeigeNachricht("hallohallO!"));
	}

	@Test
	public void zeigeNachrichtAusTrägermediumMitGroßemUmlautInDerMitte() throws Exception {
		assertEquals("AB",
				BaconKodiererImpl.zeigeNachricht("hallohäöüA"));
	}

	@Test
	public void zeigeNachrichtAusTrägermediumMitKleinemUmlautInDerMitte() throws Exception {
		assertEquals("AQ",
				BaconKodiererImpl.zeigeNachricht("hallohÄÖÜA"));
	}

	@Test
	public void zeigeNachrichtAusTrägermediumMitSZInDerMitte() throws Exception {
		assertEquals("AB",
				BaconKodiererImpl.zeigeNachricht("halloßhallO"));
	}

	@Test
	public void zeigeNachrichtAusTrägermediumMitLeerzeichenInDerMitte() throws Exception {
		assertEquals("AB",
				BaconKodiererImpl.zeigeNachricht("hallo hallO"));
	}

	@Test
	public void zeigeNachrichtAusTrägermediumMitSonderzeichenInDerMitte() throws Exception {
		assertEquals("AB",
				BaconKodiererImpl.zeigeNachricht("hallo!hallO"));
	}

}
