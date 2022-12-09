package Whole.daoPackage;

import Whole.ccmsPackage.CCMS;

import java.sql.Connection;
import java.util.*;

/**
 * Classe abstraite servant à factoriser à lié à la base de donnée les méthodes
 * modifier, creer, chercher et supprimer des CCMS
 */
public abstract class AbstractDAO {

    public AbstractDAO() {
    }

    /**
     * Met à jour la BD
    * @param objet CCMS à changer
    * @param changement CCMS de changement (les paramètres null ne sont pas à changer)
     * @param cn La connection à la base de donnée
     * @see CCMS
     * @see Whole.LinkToDb
    */


    public void modifier(CCMS objet , CCMS changement ,Connection cn) {

    }
    /**
     * Supprime de la db un CCMS
    * @param objet un CCMS d'un type à déterminer dans chaque implémentation
     * @param cn La connection à la base de donnée
     * @see CCMS
     * @see Whole.LinkToDb
    */

    public void supprimer(CCMS objet ,Connection cn) {

    }
    /**
     * Ajoute à la base de donnée un CCMS
    * @param donne le CCMS à ajouter
     *@param cn La connection à la base de donnée
     * @see CCMS
     * @see Whole.LinkToDb
    */

    public void creer(CCMS donne,Connection cn) {

    }
    /**
     *Cherche un CCMS dans la base
    * @param donne CCMS avec tout les paramètres nuls sauf ceux à chercher
     *@param cn La connection à la base de donnée
     * @see CCMS
     * @see Whole.LinkToDb
    */

    public ArrayList<CCMS> chercher(CCMS donne,Connection cn) {
        return null;
    }

}