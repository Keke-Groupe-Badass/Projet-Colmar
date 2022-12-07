package Whole;

import java.sql.Connection;


/**
* SingleConnection est appelee pour creer une unique connexion entre l'application et la base de donnees
*/
public class SingleConnection {
	private static Connection cn;
    
	/**
	 * Constructeur de la classe SingleConnection. 
	 */
    public SingleConnection(){
    	
    }
    
	/**
     * La m�thode permet de s'assurer qu'il n'y a pas de connexion d�j� existante.
     * Si cn=null, la methode se charge de creer une connexion : elle prend l'url de la base,
     * le login de la personne souhaitant y acceder ainsi que le mot de passe puis cree la
     * connexion et la renvoie. Elle instancie la Connection cn.
 	 * Sinon, elle renvoie la connexion deja existante.
     * Si echec de connexion, elle leve une exception SQLException.
     * 
     * @param url lien vers la base de donnees
     * @param login login de l'utilisateur de la BDD, permet de s'identifier sur la base de donnees
     * pour y avoir acces
     * @param pwd mot de passe de l'utilisateur de la BDD, permet egalement de s'identifier sur
     * la base de donnees
     * @return renvoie l'objet Connection cn
     */
    public Connection connection(String url, String login, String pwd) {
        return null;
    }
}