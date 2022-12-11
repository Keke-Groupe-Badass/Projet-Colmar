package Whole.daoPackage;


import Whole.LinkToDb;
import Whole.Metadonnee;
import Whole.ccmsPackage.CCMS;
import Whole.ccmsPackage.Lettrine;
import Whole.ccmsPackage.Ouvrage;
import Whole.ccmsPackage.Tag;
import java.sql.Connection;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Classe héritant d'AbstractDAO, permettant de lier une Lettrine à la base de donnée
 * @see Lettrine
 */
public class LettrineDAO extends AbstractDAO<Lettrine> {
    /**
     * Constructeur de LettrineDAO
     * @see LinkToDb
     */
    public LettrineDAO() {
        super();
    }

    /**
     * Met à jour la BD
     *
     * @param actuelle   La Lettrine à modifier
     * @param changement La lettrine de changement (les paramètres null ne sont pas à changer)
     * @param cn         La connection à la base de donnée
     * @see Lettrine
     * @see LinkToDb
     */
    @Override
    public void modifier(Lettrine actuelle, Lettrine changement, Connection cn) {
    }

    /**
     * Supprime une db de la db
     *
     * @param objet La lettrine à supprimer
     * @param cn    La connection à la base de donnée
     * @see Lettrine
     * @see LinkToDb
     */
    @Override
    public void supprimer(Lettrine objet, Connection cn) {

    }

    /**
     * Ajoute à la base de donnée d'une lettrine
     *
     * @param donne la lettrine à ajouter
     * @param cn    La connection à la base de donnée
     * @see Lettrine
     * @see LinkToDb
     */
    @Override
    public void creer(Lettrine donne, Connection cn) {

    }

    /**
     * Cherche un CCMS dans la base
     *
     * @param donne CCMS avec tout les paramètres nuls sauf ceux à chercher
     * @param cn    La connection à la base de donnée
     * @return la Liste des des CCMS correspondant aux critères
     * @see CCMS
     * @see LinkToDb
     */
    @Override
    public ArrayList<Lettrine> chercher(Lettrine donne, Connection cn) {
        return null;
    }

    /**
     * recherche sur les métadonnées, si des métadonnées sont passées en attribut de la lettrine
     * de recherche, on commence par récupérer tous les id de ces métadonnées, puis on les stockes dans
     * un ArrayList. Si aucune métadonnée n'est passée en attribut de la lettrine
     * (donne.getMetadonnees == null) alors on récupère toutes les métadonnées de la base. On commence par
     * récuperer chaque id de chacune des métadonnées récupérées par la requete, puis on utilice cet
     * id pour créer un bout de requete sql, finalement on stocke de bout de requete (String) dans
     * un ArrayList.
     * @param donne Lettrine :  lettrine contenant les attributs sur lesquels effectuer la recherche
     * @param cn Connection : connexion
     * @return ArrayList<String> tab : ArrayList contenant les sql de chaque tags
     */
    private static ArrayList<String> tabSqlMeta(Lettrine donne, Connection cn) {
        return null;
    }


    /**
     * recherche sur les tags: meme principe que pour les métadonnées. On récupère une liste de morceaux
     * de requêtes SQL, un morceau de requete par tag (idTag= id du tag de l'ArrayList contenant les tags
     * obtenues lors de la requete permettant des les obtenirs en fonction de leur présence dans les
     * attributs de la lettrine de recherche).
     * @param donne Lettrine :  lettrine contenant les attributs sur lesquels effectuer la recherche
     * @param cn Connection : connexion
     * @return ArrayList<String> tab : ArrayList contenant les sql de chaque tags
     */
    private static ArrayList<String> tabSqlTags(Lettrine donne, Connection cn) {
        return null;
    }

    /**
     *permet de lier dans la base de donnée une lettrine à ouvrage, en effet une lettrine n'est présente dans un seul et unique ouvrage.
     * @param l la lettrine à lier à l'ouvrage
     * @param o l'ouvrage d'origine
     * @param cn La connection à la base de donnée
     * @see LinkToDb
     * @see Ouvrage
     * @see Lettrine
     *
     */
    public void provient(Lettrine l , Ouvrage o,Connection cn)   {

    }
    /**
     *Permet de lier dans la base de donnée une lettrine à un tag
     * @param l La lettrine dont on souhaite ajouter un tag
     * @param t Le tag à ajouter à la lettrine
     * @param cn La connection à la base de donnée
     * @see LinkToDb
     * @see Lettrine
     * @see Tag
     */


    public void tager(Lettrine l , Tag t,Connection cn) {

    }
    /**
     * permet de caracteriser une lettrine en ajoutant une métadonnée
     * @param meta Métadonnée à ajouter à la lettrine
     * @param cn La connection à la base de donnée
     * @see LinkToDb
     * @see Metadonnee
     */


    public void ajouterMeta(Metadonnee meta,Connection cn) {

    }
    /**
     * permet de décaracteriser une lettrine en supprimant une métadonnée
     * @param meta Métadonnée à supprimer à la lettrine
     * @param cn La connection à la base de donnée
     * @see LinkToDb
     * @see Metadonnee
     */


    public void supprimerMeta(Metadonnee meta,Connection cn) {

    }
    /**
     * Met à jour la base de donnée avec les nouvelles valeurs de la métadonnée
     * @param meta La métadonnée dont l'on souhaite que la partie code correspond avec la partie base de donnée
     * @param cn La connection à la base de donnée
     * @see LinkToDb
     * @see Metadonnee
     */

    public void modifierMeta(Metadonnee meta,Connection cn) {

    }

    /**
     * Met en ligne une image stockée sur disque et renvoie son URL
     * @param img le fichier où se trouve l'image dans le disque
     * @param cn La connection à la base de donnée
     * @see LinkToDb
     * @see BufferedImage
     * @return String: le lien vers l'image en ligne
     */
    private String upload(BufferedImage img,Connection cn) {
        return null;
    }
}