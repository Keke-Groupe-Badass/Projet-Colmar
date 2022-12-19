package Whole;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * SingleConnection est appelee pour creer une unique connexion entre l'application et la base de donnees
 */
public class SingleConnection {
    private static Connection cn;
    private static SingleConnection instance = new SingleConnection();

    /**
     * @author Andreas
     * Constructeur de la classe SingleConnection.
     */

    private static void SingleConnection(String url, String login, String pwd) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        try {
            cn= DriverManager.getConnection(url,login,pwd);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * La méthode permet de s'assurer qu'il n'y a pas de connexion déjà existante.
     * Si cn=null, la methode se charge de creer une connexion : elle prend l'url de la base,
     * le login de la personne souhaitant y acceder ainsi que le mot de passe puis cree la
     * connexion et la renvoie. Elle instancie la Connection cn.
     * Sinon, elle renvoie la connexion deja existante.
     * Si echec de connexion, elle leve une exception SQLException.
     * @author Emerance
     * @param url   lien vers la base de donnees
     * @param login login de l'utilisateur de la BDD, permet de s'identifier sur la base de donnees
     *              pour y avoir acces
     * @param pwd   mot de passe de l'utilisateur de la BDD, permet egalement de s'identifier sur
     *              la base de donnees
     * @return renvoie l'objet Connection cn
     */
    public static Connection getInstance(String url, String login, String pwd) {
        try {
            SingleConnection(url, login, pwd);
            return cn;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}