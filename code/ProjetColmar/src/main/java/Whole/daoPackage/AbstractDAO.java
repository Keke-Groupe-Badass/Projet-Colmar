package Whole.daoPackage;

import Whole.SingleConnection;

import java.sql.Connection;
import java.util.*;

/**
 * Classe abstraite servant à factoriser à lié à la base de donnée les méthodes
 * modifier, creer, chercher et supprimer des CCMS
 */
public abstract class AbstractDAO<CCMS>{
    static Connection cn;
    public AbstractDAO(String url, String login, String password) {
        this.cn=SingleConnection.getInstance(url,login,password);
    }

    /**
     * Met à jour la BD
     * @param objet CCMS à changer
     * @param changement CCMS de changement (les paramètres null ne sont pas à changer)
     * @see CCMS
     * @see SingleConnection
    */
    public abstract boolean modifier(CCMS objet , CCMS changement);

    /**
     * Supprime de la db un CCMS
     * @param objet un CCMS d'un type à déterminer dans chaque implémentation
     * @see CCMS
     * @see SingleConnection
    */
    public abstract boolean supprimer(CCMS objet);

    /**
     * Ajoute à la base de donnée un CCMS
     * @param donne le CCMS à ajouter
     * @see CCMS
     * @see SingleConnection
    */
    public abstract boolean creer(CCMS donne);

    /**
     *Cherche un CCMS dans la base
     * @param donne CCMS avec tout les paramètres nuls sauf ceux à chercher
     * @return la Liste des des CCMS correspondant aux critères
     * @see CCMS
     * @see SingleConnection
     */

    public abstract ArrayList<CCMS> chercher(CCMS donne);

}