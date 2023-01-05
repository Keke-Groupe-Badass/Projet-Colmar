package Whole.daoPackage;

import Whole.Metadonnee;
import Whole.SingleConnection;
import Whole.ccmsPackage.*;
import java.awt.image.BufferedImage;
import java.sql.*;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

/**
 * Classe héritant d'AbstractDAO, permettant de lier une Lettrine à la base de
 * données.
 *
 * @see Lettrine
 */
public class LettrineDAO extends AbstractDAO<Lettrine> {
    /**
     * Constructeur de LettrineDAO.
     *
     * @param url url de la BDD
     * @param login login de la BDD
     * @param mdp mot de passe de la BDD
     * @see SingleConnection
     */
    public LettrineDAO(String url, String login, String mdp) {
        super(url, login, mdp);
    }

    /**
     * Permet de modifier les attributs de la lettrine objet par ceux non null
     * de la lettrine changement dans la base. Cette methode renverra true si
     * la requête a bien pu être effectuée, false dans les autres cas.
     * Cette méthode renverra notamment false si les lettrines objet ou
     * changement sont vides, ou que tous leurs attributs sont null. Elle
     * renverra false également si l'id de la lettrine objet est <= 0.
     *
     * @param objet      lettrine à changer
     * @param changement lettrine de changement (les paramètres null ne sont pas
     *                  à changer)
     * @return true si la requête a abouti, false sinon
     * @author Romain
     */
    @Override
    public boolean modifier(Lettrine objet, Lettrine changement) {
        ArrayList<String> rq = new ArrayList<>();

        String reqNbPage = "";
        if (changement.getNbPage() != -1) {
            reqNbPage = reqNbPage + "nbPage=" + changement.getNbPage();
        }
        rq.add(reqNbPage);

        String reqChanngement = "";
        if (changement.getLien() != null) {
            reqChanngement = reqChanngement + "lien=" + changement.getLien();
        }
        rq.add(reqChanngement);

        String reqCrea = "";
        if (changement.getCreateur() != null) {
            reqCrea = reqCrea + "idPersonne="
                    + changement.getCreateur().getId();
        }
        rq.add(reqCrea);

        String reqIden = "";
        if (changement.getIdentique() != 0) {
            reqIden = reqIden + "idIdentique=" + changement.getIdentique();
        }
        rq.add(reqIden);

        StringBuilder str = new StringBuilder();
        for (String s : rq) {
            if (s.isBlank())
                rq.remove(s);
        }

        //return true car pas de modif à faire
        if (rq.isEmpty()) {
            return true;
        } else {
            str.append(", ?".repeat(rq.size() - 1));
        }

        if (changement.getMetadonnees() != null) {
            for (Metadonnee meta : changement.getMetadonnees()) {
                try {
                    Statement stmtMeta = cn.createStatement();
                    String sqlMeta = "UPDATE metadonnees "
                            + "SET idLettrine=" + objet.getId()
                            + " WHERE idMeta=" + meta.getId();
                    stmtMeta.executeQuery(sqlMeta);

                } catch (SQLException e) {
                    return false;
                }
            }
        }
        try {
            String sql="UPDATE lettrines SET ?" + str;
            PreparedStatement pstmt = cn.prepareStatement(sql);
            for (int i = 0; i < rq.size(); i++) {
                pstmt.setString(i + 1, rq.get(i));
            }
            pstmt.executeQuery();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    /**
     * Permet de supprimer la lettrine de la base de données. Renvoie true si la
     * requête s'est effectuée, false sinon. Renvoie false également si l'id de
     * la lettrine passée en paramètres est <= 0.
     *
     * @param lettrine La lettrine à supprimer
     * @return true : si la requête a été effectuée, false sinon
     * @author Romain
     * @see Lettrine
     * @see SingleConnection
     */
    @Override
    public boolean supprimer(Lettrine lettrine) {
        if (lettrine.getId() <= 0) {
            return false;
        }
        try {
            lettrine.getMetadonnees().forEach(m -> supprimerMeta(m));
            lettrine.getTags().forEach(t -> detaguer(lettrine, t));
            Statement stmt = cn.createStatement();
            String sql = "DELETE FROM lettrines WHERE id=" + lettrine.getId();
            stmt.executeQuery(sql);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    /**
     * Ajoute la lettrine donne à la base de données. Renvoie true si
     * l'insertion s'est bien passée, false sinon. Renvoie false également
     * si l'id et le lien de la lettrine donnee sont respectivement <= 0
     * et null.
     *
     * @param donne la lettrine à ajouter
     * @return true : si la requête a été effectuée, false sinon
     * @author Romain
     * @see Lettrine
     * @see SingleConnection
     */
    @Override
    public boolean creer(Lettrine donne) {
        if (donne.getId() < 0 || donne.getLien() == null) {
            return false;
        }
        try {
            String sql="INSERT INTO lettrines(nbPage, lien, idOuvrage," +
                    "idPersonne, idIdentique) " +
                    "VALUES(?,?,?,?,?)";
            PreparedStatement stmt = cn.prepareStatement(sql);
            stmt.setInt(1, donne.getNbPage());
            stmt.setString(2, donne.getLien());
            if (donne.getOuvrage() != null)
                stmt.setInt(3, donne.getOuvrage().getId());
            else
                stmt.setInt(3, -1);
            if (donne.getCreateur() != null)
                stmt.setInt(4, donne.getCreateur().getId());
            else
                stmt.setInt(4, -1);
            stmt.setInt(5, donne.getIdentique());
            int nbColonne = stmt.executeUpdate();
            if (nbColonne <= 0) {
                return false;
            }
            donne.getMetadonnees().forEach(m -> ajouterMeta(m, donne));
            donne.getTags().forEach(t -> taguer(donne, t));

            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    //TODO A SUPPRIMER QUAND chercher AURA ETE TESTE

    /**
     * Cherche des lettrines dans la base. La méthode renvoie une ArrayList de
     * lettrines, en fonction des attributs non null de la lettrine donne
     * passée en paramètres.
     *
     * @param donne CCMS avec tous les paramètres nuls sauf ceux à chercher
     * @return la Liste des lettrines correspondant aux critères
     * @author Romain
     * @see CCMS
     * @see SingleConnection
     */
    public ArrayList<Lettrine> chercherObsolete(Lettrine donne) {
        ArrayList<Lettrine> letList = new ArrayList<>();
        StringBuilder req = new StringBuilder();
        /*
        Recherche sur l'ouvrage, si non null, on inclut l'id de l'ouvrage dans
        la requête.
        */
        String sqlOuvrage = "";
        if (donne.getOuvrage() != null) {
            int idOuvrage = donne.getOuvrage().getId();
            sqlOuvrage = "idOuvrage=" + idOuvrage;
            req.append(sqlOuvrage);
        }

        /*
        Recherche sur le numéro de la page. S'il existe, on inclut le numéro de
        la page dans la requête.
         */
        String sqlNumPage = "";
        if (donne.getNbPage() != -1) {
            int numPage = donne.getNbPage();
            sqlNumPage = "nbPage=" + numPage;
            req.append(sqlNumPage);
        }

        if (donne.getMetadonnees() != null) {
            ArrayList<Integer> idMeta = new ArrayList<Integer>();
            for (Metadonnee met : donne.getMetadonnees())
                idMeta.add(met.getId());
            String metaSQL = createTabSqlMeta(donne, idMeta);
            req.append(metaSQL);
        } else {
            String metaSQL = createTabSqlMeta(donne, null);
            req.append(metaSQL);
        }

        if (donne.getTags() != null) {
            ArrayList<Integer> idTags = new ArrayList<>();
            for (Tag tag : donne.getTags()) {
                idTags.add(tag.getId());
            }
            String tagSQL = createTabSqlTags(donne, idTags);
            req.append(tagSQL);
        } else {
            String tagSQL = createTabSqlTags(donne, null);
            req.append(tagSQL);
        }

        /*
        Recherche des lettrines correspondant aux critères récupérés au-dessus.
         */
        try {
            ArrayList<Tag> tagList = new ArrayList<>();
            ArrayList<Metadonnee> metaList = new ArrayList<>();
            Statement stmt = cn.createStatement();
            String sql = "SELECT * FROM lettrine WHERE " + req;
            ResultSet res = stmt.executeQuery(sql);
            while (res.next()) {
                //récupération des tags de chaque lettrine
                Statement stmtTag = cn.createStatement();
                String sqlTag = "SELECT * FROM tags " +
                        "INNER JOIN lettrine_tags " +
                        "ON tags.idTag = lettrine_tags.idTag " +
                        "INNER JOIN lettrines " +
                        "ON lettrines_tags.idLettrine = lettrines.idLettrine " +
                        "WHERE lettrines_tags.idLettrine=" + res.getInt(1);
                ResultSet resTags = stmtTag.executeQuery(sqlTag);
                while (resTags.next()) {
                    Tag t = new Tag(resTags.getInt(1), resTags.getString(3),
                            resTags.getString(2));
                    tagList.add(t);
                }

                //récupération des métadonnées de chaque lettrine
                Statement stmtMeta = cn.createStatement();
                String sqlMeta = "SELECT * FROM metadonnees " +
                        "WHERE idLettrine=" + res.getInt(1);
                ResultSet resMeta = stmtMeta.executeQuery(sqlMeta);
                while (resMeta.next()) {
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
                String sqlOuvr = "SELECT * FROM ouvrages " +
                        "WHERE idOuvrage=" + res.getInt(4);
                ResultSet resOuvr = stmtOuvr.executeQuery(sqlOuvr);
                if (resOuvr.next()) {
                    o.setTitre(resOuvr.getString(7));
                    o.setId(resOuvr.getInt(1));
                }
                Lettrine let = new Lettrine();
                let.setId(1);
                let.setNbPage(res.getInt(2));
                let.setOuvrage(o);
                let.setLien(res.getString(3));
                let.setTags(tagList);
                let.setMetadonnees(metaList);
                letList.add(let);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return letList;
    }

    /**
     * Recherche sur les métadonnées. Si des métadonnées sont passées en
     * attribut de la lettrine de recherche, on commence par récupérer tous les
     * id de ces métadonnées, puis on les stocke dans un ArrayList. Si aucune
     * métadonnée n'est passée en attribut de la lettrine
     * (donne.getMetadonnees == null) alors on récupère toutes les métadonnées
     * de la base. On commence par récupérer chaque id de chacune des
     * métadonnées récupérées par la requête, puis on utilise cet id pour créer
     * un bout de requête sql, finalement on stocke ce bout de requête (String)
     * dans un StringBuilder, qui sera converti en un String contenant la partie
     * de requête correspondante a la recherche des métadonnées, String qui
     * sera retourné.
     *
     * @param donne  Lettrine : lettrine contenant les attributs sur lesquels
     *               effectuer la recherche
     * @param idMeta : ArrayList d'entiers contenant les id des métadonnées
     *               contenues dans l'attribut métadonnée de donne.
     * @return String resSql : String contenant le bout de requête permettant
     *               d'obtenir les métadonnées cherchées
     * @author Romain
     */
    private static String createTabSqlMeta(Lettrine donne,
                                           ArrayList<Integer> idMeta) {
        ArrayList<Metadonnee> meta = new ArrayList<>();
        if (idMeta != null) {
            try {
                for (int id : idMeta) {
                    Statement stmtMeta = cn.createStatement();
                    String sqlMeta = "SELECT * FROM metadonnees " +
                            "WHERE idMeta=" + id;
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
        } else {
            try {

                Statement stmtMeta = cn.createStatement();
                String sqlMeta = "SELECT * FROM metadonnees " +
                        "WHERE idLettrine=" + donne.getId();
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
    }

    /**
     * Recherche sur les tags : même principe que pour les métadonnées. On
     * récupère String contenant la requête SQL de recherche des tags.
     *
     * @param donne  Lettrine : lettrine contenant les attributs sur lesquels
     *               effectuer la recherche
     * @param idTags : ArrayList d'entiers contenant les id des métadonnées
     *               contenues dans l'attribut tag de donne.
     * @return resSql : String contenant le morceau de requête correspondant à
     *               la recherche des tags
     * @author Romain
     */
    private static String createTabSqlTags(Lettrine donne,
                                           ArrayList<Integer> idTags) {
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

        } else {
            try {
                Statement stmtTag = cn.createStatement();
                String sqlTag = "SELECT * FROM tags " +
                        "INNER JOIN lettrines_tags " +
                        "ON tags.tagID = lettrines_tags.tagID " +
                        "INNER JOIN lettrines " +
                        "ON lettrines_tags.lettrineId = lettrines.lettrineId " +
                        "WHERE lettrineId=" + donne.getId();
                ResultSet resTag = stmtTag.executeQuery(sqlTag);
                while (resTag.next()) {
                    Tag t = new Tag();
                    t.setId(resTag.getInt(1));
                    t.setDescription(resTag.getString(2));
                    t.setNom(resTag.getString(3));
                    tags.add(t);
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
    }

    /**
     * Permet de lier dans la base de données une lettrine à ouvrage, en effet
     * une lettrine n'est présente que dans un seul et unique ouvrage. Renvoie
     * true si la requête a été effectuée, false sinon. Renvoie false également
     * si les id de l et de o sont <= 0.
     *
     * @param l la lettrine à lier à l'ouvrage
     * @param o l'ouvrage d'origine
     * @return true : si la requête a été effectuée, false sinon
     * @author Romain
     * @see SingleConnection
     * @see Ouvrage
     * @see Lettrine
     */
    public boolean provient(Lettrine l, Ouvrage o) {
        if (l.getId() <= 0 || o.getId() <= 0) {
            return false;
        }
        if (l.getOuvrage().getId() == o.getId()) {
            return false;
        }
        try {
            Statement stmt = cn.createStatement();
            String sql = "UPDATE lettrines SET idOuvrage=" + o.getId() +
                    " WHERE id=" + l.getId();
            stmt.executeQuery(sql);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    /**
     * Permet de lier dans la base de données une lettrine à un tag.
     * Renvoie true si la requête s'est bien effectuée false sinon.
     * Renvoie false si les id de l et de t sont <= 0.
     *
     * @param l La lettrine dont on souhaite ajouter un tag
     * @param t Le tag à ajouter à la lettrine
     * @return true : si la requête a été effectuée, false sinon
     * @author Romain
     * @see SingleConnection
     * @see Lettrine
     * @see Tag
     */
    public boolean taguer(Lettrine l, Tag t) {
        if (l.getId() <= 0 || t.getId() <= 0) {
            return false;
        }
        try {
            Statement stmt = cn.createStatement();
            String sql = "INSERT INTO regroupe " +
                    "VALUES (" + t.getId() + ", " + l.getId() + ")";
            stmt.executeQuery(sql);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    /**
     * Permet de caractériser une lettrine en ajoutant une métadonnée. Renvoie
     * true si la requête s'est bien effectuée, false sinon. Renvoie false
     * également si l'id de meta et l'id de l sont <= 0.
     *
     * @param meta Métadonnée à ajouter à la lettrine
     * @param l    Lettrine à laquelle la métadonnée doit être ajoutée
     * @return true : si la requête a été effectuée, false sinon
     * @author Romain
     * @see SingleConnection
     * @see Metadonnee
     */
    public boolean ajouterMeta(Metadonnee meta, Lettrine l) {
        if (meta.getId() <= 0 || l.getId() <= 0) {
            return false;
        }
        try {
            Statement stmt = cn.createStatement();
            String sql = "UPDATE metadonnees SET idLettrine=" + l.getId() +
                    "WHERE idMeta=" + meta.getId();
            stmt.executeQuery(sql);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    /**
     * Supprimer une métadonnée de la base. Renvoie true si la suppression s'est
     * bien effectuée, false sinon. Renvoie false si l'id de meta est <= 0.
     *
     * @param meta métadonnée à supprimer
     * @return true si la requête s'est effectuée, false sinon
     * @author Romain
     */
    public boolean supprimerMeta(Metadonnee meta) {
        if (meta.getId() <= 0) {
            return false;
        }
        try {
            Statement stmt = cn.createStatement();
            String sql = "DELETE FROM metadonnees WHERE idMeta=" + meta.getId();
            stmt.executeQuery(sql);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    /**
     * Met à jour la base de données avec les nouvelles valeurs de la
     * métadonnée. Renvoie true si la requête s'est bien effectuée, false
     * sinon. Renvoie false si l'id de meta est <= 0.
     *
     * @param meta La métadonnée dont la partie code doit correspondre avec la
     *             partie base de données
     * @return true : si la requête a été effectuée, false sinon
     * @author Romain
     * @see SingleConnection
     * @see Metadonnee
     */
    public boolean modifierMeta(Metadonnee meta) {
        if (meta.getId() <= 0) {
            return false;
        }
        StringBuilder req = new StringBuilder();
        if (meta.getNom() != null) {
            String sqlNom = "nom=" + meta.getNom();
            req.append(sqlNom);
        }

        if (meta.getEntree() != null) {
            String sqlEntree = ", valeur=" + meta.getEntree();
            req.append(sqlEntree);
        }

        if (meta.getUnite() != null) {
            String sqlUnite = ", unite=" + meta.getUnite();
            req.append(sqlUnite);
        }

        if (meta.getDescription() != null) {
            String sqlDesc = ", description=" + meta.getDescription();
            req.append(sqlDesc);
        }

        if (req.isEmpty()) {
            return true;
        } else {
            try {
                String sql = "UPDATE metadonnees SET ?" +
                        " WHERE idMeta=?";
                PreparedStatement stmt = cn.prepareStatement(sql);
                stmt.setString(1, req.toString());
                stmt.setInt(2, meta.getId());
                int nbColonne = stmt.executeUpdate();
                return nbColonne > 0;
            } catch (SQLException e) {
                return false;
            }
        }
    }

    /**
     * Met en ligne une image stockée sur disque et renvoie son URL.
     *
     * @param img le fichier où se trouve l'image dans le disque
     * @return String: le lien vers l'image en ligne
     * @see SingleConnection
     * @see BufferedImage
     */
    private String upload(BufferedImage img) {
        return null;
    }

    /**
     * Crée un nouveau groupe d'éléments identiques.
     *
     * @param description la description du groupe
     * @return l'identifiant du groupe, en cas d'erreur -1
     * @author Andreas
     */
    public int nouveauGroupe(String description) {
        Statement stmt = null;
        try {
            stmt = cn.createStatement();
            String sql = "INSERT INTO `identiques`( `note`) " +
                    "VALUES ('" + description + "')";
            sql += "\n" + "SELECT LAST_INSERT_ID()";
            ResultSet rs = stmt.executeQuery(sql);
            int id = -1;
            if (rs.next()) {
                id = rs.getInt(1);
            }
            return id;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //TODO décommenter quand on enlève le corps du catch
        // return -1;
    }

    /**
     * Permet de changer dans la base de données la description d'un groupe.
     *
     * @param id          l'identifiant du groupe
     * @param description la description du groupe
     * @return true si l'opération a pu se faire, false sinon
     * @author Andreas
     */
    public boolean changeDescription(int id, String description) {
        try {
            String sql = "UPDATE `identiques` SET `note`='?" +
                    "'WHERE `idIdentique`=?";
            PreparedStatement stmt = cn.prepareStatement(sql);
            stmt.setString(1, description);
            stmt.setInt(2, id);
            int nbColonne = stmt.executeUpdate();
            return nbColonne > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //TODO décommenter quand on enlève le corps du catch
        //return false;
    }

    /**
     * Permet de retirer la liaison entre un tag et une lettrine.
     *
     * @param l la lettrine en question
     * @param t le tag à retirer
     * @return true si la liaison a pu être retirée ou s'il n'y a jamais eu de
     *          lien, false en cas d'erreur
     */
    public Boolean detaguer(Lettrine l, Tag t) {
        if (t == null) {
            return false;
        }
        if (l == null) {
            return false;
        }
        try {
            String sql="DELETE FROM `regroupe` " +
                    "WHERE `idLettrine`=? AND `idTag`=?";
            PreparedStatement stmt = cn.prepareStatement(sql);
            stmt.setInt(1, l.getId());
            stmt.setInt(2, t.getId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Cherche des lettrines dans la base. La méthode renvoie une ArrayList de
     * lettrines, en fonction des attributs non null de la lettrine donne passée
     * en paramètres.
     *
     * @param donne CCMS avec tous les paramètres nuls sauf ceux à chercher
     * @return la Liste des lettrines correspondant aux critères
     * @author Romain
     * @see CCMS
     * @see SingleConnection
     */
    @Override
    public ArrayList<Lettrine> chercher(Lettrine donne) {
        ArrayList<ArrayList<Integer>> taille = new ArrayList<>();
        ArrayList<Lettrine> let = new ArrayList<>();
        Lettrine l = new Lettrine();
        if(donne.getMetadonnees().size()>0){
            donne.setMetadonnees(rechercheMeta(donne.getMetadonnees().get(0)));

        }
        // Recherche par id
        if (donne.getId() >= 0) {
            try {
                Statement stmt = cn.createStatement();
                String sql = "SELECT * FROM lettrines " +
                        "WHERE idLettrine=" + donne.getId();
                ResultSet res = stmt.executeQuery(sql);
                if (res.next()) {
                    l.setId(res.getInt(1));
                    l.setNbPage(res.getInt(2));
                    l.setLien(res.getString(3));
                    l.setOuvrage(setOuvr(res.getInt(4)));
                    l.setMetadonnees(setMeta(res.getInt(1)));
                    l.setCreateur(setPers(res.getInt(5)));
                    l.setIdentique(res.getInt(6));
                    let.add(l);
                }
                return let;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Recherche des lettrines associées à l'ouvrage
        ArrayList<Integer> idRechercheOuvrage = new ArrayList<>();
        if (donne.getOuvrage() != null) {
            try {
                Statement stmtOuvrage = cn.createStatement();
                String sqlOuvrage = "SELECT idLettrine FROM lettrines " +
                        "WHERE idOuvrage=" + donne.getOuvrage().getId();
                ResultSet resOuvrage = stmtOuvrage.executeQuery(sqlOuvrage);
                while (resOuvrage.next()) {
                    idRechercheOuvrage.add(resOuvrage.getInt(1));
                }
                taille.add(idRechercheOuvrage);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Recherche des lettrines associées au num de page
        ArrayList<Integer> idRechercheNumPage = new ArrayList<>();
        if (donne.getNbPage() > 0) {
            try {
                Statement stmtNumPage = cn.createStatement();
                String sqlNumPage = "SELECT idLettrine FROM lettrine " +
                        "WHERE nbPage=" + donne.getNbPage();
                ResultSet resNumPage = stmtNumPage.executeQuery(sqlNumPage);
                while (resNumPage.next()) {
                    idRechercheNumPage.add(resNumPage.getInt(1));
                }
                taille.add(idRechercheNumPage);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Recherche des lettrines associées aux métadonnées
        Set<Integer> idRechercheMetaSet = new TreeSet<>();
        if (donne.getMetadonnees() != null) {
            try {
                for (Metadonnee meta : donne.getMetadonnees()) {
                    Statement stmtMeta = cn.createStatement();
                    String sqlMeta = "SELECT idLettrine FROM metadonnees " +
                            "WHERE idMeta=" + meta.getId();
                    ResultSet resMeta = stmtMeta.executeQuery(sqlMeta);
                    if (resMeta.next()) {
                        idRechercheMetaSet.add(resMeta.getInt(1));
                    }
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Recherche des lettrines associées aux tests
        Set<Integer> idRechercheTagSet = new TreeSet<>();
        if (donne.getTags() != null) {
            try {
                for (Tag tag : donne.getTags()) {
                    Statement stmtTag = cn.createStatement();
                    String sqlTag = "SELECT idLettrine FROM regroupe " +
                            "WHERE idTag=" + tag.getId();
                    ResultSet resTag = stmtTag.executeQuery(sqlTag);
                    while (resTag.next()) {
                        idRechercheTagSet.add(resTag.getInt(1));
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Recherche des lettrines associées à la personne
        ArrayList<Integer> idRecherchePersonne = new ArrayList<>();
        if (donne.getCreateur() != null) {
            try {
                Statement stmtPersonne = cn.createStatement();
                String sqlPersonne = "SELECT idLettrine FROM lettrines " +
                        "WHERE idPersonne=" + donne.getCreateur().getId();
                ResultSet resPersonne = stmtPersonne.executeQuery(sqlPersonne);
                while (resPersonne.next()) {
                    idRecherchePersonne.add(resPersonne.getInt(1));
                }
                taille.add(idRecherchePersonne);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        //recherche des lettrines associées aux plagiat
        ArrayList<Integer> idRecherchePlagiat = new ArrayList<>();
        if (donne.getIdentique() != -1) {
            try {
                Statement stmtPlagiat = cn.createStatement();
                String sqlPlagiat = "SELECT idLettrine FROM lettrines " +
                        "WHERE idIdentique=" + donne.getIdentique();
                ResultSet resPlagiat = stmtPlagiat.executeQuery(sqlPlagiat);
                if (resPlagiat.next()) {
                    idRecherchePlagiat.add(resPlagiat.getInt(1));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        ArrayList<Integer> idRechercheMeta = new ArrayList<>(idRechercheMetaSet);
        taille.add(idRechercheMeta);

        ArrayList<Integer> idRechercheTag = new ArrayList<>(idRechercheTagSet);
        taille.add(idRechercheTag);

        ArrayList<Integer> boucle = max(taille);
        Set<Integer> idSet = new TreeSet<>();
        for (int id : boucle) {
            rechercheID(idRechercheOuvrage, idSet, id);
            rechercheID(idRechercheNumPage, idSet, id);
            rechercheID(idRechercheMeta, idSet, id);
            rechercheID(idRechercheTag, idSet, id);
            rechercheID(idRecherchePersonne, idSet, id);
            rechercheID(idRecherchePlagiat, idSet, id);
        }

        for (int id : idSet) {
            try {
                Statement st = cn.createStatement();
                String sql = "SELECT * FROM lettrines WHERE idLettrine=" + id;
                ResultSet res = st.executeQuery(sql);
                while (res.next()) {
                    l.setId(res.getInt(1));
                    l.setNbPage(res.getInt(2));
                    l.setLien(res.getString(3));
                    l.setOuvrage(setOuvr(res.getInt(4)));
                    l.setMetadonnees(setMeta(res.getInt(1)));
                    l.setCreateur(setPers(res.getInt(5)));
                    l.setIdentique(res.getInt(6));
                    let.add(l);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return let;
    }

    /**
     * Permet de récupérer les id des lettrines qui nous intéressent parmi des
     * listes d'id de lettrines dont certaines peuvent ne pas correspondre à
     * la recherche.
     *
     * @param array arraylist contenant les arraylists des id des lettrines à
     *              trier
     * @return res, arraylist contenant les id des lettrines correspondantes à
     *              la recherche
     * @author Romain
     * @see #chercher
     */
    public static ArrayList<Integer> max(ArrayList<ArrayList<Integer>> array) {
        ArrayList<Integer> res = new ArrayList<>(array.get(0));
        for (int i = 0; i < array.size() - 1; i++) {
            if (array.get(i).size() >= array.get(i + 1).size()) {
                res = array.get(i + 1);
            }
        }
        return res;
    }

    /**
     * Factorisation de code.
     *
     * @param array arraylist contenant des id de lettrines
     * @param set   set à remplir par des id de lettrine
     * @param id    id d'une lettrine
     * @author Romain
     * @see #chercher
     */
    public static void rechercheID(ArrayList<Integer> array, Set<Integer> set,
                                   int id) {
        if (array.contains(id)) {
            set.add(id);
        }
    }

    /**
     * Permet de récupérer les métadonnées associées à la lettrine dont l'id est
     * passé en paramètre.
     *
     * @param id id de la lettrine dont on veut récupérer les métadonnées
     * @return meta : arraylist contenant les métadonnées récupérées
     * @author Romain
     * @see #chercher
     */
    public static ArrayList<Metadonnee> setMeta(int id) {
        Metadonnee meta = new Metadonnee();
        ArrayList<Metadonnee> array = new ArrayList<>();
        try {
            Statement stmt = cn.createStatement();
            String sql = "SELECT * FROM metadonnees WHERE idLettrine=" + id;
            ResultSet res = stmt.executeQuery(sql);
            while (res.next()) {
                meta.setId(res.getInt(1));
                meta.setNom(res.getString(2));
                meta.setDescription(res.getString(3));
                meta.setEntree(res.getString(4));
                meta.setUnite(res.getString(5));
                array.add(meta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return array;
    }

    /**
     * Permet de construire un objet de type Ouvrage en passant son id en
     * paramètre.
     *
     * @param id : id de l'ouvrage dans la base de données
     * @return o : Ouvrage
     * @author Romain
     * @see #chercher
     */
    public static Ouvrage setOuvr(int id) {
        Ouvrage o = new Ouvrage();
        if (id != -1) {
            try {
                Statement stmt = cn.createStatement();
                String sql = "SELECT * FROM Ouvrage WHERE idOuvrage=" + id;
                ResultSet res = stmt.executeQuery(sql);
                if (res.next()) {
                    o.setId(res.getInt(1));
                    o.setTitre(res.getString(2));
                    o.setDateEdition(res.getInt(3));
                    o.setFormat(res.getString(4));
                    o.setResolution(res.getString(6));
                    o.setCreditPhoto(res.getString(7));
                    o.setReechantillonage(setReechantillonage(res.getInt(8)));
                    o.setCopyright(res.getString(9));
                    o.setNbPage(res.getInt(10));
                    o.setLieuImpression(res.getString(11));
                    o.setImprimeur(setPers(res.getInt(12)));
                    o.setLibraire(setPers(res.getInt(13)));
                    o.setAuteurs(setAut(res.getInt(1)));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return o;
    }

    /**
     * Permet de créer un objet de type Personne à partir de son id passé en
     * paramètre.
     *
     * @param id : id de la personne dans la base de données
     * @return p : Personne
     * @author Romain
     */
    public static Personne setPers(int id) {
        Personne p = new Personne();
        try {
            Statement stmt = cn.createStatement();
            String sql = "SELECT * FROM personnes WHERE idPersonne=" + id;
            ResultSet res = stmt.executeQuery(sql);
            if (res.next()) {
                p.setId(res.getInt(1));
                p.setNom(res.getString(2));
                p.setPrenom(res.getString(3));
                p.setNote(res.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }

    /**
     * Permet de récupérer les auteurs ayant écrit un ouvrage.
     *
     * @param id : id de l'ouvrage
     * @return personnes : Arraylist contenant le (ou les) auteur(s) ayant
     *          écrit l'ouvrage
     * @author Romain
     */
    public static ArrayList<Personne> setAut(int id) {
        ArrayList<Personne> personnes = new ArrayList<>();
        ArrayList<Integer> idAut = new ArrayList<>();
        try {
            Statement stmt = cn.createStatement();
            String sql = "SELECT idAuteur FROM ecrit WHERE idOuvrage=" + id;
            ResultSet res = stmt.executeQuery(sql);
            while (res.next()) {
                idAut.add(res.getInt(1));
            }
            for (int idA : idAut) {
                personnes.add(setPers(idA));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personnes;
    }

    /**
     * Permet de transformer en booléens les 0 et 1 de l'attribut
     * reechantillonage de la base.
     *
     * @param nb : 0 ou 1 pour false ou true
     * @return false si nb = 0, true sinon
     * @author Romain
     */
    public static boolean setReechantillonage(int nb) {
        return nb != 0;
    }

    /**
     * permet de rechercher dans la base les métadonnées dont les champs
     * correspondent à ceux de la métadonnée passée en paramètre.
     *
     * @param meta métadonnée dont les champs vont servir à la recherche
     * @return arrayRes Araylist contenant les métadonnées extraites de la base
     * @author Romain
     * @see #chercher
     */
    public static ArrayList<Metadonnee> rechercheMeta(Metadonnee meta) {
        ArrayList<Metadonnee> arrayRes = new ArrayList<>();
        ArrayList<String> array = new ArrayList<>();

        String reqNom = "";
        if (meta.getNom() != null) {
            reqNom = reqNom + "nom=" + meta.getNom();
        }
        array.add(reqNom);

        String reqDesc = "";
        if (meta.getDescription() != null) {
            reqDesc = reqDesc + "description=" + meta.getDescription();
        }
        array.add(reqDesc);

        String reqVal = "";
        if (meta.getEntree() != null) {
            reqVal = reqVal + "valeur=" + meta.getEntree();
        }
        array.add(reqVal);

        String reqUnite = "";
        if (meta.getUnite() != null) {
            reqUnite = reqUnite + "unite=" + meta.getUnite();
        }

        array.add(reqUnite);

        for (String str : array) {
            if (str.isBlank()) {
                array.remove(str);
            }
        }
        String requete = "";
        StringBuilder ps = new StringBuilder();
        if (array.isEmpty()) {
            requete = "SELECT * FROM metadonnees";
        } else {
            ps.append("AND ? ".repeat(array.size() - 1));
        }
        Metadonnee m = new Metadonnee();
        try {
            if (requete.isBlank())
                requete = "SELECT * FROM metadonnees WHERE ?" + ps;
            PreparedStatement pstmt = cn.prepareStatement(requete);
            if (!("SELECT * FROM metadonnees").equals(requete)) {
                for (int i = 0; i < array.size(); i++) {
                    pstmt.setString(i + 1, array.get(i));
                }
            }
            ResultSet res = pstmt.executeQuery();
            while (res.next()) {
                m.setId(res.getInt(1));
                m.setNom(res.getString(2));
                m.setDescription(res.getString(3));
                m.setEntree(res.getString(4));
                m.setUnite(res.getString(5));
                arrayRes.add(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return arrayRes;
    }

}
