package Whole.daoPackage;

import Whole.ccmsPackage.CCMS;

import java.sql.Connection;
import java.util.*;

public abstract class AbstractDAO {

    private static Connection cn;

    /**
     * Met à jour la BD
    * @param objet CCMS à changer
    * @param changement CCMS de changement (les paramètres null ne sont pas à changer)
    */


    public void modifier(CCMS objet , CCMS changement ) {

    }
    /**
     * Supprime de la db un CCMS
    * @param objet un CCMS d'un type à déterminer dans chaque implémentation
     * @see CCMS
    */

    public void supprimer(CCMS objet ) {

    }
    /**
     * Ajoute à la base de donnée un CCMS
    * @param donne le CCMS à ajouter
     * @see CCMS
    */

    public void creer(CCMS donne) {

    }
    /**
     *Cherche un CCMS dans la base
    * @param donne CCMS avec tout les paramètres nuls sauf ceux à chercher
     * @see CCMS
    */

    public ArrayList<CCMS> chercher(CCMS donne) {
        return null;
    }

}