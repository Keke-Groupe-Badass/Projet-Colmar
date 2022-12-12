package Whole.ccmsPackage;

import Whole.daoPackage.AbstractDAO;
import Whole.daoPackage.AuteurDAO;

/**
 * Classe représentant les auteurs
 */
public class Auteur implements CCMS {

    private int id;

    private String nom;

    private String prenom;




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
     * change le prenom de l'auteur par le prénom passé en param
     * @param prenom String
     */
    private void setPrenom(String prenom) {
        this.prenom = prenom;
    }


    /**
     * Modifie un Auteur, appel la méthode modifier d'un objet de type AbstractDAO
     *
     * @see AuteurDAO
     */
    @Override
    public void modifier() {

    }

    /**
     * Cherche un Auteur, appel la méthode chercher d'un objet de type AbstractDAO
     *
     * @see AuteurDAO
     */
    @Override
    public void chercher() {

    }

    /**
     * Créer un Auteur, appel la méthode créer d'un objet de type AbstractDAO
     *
     * @see AuteurDAO
     */
    @Override
    public void creer() {

    }

    /**
     * Supprime un Auteur, appel la méthode supprimer d'un objet de type AbstractDAO
     *
     * @see AuteurDAO
     */
    @Override
    public void supprimer() {

    }
}