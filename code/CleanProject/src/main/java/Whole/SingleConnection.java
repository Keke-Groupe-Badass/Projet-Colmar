package Whole;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * SingleConnection est appelée pour créer une unique connexion
 * entre l'application et la base de données.
 */
public class SingleConnection {
    private static Connection cn;

    /**
     * Permet de faire le lien avec la base de données grâce à l'url, le
     * login et le mot de passe.
     * Constructeur de la classe SingleConnection.
     *
     * @param url url de la BDD
     * @param login login de la BDD
     * @param mdp mot de passe de la BDD
     */
    private SingleConnection(String url, String login, String mdp) {
        final MysqlDataSource mysqlDS=new MysqlDataSource();
        mysqlDS.setURL(url);
        mysqlDS.setUser(login);
        mysqlDS.setPassword(mdp);

        try {
            cn=mysqlDS.getConnection();
        } catch (SQLException e) {
            System.out.println("Erreur");
            e.printStackTrace();
        }
    }

    /**
     * La méthode permet de s'assurer qu'il n'y a pas de connexion déjà
     * existante.
     * Si cn=null, la methode se charge de créer une connexion : elle
     * prend l'url de la base, le login de la personne souhaitant y accéder
     * ainsi que le mot de passe puis crée la connexion et la renvoie.
     * Elle instancie la Connection cn.
     * Sinon, elle renvoie la connexion deja existante.
     * Si échec de connexion, elle lève une exception SQLException.
     *
     * @author Emerance
     * @param url   lien vers la base de donnees
     * @param login login de l'utilisateur de la BDD, permet de s'identifier
     *              sur la base de données pour y avoir accès
     * @param mdp   mot de passe de l'utilisateur de la BDD, permet également
     *              de s'identifier sur la base de donnees
     * @return renvoie l'objet Connection cn
     */
    public static Connection getInstance(String url, String login, String mdp) {
        if (cn == null) {
            new SingleConnection(url, login, mdp);
        }
        return cn;
    }
}