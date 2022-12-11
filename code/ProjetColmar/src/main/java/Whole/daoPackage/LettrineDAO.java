package Whole.daoPackage;


import Whole.LinkToDb;
import Whole.Metadonnee;
import Whole.ccmsPackage.CCMS;
import Whole.ccmsPackage.Lettrine;
import Whole.ccmsPackage.Ouvrage;
import Whole.ccmsPackage.Tag;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;

import java.awt.image.BufferedImage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.IdentityHashMap;

/**
 * Classe héritant d'AbstractDAO, permettant de lier une Lettrine à la base de donnée
 * @see Lettrine
 */
public class LettrineDAO extends AbstractDAO<Lettrine> {
    /**
     * Constructeur de LettrineDAO
     * @see LinkToDb
     */
    public LettrineDAO() {
        super();
    }

    /**
     * Met à jour la BD
     *
     * @param actuelle   La Lettrine à modifier
     * @param changement La lettrine de changement (les paramètres null ne sont pas à changer)
     * @param cn         La connection à la base de donnée
     * @see Lettrine
     * @see LinkToDb
     */
    @Override
    public boolean modifier(Lettrine actuelle, Lettrine changement, Connection cn) {
        try {
            Statement stmt = cn.createStatement();
            String sql = "UPDATE lettrine SET WHERE id=" + actuelle.getId();
            stmt.executeQuery(sql);
            return true;
        }
        catch (SQLException e) {
           return false;
        }
        return false;
    }

    /**
     * Supprime une lettrine de la db
     *
     * @param lettrine La lettrine à supprimer
     * @param cn    La connection à la base de donnée
     * @see Lettrine
     * @see LinkToDb
     */
    @Override
    public boolean supprimer(Lettrine lettrine, Connection cn) {
        try {
            Statement stmt = cn.createStatement();
            String sql = "DELETE FROM lettrine WHERE id=" + lettrine.getId();
            stmt.executeQuery(sql);
            return true;
        }
        catch (SQLException e) {
           return false;
        }
        return false;
    }

    /**
     * Ajoute à la base de donnée d'une lettrine
     *
     * @param donne la lettrine à ajouter
     * @param cn    La connection à la base de donnée
     * @see Lettrine
     * @see LinkToDb
     */
    @Override
    public boolean creer(Lettrine donne, Connection cn) {
        try {
            Statement stmt = cn.createStatement();
            String sql = "INSERT INTO lettrine VALUES (" + donne.getId() + ", ";
            stmt.executeQuery(sql);
            return true;
        }
        catch (SQLException e) {
            return false;
        }
        return false;
    }

    /**
     * Cherche un CCMS dans la base
     *
     * @param donne CCMS avec tout les paramètres nuls sauf ceux à chercher
     * @param cn    La connection à la base de donnée
     * @return la Liste des des CCMS correspondant aux critères
     * @see CCMS
     * @see LinkToDb
     */
    @Override
    public ArrayList<Lettrine> chercher(Lettrine donne, Connection cn) {

        String sqlOuvrage = "";
        if(donne.getOuvrage() != null) {
            int idOuvrage = donne.getOuvrage().getId();
            sqlOuvrage = "idOuvrage=" + idOuvrage;
        }

        ArrayList<Metadonnee> meta = new ArrayList<>();

        if(donne.getMetadonnees() != null) {
            ArrayList<Integer> idMeta = new ArrayList<Integer>();
            for (Metadonnee met : donne.getMetadonnees())
                idMeta.add(met.getId());

            try {
                for(int id : idMeta) {
                    Statement stmtMeta = cn.createStatement();
                    String sqlMeta = "SELECT * FROM metadonnees WHERE idMeta=" + id;
                    ResultSet resMeta = stmtMeta.executeQuery(sqlMeta);

                    if (resMeta.next()) {
                        Metadonnee m = new Metadonnee();
                        m.setId(resMeta.getInt(1));
                        m.setNom(resMeta.getString(2));
                        m.setDescription(resMeta.getString(3));
                        m.setEntree(resMeta.getString(4));
                        m.setUnite(resMeta.getString(5));
                        meta.add(m);
                    }
                }
            }
            catch (SQLException e) {
                System.err.println("Erreur récuperation des métadonnées");
                e.printStackTrace();
            }
        }

        else {
            try {

                Statement stmtMeta = cn.createStatement();
                String sqlMeta = "SELECT * FROM metadonnees WHERE idLettrine=" + donne.getId();
                ResultSet resMeta = stmtMeta.executeQuery(sqlMeta);

                while (resMeta.next()) {
                    Metadonnee m = new Metadonnee();
                    m.setId(resMeta.getInt(1));
                    m.setNom(resMeta.getString(2));
                    m.setDescription(resMeta.getString(3));
                    m.setEntree(resMeta.getString(4));
                    m.setUnite(resMeta.getString(5));
                    meta.add(m);
                }
            }
            catch (SQLException e) {
                System.err.println("Erreur récuperation des métadonnées");
                e.printStackTrace();
            }

        }

        if(donne.getNbPage() != -1) {
            int numPage = donne.getNbPage();
        }

        ArrayList<Tag> tags = new ArrayList<>();
        if(donne.getTags() != null) {
            ArrayList<Integer> idTags = new ArrayList<>();
            for(Tag tag : donne.getTags()) {
                idTags.add(tag.getId());

                try {
                    for(int id : idTags) {
                        Statement stmtTag = cn.createStatement();
                        String sqlTag = "SELECT * FROM tags WHERE idTag=" + id;
                        ResultSet resTag = stmtTag.executeQuery(sqlTag);
                        if(resTag.next()) {
                            Tag t = new Tag();
                            t.setId(resTag.getInt(1));
                            t.setDescription(resTag.getString(2));
                            t.setNom(resTag.getString(3));
                            tags.add(t);
                        }
                    }
                }
                catch (SQLException e) {
                    System.err.println("Erreur récuperation des tags");
                    e.printStackTrace();
                }
            }
        }
        else {
            try {
                Statement stmtTag = cn.createStatement();
                String sqlTag = "SELECT * FROM tags INNER JOIN lettrines_tags ON tags.tagID = " +
                        "lettrines_tags.tagID INNER JOIN lettrines ON lettrines_tags.lettrineId = " +
                        "lettrines.lettrineId WHERE lettrineId=" + donne.getId();
                ResultSet resTag = stmtTag.executeQuery(sqlTag);
                while(resTag.next()) {
                    Tag t = new Tag();
                    t.setId(resTag.getInt(1));
                    t.setDescription(resTag.getString(2));
                    t.setNom(resTag.getString(3));
                    tags.add(t);
                }
            }
            catch (SQLException e) {
                System.err.println("Erreur récuperation des tags");
                e.printStackTrace();
            }
        }

        Lettrine let = new Lettrine();
        try {
            Statement stmt = cn.createStatement();
            String sql = "SELECT * FROM lettrine WHERE ";
        }
        catch (SQLException e) {
            System.err.println("Erreur de requete");
            e.printStackTrace();
        }
    }


    /**
     *permet de lier dans la base de donnée une lettrine à ouvrage, en effet une lettrine n'est présente
     * que dans un seul et unique ouvrage.
     * @param l la lettrine à lier à l'ouvrage
     * @param o l'ouvrage d'origine
     * @param cn La connection à la base de donnée
     * @see LinkToDb
     * @see Ouvrage
     * @see Lettrine
     *
     */
    public void provient(Lettrine l , Ouvrage o,Connection cn)   {
        try {
            Statement stmt = cn.createStatement();
            String sql = "UPDATE lettrine SET idOuvrage=" + o.getId() + " WHERE id=" + l.getId();
            stmt.executeQuery(sql);
            System.out.println("requete effectuee");
        }
        catch (SQLException e) {
            System.err.println("Erreur de requete");
            e.printStackTrace();
        }
    }

    /**
     *Permet de lier dans la base de donnée une lettrine à un tag
     * @param l La lettrine dont on souhaite ajouter un tag
     * @param t Le tag à ajouter à la lettrine
     * @param cn La connection à la base de donnée
     * @see LinkToDb
     * @see Lettrine
     * @see Tag
     */
    public void tager(Lettrine l , Tag t,Connection cn) {

    }

    /**
     * permet de caracteriser une lettrine en ajoutant une métadonnée
     * @param meta Métadonnée à ajouter à la lettrine
     * @param cn La connection à la base de donnée
     * @see LinkToDb
     * @see Metadonnee
     */
    public void ajouterMeta(Metadonnee meta,Connection cn) {

    }
    /**
     * permet de décaracteriser une lettrine en supprimant une métadonnée
     * @param meta Métadonnée à supprimer à la lettrine
     * @param cn La connection à la base de donnée
     * @see LinkToDb
     * @see Metadonnee
     */


    public void supprimerMeta(Metadonnee meta,Connection cn) {

    }
    /**
     * Met à jour la base de donnée avec les nouvelles valeurs de la métadonnée
     * @param meta La métadonnée dont l'on souhaite que la partie code correspond avec la partie base de donnée
     * @param cn La connection à la base de donnée
     * @see LinkToDb
     * @see Metadonnee
     */

    public void modifierMeta(Metadonnee meta,Connection cn) {

    }

    /**
     * Met en ligne une image stockée sur disque et renvoie son URL
     * @param img le fichier où se trouve l'image dans le disque
     * @param cn La connection à la base de donnée
     * @see LinkToDb
     * @see BufferedImage
     * @return String: le lien vers l'image en ligne
     */
    private String upload(BufferedImage img,Connection cn) {
        return null;
    }
}