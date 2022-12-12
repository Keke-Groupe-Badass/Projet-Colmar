package Whole.ccmsPackage;

import Whole.daoPackage.AbstractDAO;

import java.util.*;

/**
 * Classe représentant les ouvrages
 */
public class Ouvrage implements CCMS<Ouvrage> {
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
     * Constructeur à utiliser pour les instances de changement
     */
    public Ouvrage() {
        this.id = -2;
        this.nbPage = -2;

    }

    /**
     * Constructeur de la classe ouvrage à utiliser en cas normal
     * @param titre String
     * @param id int
     */
    public Ouvrage(String titre, int id) {
        this.titre = titre;
        this.id = id;
    }

    /**
     * Constructeur à utilisé pour les copies uniquements
     * @param titre String
     * @param auteurs ArrayList<String>
     * @param editeur String
     * @param imprimeur String
     * @param lieuEdition String
     * @param dateEdition String
     * @param nbPage int
     * @param lien String
     * @param id int
     * @param format String
     * @param resolution String
     * @param creditResolution String
     * @param reechantillonage boolean
     * @param copyright String
     */
    public Ouvrage(String titre, ArrayList<Auteur> auteurs, String editeur, String imprimeur, String lieuEdition, int dateEdition, int nbPage, String lien, int id, String format, String resolution, String creditResolution, boolean reechantillonage, String copyright) {
        this.titre = titre;
        this.auteurs = auteurs;
        this.editeur = editeur;
        this.imprimeur = imprimeur;
        this.lieuEdition = lieuEdition;
        this.dateEdition = dateEdition;
        this.nbPage = nbPage;
        this.lien = lien;
        this.id = id;
        this.format = format;
        this.resolution = resolution;
        this.creditResolution = creditResolution;
        this.reechantillonage = reechantillonage;
        this.copyright = copyright;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * getter de l'attribut format
     * @return format
     */
    public String getFormat() {
        return format;
    }

    /**
     * setter de l'attribut format
     * @param format String
     */
    public void setFormat(String format) {
        this.format = format;
    }

    /**
     * getter de l'attribut résolution
     * @return resolution
     */
    public String getResolution() {
        return resolution;
    }

    /**
     * setter de l'attribut résolution
     * @param resolution String
     */
    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    /**
     * getter de l'attribut CreditResolution
     * @return ceditResolution
     */
    public String getCreditResolution() {
        return creditResolution;
    }

    /**
     * setter de l'attribut creditResolution
     * @param creditResolution String
     */
    public void setCreditResolution(String creditResolution) {
        this.creditResolution = creditResolution;
    }

    /**
     * equivalent getter de l'attribut reechantillonage
     * @return reechantillonage
     */
    public boolean isReechantillonage() {
        return reechantillonage;
    }

    /**
     * setter de l'attribut reechantillonage
     * @param reechantillonage boolean
     */
    public void setReechantillonage(boolean reechantillonage) {
        this.reechantillonage = reechantillonage;
    }

    /**
     * getter de l'attribut copyright
     * @return copytight
     */
    public String getCopyright() {
        return copyright;
    }

    /**
     * setter de l'attribut copyright
     * @param copyright String
     */
    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    /**
     * renvoie le titre de l'ouvrage
     * @return titre String
     */
    public String getTitre() {
        return titre;
    }

    /**
     * renvoie les auteurs de l'ouvrage
     * @return auteurs String
     */
    public ArrayList<Auteur> getAuteurs() {
        return auteurs;
    }

    /**
     * renvoie l'editeur de l'ouvrage
     * @return editeur String
     */
    public String getEditeur() {
        return editeur;
    }

    /**
     * renvoie l'imprimeur de l'ouvrage
     * @return imprimeur String
     */
    public String getImprimeur() {
        return imprimeur;
    }

    /**
     * renvoie le lieu où l'ouvrage a été imprimé
     * @return lieuEdition String
     */
    public String getLieuEdition() {
        return lieuEdition;
    }

    /**
     * renvoie la date d'édition de l'ouvrage
     * @return dateEdition String
     */
    public int getDateEdition() {
        return dateEdition;
    }

    /**
     * renvoie le nombre de pages de l'ouvrage
     * @return nbPages int
     */
    public int getNbPage() {
        return nbPage;
    }


    public String getLien() {
        return lien;
    }

    /**
     * renvoie l'id de l'ouvrage dans la base
     * @return id int
     */
    public int getId() {
        return id;
    }

    /**
     * change le titre de l'ouvrage par le titre passé en paramètre
     * @param titre String
     */
    public void setTitre(String titre) {
        this.titre = titre;
    }

    /**
     * change les auteurs de l'ouvrage par les auteurs passés en paramètre
     * @param auteurs String
     */
    public void setAuteurs(ArrayList<Auteur> auteurs) {
        this.auteurs = auteurs;
    }

    /**
     * change l'éditeur de l'ouvrage par l'éditeur passé en paramètre
     * @param editeur String
     */
    public void setEditeur(String editeur) {
        this.editeur = editeur;
    }

    /**
     * change l'imprimeur de l'ouvrage par l'imprimeur passé en paramètre
     * @param imprimeur String
     */
    public void setImprimeur(String imprimeur) {
        this.imprimeur = imprimeur;
    }

    /**
     * Change le lieu d'édition de l'ouvrage par le lieu d'édition passé en paramètre
     * @param lieuEdition String
     */
    public void setLieuEdition(String lieuEdition) {
        this.lieuEdition = lieuEdition;
    }

    /**
     * Permet de copier les valeurs d'un ouvrage
     * @return la copie exacte d'un ouvrage
     */
    public Ouvrage copie(){
        return new Ouvrage( titre,  auteurs,  editeur,  imprimeur,  lieuEdition,  dateEdition,  nbPage,  lien,  id,  format,  resolution,  creditResolution,  reechantillonage, copyright);
    }
    /**
     * Change la date d'édition de l'ouvrage par la date passée en paramètre
     * @param dateEdition String
     */
    public void setDateEdition(int dateEdition) {
        this.dateEdition = dateEdition;
    }

    /**
     * change le nombre de pages de l'ouvrage par le nombre de pages passé en paramètres
     * @param nbPage int
     */
    public void setNbPage(int nbPage) {
        this.nbPage = nbPage;
    }

    /**
     * change le lien de l'ouvrage par le lien passé en paramètre
     * @param lien String
     */
    public void setLien(String lien) {
        this.lien = lien;
    }

    /**
     * Modifie un Ouvrage, appel la méthode modifier d'un objet de type AbstractDAO
     *
     * @see Whole.daoPackage.OuvrageDAO
     */
    @Override
    public void modifier(Ouvrage objet) {

    }

    /**
     * Cherche un Ouvrage, appel la méthode chercher d'un objet de type AbstractDAO
     *
     * @see Whole.daoPackage.OuvrageDAO
     */
    @Override
    public void chercher(Ouvrage objet) {

    }

    /**
     * Créer un Ouvrage, appel la méthode créer d'un objet de type AbstractDAO
     *
     * @see Whole.daoPackage.OuvrageDAO
     */
    @Override
    public void creer(Ouvrage objet) {

    }

    /**
     * Supprime un Ouvrage, appel la méthode supprimer d'un objet de type AbstractDAO
     * @param objet l'ouvrage dans le
     * @see Whole.daoPackage.OuvrageDAO
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