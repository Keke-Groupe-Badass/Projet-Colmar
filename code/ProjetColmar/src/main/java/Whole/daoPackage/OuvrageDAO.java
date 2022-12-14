package Whole.daoPackage;

import Whole.LinkToDb;
import Whole.ccmsPackage.Auteur;
import Whole.ccmsPackage.Ouvrage;
import java.sql.Connection;
import java.util.ArrayList;

/**
 * Cette classe est appelee pour creer un lien entre l'application et la base de donnees
 * pour tout ce qui concerne les interactions et les modifications d'un ouvrage
 * @see AbstractDAO
 */
public class OuvrageDAO extends AbstractDAO<Ouvrage> {

    private Connection cn;
    /**
     * Constructeur de la classe OuvrageDAO.
     *
     * @see Connection
     * @see LinkToDb
     */

    public OuvrageDAO() {
        super();
    }

    /**
     * Ajoute à la base de donnée un ouvrage
     *
     * @param donne l'ouvrage à ajouter
     * @param cn    La connection à la base de donnée
     * @see Ouvrage
     * @see LinkToDb
     */
    @Override
    public boolean creer(Ouvrage donne, Connection cn) {
        return false;
    }


    /**
    * Permet d'ajouter un ouvrage dans la base de donnees. L'auteur peut être NULL,
    * on ne connait pas forcement l'auteur d'un ouvrage. Si il n'est pas NULL, on
    * vérifie que l'auteur passé en paramètre existe bien dans la base de données,
    * puis on effectue une requete d'insertion.
    *
    * @param a Auteur auteur de l'ouvrage
    * @param objet Ouvrage ouvrage qu'on souhaite inserer
     * @param cn La connection à la base de donnée
     * @see LinkToDb
    */
    public void ecrit(Auteur a, Ouvrage objet,Connection cn) {
    	
    }
    
    /**
     * Permet de modifier un ouvrage dans la base de donnees. On s'assure que
     * l'ouvrage qu'on souhaite modifier est bien dans la base de donnees, puis
     * on le remplace par le nouvel ouvrage passe en 2e parametre.
     * 
     * @param objet l'ouvrage cible qu'on souhaite modifier
     * @param changement l'ouvrage par lequel on souhaite remplacer l'ancien
     * @param cn La connection à la base de donnée
     * @see LinkToDb
     */
    public boolean modifier(Ouvrage objet, Ouvrage changement,Connection cn) {
    	return false;
    }
    
    /**
     * Permet de supprimer un ouvrage de la base de donnees. On s'assure que
     * l'ouvrage qu'on souhaite supprimer est bien dans la base de donnees, puis
     * si trouve on le supprime.
     * 
     * @param objet l'ouvrage cible qu'on souhaite supprimer
     * @param cn La connection à la base de donnée
     * @see LinkToDb
     */
    public boolean supprimer(Ouvrage objet,Connection cn) {
        return false;
    }
    
    /**
     * Permet de rechercher un ou plusieurs ouvrages dans la base de donnees
     * selon un ou plusieurs criteres.
     * 
     * @param objet ouvrage avec tous les parametres nuls sauf ceux a chercher
     * @return renvoie une liste des ouvrages qui correspondent aux critères
     * de recherche
     * @param cn La connection à la base de donnée
     * @see LinkToDb
     */
    public ArrayList<Ouvrage> chercher(Ouvrage objet,Connection cn) {
        return null;
    }
}