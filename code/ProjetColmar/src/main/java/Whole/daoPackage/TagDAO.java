/*
* This code has been generated by the Rebel: a code generator for modern Java.
*
* Drop us a line or two at feedback@archetypesoftware.com: we would love to hear from you!
*/
package Whole.daoPackage;

import Whole.SingleConnection;
import Whole.ccmsPackage.Tag;

import java.sql.Connection;
import java.util.ArrayList;
/**
 * Classe servant à lié à la base de donnée les méthodes de Tag
 * @see Tag
 */
public class TagDAO<objet extends Tag> extends AbstractDAO<objet>{

    /**
     * Constructeur de la classe OuvrageDAO.
     * @see SingleConnection
     */
    public TagDAO() {
        super();
    }


    /**
     * Met à jour la BD
     *
     * @param objet      Tag à changer
     * @param changement Tag de changement (les paramètres null ne sont pas à changer)
     * @param cn         La connection à la base de donnée
     * @return
     * @see SingleConnection
     */


    @Override
    public boolean modifier(Tag objet , Tag changement , Connection cn) {

        return false;
    }
    /**
     * Supprime de la db un Tag
     *
     * @param objet un Tag d'un type à déterminer dans chaque implémentation
     * @param cn    La connection à la base de donnée
     * @return
     * @see SingleConnection
     * @see Tag
     */
    @Override

    public boolean supprimer(Tag objet , Connection cn) {

        return false;
    }
    /**
     * Ajoute à la base de donnée un Tag
     *
     * @param objet le Tag à ajouter
     * @param cn    La connection à la base de donnée
     * @return
     * @see SingleConnection
     * @see Tag
     */
    @Override

    public boolean creer(Tag objet, Connection cn) {

        return false;
    }
    /**
     *Cherche un Tag dans la base
     * @param objet Tag avec tous les paramètres nuls sauf ceux à chercher
     * @param cn La connection à la base de donnée
     * @return La liste des tags qui correspond auc paramètres donnés
     * @see SingleConnection
     * @see Tag
     *
     */
    @Override

    public ArrayList<objet> chercher(Tag objet,Connection cn) {
        return null;
    }
}