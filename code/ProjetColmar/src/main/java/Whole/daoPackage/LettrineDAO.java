package Whole.daoPackage;


import Whole.Metadonnee;
import Whole.ccmsPackage.Lettrine;
import Whole.ccmsPackage.Ouvrage;
import Whole.ccmsPackage.Tag;

import java.io.File;

/**
 * Classe héritant d'AbstractDAO, permettant de lier une Lettrine à la base de donnée
 * @see AbstractDAO
 */
public class LettrineDAO extends AbstractDAO {

    /**
     *permet de lier dans la base de donnée une lettrine à ouvrage, en effet une lettrine n'est présente dans un seul et unique ouvrage.
     * @param l la lettrine à lier à l'ouvrage
     * @param O l'ouvrage d'origine
     * @see Ouvrage
     * @see Lettrine
     */


    public void provient(Lettrine l , Ouvrage O)   {

    }
    /**
     *Permet de lier dans la base de donnée une lettrine à un tag
     * @param l La lettrine dont on souhaite ajouter un tag
     * @param t Le tag à ajouter à la lettrine
     * @see Lettrine
     * @see Tag
     */


    public void tager(Lettrine l , Tag t) {

    }
    /**
     * permet de caracteriser une lettrine en ajoutant une métadonnée
     * @param meta Métadonnée à ajouter à la lettrine
     * @see Metadonnee
     */


    public void ajouterMeta(Metadonnee meta) {

    }
    /**
     * permet de décaracteriser une lettrine en supprimant une métadonnée
     * @param meta Métadonnée à supprimer à la lettrine
     * @see Metadonnee
     */


    public void supprimerMeta(Metadonnee meta) {

    }
    /**
     * Met à jour la base de donnée avec les nouvelles valeurs de la métadonnée
     * @param meta La métadonnée dont l'on souhaite que la partie code correspond avec la partie base de donnée
     * @see Metadonnee
     */

    public void modifierMeta(Metadonnee meta) {

    }

    /**
     * Met en ligne une image stockée sur disque et renvoie son URL
     * @param file le fichier où se trouve l'image dans le disque
     * @return String: le lien vers l'image en ligne
     * @see File
     */
    private String upload(File file) {
        return null;
    }
}