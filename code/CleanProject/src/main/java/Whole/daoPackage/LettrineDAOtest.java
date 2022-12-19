package Whole.daoPackage;

import Whole.Metadonnee;
import Whole.ccmsPackage.Lettrine;
import Whole.ccmsPackage.Ouvrage;
import Whole.ccmsPackage.Tag;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LettrineDAOtest {
	
	
	private Ouvrage ouvragetest= new Ouvrage();
	private Ouvrage ouvragetest2= new Ouvrage();
	
	private ArrayList<Metadonnee> listeMetaTest = new ArrayList<>();
	private ArrayList<Metadonnee> listeMetaTest2 = new ArrayList<>();
	
	private ArrayList<Tag> listeTagTest = new ArrayList<>();
	private ArrayList<Tag> listeTagTest2 = new ArrayList<>();

	public static Connection cn;
	
	
	/**
	 * test modifier avec des les bon argument 
	 * @return boolean 
	 */
	public boolean modifLettrineTD1() {
		Lettrine l1 = new Lettrine(ouvragetest,listeMetaTest,2,47,listeTagTest,"lien");
		Lettrine l2 = new Lettrine(ouvragetest2,listeMetaTest2,594,496,listeTagTest2,"lien");
		LettrineDAO ldao1 = new LettrineDAO("url", "log", "pwd");
		return ldao1.modifier(l1, l2);
	}
	
	/**
	 * test modifier avec comme 1er argument une lettrine vide  
	 * @return boolean 
	 */
	public boolean modifLettrineTD2() {
		Lettrine l1 = new Lettrine();
		Lettrine l2 = new Lettrine(ouvragetest2,listeMetaTest2,594,496,listeTagTest2,"lien");
		LettrineDAO ldao1 = new LettrineDAO("url", "log", "pwd");
		return ldao1.modifier(l1, l2);
	}
	
	/**
	 * test modifier avec comme 1er argument une lettrine null   
	 * @return boolean 
	 */
	public boolean modifLettrineTD3() {
		Lettrine l1 = new Lettrine(null,null,2,47,null,null);
		Lettrine l2 = new Lettrine(ouvragetest2,listeMetaTest2,594,496,listeTagTest2,"lien");
		LettrineDAO ldao1 = new LettrineDAO("url", "log", "pwd");
		return ldao1.modifier(l1, l2);
	}
	
	/**
	 * test modifier avec comme 2er argument une lettrine vide   
	 * @return boolean 
	 */
	public boolean modifLettrineTD4() {
		Lettrine l1 = new Lettrine(ouvragetest,listeMetaTest,2,47,listeTagTest,"lien");
		Lettrine l2 = new Lettrine();
		LettrineDAO ldao1 = new LettrineDAO("url", "log", "pwd");
		return ldao1.modifier(l1, l2);
	}
	
	/**
	 * test modifier avec comme 2er argument une lettrine null   
	 * @return boolean 
	 */
	public boolean modifLettrineTD5() {
		Lettrine l1 = new Lettrine(ouvragetest,listeMetaTest,2,47,listeTagTest,"lien");
		Lettrine l2 = new Lettrine(null,null,3,47,null,null);
		LettrineDAO ldao1 = new LettrineDAO("url", "log", "pwd");
		return ldao1.modifier(l1, l2);
	}
	
	/**
	 * test modifier avec comme 2er argument une lettrine qui a un lien et une nbpage negatif   
	 * @return boolean 
	 */
	public boolean modifLettrineTD6() {
		Lettrine l1 = new Lettrine(ouvragetest,listeMetaTest,2,47,listeTagTest,"lien");
		Lettrine l2 = new Lettrine(null,null,-1,257,null,"lien4");
		LettrineDAO ldao1 = new LettrineDAO("url", "log", "pwd");
		return ldao1.modifier(l1, l2);
	}
	
	/**
	 * test modifier avec comme 2er argument une lettrine avec une id negative   
	 * @return boolean 
	 */
	public boolean modifLettrineTD7() {
		Lettrine l1 = new Lettrine(ouvragetest,listeMetaTest,2,47,listeTagTest,"lien");
		Lettrine l2 = new Lettrine(null,null,156,-1,null,"lien4");
		LettrineDAO ldao1 = new LettrineDAO("url", "log", "pwd");
		return ldao1.modifier(l1, l2);
	}
	

	@Test
	void modifLettrine() {
		assertTrue(modifLettrineTD1());
		assertFalse(modifLettrineTD2());
		assertFalse(modifLettrineTD3());
		assertFalse(modifLettrineTD4());
		assertFalse(modifLettrineTD5());
		assertTrue(modifLettrineTD6());
		assertFalse(modifLettrineTD7());
		
	}
	
	/**
	 * test la fonction supprimer avec les bon arguments 
	 * @return boolean
	 */
	public boolean suppLettrineDT1() {
		Lettrine l1 = new Lettrine(ouvragetest,listeMetaTest,2,47,listeTagTest,"lien");
		LettrineDAO ldao1 = new LettrineDAO("url", "log", "pwd");
		return ldao1.supprimer(l1);
	}
	
	/**
	 * test la fonction supprimer avec une lettrine vide
	 * @return boolean
	 */
	public boolean suppLettrineDT2() {
		Lettrine l1 = new Lettrine();
		LettrineDAO ldao1 = new LettrineDAO("url", "log", "pwd");
		return ldao1.supprimer(l1);
	}
	
	/**
	 * test la fonction supprimer avec une lettrine null
	 * @return boolean 
	 */
	public boolean suppLettrineDT3() {
		Lettrine l1 = new Lettrine(null,null,2,47,null,null);
		LettrineDAO ldao1 = new LettrineDAO("url", "log", "pwd");
		return ldao1.supprimer(l1);
	}
	
	@Test
	void suppLettrine() {
		assertTrue(suppLettrineDT1());
		assertFalse(suppLettrineDT2());
		assertFalse(suppLettrineDT3());
	
	}
	
	/**
	 * test la fonction cree avec les bon argument 
	 * @return boolean
	 */
	public boolean creeLettrineDT1() {
		Lettrine l1 = new Lettrine(ouvragetest,listeMetaTest,2,47,listeTagTest,"lien");
		LettrineDAO ldao1 = new LettrineDAO("url", "log", "pwd");
		return ldao1.creer(l1);
	}
	
	/**
	 * test la fonction cree avec une lettrine vide
	 * @return boolean 
	 */
	public boolean creeLettrineDT2() {
		Lettrine l1 = new Lettrine();
		LettrineDAO ldao1 = new LettrineDAO("url", "log", "pwd");
		return ldao1.creer(l1);
	}
	
	/**
	 * test la fonction cree avec une lettrine null
	 * @return boolean 
	 */
	public boolean creeLettrineDT3() {
		Lettrine l1 = new Lettrine(null,null,2,47,null,null);
		LettrineDAO ldao1 = new LettrineDAO("url", "log", "pwd");
		return ldao1.creer(l1);
	}
	
	@Test
	void creeLettrine() {
		assertTrue(creeLettrineDT1());
		assertFalse(creeLettrineDT2());
		assertFalse(creeLettrineDT3());
	}
	
	@Test
	void chercherLettrine() {
		
	}
	
	/**
	 * test la fonction tagger avec les bon arguments 
	 * @return boolean 
	 */
	public boolean tagDT1() {
		Tag t1 = new Tag(2, "test", "ahjkfahjkfafhijkga");
		Lettrine l1 = new Lettrine(ouvragetest,listeMetaTest,2,47,listeTagTest,"lien");
		LettrineDAO ldao1 = new LettrineDAO("url", "log", "pwd");
		return ldao1.tager(l1, t1, cn) ;
	}
	
	/**
	 * test la fonction tagger avec un tag vide
	 * @return boolean 
	 */
	public boolean tagDT2() {
		Tag t1 = new Tag();
		Lettrine l1 = new Lettrine(ouvragetest,listeMetaTest,2,47,listeTagTest,"lien");
		LettrineDAO ldao1 = new LettrineDAO("url", "log", "pwd");
		return ldao1.tager(l1, t1, cn) ;
	}
	
	/**
	 * test la fonction tagger avec un tag null
	 * @return boolean 
	 */
	public boolean tagDT3() {
		Tag t1 = new Tag(5, null, null);
		Lettrine l1 = new Lettrine(ouvragetest,listeMetaTest,2,47,listeTagTest,"lien");
		LettrineDAO ldao1 = new LettrineDAO("url", "log", "pwd");
		return ldao1.tager(l1, t1, cn) ;
	}
	
	/**
	 * test la fonction tagger avec une lettrine vide
	 * @return boolean 
	 */
	public boolean tagDT4() {
		Tag t1 = new Tag(2, "test", "ahjkfahjkfafhijkga");
		Lettrine l1 = new Lettrine();
		LettrineDAO ldao1 = new LettrineDAO("url", "log", "pwd");
		return ldao1.tager(l1, t1, cn) ;
	}
	
	/**
	 * test la fonction tagger avec une lettrine null
	 * @return boolean 
	 */
	public boolean tagDT5() {
		Tag t1 = new Tag(2, "test", "ahjkfahjkfafhijkga");
		Lettrine l1 = new Lettrine(null,null,2,47,null,null);
		LettrineDAO ldao1 = new LettrineDAO("url", "log", "pwd");
		return ldao1.tager(l1, t1, cn) ;
	}
	
	@Test
	void TagerLettrine() {
		assertTrue(tagDT1());
		assertFalse(tagDT2());
		assertFalse(tagDT3());
		assertFalse(tagDT4());
		assertFalse(tagDT5());
	}
	
	
	/**
	 * test la fonction ajoutemeta avec les bon arguments 
	 * @return boolean 
	 */
	public boolean ajouteMetaDT1() {
		Metadonnee metatest= new Metadonnee("nom",2,"entree","unite","description");
		Lettrine l1 = new Lettrine(ouvragetest,listeMetaTest,2,47,listeTagTest,"lien");
		LettrineDAO ldao1 = new LettrineDAO("url", "log", "pwd");
		return ldao1.ajouterMeta(metatest, l1, cn);
	}
	
	/**
	 * test la fonction ajoutemeta avec les metadonnee vide
	 * @return boolean 
	 */
	public boolean ajouteMetaDT2() {
		Metadonnee metatest= new Metadonnee();
		Lettrine l1 = new Lettrine(ouvragetest,listeMetaTest,2,47,listeTagTest,"lien");
		LettrineDAO ldao1 = new LettrineDAO("url", "log", "pwd");
		return ldao1.ajouterMeta(metatest, l1, cn);
	}
	
	/**
	 * test la fonction ajoutemeta avec les metadonnee null
	 * @return boolean 
	 */
	public boolean ajouteMetaDT3() {
		Metadonnee metatest= new Metadonnee(null,2,null,null,null);
		Lettrine l1 = new Lettrine(ouvragetest,listeMetaTest,2,47,listeTagTest,"lien");
		LettrineDAO ldao1 = new LettrineDAO("url", "log", "pwd");
		return ldao1.ajouterMeta(metatest, l1, cn);
	}
	
	/**
	 * test la fonction ajoutemeta avec lettrine vide
	 * @return boolean 
	 */
	public boolean ajouteMetaDT4() {
		Metadonnee metatest= new Metadonnee("nom",2,"entree","unite","description");
		Lettrine l1 = new Lettrine();
		LettrineDAO ldao1 = new LettrineDAO("url", "log", "pwd");
		return ldao1.ajouterMeta(metatest, l1, cn);
	}
	
	/**
	 * test la fonction ajoutemeta avec lettrine null
	 * @return boolean 
	 */
	public boolean ajouteMetaDT5() {
		Metadonnee metatest= new Metadonnee("nom",2,"entree","unite","description");
		Lettrine l1 = new Lettrine(null,null,2,47,null,null);
		LettrineDAO ldao1 = new LettrineDAO("url", "log", "pwd");
		return ldao1.ajouterMeta(metatest, l1, cn);
	}
	
	@Test
	void ajouteMeta() {
		assertTrue(ajouteMetaDT1());
		assertFalse(ajouteMetaDT2());
		assertFalse(ajouteMetaDT3());
		assertFalse(ajouteMetaDT4());
		assertFalse(ajouteMetaDT5());	
	}
	
	/**
	 * test la fonction suppmeta avec les bon arguments 
	 * @return boolean 
	 */
	public boolean suppMetaDT1() {
		Metadonnee metatest= new Metadonnee("nom",2,"entree","unite","description");
		LettrineDAO ldao1 = new LettrineDAO("url", "log", "pwd");
		return ldao1.supprimerMeta(metatest, cn);
	}
	
	/**
	 * test la fonction suppmeta avec metadonnee vide
	 * @return boolean 
	 */
	public boolean suppMetaDT2() {
		Metadonnee metatest= new Metadonnee();
		LettrineDAO ldao1 = new LettrineDAO("url", "log", "pwd");
		return ldao1.supprimerMeta(metatest, cn);
	}
	
	/**
	 * test la fonction suppmeta avec metadonnee null 
	 * @return boolean 
	 */
	public boolean suppMetaDT3() {
		Metadonnee metatest= new Metadonnee(null,2,null,null,null);
		LettrineDAO ldao1 = new LettrineDAO("url", "log", "pwd");
		return ldao1.supprimerMeta(metatest, cn);
	}
	
	
	@Test
	void supprimerMeta() {
		assertTrue(suppMetaDT1());
		assertFalse(suppMetaDT2());
		assertFalse(suppMetaDT3());
		
	}
	
	/**
	 * test la fonction modifierMeta avec les bon arguments 
	 * @return boolean 
	 */
	public boolean modifierMetaTD1() {
		Metadonnee metatest= new Metadonnee("nom",2,"entree","unite","description");
		LettrineDAO ldao1 = new LettrineDAO("url", "log", "pwd");
		return ldao1.modifierMeta(metatest, cn);
	}
	
	/**
	 * test la fonction modifierMeta avec metadonnee vide
	 * @return boolean 
	 */
	public boolean modifierMetaTD2() {
		Metadonnee metatest= new Metadonnee();
		LettrineDAO ldao1 = new LettrineDAO("url", "log", "pwd");
		return ldao1.modifierMeta(metatest, cn);
	}
	
	/**
	 * test la fonction modifierMeta avec metadonnee null 
	 * @return boolean 
	 */
	public boolean modifierMetaTD3() {
		Metadonnee metatest= new Metadonnee(null,2,null,null,null);
		LettrineDAO ldao1 = new LettrineDAO("url", "log", "pwd");
		return ldao1.modifierMeta(metatest, cn);
	}
	
	@Test
	void modifierMeta() {
		assertTrue(modifierMetaTD1());
		assertFalse(modifierMetaTD2());
		assertFalse(modifierMetaTD3());
		
	}

}
