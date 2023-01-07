package Whole.daoPackage;

import Whole.SingleConnection;
import java.sql.Connection;

/**
 * Classe permettant la construction de tous les DAO en obtenant
 * l'instance de SingleConnection.
 */
public abstract class SuperAbstractDAO {
    /**
     * Attribut connection qui sert à faire le lien avec la BDD.
     */
    protected static Connection cn;

    /**
     * Constructeur de SuperAbstractDao.
     * @param url url de la BDD
     * @param login login de la BDD
     * @param mdp mot de passe de la BDD
     */
    public SuperAbstractDAO(String url, String login, String mdp) {
        cn = SingleConnection.getInstance(url,login,UtilisateurDAO.encrypte(mdp));
    }
}
