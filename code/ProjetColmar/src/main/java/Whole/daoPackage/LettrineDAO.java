package Whole.daoPackage;


import Whole.SingleConnection;
import Whole.Metadonnee;
import Whole.ccmsPackage.CCMS;
import Whole.ccmsPackage.Lettrine;
import Whole.ccmsPackage.Ouvrage;
import Whole.ccmsPackage.Tag;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.awt.image.BufferedImage;

import java.util.ArrayList;

/**
 * Classe héritant d'AbstractDAO, permettant de lier une Lettrine à la base de donnée
 * @see Lettrine
 */
public class LettrineDAO extends AbstractDAO<Lettrine> {

    /**
     * Constructeur de LettrineDAO
     * @see SingleConnection
     */
    public LettrineDAO(String url, String login, String password) {
        super(url, login, password);
    }

    /**
     * Permet de modifier les attributs de la lettrine ojet par ceux non null de la lettrinve changemment
     * dans la base. Cette methode renverra true si la requette a bien pu être effectuée, false dans les autres cas.
     * Cette méthode renverra notamment false si les lettrines objet ou changement sont vides, ou que tous leurs
     * attributs sont null. Elle renverra false également si l'id de la lettrine objet est <= 0
     * @author Romain
     * @param objet CCMS à changer
     * @param changement CCMS de changement (les paramètres null ne sont pas à changer)
     * @return true si la requete a abouttie, false sinon
     */
    @Override
    public boolean modifier(Lettrine objet, Lettrine changement) {
        StringBuilder str = new StringBuilder();
        if(changement.getNbPage() != -1) {
            str.append("nbPage=" + changement.getNbPage());
        }

        if(changement.getLien() != null) {
            str.append(", lien=" + changement.getLien());
        }

        if(changement.getOuvrage() != null) {
            str.append(", idOuvrage=" + changement.getOuvrage().getId());
        }

        if(changement.getMetadonnees() != null) {
            for(Metadonnee meta : changement.getMetadonnees()) {
                try {
                    Statement stmtMeta = this.cn.createStatement();
                    String sqlMeta = "UPDATE metadonnee SET idLettrine=" + objet.getId() +
                            " WHERE idMeta=" + meta.getId();
                    stmtMeta.executeQuery(sqlMeta);

                }
                catch (SQLException e) {
                    return false;
                }
            }
        }

        if(changement.getTags() != null) {
            for(Tag tag : changement.getTags()) {
                try {
                    Statement stmtTag = cn.createStatement();
                    String sqlTag = "UPDATE lettrines_tags SET ";
                }
                catch (SQLException e) {
                    e.printStackTrace();
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Permet de supprimer la lettrine de l base de données. Renvoie true si la requete s'est
     * effectuée, false sinon. Renvoi false également si l'id de la lettrine passée en param est <= 0
     * <= 0.
     * @author Romain
     * @param lettrine La lettrine à supprimer
     * @see Lettrine
     * @see SingleConnection
     * @return true : si la requete a été effectuée, false sinon
     */
    @Override
    public boolean supprimer(Lettrine lettrine) {
        if(lettrine.getId() <= 0) {
            return false;
        }
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
     * Ajoute la lettrine donne à la base de données. Renvoie true si l'insertion s'est bien passée, false
     * sinon. Renvoie false également si l'id et le lien de la lettrine donnee s0nt respectivement
     * <= 0 et null.
     * @author Romain
     * @param donne la lettrine à ajouter
     * @see Lettrine
     * @see SingleConnection
     * @return true : si la requete a été effectuée, false sinon
     */
    @Override
    public boolean creer(Lettrine donne) {
        if(donne.getId() <= 0 || donne.getLien() == null) {
            return false;
        }
        StringBuilder str = new StringBuilder();
        //écrire code permettant de condtruire la requete
        try {
            Statement stmt = cn.createStatement();
            String sql = "INSERT INTO lettrine VALUES (" + str + ")";
            stmt.executeQuery(sql);
            return true;
        }
        catch (SQLException e) {
            return false;
        }
        /*
        appel des methodes tager et ajouterMeta pour ajouter les métdonnées et les tags a la lettrine
        crée
        */
    }

    /**
     * Cherche des lettrines dans la base. La méthode renvoie une ArrayList de lettrines, en fonction
     * des attributs non null de la lettrine donne passée en param.
     * @author Romain
     * @param donne CCMS avec tous les paramètres nuls sauf ceux à chercher
     * @return la Liste des lettrines correspondant aux critères
     * @see CCMS
     * @see SingleConnection
     */
    @Override
    public ArrayList<Lettrine> chercher(Lettrine donne) {
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
            String metaSQL = createTabSqlMeta(donne, idMeta);
            req.append(metaSQL);
        }
        else {
            String metaSQL = createTabSqlMeta(donne, null);
            req.append(metaSQL);
        }

        if(donne.getTags() != null) {
            ArrayList<Integer> idTags = new ArrayList<>();
            for (Tag tag : donne.getTags()) {
                idTags.add(tag.getId());
            }
            String tagSQL = createTabSqlTags(donne, idTags);
            req.append(tagSQL);
        }
        else {
            String tagSQL = createTabSqlTags(donne, null);
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
           
        }
        catch (SQLException e) {
           
        }
        return letList;
    }

    /**
     * recherche sur les métadonnées, si des métadonnées sont passées en attribut de la lettrine
     * de recherche, on commence par récupérer tous les id de ces métadonnées, puis on les stockes dans
     * un ArrayList. Si aucune métadonnée n'est passée en attribut de la lettrine
     * (donne.getMetadonnees == null) alors on récupère toutes les métadonnées de la base. On commence par
     * récuperer chaque id de chacune des métadonnées récupérées par la requete, puis on utilise cet
     * id pour créer un bout de requete sql, finalement on stocke ce bout de requete (String) dans
     * un StringBuilder, qui sera converti en un String contenant la partie de requete correspondante a la
     * recherche des métadonnées, String qui sera retourné.
     * @author Romain
     * @param donne Lettrine : lettrine contenant les attributs sur lesquels effectuer la recherche
     * @param idMeta : ArrayList d'entiers contenant les id des métadonnées contenues dans l'attribut métadonnée
     * de donne.
     * @return String resSql : String contenant le bout de requete permettant d'obtenir les métadonnées
     * cherchées
     */
    private static String createTabSqlMeta(Lettrine donne, ArrayList<Integer> idMeta) {
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
     * recherche sur les tags : meme principe que pour les métadonnées. On récupère String contenant la
     * requête SQL de recherche des tags.
     * @author Romain
     * @param donne Lettrine : lettrine contenant les attributs sur lesquels effectuer la recherche
     * @param idTags : ArrayList d'entiers contenant les id des métadonnées contenues dans l'attribut tag
     * de donne.
     * @return resSql : String contenant le morceau de requete correspondant à la recherche des tags
     */
    private static String createTabSqlTags(Lettrine donne, ArrayList<Integer> idTags) {
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
     * permet de lier dans la base de donnée une lettrine à ouvrage, en effet une lettrine n'est présente
     * que dans un seul et unique ouvrage. renvoie true si la requete a été effectuée, false sinon. Renvoie
     * false également si les id de l et de o sont <= 0
     * @author Romain
     * @param l la lettrine à lier à l'ouvrage
     * @param o l'ouvrage d'origine
     * @param cn La connection à la base de donnée
     * @see SingleConnection
     * @see Ouvrage
     * @see Lettrine
     * @return true : si la requete a été effectuée, false sinon
     */
    public boolean provient(Lettrine l , Ouvrage o,Connection cn)   {
        if(l.getId() <= 0 || o.getId() <= 0) {
            return false;
        }
        if(l.getOuvrage().getId() != o.getId()) {
            try {
                Statement stmt = cn.createStatement();
                String sql = "UPDATE lettrine SET idOuvrage=" + o.getId() + " WHERE id=" + l.getId();
                stmt.executeQuery(sql);
                return true;
            } catch (SQLException e) {
                return false;
            }
        }
        else {
            return false;
        }
    }

    /**
     * Permet de lier dans la base de donnée une lettrine à un tag. Renvoie true si la requete s'est bien effectuée
     * false sinon. Renvoie false si les id de l et de t sont <= 0
     * @author Romain
     * @param l La lettrine dont on souhaite ajouter un tag
     * @param t Le tag à ajouter à la lettrine
     * @param cn La connection à la base de donnée
     * @see SingleConnection
     * @see Lettrine
     * @see Tag
     * @return true : si la requete a été effectuée, false sinon
     */
    public boolean tager(Lettrine l , Tag t,Connection cn) {
        if(l.getId() <= 0 || t.getId() <= 0) {
            return false;
        }
        try {
            Statement stmt = cn.createStatement();
            String sql = "INSERT INTO lettrines_tags VALUES (" + t.getId() + ", "+ l.getId() + ")";
            stmt.executeQuery(sql);
            return true;
        }
        catch (SQLException e) {
            return false;
        }
    }

    /**
     * permet de caracteriser une lettrine en ajoutant une métadonnée. Renvoie true si la requete s'est bien
     * effectuée, false sinon. Renvoie false également si l'id de meta et l'id de l sont <= 0
     * @author Romain
     * @param meta Métadonnée à ajouter à la lettrine
     * @param l Lettrine à laquelle la métadonnée doit etre ajoutée
     * @param cn La connection à la base de donnée
     * @see SingleConnection
     * @see Metadonnee
     * @return true : si la requete a été effectuée, false sinon
     */
    public boolean ajouterMeta(Metadonnee meta, Lettrine l, Connection cn) {
        if(meta.getId() <= 0 || l.getId() <= 0) {
            return false;
        }
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
     * supprimer une métadonnée de la base. Renvoie true si la suppression s'est bien effectuée, false sinon
     * Renvoie false si l'id de meta est <= 0
     * @author Romain
     * @param meta metadonnée a supprimer
     * @param cn connexion a la base
     * @return true si la requete s'est effectuée, false sinon
     */
    public boolean supprimerMeta(Metadonnee meta, Connection cn) {
        if(meta.getId() <= 0) {
            return false;
        }
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
     * Met à jour la base de donnée avec les nouvelles valeurs de la métadonnée. Renvoie true si la requete
     * s'est bien effectée, false sinon. Renvoie false si l'id de meta est <= 0
     * @author Romain
     * @param meta La métadonnée dont l'on souhaite que la partie code correspond avec la partie base de donnée
     * @param cn La connection à la base de donnée
     * @see SingleConnection
     * @see Metadonnee
     * @return true : si la requete a été effectuée, false sinon
     */
    public boolean modifierMeta(Metadonnee meta,Connection cn) {
        if(meta.getId() <= 0) {
            return false;
        }
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
     * @see SingleConnection
     * @see BufferedImage
     * @return String: le lien vers l'image en ligne
     */
    private String upload(BufferedImage img) {
        return null;
    }

    /**
     * Créer un nouveau groupe d'élément identiques
     * @author Andreas
     * @param description la description du groupe
     * @return l'identifiant du groupe, en cas d'erreur -1
     */
    public int nouveauGroupe(String description){
        Statement stmt = null;
        try {
            stmt = cn.createStatement();
            String sql = "INSERT INTO `identiques`( `note`) VALUES ('"+description+"')";
            sql+="\n"+"SELECT LAST_INSERT_ID()";
            ResultSet rs=stmt.executeQuery(sql);
            int id=-1;
            if(rs.next()){
                id=rs.getInt(1);
            }
            return id;
        } catch (SQLException e) {
        }
        return -1;
    }

    /**
     * Permet de changer dans la base de donnée la description d'un groupe
     * @author Andreas
     * @param id l'identifiant du groupe
     * @param description la description du groupe
     * @return true si l'opération a pu se faire, false sinon
     */


    public boolean changeDescription(int id, String description){
        Statement stmt = null;
        try {
            stmt = cn.createStatement();
            String sql = "UPDATE `identiques` SET `note`='"+description+"'WHERE `idIdentique`=" + id;
            stmt.execute(sql);
            return true;
        } catch (SQLException e) {
        }
        return false;
    }

    /**
     * Permet de retirer la liaison entre un tag et une lettrine
     * @param l la lettrine en question
     * @param t le tag à retirer
     * @return true si la liaison a pu etre retiré ou qu'il n' a jamais eu de lien, false en cas d'erreur
     */
    public Boolean detager(Lettrine l, Tag t){
        return null;
    }
}
