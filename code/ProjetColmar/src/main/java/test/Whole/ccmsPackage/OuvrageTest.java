package test.Whole.ccmsPackage;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import Whole.ccmsPackage.Personne;
import Whole.ccmsPackage.Ouvrage;
import org.junit.jupiter.api.Test;

class OuvrageTest {
	/**
	 * Teste que le premier constructeur n'accepte pas null en tant que titre.
	 */
	@Test
	void testConstructeurTitreNull() {
		Ouvrage ouvrage=new Ouvrage(null, 5);
		assertFalse(ouvrage.getTitre() == null);
	}
	
	/**
	 * Teste que le premier constructeur n'accepte pas un id n�gatif.
	 */
	@Test
	void testConstructeurIdNegatif() {
		Ouvrage ouvrage=new Ouvrage("Test", -2);
		assertFalse(ouvrage.getId() < 0);
	}
	
	/**
	 * Teste que le constructeur pour les copies n'accepte pas de titre null.
	 */
	@Test
	void testConstructeurCopieTitreNull() {
		Ouvrage ouvrage=new Ouvrage(null, new ArrayList<Personne>(), new Personne(), new Personne(), "lieuEdition", 0000, 10, 1, "format", "resolution", "creditResolution", false, "copyright");
		assertFalse(ouvrage.getTitre() == null);
	}
	
	/**
	 * Teste que le constructeur pour les copies n'accepte pas d'auteur null.
	 */
	@Test
	void testConstructeurCopieAuteurNull() {
		Ouvrage ouvrage=new Ouvrage("titre", null, new Personne(), new Personne(), "lieuEdition", 0000, 10, 1, "format", "resolution", "creditResolution", false, "copyright");
		assertTrue(ouvrage.getAuteurs().isEmpty());
	}
	
	/**
	 * Teste que le constructeur pour les copies n'accepte pas de libraire null.
	 */
	@Test
	void testConstructeurCopieEditeurNull() {
		Ouvrage ouvrage=new Ouvrage("titre", new ArrayList<Personne>(), null, new Personne(), "lieuEdition", 0000, 10,  1, "format", "resolution", "creditResolution", false, "copyright");
		assertFalse(ouvrage.getLibraire() == null);
	}
	
	/**
	 * Teste que le constructeur pour les copies n'accepte pas d'imprimeur null.
	 */
	@Test
	void testConstructeurCopieImprimeurNull() {
		Ouvrage ouvrage=new Ouvrage("titre", new ArrayList<Personne>(), new Personne(), null, "lieuEdition", 0000, 10, 1, "format", "resolution", "creditResolution", false, "copyright");
		assertFalse(ouvrage.getImprimeur() == null);
	}
	
	/**
	 * Teste que le constructeur pour les copies n'accepte pas LieuEdition null.
	 */
	@Test
	void testConstructeurCopieLieuEditionNull() {
		Ouvrage ouvrage=new Ouvrage("titre", new ArrayList<Personne>(), new Personne(), new Personne(), null, 0000, 10, 1, "format", "resolution", "creditResolution", false, "copyright");
		assertFalse(ouvrage.getLieuEdition() == null);
	}
	
	/**
	 * Teste que le constructeur pour les copies n'accepte pas de date au-del� de 10000.
	 */
	@Test
	void testConstructeurCopieDateEditionImpossible() {
		Ouvrage ouvrage=new Ouvrage("titre", new ArrayList<Personne>(), new Personne(), new Personne(), "lieuEdition", 52023, 10, 1, "format", "resolution", "creditResolution", false, "copyright");
		assertTrue(ouvrage.getDateEdition() < 10000);
	}
	
	/**
	 * Teste que le constructeur pour les copies n'accepte pas de nombre de pages n�gatif.
	 */
	@Test
	void testConstructeurCopieNbPageNegatif() {
		Ouvrage ouvrage=new Ouvrage("titre", new ArrayList<Personne>(), new Personne(), new Personne(), "lieuEdition", 0000, -5, 1, "format", "resolution", "creditResolution", false, "copyright");
		assertFalse(ouvrage.getNbPage() < 0);
	}
	
	/**
	 * Teste que le constructeur pour les copies n'accepte pas d'id n�gatif.
	 */
	@Test
	void testConstructeurCopieIdNegatif() {
		Ouvrage ouvrage=new Ouvrage("titre", new ArrayList<Personne>(), new Personne(), new Personne(), "lieuEdition", 0000, 10, -5, "format", "resolution", "creditResolution", false, "copyright");
		assertFalse(ouvrage.getId() < 0);
	}
	
	/**
	 * Teste que le constructeur pour les copies n'accepte pas de format null.
	 */
	@Test
	void testConstructeurCopieFormatNull() {
		Ouvrage ouvrage=new Ouvrage("titre", new ArrayList<Personne>(), new Personne(), new Personne(), "lieuEdition", 0000, 10, 1, null, "resolution", "creditResolution", false, "copyright");
		assertFalse(ouvrage.getFormat() == null);
	}
	
	/**
	 * Teste que le constructeur pour les copies n'accepte pas de r�solution null.
	 */
	@Test
	void testConstructeurCopieResolutionNull() {
		Ouvrage ouvrage=new Ouvrage("titre", new ArrayList<Personne>(),new Personne(), new Personne(), "lieuEdition", 0000, 10, 1, "format", null, "creditResolution", false, "copyright");
		assertFalse(ouvrage.getResolution() == null);
	}
	
	/**
	 * Teste que le constructeur pour les copies n'accepte pas de cr�dit r�solution null.
	 */
	@Test
	void testConstructeurCopieCreditResolutionNull() {
		Ouvrage ouvrage=new Ouvrage("titre", new ArrayList<Personne>(), new Personne(), new Personne(), "lieuEdition", 0000, 10, 1, "format", "resolution", null, false, "copyright");
		assertFalse(ouvrage.getCreditResolution() == null);
	}
	
	/**
	 * Teste que le constructeur pour les copies n'accepte pas de copyright null.
	 */
	@Test
	void testConstructeurCopieCopyrightNull() {
		Ouvrage ouvrage=new Ouvrage("titre", new ArrayList<Personne>(), new Personne(), new Personne(), "lieuEdition", 0000, 10, 1, "format", "resolution", "creditResolution", false, null);
		assertFalse(ouvrage.getCopyright() == null);
	}
	
	/**
	 * Teste que setFormat n'accepte pas de format null.
	 */
	@Test
	void testSetFormatNull() {
		Ouvrage ouvrage=new Ouvrage("titre", 5);
		ouvrage.setFormat(null);
		assertFalse(ouvrage.getFormat() == null);
	}
	
	/**
	 * Teste que setResolution n'accepte pas de r�solution null.
	 */
	@Test
	void testSetResolutionNull() {
		Ouvrage ouvrage=new Ouvrage("titre", 5);
		ouvrage.setResolution(null);
		assertFalse(ouvrage.getResolution() == null);
	}
	
	/**
	 * Teste que setCreditFormat n'accepte pas de cr�dit format null.
	 */
	@Test
	void testSetCreditResolutionNull() {
		Ouvrage ouvrage=new Ouvrage("titre", 5);
		ouvrage.setCreditResolution(null);
		assertFalse(ouvrage.getCreditResolution() == null);
	}
	
	/**
	 * Teste que setCopyright n'accepte pas de copyright null.
	 */
	@Test
	void testSetCopyrightNull() {
		Ouvrage ouvrage=new Ouvrage("titre", 5);
		ouvrage.setCopyright(null);
		assertFalse(ouvrage.getCopyright() == null);
	}
	
	/**
	 * Teste que setTitre n'accepte pas de titre null.
	 */
	@Test
	void testSetTitreNull() {
		Ouvrage ouvrage=new Ouvrage("titre", 5);
		ouvrage.setTitre(null);
		assertFalse(ouvrage.getTitre() == null);
	}
	
	/**
	 * Teste que setAuteurs n'accepte pas d'auteurs null.
	 */
	@Test
	void testSetAuteursNull() {
		Ouvrage ouvrage=new Ouvrage("titre", 5);
		ouvrage.setAuteurs(null);
		assertFalse(ouvrage.getAuteurs() == null);
	}
	
	/**
	 * Teste que setLibraire n'accepte pas de libraire null.
	 */
	@Test
	void testSetLibraireNull() {
		Ouvrage ouvrage=new Ouvrage("titre", 5);
		ouvrage.setLibraire(null);
		assertFalse(ouvrage.getLibraire() == null);
	}
	
	/**
	 * Teste que setImprimeur n'accepte pas d'imprimeur null.
	 */
	@Test
	void testSetImprimeurNull() {
		Ouvrage ouvrage=new Ouvrage("titre", 5);
		ouvrage.setImprimeur(null);
		assertFalse(ouvrage.getImprimeur() == null);
	}
	
	/**
	 * Teste que setLieuEdition n'accepte pas de lieu d'�dition null.
	 */
	@Test
	void testSetLieuEditionNull() {
		Ouvrage ouvrage=new Ouvrage("titre", 5);
		ouvrage.setLieuEdition(null);
		assertFalse(ouvrage.getLieuEdition() == null);
	}
	
	/**
	 * Teste que setNbPage n'accepte pas de nombre de pages n�gatif.
	 */
	@Test
	void testSetNbPageNegatif() {
		Ouvrage ouvrage=new Ouvrage("titre", 5);
		ouvrage.setNbPage(-5);
		assertFalse(ouvrage.getNbPage() < 0);
	}
	
	/**
	 * Teste que setDateEdition n'accepte pas de date au dessus de 10000.
	 */
	@Test
	void testSetDateEditionImpossible() {
		Ouvrage ouvrage=new Ouvrage("titre", 5);
		ouvrage.setDateEdition(15000);
		assertTrue(ouvrage.getDateEdition() < 10000);
	}
	
	/**
	 * Teste que addAuteur ajoute correctement un auteur.
	 */
	@Test
	void testAddAuteur() {
		Ouvrage ouvrage=new Ouvrage("titre", 5);
		Personne test=new Personne(1, "Personne", "Test");
		ouvrage.addAuteur(test);
		assertTrue(ouvrage.getAuteurs().contains(test));
	}
	
	/**
	 * Teste que addAuteur n'ajoute pas d'auteur null.
	 */
	@Test
	void testAddAuteurNull() {
		Ouvrage ouvrage=new Ouvrage("titre", 5);
		ouvrage.addAuteur(null);
		assertFalse(ouvrage.getAuteurs().contains(null));
	}
	
	/**
	 * Teste que addAuteur n'ajoute pas de doublons � la liste.
	 */
	@Test
	void testAddAuteurDoublon() {
		Ouvrage ouvrage=new Ouvrage("titre", 5);
		Personne test=new Personne(1, "Personne", "Test");
		ouvrage.addAuteur(test);
		ouvrage.addAuteur(test);
		Set<Personne> set=new HashSet<Personne>(ouvrage.getAuteurs());
		assertFalse(set.size() < ouvrage.getAuteurs().size());
	}
	
	/**
	 * Teste que retirerAuteur fonctionne correctement.
	 */
	@Test
	void testRetirerAuteur() {
		Ouvrage ouvrage=new Ouvrage("titre", 5);
		Personne test=new Personne(1, "Personne", "Test");
		ouvrage.retirerAuteur(test);
		assertFalse(ouvrage.getAuteurs().contains(test));
	}
}
