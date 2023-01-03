package Whole.daoPackage;

import Whole.SingleConnection;
import java.sql.Connection;
import java.util.ArrayList;

/**
 * Classe abstraite servant à factoriser et à lier les méthodes modifier,
 * creer, chercher et supprimer des CCMS à la base de données.
 * @param <CCMS> objet CCMS
 */
public abstract class AbstractDAO<CCMS> extends SuperAbstractDAO{
    /**
     * Objet connection pour se connecter à la BDD.
     */
    private static Connection cn;

    /**
     * Constructeur de la classe single connect.
     * @author Andreas
     * @param url l'url de la base de données
     * @param login le nom d'utilisateur
     * @param password le mot de passe de la base de données
     */
    public AbstractDAO(String url, String login, String password) {
        super(url,login,password);
    }

    /**
     * Met à jour la BDD.
     * @author Andreas
     * @param objet CCMS à changer
     * @param changement CCMS de changement (les paramètres null ne
     *                   sont pas à changer)
     * @see CCMS
     * @see SingleConnection
     * @return Renvoie true si la modification s'est effectuée, false sinon.
    */
    public abstract boolean modifier(CCMS objet , CCMS changement);

    /**
     * Supprime de la BDD un CCMS.
     * @author Andreas
     * @param objet un CCMS d'un type à déterminer dans chaque implémentation
     * @see CCMS
     * @see SingleConnection
     * @return Renvoie true si la suppression s'est effectuée, false sinon.
    */
    public abstract boolean supprimer(CCMS objet);

    /**
     * Ajoute à la base de donnée un CCMS.
     * @author Andreas
     * @param donne le CCMS à ajouter
     * @see CCMS
     * @see SingleConnection
     * @return Renvoie true si l'ajout s'est effectué, false sinon.
    */
    public abstract boolean creer(CCMS donne);

    /**
     * Cherche un CCMS dans la base.
     * @author Andreas
     * @param donne CCMS avec tous les paramètres null sauf ceux à chercher
     * @return la Liste des CCMS correspondant aux critères
     * @see CCMS
     * @see SingleConnection
     */

    public abstract ArrayList<CCMS> chercher(CCMS donne);

}