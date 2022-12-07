package Whole.daoPackage;

import Whole.ccmsPackage.Auteur;
import Whole.ccmsPackage.Ouvrage;
import Whole.daoPackage.AbstractDAO;

/**
 * Cette classe est appelee pour creer un lien entre l'application et la base de donnees
 * pour tout ce qui concerne les interactions et les modifications d'un ouvrage
 * @see AbstractDAO
 */
public class OuvrageDAO extends AbstractDAO {
	private static Connection cn;
	
	/**
	 * Constructeur de la classe OuvrageDAO. Instancie l'objet Connection
	 * cn avec le cn passe en parametre.
	 * 
	 * @param cn objet Connection provenant de SingleConnection
	 */
	public OuvrageDAO(Connection cn) {
		
	}
	
    /**
    * Permet d'ajouter un ouvrage dans la base de donnees. L'auteur peut être NULL,
    * on ne connait pas forcement l'auteur d'un ouvrage. Si il n'est pas NULL, on
    * vérifie que l'auteur passé en paramètre existe bien dans la base de données,
    * puis on effectue une requete d'insertion.
    * 
    * @param a Auteur auteur de l'ouvrage
    * @param o Ouvrage ouvrage qu'on souhaite inserer
    */
    public void ecrit(Auteur a, Ouvrage o) {
    	
    }
    
    /**
     * Permet de modifier un ouvrage dans la base de donnees. On s'assure que
     * l'ouvrage qu'on souhaite modifier est bien dans la base de donnees, puis
     * on le remplace par le nouvel ouvrage passe en 2e parametre.
     * 
     * @param objet l'ouvrage cible qu'on souhaite modifier
     * @param changement l'ouvrage par lequel on souhaite remplacer l'ancien
     */
    public void modifier(Ouvrage objet, Ouvrage changement) {
    	
    }
    
    /**
     * Permet de supprimer un ouvrage de la base de donnees. On s'assure que
     * l'ouvrage qu'on souhaite supprimer est bien dans la base de donnees, puis
     * si trouve on le supprime.
     * 
     * @param objet l'ouvrage cible qu'on souhaite supprimer
     */
    public void supprimer(Ouvrage objet) {

    }
    
    /**
     * Permet de rechercher un ou plusieurs ouvrages dans la base de donnees
     * selon un ou plusieurs criteres.
     * 
     * @param donne ouvrage avec tous les parametres nuls sauf ceux a chercher
     * @return renvoie une liste des ouvrages qui correspondent aux critères
     * de recherche
     */
    public ArrayList<Ouvrage> chercher(Ouvrage donne) {
        return null;
    }
}