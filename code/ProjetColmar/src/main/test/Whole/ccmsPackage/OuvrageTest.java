package Whole.ccmsPackage;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

class OuvrageTest {
	@Test
	void testConstructeurTitreNull() {
		Ouvrage ouvrage=new Ouvrage(null, 5);
		assertFalse(ouvrage.getTitre() == null);
	}
	
	@Test
	void testConstructeurIdNegatif() {
		Ouvrage ouvrage=new Ouvrage("Test", -2);
		assertFalse(ouvrage.getId() < 0);
	}
	
	@Test
	void testConstructeurCopieTitreNull() {
		Ouvrage ouvrage=new Ouvrage(null, new ArrayList<Auteur>(), "editeur", "imprimeur", "lieuEdition", 0000, 10, "lien", 1, "format", "resolution", "creditResolution", false, "copyright");
		assertFalse(ouvrage.getTitre() == null);
	}
	
	@Test
	void testConstructeurCopieAuteurNull() {
		Ouvrage ouvrage=new Ouvrage("titre", null, "editeur", "imprimeur", "lieuEdition", 0000, 10, "lien", 1, "format", "resolution", "creditResolution", false, "copyright");
		assertTrue(ouvrage.getAuteurs().isEmpty());
	}
	
	@Test
	void testConstructeurCopieEditeurNull() {
		Ouvrage ouvrage=new Ouvrage("titre", new ArrayList<Auteur>(), null, "imprimeur", "lieuEdition", 0000, 10, "lien", 1, "format", "resolution", "creditResolution", false, "copyright");
		assertFalse(ouvrage.getEditeur() == null);
	}
	
	@Test
	void testConstructeurCopieImprimeurNull() {
		Ouvrage ouvrage=new Ouvrage("titre", new ArrayList<Auteur>(), "editeur", null, "lieuEdition", 0000, 10, "lien", 1, "format", "resolution", "creditResolution", false, "copyright");
		assertFalse(ouvrage.getImprimeur() == null);
	}
	
	@Test
	void testConstructeurCopieLieuEditionNull() {
		Ouvrage ouvrage=new Ouvrage("titre", new ArrayList<Auteur>(), "editeur", "imprimeur", null, 0000, 10, "lien", 1, "format", "resolution", "creditResolution", false, "copyright");
		assertFalse(ouvrage.getLieuEdition() == null);
	}
	
	@Test
	void testConstructeurCopieDateEditionImpossible() {
		Ouvrage ouvrage=new Ouvrage("titre", new ArrayList<Auteur>(), "editeur", "imprimeur", "lieuEdition", 52023, 10, "lien", 1, "format", "resolution", "creditResolution", false, "copyright");
		assertTrue(ouvrage.getDateEdition() < 10000);
	}
	
	@Test
	void testConstructeurCopieNbPageNegatif() {
		Ouvrage ouvrage=new Ouvrage("titre", new ArrayList<Auteur>(), "editeur", "imprimeur", "lieuEdition", 0000, -5, "lien", 1, "format", "resolution", "creditResolution", false, "copyright");
		assertFalse(ouvrage.getNbPage() < 0);
	}
	
	@Test
	void testConstructeurCopieIdNegatif() {
		Ouvrage ouvrage=new Ouvrage("titre", new ArrayList<Auteur>(), "editeur", "imprimeur", "lieuEdition", 0000, 10, "lien", -5, "format", "resolution", "creditResolution", false, "copyright");
		assertFalse(ouvrage.getId() < 0);
	}
	
	@Test
	void testConstructeurCopieFormatNull() {
		Ouvrage ouvrage=new Ouvrage("titre", new ArrayList<Auteur>(), "editeur", "imprimeur", "lieuEdition", 0000, 10, "lien", 1, null, "resolution", "creditResolution", false, "copyright");
		assertFalse(ouvrage.getFormat() == null);
	}
	
	@Test
	void testConstructeurCopieResolutionNull() {
		Ouvrage ouvrage=new Ouvrage("titre", new ArrayList<Auteur>(), "editeur", "imprimeur", "lieuEdition", 0000, 10, "lien", 1, "format", null, "creditResolution", false, "copyright");
		assertFalse(ouvrage.getResolution() == null);
	}
	
	@Test
	void testConstructeurCopieCreditResolutionNull() {
		Ouvrage ouvrage=new Ouvrage("titre", new ArrayList<Auteur>(), "editeur", "imprimeur", "lieuEdition", 0000, 10, "lien", 1, "format", "resolution", null, false, "copyright");
		assertFalse(ouvrage.getCreditResolution() == null);
	}
	
	@Test
	void testConstructeurCopieCopyrightNull() {
		Ouvrage ouvrage=new Ouvrage("titre", new ArrayList<Auteur>(), "editeur", "imprimeur", "lieuEdition", 0000, 10, "lien", 1, "format", "resolution", "creditResolution", false, null);
		assertFalse(ouvrage.getCopyright() == null);
	}
	
	@Test
	void testSetFormatNull() {
		Ouvrage ouvrage=new Ouvrage("titre", 5);
		ouvrage.setFormat(null);
		assertFalse(ouvrage.getFormat() == null);
	}
	
	@Test
	void testSetResolutionNull() {
		Ouvrage ouvrage=new Ouvrage("titre", 5);
		ouvrage.setResolution(null);
		assertFalse(ouvrage.getResolution() == null);
	}
	
	@Test
	void testSetCreditResolutionNull() {
		Ouvrage ouvrage=new Ouvrage("titre", 5);
		ouvrage.setCreditResolution(null);
		assertFalse(ouvrage.getCreditResolution() == null);
	}
	
	@Test
	void testSetCopyrightNull() {
		Ouvrage ouvrage=new Ouvrage("titre", 5);
		ouvrage.setCopyright(null);
		assertFalse(ouvrage.getCopyright() == null);
	}
	
	@Test
	void testSetTitreNull() {
		Ouvrage ouvrage=new Ouvrage("titre", 5);
		ouvrage.setTitre(null);
		assertFalse(ouvrage.getTitre() == null);
	}
	
	@Test
	void testSetAuteursNull() {
		Ouvrage ouvrage=new Ouvrage("titre", 5);
		ouvrage.setAuteurs(null);
		assertFalse(ouvrage.getAuteurs() == null);
	}
	
	@Test
	void testSetEditeurNull() {
		Ouvrage ouvrage=new Ouvrage("titre", 5);
		ouvrage.setEditeur(null);
		assertFalse(ouvrage.getEditeur() == null);
	}
	
	@Test
	void testSetImprimeurNull() {
		Ouvrage ouvrage=new Ouvrage("titre", 5);
		ouvrage.setImprimeur(null);
		assertFalse(ouvrage.getImprimeur() == null);
	}
	
	@Test
	void testSetLieuEditionNull() {
		Ouvrage ouvrage=new Ouvrage("titre", 5);
		ouvrage.setLieuEdition(null);
		assertFalse(ouvrage.getLieuEdition() == null);
	}
	
	@Test
	void testSetNbPageNegatif() {
		Ouvrage ouvrage=new Ouvrage("titre", 5);
		ouvrage.setNbPage(-5);
		assertFalse(ouvrage.getNbPage() < 0);
	}
	
	@Test
	void testSetDateEditionImpossible() {
		Ouvrage ouvrage=new Ouvrage("titre", 5);
		ouvrage.setDateEdition(15000);
		assertTrue(ouvrage.getDateEdition() < 10000);
	}
	
	@Test
	void testAddAuteur() {
		Ouvrage ouvrage=new Ouvrage("titre", 5);
		Auteur test=new Auteur(1, "Auteur", "Test");
		ouvrage.addAuteur(test);
		assertTrue(ouvrage.getAuteurs().contains(test));
	}
	
	@Test
	void testAddAuteurNull() {
		Ouvrage ouvrage=new Ouvrage("titre", 5);
		ouvrage.addAuteur(null);
		assertFalse(ouvrage.getAuteurs().contains(null));
	}
	
	@Test
	void testAddAuteurDoublon() {
		Ouvrage ouvrage=new Ouvrage("titre", 5);
		Auteur test=new Auteur(1, "Auteur", "Test");
		ouvrage.addAuteur(test);
		ouvrage.addAuteur(test);
		Set<Auteur> set=new HashSet<Auteur>(ouvrage.getAuteurs());
		assertFalse(set.size() < ouvrage.getAuteurs().size());
	}
	
	@Test
	void testRetirerAuteur() {
		Ouvrage ouvrage=new Ouvrage("titre", 5);
		Auteur test=new Auteur(1, "Auteur", "Test");
		ouvrage.retirerAuteur(test);
		assertFalse(ouvrage.getAuteurs().contains(test));
	}
}
