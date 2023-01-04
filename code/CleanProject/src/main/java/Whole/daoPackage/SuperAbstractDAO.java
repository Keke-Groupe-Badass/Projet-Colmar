package Whole.daoPackage;

import Whole.SingleConnection;

import java.sql.Connection;

/**
 * Classe permettant la construction de tous les DAO en obtenant l'instance de SingleConnection
 */
public abstract class SuperAbstractDAO {
    protected static Connection cn;
    public SuperAbstractDAO(String url, String login, String password) {
        cn = SingleConnection.getInstance(url,login,password);
    }
}
