package Whole.daoPackage;

import Whole.SingleConnection;

import java.sql.Connection;

public class SuperAbstractDAO {
    static Connection cn;
    public SuperAbstractDAO(String url, String login, String password) {
        this.cn= SingleConnection.getInstance(url,login,password);
    }
}
