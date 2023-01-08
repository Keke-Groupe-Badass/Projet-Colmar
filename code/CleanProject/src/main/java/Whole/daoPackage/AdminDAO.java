package Whole.daoPackage;

import Whole.SingleConnection;
import Whole.exportPackage.ExportCSV;
import Whole.exportPackage.ExportAbstract;
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
    private String nom = "serveur";
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
     * Liste des tables dans la BDD.
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
        listeTable = new ArrayList<>();
        listeTable.add("ecrit");
        listeTable.add("identiques");
        listeTable.add("lettrines");
        listeTable.add("logs");
        listeTable.add("metadonnees");
        listeTable.add("ouvrages");
        listeTable.add("personnes");
        listeTable.add("regroupe");
        listeTable.add("tags");
        listeTable.add("utilisateurs");
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Permet de stocker dans un fichier la BDD.
     *
     * @param methode    le nom de la méthode d'export
     * @param path le fichier où seront exportées les données
     * @return true si l'export a pu se faire, false sinon
     * @author Andreas
     * @see SingleConnection
     * @see ExportAbstract
     */
    public Boolean exportDonnee(String methode, String path) {
        if (methode == null) {
            return false;
        }
        if (methode.equals("SQL")) {
            return sqlExport(path);
        }
        return exportNonSQL(path, methode);
    }

    /**
     * Permet d'exporter les données aux formats non-sql.
     *
     * @param path le fichier où seront exportées les données
     * @param methode le nom de la méthode d'exportation
     * @return true si l'export a pu se faire, false sinon
     * @author Andreas
     */
    private boolean exportNonSQL(String path, String methode) {
        boolean b = true;
        ArrayList<ArrayList<String>> list;
        ExportAbstract e = null;
        if(methode.equals("CSV")){
            e = new ExportCSV();
        }
        if(e!=null){
            for (String st : listeTable) {
                list = getTableList(st);
                b = b && e.export(path + "/" + st, list);
            }
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
        System.out.println(os);
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
            System.err.println(ex);
            return false;
        }
    }

    /**
     * Permet de transformer une table en une liste de liste, le premier niveau
     * de liste représentant les lignes et le second niveau les colonnes, la
     * première ligne est le nom des colonnes.
     *
     * @param table la table que l'on souhaite exporter
     * @return true si tout s'est bien passé, false sinon
     * @author Andreas
     */
    private ArrayList<ArrayList<String>> getTableList(String table) {
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        try {
            Statement stmt = cn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM " + table);
            ResultSetMetaData md = rs.getMetaData();
            int nbColonne = md.getColumnCount();
            ArrayList<String> listeNomColonne = new ArrayList<>();

            System.out.println(table + " " + nbColonne);

            if (rs.next()) {
                for (int i = 1; i <= nbColonne; i++) {
                    listeNomColonne.add(md.getColumnName(i));
                }
            }
            list.add(listeNomColonne);
            while (rs.next()) {
                ArrayList<String> listeLigne = new ArrayList<>();
                list.add(listeLigne);
                for(int i=1;i<=nbColonne;i++){
                    listeLigne.add(""+rs.getObject(i));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    /**
     * Permet de stocker dans un fichier les logs.
     *
     * @param file le fichier où seront exportés les logs
     * @return true si l'exportation s'est faite, false sinon
     * @author Andreas
     * @see SingleConnection
     */
    public boolean exportLog(File file) {
        try {
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT `texte`,`date`,`email` "
                    + "FROM `logs`");
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
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    /**
     * Supprime tous les logs de la BDD.
     *
     * @return true si fonctionne correctement, false sinon
     * @author Andreas
     * @see SingleConnection
     */
    public Boolean supprimerLogs() {
        Statement stm = null;
        try {
            stm = cn.createStatement();
            int nbColonnes = stm.executeUpdate("DELETE FROM `logs`");
            return nbColonnes > 0;
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
    public Boolean ecrireLog(String txt) {
        try {
            String sql = "INSERT INTO `logs`(`texte`, `date`, `email`) "
                    + "VALUES(?,'"
                    + new Date(System.currentTimeMillis()) + "','"
                    + nom + "')";
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, txt);
            int nbColonnes = st.executeUpdate();
            return nbColonnes > 0;
        } catch (SQLException e) {
            System.err.println("something went wrong with the database link");
        }
        return false;
    }
}