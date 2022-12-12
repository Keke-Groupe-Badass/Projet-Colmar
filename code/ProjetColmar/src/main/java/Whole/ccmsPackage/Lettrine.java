/*
* This code has been generated by the Rebel: a code generator for modern Java.
*
* Drop us a line or two at feedback@archetypesoftware.com: we would love to hear from you!
*/
package Whole.ccmsPackage;

import Whole.daoPackage.AbstractDAO;
import Whole.Metadonnee;
import Whole.daoPackage.LettrineDAO;

import java.awt.image.BufferedImage;
import java.util.*;

/**
 * Classe représentant les lettrines
 */
public class Lettrine implements CCMS {

    private Ouvrage ouvrage;

    /**
     * Liste des métadonnées associées à la lettrine
     * @see Whole.Metadonnee
     */
    private ArrayList<Metadonnee> metadonnees;

    /**
     * numéro de la page sur laquelle figure la lettrine
     */
    private int nbPage;

    /**
     * id de la lettrine dans la base
     */
    private int id;

    /**
     * Liste des tags associés à la lettrine
     */
    private ArrayList<Tag> tags;

    private String lien;

    /**
     * Constructeur de la classe Lettrine
     * @param ouvrage Ouvrage
     * @param metadonnees ArrayList<Metadonnee>
     * @param nbPage int
     * @param id int
     * @param tags ArrayList<Tag>
     */
    public Lettrine(Ouvrage ouvrage, ArrayList<Metadonnee> metadonnees, int nbPage, int id, ArrayList<Tag> tags, String lien) {
        this.ouvrage = ouvrage;
        this.metadonnees = metadonnees;
        this.nbPage = nbPage;
        this.id = id;
        this.tags = tags;
        this.lien = lien;
    }
    /**
     * Constructeur à utiliser pour les instances de changement
     */
    public Lettrine(){
        this.ouvrage = null;
        this.metadonnees = null;
        this.nbPage = -2;
        this.id = -2;
        this.lien = null;
    }
    /**
     * Renvoie un objet de type Ouvrage
     * @return ouvrage
     */
    public Ouvrage getOuvrage() {
        return ouvrage;
    }

    /**
     * Renvoie la liste des métadonnées associées à la lettrine
     * @return ArrayList<Metadonnees> liste des métadonnées associés
     * @see Metadonnee
     */
    public ArrayList<Metadonnee> getMetadonnees() {
        return metadonnees;
    }

    /**
     * Renvoie le numéro de la page sur laquelle la lettrine figure. Si le numero de page de la lettrine
     * est inconue : return -1
     * @return nbPage
     */
    public int getNbPage() {
        return nbPage;
    }

    /**
     * Renvoie l'id de la lettrine dans la base de données
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Renvoie la liste des tags associés à la lettrine
     * @return tags
     */
    public ArrayList<Tag> getTags() {
        return tags;
    }

    public String getLien() {
        return lien;
    }

    /**
     * permet de modifier la valeur de l'ouvrage par l'objet en paramètre
     * @param ouvrage Ouvrage : nouvelle valeur de ouvrage
     */
    public void setOuvrage(Ouvrage ouvrage) {
        this.ouvrage = ouvrage;
    }

    /**
     * permet de modifier la valeur du numéro de la page par l'objet en paramètre
     * @param nbPage int : nouvelle valeur de nbPage. Si on ne connait pas le numéro de la page sur
     *                     laquelle la lettrine figure, nbPage = -1
     */
    public void setNbPage(int nbPage) {
        this.nbPage = nbPage;
    }

    public void setLien(String lien) {
        this.lien = lien;
    }

    public void setMetadonnees(ArrayList<Metadonnee> metadonnees) {
        this.metadonnees = metadonnees;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTags(ArrayList<Tag> tags) {
        this.tags = tags;
    }

    /**
     * Cette methode permet d'ajouter la métadonnée passée en paramètre à la lettrine.
     *Elle affecte la liste de métadonnées metadonnees en y ajoutant la métadonnée passée en paramètre.
     * @param meta Metadonnee : metadonnée à ajouter
     * @see Metadonnee
     */
    public void AjouterMetadonnees(Metadonnee meta) {

    }

    /**
     * Cette méthode permet de supprimer la métadonnée passée en paramètre à la lettrine.
     * Elle affecte la liste de métadonnées metadonnees en en retirant la métadonnée passée en paramètre.
     * @param meta : métadonnée à supprimer
     * @see Metadonnee
     */
    public void SupprimerMetadonnees(Metadonnee meta) {

    }


    /**
     * Modifie une Lettrine, appel la méthode modifier d'un objet de type AbstractDAO
     *
     * @see Whole.daoPackage.LettrineDAO
     */
    @Override
    public void modifier() {

    }

    /**
     * Cherche une Lettrine, appel la méthode chercher d'un objet de type AbstractDAO
     *
     * @see Whole.daoPackage.LettrineDAO
     */
    @Override
    public void chercher() {

    }

    /**
     * Créer une Lettrine, appel la méthode créer d'un objet de type AbstractDAO
     *
     * @see Whole.daoPackage.LettrineDAO
     */
    @Override
    public void creer() {

    }

    /**
     * Supprime une Lettrine, appel la méthode supprimer d'un objet de type AbstractDAO
     *
     * @see Whole.daoPackage.LettrineDAO
     */
    @Override
    public void supprimer() {

    }

    /**
     * Renvoie l'image d'une lettrine sur un serveur distant, si non-trouvable alors envoyé image par défaut
     * @return L'image issue du lien
     * @see BufferedImage
     */
    public BufferedImage loadImage(){
        return null;
    }
}