package Whole.ccmsPackage;

import Whole.daoPackage.AbstractDAO;

/**
 * Classe représentant les auteurs
 */
public class Auteur implements CCMS {

    private int id;

    private String nom;

    private String prenom;

    private String format;

    private String resolution;

    private String creditResolution;

    private boolean reechantillonage;

    private String copyright;


    /**
     * Constructeur de la classe Auteur
     * @param id int
     * @param nom String
     * @param prenom String
     */
    public Auteur(int id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }

    /**
     * Constructeur de la classe Auteur
     * @param id int
     */
    public Auteur(int id) {
        this.id = id;
    }

    /**
     * Constructeur à utiliser pour les instances de changement
     */
    public Auteur(){
        this.id=-2;
        this.nom=null;
        this.prenom=null;
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
     * renvoie l'id de l'auteur dans la base
     * @return id int
     */
    private int getId() {
        return id;
    }

    /**
     * renvoie le nom de l'auteur
     * @return nom String
     */
    private String getNom() {
        return nom;
    }

    /**
     * renvoie le prenom de l'auteur
     * @return prenom String
     */
    private String getPrenom() {
        return prenom;
    }

    /**
     * change le nom de l'auteur par le nom passé en param
     * @param nom String
     */
    private void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * change le prenom de l'auteur par le prenom passé en param
     * @param prenom String
     */
    private void setPrenom(String prenom) {
        this.prenom = prenom;
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
}