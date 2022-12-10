package Whole.daoPackage;

import Whole.LinkToDb;
import Whole.ccmsPackage.Auteur;

import java.sql.Connection;

import java.util.ArrayList;
/**
 * Classe servant à lié à la base de donnée les méthodes d'Auteurs
 * @see Auteur
 */
public class AuteurDAO extends AbstractDAO {

    /**
     * Constructeur d'AdminDAO
     * @see LinkToDb
     */
    public AuteurDAO() {
        super();
    }



    /**
     * Met à jour la BD
     * @param objet Auteur à changer
     * @param changement Auteur de changement (les paramètres null ne sont pas à changer)
     * @param cn La connection à la base de donnée
     * @see LinkToDb
     */
    public void modifier(Auteur objet , Auteur changement,Connection cn) {

    }
    /**
     * Supprime de la db un Auteur
     * @param objet un Auteur d'un type à déterminer dans chaque implémentation
     * @param cn La connection à la base de donnée
     * @see Auteur
     * @see LinkToDb
     */
    public void supprimer(Auteur objet,Connection cn) {

    }
    /**
     * Ajoute à la base de donnée un Auteur
     * @param donne l'Auteur à ajouter
     * @param cn La connection à la base de donnée
     * @see Auteur
     * @see LinkToDb
     */
    public void creer(Auteur donne,Connection cn) {

    }
    /**
     *Cherche un Auteur dans la base
     * @param donne Auteur avec tous les paramètres nuls sauf ceux à chercher
     * @param cn La connection à la base de donnée
     * @return la Liste des auteurs correspondant aux critères
     * @see Auteur
     * @see LinkToDb
     */
    public ArrayList<Auteur> chercher(Auteur donne,Connection cn) {
        return null;
    }
}