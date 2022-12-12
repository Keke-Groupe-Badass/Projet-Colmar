package Whole.daoPackage;


import Whole.LinkToDb;
import Whole.Metadonnee;
import Whole.ccmsPackage.CCMS;
import Whole.ccmsPackage.Lettrine;
import Whole.ccmsPackage.Ouvrage;
import Whole.ccmsPackage.Tag;

import java.sql.Connection;

import java.awt.image.BufferedImage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
     * @return true : si la requete a été effectuée, false sinon
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
    }

    /**
     * Supprime une lettrine de la db
     *
     * @param lettrine La lettrine à supprimer
     * @param cn    La connection à la base de donnée
     * @see Lettrine
     * @see LinkToDb
     * @return true : si la requete a été effectuée, false sinon
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
    }

    /**
     * Ajoute à la base de donnée d'une lettrine
     *
     * @param donne la lettrine à ajouter
     * @param cn    La connection à la base de donnée
     * @see Lettrine
     * @see LinkToDb
     * @return true : si la requete a été effectuée, false sinon
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
        ArrayList<Lettrine> letList = new ArrayList<>();
        StringBuilder req = new StringBuilder();
        /*
        recherche sur l'ouvrage, si non null, on inclue l'id de l'ouvrage dans la requete
        */
        String sqlOuvrage = "";
        if(donne.getOuvrage() != null) {
            int idOuvrage = donne.getOuvrage().getId();
            sqlOuvrage = "idOuvrage=" + idOuvrage;
            req.append(sqlOuvrage);
        }

        /*
        recherche sur le numéro de la page. S'il existe, on inclue le numero de la page dans la requete
         */
        String sqlNumPage = "";
        if(donne.getNbPage() != -1) {
            int numPage = donne.getNbPage();
            sqlNumPage = "nbPage=" + numPage;
            req.append(sqlNumPage);
        }

        if(donne.getMetadonnees() != null) {
            ArrayList<Integer> idMeta = new ArrayList<Integer>();
            for (Metadonnee met : donne.getMetadonnees())
                idMeta.add(met.getId());
            String metaSQL = createTabSqlMeta(donne, cn, idMeta);
            req.append(metaSQL);
        }
        else {
            String metaSQL = createTabSqlMeta(donne, cn, null);
            req.append(metaSQL);
        }

        if(donne.getTags() != null) {
            ArrayList<Integer> idTags = new ArrayList<>();
            for (Tag tag : donne.getTags()) {
                idTags.add(tag.getId());
            }
            String tagSQL = createTabSqlTags(donne, cn, idTags);
            req.append(tagSQL);
        }
        else {
            String tagSQL = createTabSqlTags(donne, cn, null);
            req.append(tagSQL);
        }

        /*
        recherche des lettrines correspondants aux critères récupérés au dessus.
         */
        try {
            ArrayList<Tag> tagList = new ArrayList<>();
            ArrayList<Metadonnee> metaList = new ArrayList<>();
            Statement stmt = cn.createStatement();
            String sql = "SELECT * FROM lettrine WHERE " + req;
            ResultSet res = stmt.executeQuery(sql);
            while(res.next()) {
                Lettrine let = new Lettrine();

                //recuperation des tags de chaque lettrine
                Statement stmtTag = cn.createStatement();
                String sqlTag = "SELECT * FROM tags INNER JOIN lettrine_tags ON tags.idTag = lettrine_tags.idTag " +
                        "INNER JOIN lettrines ON lettrines_tags.idLettrine = lettrines.idLettrine " +
                        "WHERE lettrines_tags.idLettrine=" + res.getInt(1);
                ResultSet resTags = stmtTag.executeQuery(sqlTag);
                while (resTags.next()) {
                    Tag t = new Tag(resTags.getInt(1), resTags.getString(3), resTags.getString(2));
                    tagList.add(t);
                }

                //recuperation des metadonnees de chaque lettrine
                Statement stmtMeta = cn.createStatement();
                String sqlMeta = "SELECT * FROM metadonnees WHERE idLettrine=" + res.getInt(1);
                ResultSet resMeta = stmtMeta.executeQuery(sqlMeta);
                while(resMeta.next()) {
                    Metadonnee m = new Metadonnee();
                    m.setNom(resMeta.getString(3));
                    m.setId(resMeta.getInt(1));
                    m.setEntree(resMeta.getString(4));
                    m.setUnite(resMeta.getString(5));
                    m.setDescription(resMeta.getString(2));
                    metaList.add(m);
                }

                Ouvrage o = new Ouvrage();
                Statement stmtOuvr = cn.createStatement();
                String sqlOuvr = "SELECT * FROM ouvrages WHERE idOuvrage=" + res.getInt(4);
                ResultSet resOuvr = stmtOuvr.executeQuery(sqlOuvr);
                if(resOuvr.next()) {
                    o.setTitre(resOuvr.getString(7));
                    o.setId(resOuvr.getInt(1));
                }
                let.setId(1);
                let.setNbPage(res.getInt(2));
                let.setOuvrage(o);
                let.setLien(res.getString(3));
                let.setTags(tagList);
                let.setMetadonnees(metaList);
                letList.add(let);
            }
            return letList;
        }
        catch (SQLException e) {
           return letList;
        }
    }

    /**
     * recherche sur les métadonnées, si des métadonnées sont passées en attribut de la lettrine
     * de recherche, on commence par récupérer tous les id de ces métadonnées, puis on les stockes dans
     * un ArrayList. Si aucune métadonnée n'est passée en attribut de la lettrine
     * (donne.getMetadonnees == null) alors on récupère toutes les métadonnées de la base. On commence par
     * récuperer chaque id de chacune des métadonnées récupérées par la requete, puis on utilice cet
     * id pour créer un bout de requete sql, finalement on stocke ce bout de requete (String) dans
     * un StringBuilder, qui sera converti en un String contenant la partie de requete correspondante a la
     * recherche des métadonnées, String qui sera retourné.
     * @param donne Lettrine :  lettrine contenant les attributs sur lesquels effectuer la recherche
     * @param cn Connection : connexion
     * @param idMeta : ArrayList d'entiers contenant les id des métadonnées contenues dans l'attribut métadonnée
     * de donne.
     * @return String resSql : String contenant le bout de requete permettant d'obtenir les métadonnées
     * cherchées
     */
    private static String createTabSqlMeta(Lettrine donne, Connection cn, ArrayList<Integer> idMeta) {
        ArrayList<Metadonnee> meta = new ArrayList<>();
        if(idMeta != null) {
            try {
                for (int id : idMeta) {
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
            } catch (SQLException e) {
                System.err.println("Erreur récuperation des métadonnées");
                e.printStackTrace();
            }
            String sqlMeta = "";
            ArrayList<String> tab = new ArrayList<>();
            for (Metadonnee idmeta : meta) {
                sqlMeta = "AND idMeta=" + idmeta + " ";
                tab.add(sqlMeta);

            }
            StringBuilder resSql = new StringBuilder();
            for (String str : tab) {
                resSql.append(str);
            }
            return resSql.toString();
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
            String sqlMeta = "";
            ArrayList<String> tab = new ArrayList<>();
            for(Metadonnee idmeta : meta) {
                sqlMeta = "AND idMeta=" + idmeta + " ";
                tab.add(sqlMeta);
            }
            StringBuilder resSql = new StringBuilder();
            for(String str : tab) {
                resSql.append(str);
            }
            return resSql.toString();
        }
    }

    /**
     * recherche sur les tags: meme principe que pour les métadonnées. On récupère String contenant la
     * requête SQL de recherche des tags.
     * @param donne Lettrine :  lettrine contenant les attributs sur lesquels effectuer la recherche
     * @param cn Connection : connexion
     * @param idTags : ArrayList d'entiers contenant les id des métadonnées contenues dans l'attribut tag
     * de donne.
     * @return resSql : String contenant le morceau de requete correspondant a la recherche des tags
     */
    private static String createTabSqlTags(Lettrine donne, Connection cn, ArrayList<Integer> idTags) {
        ArrayList<Tag> tags = new ArrayList<>();
        if (idTags != null) {
            try {
                for (int id : idTags) {
                    Statement stmtTag = cn.createStatement();
                    String sqlTag = "SELECT * FROM tags WHERE idTag=" + id;
                    ResultSet resTag = stmtTag.executeQuery(sqlTag);
                    if (resTag.next()) {
                        Tag t = new Tag();
                        t.setId(resTag.getInt(1));
                        t.setDescription(resTag.getString(2));
                        t.setNom(resTag.getString(3));
                        tags.add(t);
                    }
                }
            } catch (SQLException e) {
                System.err.println("Erreur récuperation des tags");
                e.printStackTrace();
            }

        String sqlTag = "";
        ArrayList<String> tab = new ArrayList<>();
        for (Tag idtag : tags) {
            sqlTag = "idTag=" + idtag;
            tab.add(sqlTag);
        }
        StringBuilder resSql = new StringBuilder();
        for (String str : tab) {
            resSql.append(str);
        }
        return resSql.toString();

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
            String sqlTag = "";
            ArrayList<String> tab = new ArrayList<>();
            for(Tag idtag : tags) {
                sqlTag = "idTag=" + idtag;
                tab.add(sqlTag);
            }
            StringBuilder resSql = new StringBuilder();
            for (String str : tab) {
                resSql.append(str);
            }
            return resSql.toString();
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
     * @return true : si la requete a été effectuée, false sinon
     */
    public boolean provient(Lettrine l , Ouvrage o,Connection cn)   {
        try {
            Statement stmt = cn.createStatement();
            String sql = "UPDATE lettrine SET idOuvrage=" + o.getId() + " WHERE id=" + l.getId();
            stmt.executeQuery(sql);
            return true;
        }
        catch (SQLException e) {
            return false;
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
     * @return true : si la requete a été effectuée, false sinon
     */
    public boolean tager(Lettrine l , Tag t,Connection cn) {
        try {
            Statement stmt = cn.createStatement();
            String sql = "UPDATE lettrines_tags SET idTags=" + t.getId() + " WHERE idLettrine =" + l.getId();
            stmt.executeQuery(sql);
            return true;
        }
        catch (SQLException e) {
            return false;
        }
    }

    /**
     * permet de caracteriser une lettrine en ajoutant une métadonnée
     * @param meta Métadonnée à ajouter à la lettrine
     * @param l Lettrine a laquelle la métadonnée doit etre ajoutée
     * @param cn La connection à la base de donnée
     * @see LinkToDb
     * @see Metadonnee
     */
    public boolean ajouterMeta(Metadonnee meta, Lettrine l, Connection cn) {
        try {
            Statement stmt = cn.createStatement();
            String sql = "UPDATE metadonnee SET idLettrine=" + l.getId() + "WHERE idMeta=" + meta.getId();
            stmt.executeQuery(sql);
            return true;
        }
        catch (SQLException e) {
            return false;
        }
    }


    /**
     * permet de décaracteriser une lettrine en supprimant une métadonnée
     * @param meta Métadonnée à supprimer à la lettrine
     * @param cn La connection à la base de données
     * @see LinkToDb
     * @see Metadonnee
     * @return true : si la requete a été effectuée, false sinon
     */
    public boolean supprimerMeta(Metadonnee meta, Connection cn) {
        try {
            Statement stmt = cn.createStatement();
            String sql = "DELETE FROM metadonnees WHERE idMeta=" + meta.getId();
            stmt.executeQuery(sql);
            return true;
        }
        catch (SQLException e) {
            return false;
        }
    }


    /**
     * Met à jour la base de donnée avec les nouvelles valeurs de la métadonnée
     * @param meta La métadonnée dont l'on souhaite que la partie code correspond avec la partie base de donnée
     * @param cn La connection à la base de donnée
     * @see LinkToDb
     * @see Metadonnee
     * @return true : si la requete a été effectuée, false sinon
     */
    public boolean modifierMeta(Metadonnee meta,Connection cn) {
        StringBuilder req = new StringBuilder();
        String sqlNom = "";
        if(meta.getNom() != null) {
            sqlNom = "nom=" + meta.getNom();
            req.append(sqlNom);
        }


        String sqlEntree = "";
        if(meta.getEntree() != null) {
            sqlEntree = ", valeur=" + meta.getEntree();
            req.append(sqlEntree);
        }


        String sqlUnite = "";
        if(meta.getUnite() != null) {
            sqlUnite = ", unite=" + meta.getUnite();
            req.append(sqlUnite);
        }

        String sqlDesc = "";
        if(meta.getDescription() != null) {
            sqlDesc = "description=" + meta.getDescription();
            req.append(sqlDesc);
        }

        if(req.isEmpty()) {
            return true;
        }
        else {
            try {
                Statement stmt = cn.createStatement();
                String sql = "UPDATE metadonnee SET " + req;
                stmt.executeQuery(sql);
                return true;
            }
            catch (SQLException e) {
                return false;
            }
        }
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