package Whole.daoPackage;

import Whole.SingleConnection;
import Whole.ccmsPackage.Lettrine;
import Whole.ccmsPackage.Tag;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Classe servant à lier à la base de données les méthodes de Tag.
 *
 * @see Tag
 */
public class TagDAO extends AbstractDAO<Tag> {
    /**
     * Constructeur de la classe OuvrageDAO.
     * @param url url de la BDD
     * @param login login de la BDD
     * @param mdp mot de passe de la BDD
     * @see SingleConnection
     */
    public TagDAO(String url, String login, String mdp) {
        super(url, login, mdp);
    }

    /**
     * Met à jour la BDD.
     *
     * @param objet      Tag à changer
     * @param changement Tag de changement (les paramètres null ne sont
     *                   pas à changer)
     * @return true si la modification s'est correctement effectuée, false sinon
     * @see SingleConnection
     */
    @Override
    public boolean modifier(Tag objet, Tag changement) {
        boolean premier=true;
        if (changement == null) {
            return false;
        }
        StringBuilder str = new StringBuilder();
        str.append("UPDATE `tags` SET ");
        if (changement.getNom() != null) {
            str.append("`nom`='" + changement.getNom() + "'");
            premier=false;
        }
        if (changement.getDescription() != null) {
            if (!premier)
                str.append(", ");
            str.append("`description`='" + changement.getDescription() + "'");
        }
        str.append(" WHERE idTag=" + objet.getId());
        try {
            PreparedStatement stmt = cn.prepareStatement(str.toString());
            int nbColonnesModifiees = stmt.executeUpdate();
            return nbColonnesModifiees > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Supprime de la BDD un Tag.
     *
     * @param objet un Tag d'un type à déterminer dans chaque implémentation
     * @return true si la suppression s'est correctement effectuée, false sinon
     * @see SingleConnection
     * @see Tag
     */
    @Override
    public boolean supprimer(Tag objet) {
        if (objet.getId() <= 0) {
            return false;
        }
        try {
            String sql="DELETE FROM `regroupe` WHERE `idTag`=?";
            PreparedStatement stmt = cn.prepareStatement(sql);
            stmt.setInt(1, objet.getId());
            stmt.execute();
            stmt = cn.prepareStatement("DELETE FROM `tags` WHERE `idTag`=?");
            stmt.setInt(1, objet.getId());
            int nbColonnesModifiees = stmt.executeUpdate();
            return nbColonnesModifiees > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    /**
     * Ajoute à la base de donnée un Tag.
     *
     * @param objet le Tag à ajouter
     * @return true si l'ajout s'est correctement effectué, false sinon
     * @see SingleConnection
     * @see Tag
     */
    @Override
    public boolean creer(Tag objet) {
        if (objet.getNom() != null) {
            try {
                String sql="SELECT * FROM tags WHERE idTag=" + objet.getId();
                PreparedStatement stmt = cn.prepareStatement(sql);
                if (!stmt.execute()){ //Si le tag n'existe pas déjà
                    sql = "INSERT INTO tags (nom, description) VALUES(?,?)";
                    stmt = cn.prepareStatement(sql);
                    stmt.setString(1, objet.getNom());
                    stmt.setString(2, objet.getDescription());
                    int nbColonnes = stmt.executeUpdate();
                    return nbColonnes > 0;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }

    /**
     * Cherche un Tag dans la base.
     *
     * @param objet Tag avec tous les paramètres nuls sauf ceux à chercher
     * @return La liste des tags qui correspond aux paramètres donnés
     * @see SingleConnection
     * @see Tag
     */
    @Override
    public ArrayList<Tag> chercher(Tag objet) {
        ArrayList l = new ArrayList();
        if (objet == null) {
            return l;
        }
        StringBuilder str = new StringBuilder();
        boolean premier=true;
        str.append("SELECT * FROM `tags` WHERE");
        if (objet.getNom() != null) {
            str.append(" nom='" + objet.getNom() + "'");
            premier=false;
        }
        if (objet.getDescription() != null) {
            if (!premier)
                str.append(" AND");
            str.append(" description='" + objet.getDescription() + "'");
        }
        try {
            PreparedStatement stmt = cn.prepareStatement(str.toString());
            if (objet.getNom() == null && objet.getDescription() == null){
                String sql="SELECT * FROM tags";
                stmt = cn.prepareStatement(sql);
            }
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                l.add(new Tag(rs.getInt("idTag"), rs.getString("nom"),
                        rs.getString("description")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return l;
    }

    /**
     * Permet d'obtenir toutes les lettrines associées à un tag
     * @param t le tag que la lettrine doit avoir
     * @return la liste des lettrines possédant le tag
     */
    public ArrayList<Lettrine> lettrinesAssociees(Tag t){
        ArrayList<Lettrine> l = new ArrayList<>();
        if(t!=null){
            String sql = "SELECT lettrines.idLettrine FROM `lettrines` INNER JOIN regroupe on regroupe.idLettrine = idLettrine WHERE regroupe.idTag = ?";
            try {
                PreparedStatement preparedStatement = cn.prepareStatement(sql);
                ResultSet rs = preparedStatement.executeQuery();
                while(rs.next()){
                    l.add(new Lettrine(rs.getInt(1)));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return l;
    }
}