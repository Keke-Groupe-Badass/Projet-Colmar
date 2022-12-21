package Whole.daoPackage;

import Whole.SingleConnection;
import Whole.ccmsPackage.Ouvrage;
import Whole.ccmsPackage.Personne;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Cette classe est appelee pour creer un lien entre l'application et la base de donnees
 * pour tout ce qui concerne les interactions et les modifications d'un ouvrage
 * @see AbstractDAO
 */
public class OuvrageDAO extends AbstractDAO<Ouvrage> {
    /**
     * Constructeur de la classe OuvrageDAO.
     *
     * @see Connection
     * @see SingleConnection
     */

    public OuvrageDAO(String url, String login, String password) {
        super(url, login, password);
    }

    /**
     * Ajoute à la base de donnée un ouvrage
     *
     * @param donne l'ouvrage à ajouter
     * @see Ouvrage
     * @see SingleConnection
     */
    @Override
    public boolean creer(Ouvrage donne) {
        if(donne.getId() < 0) {
            return false;
        }
        //écrire code permettant de condtruire la requete
        try {
            PreparedStatement stmt = cn.prepareStatement("insert into ouvrages values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1,donne.getTitre());
            stmt.setInt(2,donne.getDateEdition());
            stmt.setString(3, donne.getFormat());
            stmt.setString(4,donne.getLien());
            stmt.setString(5,donne.getResolution());
            stmt.setString(6,donne.getCreditPhoto());
            stmt.setBoolean(7,donne.isReechantillonage());
            stmt.setString(8,donne.getCopyright());
            stmt.setInt(9,donne.getNbPage());
            stmt.setString(10,donne.getLieuEdition());
            stmt.setInt(11,donne.getImprimeur().getId());
            stmt.setInt(12,donne.getLibraire().getId());
            return stmt.execute();
        }
        catch (SQLException e) {
            return false;
        }
    }


    /**
    * Permet d'ajouter un ouvrage dans la base de donnees. L'auteur peut être NULL,
    * on ne connait pas forcement l'auteur d'un ouvrage. Si il n'est pas NULL, on
    * vérifie que l'auteur passé en paramètre existe bien dans la base de données,
    * puis on effectue une requete d'insertion.
    *
    * @param p Personne l'auteur de l'ouvrage
    * @param objet Ouvrage ouvrage qu'on souhaite inserer
     * @see SingleConnection
    */
    public Boolean ecrit(Personne p, Ouvrage objet) {
    	if(p==null){
            return false;
        }
        if(objet==null){
            return false;
        }
        try {
            PreparedStatement stmt = cn.prepareStatement("insert into ecrit values(?,?)");
            stmt.setInt(1,p.getId());
            stmt.setInt(2,objet.getId());
            return stmt.execute();
        } catch (SQLException e) {
            System.out.println("something went wrong "+e);
        }
        return false;

    }
    
    /**
     * Permet de modifier un ouvrage dans la base de donnees. On s'assure que
     * l'ouvrage qu'on souhaite modifier est bien dans la base de donnees, puis
     * on le remplace par le nouvel ouvrage passe en 2e parametre.
     * 
     * @param objet l'ouvrage cible qu'on souhaite modifier
     * @param changement l'ouvrage par lequel on souhaite remplacer l'ancien
     * @see SingleConnection
     */
    public boolean modifier(Ouvrage objet, Ouvrage changement) {
    	return false;
    }
    
    /**
     * Permet de supprimer un ouvrage de la base de donnees. On s'assure que
     * l'ouvrage qu'on souhaite supprimer est bien dans la base de donnees, puis
     * si trouve on le supprime.
     * 
     * @param objet l'ouvrage cible qu'on souhaite supprimer
     * @see SingleConnection
     */
    public boolean supprimer(Ouvrage objet) {
        try {
            PreparedStatement stmt=cn.prepareStatement("DELETE FROM `ouvrages` WHERE `idOuvrage`=?");
            stmt.setInt(1,objet.getId());
            return stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Permet de rechercher un ou plusieurs ouvrages dans la base de donnees
     * selon un ou plusieurs criteres.
     * 
     * @param objet ouvrage avec tous les parametres nuls sauf ceux a chercher
     * @return renvoie une liste des ouvrages qui correspondent aux critères
     * de recherche
     * @see SingleConnection
     */
    public ArrayList<Ouvrage> chercher(Ouvrage objet) {
        PreparedStatement stmt= null;
        ArrayList list = new ArrayList();
        try {
            //TODO IMPLEMENTATION RECHERCHE AUTRE QU'ID
            stmt = cn.prepareStatement("SELECT * FROM `ouvrages` WHERE `idOuvrage`=?");
            stmt.setInt(1,objet.getId());
            ResultSet rs =stmt.executeQuery();
            while(rs.next()){
                Ouvrage o2=new Ouvrage();
                o2.setTitre(rs.getString(2));
                o2.setLieuEdition(rs.getString(11));
                o2.setDateEdition(rs.getInt(3));
                o2.setNbPage(rs.getInt(10));
                o2.setId(rs.getInt(1));
                o2.setFormat(rs.getString(4));
                o2.setResolution(rs.getString(6));
                o2.setCreditPhoto(rs.getString(7));
                o2.setCopyright(rs.getString(9));
                o2.setCopyright(rs.getString(5));
                o2.setPersonnes(listeAuteur(o2.getId()));
                o2.setLibraire(getPersonne(rs.getInt(13)));
                o2.setImprimeur(getPersonne(rs.getInt(12)));
                list.add(o2);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Permet d'obtenir la liste des auteurs ayant écrit un ouvrage
     * @param id l'identifiant de l'ouvrage
     * @return la liste des auteurs ayant écrie l'ouvrage
     */
    private ArrayList listeAuteur(int id){
        ArrayList l = new ArrayList();
        try {
            PreparedStatement stmt = cn.prepareStatement("SELECT * FROM `personnes` WHERE `idOuvrage`=?");
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                l.add(getPersonne(rs.getInt(1)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return l;
    }

    /**
     * Permet d'obtenir une personne grace à son id
     * @param id l'identifiant de la personne
     * @return la personne
     */
    private Personne getPersonne(int id){
        PreparedStatement stmt= null;
        try {
            stmt = cn.prepareStatement("SELECT * FROM `personnes` WHERE `idOuvrage`=?");
            stmt.setInt(1,id);
            ResultSet rs =stmt.executeQuery();
            Personne p = new Personne();
            if(rs.next()){
                p.setNom(rs.getString(2));
                p.setPrenom(rs.getString(3));
                p.setNote(rs.getString(4));
                p.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}