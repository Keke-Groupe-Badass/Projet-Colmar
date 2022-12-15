package Whole.daoPackage;

import Whole.SingleConnection;
import Whole.ccmsPackage.Personne;

import java.sql.Connection;

import java.util.ArrayList;
/**
 * Classe servant à lié à la base de donnée les méthodes d'Auteurs
 * @see Personne
 */
public class AuteurDAO extends AbstractDAO<Personne> {
    /**
     * Constructeur d'AdminDAO
     * @see SingleConnection
     */
    public AuteurDAO(String url, String login, String password) {
        super(url, login, password);
    }



    /**
     * Met à jour la BD
     *
     * @param objet      Personne à changer
     * @param changement Personne de changement (les paramètres null ne sont pas à changer)
     * @param cn         La connection à la base de donnée
     * @return
     * @see SingleConnection
     */
    public boolean modifier(Personne objet , Personne changement, Connection cn) {


        return false;
    }
    /**
     * Supprime de la db un Personne
     *
     * @param objet un Personne d'un type à déterminer dans chaque implémentation
     * @param cn    La connection à la base de donnée
     * @return
     * @see Personne
     * @see SingleConnection
     */
    public boolean supprimer(Personne objet, Connection cn) {

        return false;
    }
    /**
     * Ajoute à la base de donnée un Personne
     *
     * @param donne l'Personne à ajouter
     * @param cn    La connection à la base de donnée
     * @return
     * @see Personne
     * @see SingleConnection
     */
    public boolean creer(Personne donne, Connection cn) {

        return false;
    }
    /**
     *Cherche un Personne dans la base
     * @param donne Personne avec tous les paramètres nuls sauf ceux à chercher
     * @param cn La connection à la base de donnée
     * @return la Liste des auteurs correspondant aux critères
     * @see Personne
     * @see SingleConnection
     */
    public ArrayList<Personne> chercher(Personne donne, Connection cn) {
        return null;
    }
}