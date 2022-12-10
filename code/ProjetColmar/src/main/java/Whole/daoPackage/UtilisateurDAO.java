package Whole.daoPackage;

import Whole.LinkToDb;

import java.sql.Connection;
import java.util.*;
import java.time.*;

/**
* Cette classe est appelée pour créer un lien entre l'application et la base de données
* pour tout ce qui concerne les interactions et les modifications de l'utilisateur.
* @see AbstractDAO
*/

public class UtilisateurDAO extends AbstractDAO {

    /**
	 * Constructeur de la classe UtilisateurDAO.
	 */
	public UtilisateurDAO() {
        super();
	}

	/**
	 * Permet à un utilisateur de se connecter sur l'application. On donne le login
	 * et le mot de passe de l'utilisateur, puis on fait une requête à la base de
	 * donnees pour s'assurer que l'utilisateur existe et que le mot de passe est
	 * le bon.
	 * @param login Le nom d'utilisateur pour se connecter à la base de donnée
	 * @param pwd  Le mot de passe de la base de donnée
	 * @param cn La connection à la base de donnée
	 * @return renvoie le login sous forme de String si la connexion s'est correctement
	 * effectuée, sinon elle renvoie null.
	 * @see LinkToDb
	 */
	public String connexion(String login, String pwd,Connection cn) {
    	return null;
    }
	
    /**
    * Permet de changer le mot de passe de l'utilisateur. On donne le login et le
    * nouveau mot de passe souhaite, puis on retrouve l'utilisateur dans la base de
    * donnees à l'aide du login. Le nouveau mot de passe est encrypté puis stocké
    * dans la base à la place de l'ancien.
    * @param login login de l'utilisateur, permet de l'identifier dans la BDD
    * @param mdp nouveau mot de passe qui doit venir remplacer l'ancien
	 * @param cn La connection à la base de donnée
	 * @see LinkToDb
    */
    public void changeMDP(String login, String mdp,Connection cn) {

    }

    /**
    * Permet de supprimer un utilisateur de la base de donnees à partir de son login.
    * Le login est recherché dans la base de donnees, puis si trouve l'utilisateur
    * correspondant est alors supprimé.
    * 
    * @param login login de l'utilisateur
	 * @param cn La connection à la base de donnée
	 * @see LinkToDb
    */
    public void supprimerUtilisateur(String login,Connection cn) {
    
    }

    /**
    * Permet de créer un nouvel utilisateur dans la base de donnees.
    * Si le login n'existe pas déjà, ni que l'adresse mail est déjà utilisée, on
    * encrypte le mot de passe et on effectue une requête d'insertion avec le login,
    * mot de passe et adresse mail de l'utilisateur qu'on souhaite ajouter.
    *
    * @param login login de l'utilisateur à ajouter
    * @param mdp mot de passe de l'utilisateur à ajouter
    * @param mail adresse mail de l'utilisateur à ajouter
	 * @param cn La connection à la base de donnée
	 * @see LinkToDb
    */
    public void creerUtilisateur(String login, String mdp, String mail,Connection cn) {

    }
}