package Whole.daoPackage;

import Whole.SingleConnection;
import Whole.ccmsPackage.Ouvrage;
import Whole.ccmsPackage.Personne;

import java.sql.Connection;
import java.util.ArrayList;

/**
 * Cette classe est appelee pour creer un lien entre l'application et la base de donnees
 * pour tout ce qui concerne les interactions et les modifications d'un ouvrage
 * @see AbstractDAO
 */
public class OuvrageDAO extends AbstractDAO<Ouvrage> {
    /**
     * Constructeur de la classe OuvrageDAO.
     *
     * @see Connection
     * @see SingleConnection
     */

    public OuvrageDAO(String url, String login, String password) {
        super(url, login, password);
    }

    /**
     * Ajoute à la base de donnée un ouvrage
     *
     * @param donne l'ouvrage à ajouter
     * @see Ouvrage
     * @see SingleConnection
     */
    @Override
    public boolean creer(Ouvrage donne) {
        return false;
    }


    /**
    * Permet d'ajouter un ouvrage dans la base de donnees. L'auteur peut être NULL,
    * on ne connait pas forcement l'auteur d'un ouvrage. Si il n'est pas NULL, on
    * vérifie que l'auteur passé en paramètre existe bien dans la base de données,
    * puis on effectue une requete d'insertion.
    *
    * @param a Personne auteur de l'ouvrage
    * @param objet Ouvrage ouvrage qu'on souhaite inserer
     * @see SingleConnection
    */
    public void ecrit(Personne a, Ouvrage objet) {
    	
    }
    
    /**
     * Permet de modifier un ouvrage dans la base de donnees. On s'assure que
     * l'ouvrage qu'on souhaite modifier est bien dans la base de donnees, puis
     * on le remplace par le nouvel ouvrage passe en 2e parametre.
     * 
     * @param objet l'ouvrage cible qu'on souhaite modifier
     * @param changement l'ouvrage par lequel on souhaite remplacer l'ancien
     * @see SingleConnection
     */
    public boolean modifier(Ouvrage objet, Ouvrage changement) {
    	return false;
    }
    
    /**
     * Permet de supprimer un ouvrage de la base de donnees. On s'assure que
     * l'ouvrage qu'on souhaite supprimer est bien dans la base de donnees, puis
     * si trouve on le supprime.
     * 
     * @param objet l'ouvrage cible qu'on souhaite supprimer
     * @see SingleConnection
     */
    public boolean supprimer(Ouvrage objet) {
        return false;
    }
    
    /**
     * Permet de rechercher un ou plusieurs ouvrages dans la base de donnees
     * selon un ou plusieurs criteres.
     * 
     * @param objet ouvrage avec tous les parametres nuls sauf ceux a chercher
     * @return renvoie une liste des ouvrages qui correspondent aux critères
     * de recherche
     * @see SingleConnection
     */
    public ArrayList<Ouvrage> chercher(Ouvrage objet) {
        return null;
    }
}