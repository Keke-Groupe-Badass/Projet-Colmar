package Whole.daoPackage;

import Whole.SingleConnection;
import Whole.exportPackage.ExportTypeInterface;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;


/**
 * Classe permettant à l'administrateur de gérer la base de données.
 */
public class AdminDAO extends SuperAbstractDAO {
    /**
     * Utilisateur de la BDD.
     */
    private String utilisateur;
    /**
     * Mdp de la BDD.
     */
    private String mdp;
    /**
     * Lien de la BDD.
     */
    private String bdd;
    /**
     * Liste de tables.
     */
    private ArrayList<String> listeTable;

    /**
     * Constructeur de la classe.
     *
     * @param url   url de la BDD
     * @param login login de la BDD
     * @param mdp   mdp de la BDD
     */
    public AdminDAO(String url, String login, String mdp) {
        super(url, login, mdp);
        this.utilisateur = login;
        this.mdp = mdp;
        this.bdd = url;
    }

    /**
     * Permet de stocker dans un fichier la BDD.
     *
     * @param e    le nom de la méthode d'export
     * @param path le fichier où seront exportées les données
     * @return true si l'export a pu se faire, false sinon
     * @author Andreas
     * @see SingleConnection
     * @see ExportTypeInterface
     */
    public Boolean exportDonnee(ExportTypeInterface e, String path) {
        if (e == null) {
            return false;
        }
        if (e.getName().equals("SQL")) {
            return sqlExport(path);
        }
        return exportNonSQL(path, e);
    }

    /**
     * Permet d'exporter les données aux formats non-sql.
     *
     * @param path le fichier où seront exportées les données
     * @param e    ExportTypeInterface
     * @return true si l'export a pu se faire, false sinon
     * @author Andreas
     */
    private boolean exportNonSQL(String path, ExportTypeInterface e) {
        boolean b = true;
        ArrayList<ArrayList<String>> list;
        for (String st : listeTable) {
            list = getTableList(st);
            File f = new File(path + "/" + st);
            b = b && e.export(f, list);
        }
        return b;
    }

    /**
     * Permet d'exporter les données au format SQL.
     *
     * @param path le fichier où seront exportées les données
     * @return true si l'export a pu se faire, false sinon
     * @author Andreas
     */
    private boolean sqlExport(String path) {
        String os = System.getProperty("os.name");
        String type = "sh";
        if (os.contains("Windows")) {
            type = "cmd.exe";
        }
        String[] cmd = {type, "exportSQL.sh", "src/main/shell/exportSQL.sh",
                        utilisateur, mdp, bdd, path};
        try {
            Runtime.getRuntime().exec(cmd);
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

    /**
     * Permet de transformer une table en une liste de liste, le premier niveau
     * de liste représentant les lignes et le second niveau les colonnes, la
     * première ligne est le nom des colonnes.
     *
     * @param table la table que l'on souhaite exporter
     * @return true si tout c'est bien passé, false sinon
     * @author Andreas
     */
    private ArrayList<ArrayList<String>> getTableList(String table) {
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        try {
            Statement stmt = cn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM " + table);
            ResultSetMetaData md = rs.getMetaData();
            int size = md.getColumnCount();
            for (int i = 0; i < size; i++) {
                list.get(0).add(md.getColumnName(i));
            }
            int row = 1;
            while (rs.next()) {
                for (int j = 0; j < row; j++) {
                    for (int i = 0; i < size; i++) {
                        list.get(j).add((String) rs.getObject(i));
                    }
                }
                row++;
            }
        } catch (SQLException e) {
            System.out.println("something went wrong");
        }
        return list;
    }

    /**
     * Permet de stocker dans un fichier les logs.
     *
     * @param cn   La connection à la base de données
     * @param file le fichier où seront exportés les logs
     * @return true si l'exportation s'est faite, false sinon
     * @author Andreas
     * @see SingleConnection
     */
    public boolean exportLog(File file, Connection cn) {
        try {
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT `text`,`date`,`userLogin` "
                    + "FROM `log`");
            String str = "Hello";
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write("Log exporté le " + new Date(System.currentTimeMillis()));

            while (rs.next()) {
                bw.newLine();
                str = rs.getString(2) + " par " + rs.getString(3)
                        + ": " + rs.getString(1);
                bw.write(str);
            }
            bw.close();

        } catch (SQLException e) {
            System.err.println("something went wrong with the database link");
        } catch (IOException e) {
            System.err.println("something went wrong with the file's writing");
        }
        return false;
    }

    /**
     * Supprime les logs de la BDD.
     *
     * @param cn La connection à la base de données
     * @return true si fonctionne correctement, false sinon
     * @author Andreas
     * @see SingleConnection
     */
    public Boolean deleteLog(Connection cn) {
        Statement stm = null;
        try {
            stm = cn.createStatement();
            stm.execute("DELETE FROM `log`");
            return true;
        } catch (SQLException e) {
            System.err.println("something went wrong with the database link");
        }
        return false;
    }

    /**
     * Ajoute au log un text.
     *
     * @param txt Le message à enregistrer
     * @return true si l'insertion peut se faire, false sinon
     * @author Andreas
     * @see SingleConnection
     */
    public Boolean writeLog(String txt) {
        try {
            Statement st = cn.createStatement();
            st.execute("INSERT INTO `log`( `text`, `date`, `userLogin`) "
                    + "VALUES('" + txt + "','"
                    + new Date(System.currentTimeMillis()) + "','"
                    + utilisateur + "'");
            return true;
        } catch (SQLException e) {
            System.err.println("something went wrong with the database link");
        }
        return false;
    }
}