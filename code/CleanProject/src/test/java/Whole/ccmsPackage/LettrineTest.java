package Whole.ccmsPackage;

import Whole.Metadonnee;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

class LettrineTest {

    private Metadonnee metaTest1 = new Metadonnee("Couleur", 1, "vert", "", "couleur de la lettrine");
    private Metadonnee metaTest2 = new Metadonnee("Couleur", 2, "noir", "", "couleur de la bordure");
    private ArrayList<Metadonnee> metaArray;
    private Ouvrage ouvrageTest = new Ouvrage();
    private ArrayList<Tag> tagArray = new ArrayList<>();
    private Lettrine lettrineTest;

    /**
     * ajout d'une métadonnée dont tous les champs sont remplis
     */
    public boolean ajouterDT1() {
        Metadonnee meta = new Metadonnee("Dimensions", 3, "hauteur", "px", "hauteur de la Lettrine");
        ArrayList<Metadonnee> arrayTest = new ArrayList<>(metaArray);
        ArrayList<Metadonnee> metaTest = new ArrayList<>(metaArray);
        arrayTest.add(meta);
        Lettrine lettrineTest = new Lettrine(ouvrageTest, metaTest, 188, 1, tagArray, "url");

        lettrineTest.ajouterMetadonnees(meta);
        return lettrineTest.getMetadonnees().equals(arrayTest);
    }

    /**
     * ajout d'une métadonnée vide
     */
    public boolean ajouterDT2() {
        Metadonnee meta = new Metadonnee();
        ArrayList<Metadonnee> arrayTest = new ArrayList<>(metaArray);
        ArrayList<Metadonnee> metaTest = new ArrayList<>(metaArray);
        Lettrine lettrineTest = new Lettrine(ouvrageTest, metaTest, 188, 1, tagArray, "url");

        lettrineTest.ajouterMetadonnees(meta);
        return lettrineTest.getMetadonnees().equals(arrayTest);
    }

    /**
     * ajout d'une métadonnée dont tous les champs sont nulls
     */
    public boolean ajouterDT3() {
        Metadonnee meta = new Metadonnee(null, -1, null, null, null);
        ArrayList<Metadonnee> arrayTest = new ArrayList<>(metaArray);
        ArrayList<Metadonnee> metaTest = new ArrayList<>(metaArray);
        Lettrine lettrineTest = new Lettrine(ouvrageTest, metaTest, 188, 1, tagArray, "url");

        lettrineTest.ajouterMetadonnees(meta);
        return lettrineTest.getMetadonnees().equals(arrayTest);
    }

    /**
     * ajout d'une métadonnée dont seul l'id et le nom sont remplis
     */
    public boolean ajouterDT4() {
        Metadonnee meta = new Metadonnee("bordure", 5, null, null, null);
        ArrayList<Metadonnee> arrayTest = new ArrayList<>(metaArray);
        ArrayList<Metadonnee> metaTest = new ArrayList<>(metaArray);
        arrayTest.add(meta);
        Lettrine lettrineTest = new Lettrine(ouvrageTest, metaArray, 188, 1, tagArray, "url");

        lettrineTest.ajouterMetadonnees(meta);
        return lettrineTest.getMetadonnees().equals(arrayTest);
    }

    /**
     * test de la suppression d'une métadonnée dont tous les champs sont remplis
     */
    public boolean supprimerDT1() {
        Metadonnee meta = new Metadonnee("Dimensions", 3, "hauteur", "px", "hauteur de la Lettrine");
        ArrayList<Metadonnee> arrayTest = new ArrayList<>(metaArray);
        ArrayList<Metadonnee> metaTest = new ArrayList<>(metaArray);
        arrayTest.add(meta);
        metaTest.add(meta);
        arrayTest.remove(metaTest1);
        Lettrine lettrineTest = new Lettrine(ouvrageTest, metaTest, 188, 1, tagArray, "url");

        lettrineTest.supprimerMetadonnees(metaTest1);
        return lettrineTest.getMetadonnees().equals(arrayTest);
    }

    /**
     * suppression d'une métadonnée vide
     */
    public boolean supprimerDT2() {
        Metadonnee meta = new Metadonnee();
        ArrayList<Metadonnee> arrayTest = new ArrayList<>(metaArray);
        ArrayList<Metadonnee> metaTest = new ArrayList<>(metaArray);
        Lettrine lettrineTest = new Lettrine(ouvrageTest, metaTest, 188, 1, tagArray, "url");

        lettrineTest.supprimerMetadonnees(meta);
        return lettrineTest.getMetadonnees().equals(arrayTest);
    }

    /**
     * suppression d'une métadonnée dont tous les champs sont nuls
     */
    public boolean supprimerDT3() {
        Metadonnee meta = new Metadonnee(null, -1, null, null, null);
        ArrayList<Metadonnee> arrayTest = new ArrayList<>(metaArray);
        ArrayList<Metadonnee> metaTest = new ArrayList<>(metaArray);
        Lettrine lettrineTest = new Lettrine(ouvrageTest, metaTest, 188, 1, tagArray, "url");

        lettrineTest.supprimerMetadonnees(meta);
        return lettrineTest.getMetadonnees().equals(arrayTest);
    }

    @Test
    void ajouterMetadonnees() {
        assertTrue(ajouterDT1());
        assertTrue(ajouterDT2());
        assertTrue(ajouterDT3());
        assertTrue(ajouterDT4());
    }

    @Test
    void supprimerMetadonnees() {
        assertTrue(supprimerDT1());
        assertTrue(supprimerDT2());
        assertTrue(supprimerDT3());
    }
}
