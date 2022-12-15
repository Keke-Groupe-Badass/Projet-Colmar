package Whole.daoPackage;

import Whole.SingleConnection;
import Whole.ccmsPackage.Personne;

import java.sql.Connection;

import java.util.ArrayList;
/**
 * Classe servant à lié à la base de donnée les méthodes d'Auteurs
 * @see Personne
 */
public class PersonneDAO extends AbstractDAO<Personne> {
    /**
     * Constructeur d'AdminDAO
     * @see SingleConnection
     */
    public PersonneDAO(String url, String login, String password) {
        super(url, login, password);
    }



    /**
     * Met à jour la BD
     *
     * @param objet      Personne à changer
     * @param changement Personne de changement (les paramètres null ne sont pas à changer)
     * @return
     * @see SingleConnection
     */
    public boolean modifier(Personne objet , Personne changement) {


        return false;
    }
    /**
     * Supprime de la db un Personne
     *
     * @param objet une Personne d'un type à déterminer dans chaque implémentation
     * @return
     * @see Personne
     * @see SingleConnection
     */
    public boolean supprimer(Personne objet) {

        return false;
    }
    /**
     * Ajoute à la base de donnée une Personne
     *
     * @param donne la Personne à ajouter
     * @return
     * @see Personne
     * @see SingleConnection
     */
    public boolean creer(Personne donne) {

        return false;
    }
    /**
     *Cherche une Personne dans la base
     * @param donne Personne avec tous les paramètres nuls sauf ceux à chercher
     * @return la Liste des auteurs correspondant aux critères
     * @see Personne
     * @see SingleConnection
     */
    public ArrayList<Personne> chercher(Personne donne) {
        return null;
    }
}