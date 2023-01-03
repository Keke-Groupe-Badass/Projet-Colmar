package Whole.daoPackage;

import Whole.SingleConnection;
import Whole.ccmsPackage.Personne;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/**
 * Classe servant à lier à la base de données les méthodes de Personnes
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
     * Met à jour la BDD
     *
     * @param objet Personne à changer
     * @param changement Personne de changement (les paramètres null ne sont pas à changer)
     * @return true si le changement s'est correctement effectué, false sinon
     * @see SingleConnection
     */
    public boolean modifier(Personne objet , Personne changement) {
        //TODO Finir cette fonction

        return false;
    }
    /**
     * Supprime de la BDD une Personne
     *
     * @param objet une Personne d'un type à déterminer dans chaque implémentation
     * @return true si la suppression s'est correctement effectuée, false sinon
     * @see Personne
     * @see SingleConnection
     */
    public boolean supprimer(Personne objet) {
        if(objet.getId() <= 0) {
            return false;
        }
        try {
            Statement stmt = cn.createStatement();
            String sql = "DELETE FROM lettrine WHERE id=" + objet.getId();
            stmt.executeQuery(sql);
            return true;
        }
        catch (SQLException e) {
            return false;
        }
    }

    /**
     * Ajoute à la base de données une Personne
     *
     * @param donne la Personne à ajouter
     * @return true si l'ajout s'est correctement effectué, false sinon
     * @see Personne
     * @see SingleConnection
     */
    public boolean creer(Personne donne) {
        //TODO Finir cette fonction
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
        //TODO finir cette fonction
        return null;
    }
}