package Whole.daoPackage;

import java.sql.Connection;
import java.util.*;
import java.time.*;

/**
* Cette classe est appel�e pour cr�er un lien entre l'application et la base de donn�es
* pour tout ce qui concerne les int�ractions et les modifications de l'utilisateur
*/

public class UtilisateurDAO extends AbstractDAO {
	/**
    * La m�thode se charge de cr�er une connexion avec la base de donn�es pour pouvoir
    * ensuite effectuer des �changes et des modifications dessus. Elle prend l'url de la base,
    * le login de la personne souhaitant y acc�der ainsi que le mot de passe puis fait appel
    * � SingleConnection pour cr�er la connexion.
    * 
    * @param url : lien vers la base de donn�es
    * @param login : login de l'utilisateur de la BDD, permet de s'identifier sur la base de donn�es
    * pour y avoir acc�s
    * @param pwd : mot de passe de l'utilisateur de la BDD, permet �galement de s'identifier sur
    * la base de donn�es
    * @return Renvoie la connexion qui a �t� cr��e sous forme d'objet Connection si la
    * connexion s'est effectu�e avec succ�s. Sinon, elle l�ve une exception SQLException.
    * @see Whole.SingleConnection
    */
    public Connection connexion(String url, String login, String pwd) {
    	return null;
    }

    /**
    * Permet de changer le mot de passe de l'utilisateur. On donne le login et le
    * nouveau mot de passe souhait�, puis on retrouve l'utilisateur dans la base de
    * donn�es � l'aide du login. Le nouveau mot de passe est encrypt� puis stock�
    * dans la base � la place de l'ancien.
    * 
    * @param login : login de l'utilisateur, permet de l'identifier dans la BDD
    * @param mdp : nouveau mot de passe qui doit venir remplacer l'ancien
    */
    public void changeMDP(String login, String mdp) {

    }

    /**
    * Permet de supprimer un utilisateur de la base de donn�es � partir de son login.
    * Le login est recherch� dans la base de donn�es, puis si trouv� l'utilisateur
    * correspondant est alors supprim�.
    * 
    * @param login : login de l'utilisateur
    */
    public void supprimerUtilisateur(String login) {
    
    }

    /**
    * Permet de cr�er un nouvel utilisateur dans la base de donn�es.
    * Si le login n'existe pas d�j�, ni que l'adresse mail est d�j� utilis�e, on
    * encrypte le mot de passe et on effectue une requ�te d'insertion avec le login,
    * mot de passe et adresse mail de l'utilisateur qu'on souhaite ajouter.
    *
    * @param login : login de l'utilisateur � ajouter
    * @param mdp : mot de passe de l'utilisateur � ajouter
    * @param mail : adresse mail de l'utilisateur � ajouter
    */
    public void creerUtilisateur(String login, String mdp, String mail) {

    }
}