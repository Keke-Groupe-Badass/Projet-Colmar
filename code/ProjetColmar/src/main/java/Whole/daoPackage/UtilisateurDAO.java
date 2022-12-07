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
    * La méthode se charge de créer une connexion avec la base de données pour pouvoir
    * ensuite effectuer des échanges et des modifications dessus. Elle prend l'url de la base,
    * le login de la personne souhaitant y accéder ainsi que le mot de passe puis fait appel
    * à SingleConnection pour créer la connexion.
    * 
    * @param url : lien vers la base de données
    * @param login : login de l'utilisateur de la BDD, permet de s'identifier sur la base de données
    * pour y avoir accés
    * @param pwd : mot de passe de l'utilisateur de la BDD, permet également de s'identifier sur
    * la base de données
    * @return Renvoie la connexion qui a été créée sous forme d'objet Connection si la
    * connexion s'est effectuée avec succàs. Sinon, elle lève une exception SQLException.
    * @see Whole.SingleConnection
    */
    public Connection connexion(String url, String login, String pwd) {
    	return null;
    }

    /**
    * Permet de changer le mot de passe de l'utilisateur. On donne le login et le
    * nouveau mot de passe souhaité, puis on retrouve l'utilisateur dans la base de
    * données à l'aide du login. Le nouveau mot de passe est encrypté puis stocké
    * dans la base à la place de l'ancien.
	 * Constructeur de la classe UtilisateurDAO. Instancie l'objet Connection
	 * cn avec le cn passe en parametre.
	 * 
	 * @param cn objet Connection provenant de SingleConnection
	 */
	public UtilisateurDAO(Connection cn) {
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
    * Permet de supprimer un utilisateur de la base de données à partir de son login.
    * Le login est recherché dans la base de données, puis si trouvé l'utilisateur
    * correspondant est alors supprimé.
    * 
    * @param login login de l'utilisateur
    */
    public void supprimerUtilisateur(String login) {
    
    }

    /**
    * Permet de créer un nouvel utilisateur dans la base de données.
    * Si le login n'existe pas déjà, ni que l'adresse mail est déjà utilisée, on
    * encrypte le mot de passe et on effectue une requète d'insertion avec le login,
    * mot de passe et adresse mail de l'utilisateur qu'on souhaite ajouter.
    *
    * @param login : login de l'utilisateur à ajouter
    * @param mdp : mot de passe de l'utilisateur à ajouter
    * @param mail : adresse mail de l'utilisateur à ajouter

    */
    public void creerUtilisateur(String login, String mdp, String mail) {

    }
}