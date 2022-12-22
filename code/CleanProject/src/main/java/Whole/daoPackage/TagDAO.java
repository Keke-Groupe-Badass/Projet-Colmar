package Whole.daoPackage;

import Whole.SingleConnection;
import Whole.ccmsPackage.Tag;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/**
 * Classe servant à lié à la base de donnée les méthodes de Tag
 * @see Tag
 */
public class TagDAO extends AbstractDAO<Tag>{

    /**
     * Constructeur de la classe OuvrageDAO.
     * @see SingleConnection
     */
    public TagDAO(String url, String login, String password) {
        super(url, login, password);
    }


    /**
     * Met à jour la BD
     *
     * @param objet      Tag à changer
     * @param changement Tag de changement (les paramètres null ne sont pas à changer)
     * @return
     * @see SingleConnection
     */


    @Override
    public boolean modifier(Tag objet , Tag changement) {
        if(changement==null){
            return false;
        }
        StringBuilder str = new StringBuilder();
        str.append("UPDATE `tags` SET ");
        if(changement.getNom()!=null){
            str.append("`nom`='"+changement.getNom()+"', ");
        }
        if(changement.getDescription()!=null){
            str.append("`description`='"+changement.getDescription()+"'");
        }
        try {
            PreparedStatement stmt = cn.prepareStatement(str.toString());
            return stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * Supprime de la db un Tag
     *
     * @param objet un Tag d'un type à déterminer dans chaque implémentation
     * @return
     * @see SingleConnection
     * @see Tag
     */
    @Override

    public boolean supprimer(Tag objet ) {

        if(objet.getId() <= 0) {
            return false;
        }
        try {
            PreparedStatement stmt = cn.prepareStatement("DELETE FROM `regroupe` WHERE `idTag`=?");
            stmt.setInt(1,objet.getId());
            stmt.execute();
            stmt = cn.prepareStatement("DELETE FROM `tags` WHERE `idTag`=?");
            stmt.setInt(1,objet.getId());
            stmt.execute();
            return true;
        }
        catch (SQLException e) {
            return false;
        }    }
    /**
     * Ajoute à la base de donnée un Tag
     *
     * @param objet le Tag à ajouter
     * @return
     * @see SingleConnection
     * @see Tag
     */
    @Override

    public boolean creer(Tag objet) {
        try {
            PreparedStatement stmt = cn.prepareStatement("insert into tags values(?,?)");
            stmt.setString(2,objet.getNom());
            stmt.setString(1,objet.getDescription());
            return stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *Cherche un Tag dans la base
     * @param objet Tag avec tous les paramètres nuls sauf ceux à chercher
     * @return La liste des tags qui correspond auc paramètres donnés
     * @see SingleConnection
     * @see Tag
     *
     */
    @Override
    public ArrayList<Tag> chercher(Tag objet) {
        ArrayList l = new ArrayList();
        if(objet==null){
            return l;
        }
        StringBuilder str = new StringBuilder();
        str.append("SELECT * FROM `tags` WHERE 1 ");
        if(objet.getId()>0){
            str.append("&& idTag= "+objet.getId()+" ");
        }
        if(objet.getNom()!=null){
            str.append("&& nom= "+objet.getNom()+" ");
        }
        if(objet.getDescription()!=null){
            str.append("&& description= "+objet.getDescription()+" ");
        }
        try {
            PreparedStatement stmt = cn.prepareStatement(str.toString());
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                l.add(new Tag(rs.getInt(0),rs.getString(2),rs.getString(1)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return l;
    }
}