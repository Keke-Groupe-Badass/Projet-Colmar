package Whole.daoPackage;

import Whole.SingleConnection;
import Whole.ccmsPackage.Personne;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Classe servant à lier à la base de données les méthodes de Personnes.
 *
 * @see Personne
 */
public class PersonneDAO extends AbstractDAO<Personne> {
    /**
     * Constructeur de PersonneDAO.
     *
     * @param url   url de la BDD
     * @param login login de la BDD
     * @param mdp   mot de passe de la BDD
     * @see SingleConnection
     */
    public PersonneDAO(String url, String login, String mdp) {
        super(url, login, mdp);
    }

    /**
     * Met à jour la BDD.
     *
     * @param objet      Personne à changer
     * @param changement Personne de changement (les paramètres null ne sont
     *                   pas à changer)
     * @return true si le changement s'est correctement effectué, false sinon
     * @see SingleConnection
     */
    public boolean modifier(Personne objet, Personne changement) {
        boolean premier = true;
        StringBuilder str = new StringBuilder();
        if (changement.getNom() != null) {
            str.append("nom='" + changement.getNom());
            str.append("'");
            premier = false;
        }

        if (changement.getPrenom() != null) {
            if (!premier)
                str.append(", ");
            str.append("prenom='" + changement.getPrenom());
            str.append("'");
            premier = false;
        }

        if (changement.getNote() != null) {
            if (!premier)
                str.append(", ");
            str.append("note='" + changement.getNote());
            str.append("'");
        }
        try {
            Statement stmt = cn.createStatement();
            String sql = "UPDATE personnes SET " + str
                    + " WHERE idPersonne=" + objet.getId();
            System.out.println(sql);
            int nbColonnes = stmt.executeUpdate(sql);
            return nbColonnes > 0;


        } catch (SQLException e) {
            return false;
        }
    }

    /**
     * Supprime de la BDD une Personne.
     *
     * @param objet une Personne d'un type à déterminer dans chaque
     *              implémentation
     * @return true si la suppression s'est correctement effectuée, false sinon
     * @see Personne
     * @see SingleConnection
     */
    public boolean supprimer(Personne objet) {
        if (objet.getId() <= 0) {
            return false;
        }
        try {
            Statement stmt = cn.createStatement();
            String sql = "DELETE FROM ecrit WHERE idPersonne=" + objet.getId();
            stmt.execute(sql);
            sql = "UPDATE lettrines SET idPersonne=NULL "
                    + "WHERE idPersonne=" + objet.getId();
            stmt.execute(sql);
            sql = "UPDATE ouvrages SET imprimeur=NULL "
                    + "WHERE imprimeur=" + objet.getId();
            stmt.execute(sql);
            sql = "UPDATE ouvrages SET libraire=NULL "
                    + "WHERE libraire=" + objet.getId();
            stmt.execute(sql);
            sql = "DELETE FROM personnes "
                    + "WHERE idPersonne=" + objet.getId();
            int nbColonnes = stmt.executeUpdate(sql);
            return nbColonnes > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    /**
     * Ajoute à la base de données une Personne.
     *
     * @param donne la Personne à ajouter
     * @return true si l'ajout s'est correctement effectué, false sinon
     * @see Personne
     * @see SingleConnection
     */
    public boolean creer(Personne donne) {
        try {
            String sql = "SELECT * FROM personnes WHERE idPersonne=?";
            PreparedStatement stmt = cn.prepareStatement(sql);
            stmt.setInt(1, donne.getId());
            if (!stmt.execute()) { //Si la personne n'existe pas

                sql = "INSERT INTO personnes (nom, prenom, note) VALUES(?,?,?)";
                stmt = cn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
                stmt.setString(1, donne.getNom());
                stmt.setString(2, donne.getPrenom());
                stmt.setString(3, donne.getNote());
                int nbColonnes = stmt.executeUpdate();
                return nbColonnes > 0;
            }
        } catch (SQLException e) {
            return false;
        }
        return false;
    }

    /**
     * Cherche une Personne dans la base.
     *
     * @param donne Personne avec tous les paramètres nuls sauf ceux à chercher
     * @return la Liste des auteurs correspondant aux critères
     * @see Personne
     * @see SingleConnection
     */
    public ArrayList<Personne> chercher(Personne donne) {
        PreparedStatement stmt = null;
        ArrayList listPers = new ArrayList();
        boolean premier = true;
        String sql = "SELECT * FROM personnes WHERE";
        if (donne.getNom() != null) {
            sql += " nom='" + donne.getNom() + "'";
            premier = false;
        }
        if (donne.getPrenom() != null) {
            if (!premier)
                sql += " AND";
            sql += " prenom='" + donne.getPrenom() + "'";
            premier = false;
        }
        if (donne.getNote() != null) {
            if (!premier)
                sql += " AND";
            sql += " note='" + donne.getPrenom() + "'";
            premier = false;
        }
        if (premier) //Si tout est null
            sql="SELECT * FROM personnes";

        try {
            stmt = cn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Personne pers = new Personne();
                pers.setId(rs.getInt("idPersonne"));
                pers.setNom(rs.getString("nom"));
                pers.setPrenom(rs.getString("prenom"));
                pers.setNote(rs.getString("note"));
                listPers.add(pers);
            }
            return listPers;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}