package pr1.uebung06;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BaconKodierer1stTest {

	BaconKodiererImpl kodierer = new BaconKodiererImpl();

	@Test
	public void reinigeNachricht() {
		assertEquals("HALLOSCHOENEWELT", BaconKodiererImpl.reinigeNachricht("Hallo, schöne Welt!"));
	}

	@Test
	public void kodiereNachricht() {
		assertEquals("kkgggkkkkkkgkgkkgkgkkggkggkgkkkkgkkkgkgkgkkgk", BaconKodiererImpl.kodiereNachricht("HALLOWELT"));
	}

	@Test
	public void dekodiereNachricht() {
		assertEquals("HALLOWELT",
				BaconKodiererImpl.dekodiereNachricht("kkgggkkkkkkgkgkkgkgkkggkggkgkkkkgkkkgkgkgkkgk"));
	}

	@Test
	public void versteckeNachricht() {
		String traegerMedium = "Mein Name ist Juan Sanchez Villa-Lobos Ramirez, "
				+ "oberster Metallurge am Hofe König Karl V. von Spanien; "
				+ "ich wurde 896 vor Christus in Ägypten geboren und " + "bin unsterblich seit 846 vor Christus.";
		String steganogramm = "MeiN nAme ist jUan saNcHez ViLla-LoboS RamIreZ, ObERstEr meTAllURgE aM Hofe KÖNig karl V. von SpanIen; ICh wURDE 896 vor christuS iN ÄgyptEn geboreN UNd BIn unsTERbLIcH seIt 846 Vor christus.";
		assertEquals(steganogramm,
				BaconKodiererImpl.versteckeNachricht("Treffen uns um drei Uhr am Bahnhof!", traegerMedium));
	}

	@Test
	public void zeigeNachricht() {
		String steganogramm = "es IST trauriG zU deNkEn, dIE nATuR spriCht uNd KeIneR hÃ¶rt zu.";
		String entschlüsselterText = BaconKodiererImpl.zeigeNachricht(steganogramm);
		assertTrue(entschlüsselterText.startsWith("HALLOWELT"));
	}

}