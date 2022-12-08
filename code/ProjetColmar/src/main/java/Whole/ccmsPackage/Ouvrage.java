package Whole.ccmsPackage;

import Whole.daoPackage.AbstractDAO;

import java.util.*;

/**
 * Classe représentant les ouvrages
 */
public class Ouvrage implements CCMS {
    private String titre;

    private ArrayList<Auteur> auteurs;

    private String editeur;

    private String imprimeur;


    private String lieuEdition;

    private int dateEdition;

    private int nbPage;

    private String lien;

    private int id;

    private String format;

    private String resolution;

    private String creditResolution;

    private boolean reechantillonage;

    private String copyright;


    /**
     * construteur de la classe Ouvrage
     * @param titre String
     * @param auteurs String
     * @param editeur String
     * @param imprimeur String
     * @param lieuEdition String
     * @param dateEdition String
     * @param nbPage int
     * @param lien String
     * @param id int
     */
    public Ouvrage(String titre, ArrayList<Auteur> auteurs, String editeur, String imprimeur, String lieuEdition, int dateEdition, int nbPage, String lien, int id) {
        this.titre = titre;
        this.auteurs = auteurs;
        this.editeur = editeur;
        this.imprimeur = imprimeur;
        this.lieuEdition = lieuEdition;
        this.dateEdition = dateEdition;
        this.nbPage = nbPage;
        this.lien = lien;
        this.id = id;
    }
    /**
     * Constructeur à utiliser pour les instances de changement
     */
    public Ouvrage() {
        this.id = -2;
        this.nbPage = -2;

    }

    public Ouvrage(String titre, int id) {
        this.titre = titre;
        this.id = id;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getCreditResolution() {
        return creditResolution;
    }

    public void setCreditResolution(String creditResolution) {
        this.creditResolution = creditResolution;
    }

    public boolean isReechantillonage() {
        return reechantillonage;
    }

    public void setReechantillonage(boolean reechantillonage) {
        this.reechantillonage = reechantillonage;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    /**
     * renvoie le titre de l'ouvrage
     * @return titre String
     */
    private String getTitre() {
        return titre;
    }

    /**
     * renvoie les auteurs de l'ouvrage
     * @return auteurs String
     */
    private ArrayList<Auteur> getAuteurs() {
        return auteurs;
    }

    /**
     * renvoie l'editeur de l'ouvrage
     * @return editeur String
     */
    private String getEditeur() {
        return editeur;
    }

    /**
     * renvoie l'imprimeur de l'ouvrage
     * @return imprimeur String
     */
    private String getImprimeur() {
        return imprimeur;
    }

    /**
     * renvoie le lieu où l'ouvrage a été imprimé
     * @return lieuEdition String
     */
    private String getLieuEdition() {
        return lieuEdition;
    }

    /**
     * renvoie la date d'édition de l'ouvrage
     * @return dateEdition String
     */
    private int getDateEdition() {
        return dateEdition;
    }

    /**
     * renvoie le nombre de pages de l'ouvrage
     * @return nbPages int
     */
    private int getNbPage() {
        return nbPage;
    }


    private String getLien() {
        return lien;
    }

    /**
     * renvoie l'id de l'ouvrage dans la base
     * @return id int
     */
    private int getId() {
        return id;
    }

    /**
     * change le titre de l'ouvrage par le titre passé en paramètre
     * @param titre String
     */
    private void setTitre(String titre) {
        this.titre = titre;
    }

    /**
     * change les auteurs de l'ouvrage par les auteurs passés en paramètre
     * @param auteurs String
     */
    private void setAuteurs(ArrayList<Auteur> auteurs) {
        this.auteurs = auteurs;
    }

    /**
     * change l'éditeur de l'ouvrage par l'éditeur passé en paramètre
     * @param editeur String
     */
    private void setEditeur(String editeur) {
        this.editeur = editeur;
    }

    /**
     * change l'imprimeur de l'ouvrage par l'imprimeur passé en paramètre
     * @param imprimeur String
     */
    private void setImprimeur(String imprimeur) {
        this.imprimeur = imprimeur;
    }

    /**
     * Change le lieu d'édition de l'ouvrage par le lieu d'édition passé en paramètre
     * @param lieuEdition String
     */
    private void setLieuEdition(String lieuEdition) {
        this.lieuEdition = lieuEdition;
    }

    /**
     * Change la date d'édition de l'ouvrage par la date passée en paramètre
     * @param dateEdition String
     */
    private void setDateEdition(int dateEdition) {
        this.dateEdition = dateEdition;
    }

    /**
     * change le nombre de pages de l'ouvrage par le nombre de pages passé en paramètres
     * @param nbPage int
     */
    private void setNbPage(int nbPage) {
        this.nbPage = nbPage;
    }

    /**
     * change le lien de l'ouvrage par le lien passé en paramètre
     * @param lien String
     */
    private void setLien(String lien) {
        this.lien = lien;
    }

    /**
     * Modifie un CCMS, appel une méthode d'un objet de type AbstractDAO
     *
     * @see AbstractDAO
     */
    @Override
    public void modifier() {

    }

    /**
     * Cherche un CCMS, appel une méthode d'un objet de type AbstractDAO
     *
     * @see AbstractDAO
     */
    @Override
    public void chercher() {

    }

    /**
     * Créer un CCMS, appel une méthode d'un objet de type AbstractDAO
     *
     * @see AbstractDAO
     */
    @Override
    public void creer() {

    }

    /**
     * Supprime un CCMS, appel une méthode d'un objet de type AbstractDAO
     *
     * @see AbstractDAO
     */
    @Override
    public void supprimer() {

    }

    /**
     * Ajoute à la liste des Auteurs un auteur
     * @param a l'auteur à ajouter
     */
    public void addAuteur(Auteur a){
        if(a!=null){
            if(!auteurs.contains(a)){
                auteurs.add(a);
            }
        }
    }
    /**
     * Supprime à la liste des Auteurs un auteur
     * @param a l'auteur à supprimer
     */
    public void retirerAuteur(Auteur a){
        if(a!=null){
            auteurs.remove(a);
        }
    }
}