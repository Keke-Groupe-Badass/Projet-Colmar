package Whole.daoPackage;

import java.sql.Connection;
import java.util.*;
import java.time.*;

/**
* Cette classe est appelee pour creer un lien entre l'application et la base de donnees
* pour tout ce qui concerne les interactions et les modifications de l'utilisateur
* @see AbstractDAO
*/

public class UtilisateurDAO extends AbstractDAO {
	private static Connection cn;

    /**
	 * Constructeur de la classe UtilisateurDAO. Instancie l'objet Connection
	 * cn avec le cn passe en parametre.
	 * 
	 * @param cn objet Connection provenant de SingleConnection
	 */
	public UtilisateurDAO(Connection cn) {
	}

	/**
	 * Permet à un utilisateur de se connecter sur l'application. On donne le login
	 * et le mot de passe de l'utilisateur, puis on fait une requete a la base de 
	 * donnees pour s'assurer que l'utilisateur existe et que le mot de passe est
	 * le bon.
	 * 
	 * @return renvoie le login sous forme de String si la connexion s'est correctement
	 * effectuee, sinon elle renvoie null.
	 */
	public String connexion(String login, String pwd) {
    	return null;
    }
	
    /**
    * Permet de changer le mot de passe de l'utilisateur. On donne le login et le
    * nouveau mot de passe souhaite, puis on retrouve l'utilisateur dans la base de
    * donnees a l'aide du login. Le nouveau mot de passe est encrypte puis stocke
    * dans la base a la place de l'ancien.
    * @param login login de l'utilisateur, permet de l'identifier dans la BDD
    * @param mdp nouveau mot de passe qui doit venir remplacer l'ancien
    */
    public void changeMDP(String login, String mdp) {

    }

    /**
    * Permet de supprimer un utilisateur de la base de donnees a partir de son login.
    * Le login est recherche dans la base de donnees, puis si trouve l'utilisateur
    * correspondant est alors supprime.
    * 
    * @param login login de l'utilisateur
    */
    public void supprimerUtilisateur(String login) {
    
    }

    /**
    * Permet de creer un nouvel utilisateur dans la base de donnees.
    * Si le login n'existe pas deja , ni que l'adresse mail est deja  utilisee, on
    * encrypte le mot de passe et on effectue une requete d'insertion avec le login,
    * mot de passe et adresse mail de l'utilisateur qu'on souhaite ajouter.
    *
    * @param login login de l'utilisateur a ajouter
    * @param mdp mot de passe de l'utilisateur a ajouter
    * @param mail adresse mail de l'utilisateur a ajouter

    */
    public void creerUtilisateur(String login, String mdp, String mail) {

    }
}