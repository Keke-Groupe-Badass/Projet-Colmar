package Whole.daoPackage;

import Whole.SingleConnection;

import java.sql.Connection;

/**
 * Classe permettant la construction de tout les DAO, en obtenant l'instance de singleConnection
 */
public class SuperAbstractDAO {
    static Connection cn;
    public SuperAbstractDAO(String url, String login, String password) {
        this.cn= SingleConnection.getInstance(url,login,password);
    }
}
