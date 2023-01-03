package Whole.daoPackage;

import Whole.SingleConnection;
import Whole.ccmsPackage.Personne;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/**
 * Classe servant à lié à la base de donnée les méthodes d'Auteurs
 * @see Personne
 */
public class PersonneDAO extends AbstractDAO<Personne> {
    /**
     * Constructeur d'AdminDAO
     * @see SingleConnection
     */
    public PersonneDAO(String url, String login, String password) {
        super(url, login, password);
    }



    /**
     * Met à jour la BD
     *
     * @param objet      Personne à changer
     * @param changement Personne de changement (les paramètres null ne sont pas à changer)
     * @return
     * @see SingleConnection
     */
    public boolean modifier(Personne objet , Personne changement) {
    	
    	StringBuilder str = new StringBuilder();
        if(changement.getNom() != null) {
            str.append("Nom=" + changement.getNom());
        }
       
        if(changement.getPrenom() != null) {
            str.append(", Prenom=" + changement.getPrenom());
        }
        
        if(changement.getNote() != null) {
            str.append(", Note=" + changement.getNote());
        }
        try{
            Statement stmt = cn.createStatement();
            String sql = "UPDATE personnes SET" + str + "WHERE idPersonne=" + objet.getId();
            stmt.executeQuery(sql);
            return true;


        } catch (Exception e) {
            return false;
        }



    }
    /**
     * Supprime de la db un Personne
     *
     * @param objet une Personne d'un type à déterminer dans chaque implémentation
     * @return
     * @see Personne
     * @see SingleConnection
     */
    public boolean supprimer(Personne objet) {

        if(objet.getId() <= 0) {
            return false;
        }
        try {
            Statement stmt = cn.createStatement();
            String sql = "DELETE FROM lettrine WHERE id=" + objet.getId();
            stmt.executeQuery(sql);
            return true;
        }
        catch (SQLException e) {
            return false;
        }
    }
    /**
     * Ajoute à la base de donnée une Personne
     *
     * @param donne la Personne à ajouter
     * @return
     * @see Personne
     * @see SingleConnection
     */
    public boolean creer(Personne donne) {
    	try {
            PreparedStatement stmt = cn.prepareStatement("insert into personnes values(?,?,?)");
            stmt.setString(1,donne.getNom());
            stmt.setString(2,donne.getPrenom());
            stmt.setString(3,donne.getNote());
            return stmt.execute();
    	} 
    	catch (SQLException e) {
            return false;
        }
    }
    	
    /**
     *Cherche une Personne dans la base
     * @param donne Personne avec tous les paramètres nuls sauf ceux à chercher
     * @return la Liste des auteurs correspondant aux critères
     * @see Personne
     * @see SingleConnection
     */
    public ArrayList<Personne> chercher(Personne donne) {
        PreparedStatement stmt= null;
        ArrayList listPers = new ArrayList();
        boolean premier=true;
        String sql="SELECT * FROM personnes WHERE";
        if (donne.getId() != -2) {
            sql+=" id='"+donne.getId()+"'";
            premier=false;
        }
        if (donne.getNom() != null) {
            if (!premier)
                sql+=" AND";
            sql+=" nom='"+donne.getNom()+"'";
            premier=false;
        }
        if (donne.getPrenom() != null) {
            if (!premier)
                sql+=" AND";
            sql+=" prenom='"+donne.getPrenom()+"'";
            premier=false;
        }

        try {
            stmt = cn.prepareStatement(sql);
            ResultSet rs=stmt.executeQuery();
            while(rs.next()){
                Personne pers = new Personne();
                pers.setId(rs.getInt("id"));
                pers.setNom(rs.getString("nom"));
                pers.setPrenom(rs.getString("prenom"));
                listPers.add(pers);

            }
            return listPers;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}