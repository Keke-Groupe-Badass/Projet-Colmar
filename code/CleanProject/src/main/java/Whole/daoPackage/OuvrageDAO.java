package Whole.daoPackage;

import Whole.SingleConnection;
import Whole.ccmsPackage.Ouvrage;
import Whole.ccmsPackage.Personne;
import java.sql.*;
import java.util.ArrayList;

/**
 * Cette classe est appelée pour créer un lien entre l'application et la base
 * de données pour tout ce qui concerne les intéractions et les modifications
 * d'un ouvrage.
 * @see AbstractDAO
 */
public class OuvrageDAO extends AbstractDAO<Ouvrage> {
    /**
     * Constructeur de la classe OuvrageDAO.
     *
     * @see Connection
     * @see SingleConnection
     * @param url url de la BDD
     * @param login login de l'utilisateur de la BDD
     * @param password mot de passe de l'utilisateur de la BDD
     */
    public OuvrageDAO(String url, String login, String password) {
        super(url, login, password);
    }

    /**
     * Ajoute à la base de données un ouvrage.
     *
     * @param donne l'ouvrage à ajouter
     * @return renvoie true si l'ajout s'effectue, false sinon
     * @see Ouvrage
     * @see SingleConnection
     */
    @Override
    public boolean creer(Ouvrage donne) {
        try {

            //Si l'ouvrage n'a pas déjà été inséré
                System.out.println("hi man");
                PreparedStatement pstmt = cn.prepareStatement("INSERT INTO "
                        + "ouvrages(libraire, imprimeur, lieuImpression, "
                        + "dateEdition, lien, nbPage, copyright, "
                        + "creditPhoto, resolution, format, "
                        + "titre, reechantillonage) "
                        + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",Statement.RETURN_GENERATED_KEYS);
                if (donne.getLibraire() != null)
                    pstmt.setInt(1, donne.getLibraire().getId());
                else
                    pstmt.setNull(1, Types.INTEGER);
                if (donne.getImprimeur() != null)
                    pstmt.setInt(2, donne.getImprimeur().getId());
                else
                    pstmt.setNull(2, Types.INTEGER);
                pstmt.setString(3, donne.getLieuImpression());
                pstmt.setInt(4, donne.getDateEdition());
                pstmt.setString(5, donne.getLien());
                pstmt.setInt(6, donne.getNbPage());
                pstmt.setString(7, donne.getCopyright());
                pstmt.setString(8, donne.getCreditPhoto());
                pstmt.setString(9, donne.getResolution());
                pstmt.setString(10, donne.getFormat());
                pstmt.setString(11, donne.getTitre());
                pstmt.setBoolean(12, donne.getReechantillonage());

                int nbColonnes = pstmt.executeUpdate();
                if(nbColonnes>0){
                    ResultSet rs2 = pstmt.getGeneratedKeys();
                    if(rs2.next()){
                        donne.setId(rs2.getInt(1));
                    }
                }
                return nbColonnes > 0;

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    }


    /**
    * Permet de faire une insertion dans la table "ecrit". On vérifie que
    * ni l'auteur, ni l'ouvrage est NULL, puis on fait une requête d'insertion.
    *
    * @param p Personne l'auteur de l'ouvrage
    * @param objet Ouvrage ouvrage qu'on souhaite insérer
     * @see SingleConnection
     * @return true si l'insertion s'est effectuée, false sinon
    */
    public Boolean ecrit(Personne p, Ouvrage objet) {
        if (objet != null && p != null) {
            try {
                String sql = "SELECT * FROM personnes "
                        + "WHERE idPersonne="+p.getId();
                Statement stmt = cn.createStatement();
                boolean personneExiste = stmt.execute(sql);
                sql = "SELECT * FROM ouvrages WHERE idOuvrage="+objet.getId();
                boolean ouvrageExiste = stmt.execute(sql);

                //On vérifie que la personne et l'ouvrage existent dans la BDD
                if (personneExiste && ouvrageExiste) {
                    PreparedStatement pstmt = cn.prepareStatement(
                            "INSERT INTO ecrit VALUES(?,?)");
                    pstmt.setInt(1, p.getId());
                    pstmt.setInt(2, objet.getId());
                    int nbColonnes = pstmt.executeUpdate();
                    return nbColonnes > 0;
                }
            } catch (SQLException e) {
                System.out.println("something went wrong "+e);
            }
        }
        return false;
    }
    
    /**
     * Permet de modifier un ouvrage dans la base de données. On s'assure que
     * l'ouvrage qu'on souhaite modifier est bien dans la base de données, puis
     * on le remplace par le nouvel ouvrage passé en 2e paramètre.
     * 
     * @param objet l'ouvrage cible qu'on souhaite modifier
     * @param changement l'ouvrage par lequel on souhaite remplacer l'ancien
     * @return true si la modification s'est effectuée, false sinon
     * @see SingleConnection
     */
    public boolean modifier(Ouvrage objet, Ouvrage changement) {
    	boolean fonctionne=false;
    	String sql="SELECT * FROM ouvrages WHERE idOuvrage="+objet.getId();
    	try {
            Statement stmt=cn.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            if (rs.next()) { //Si l'ouvrage existe bien
                sql="UPDATE ouvrages SET libraire=?, "
                        + "imprimeur=?, "
                        + "lieuImpression=?, dateEdition=?, lien=?, "
                        + "nbPage=?, copyright=?, creditPhoto=?, "
						+ "resolution=?, format=?, "
                        + "titre=?, "
                        + "reechantillonage=? "
					+"WHERE idOuvrage=?";
                PreparedStatement pstmt=cn.prepareStatement(sql);
                if (changement.getLibraire() != null)
                    pstmt.setInt(1, changement.getLibraire().getId());
                else
                    pstmt.setNull(1, Types.INTEGER);
                if (changement.getImprimeur() != null)
                    pstmt.setInt(2, changement.getImprimeur().getId());
                else
                    pstmt.setNull(2, Types.INTEGER);
                pstmt.setString(3, changement.getLieuImpression());
                pstmt.setInt(4, changement.getDateEdition());
                pstmt.setString(5, changement.getLien());
                pstmt.setInt(6, changement.getNbPage());
                pstmt.setString(7, changement.getCopyright());
                pstmt.setString(8, changement.getCreditPhoto());
                pstmt.setString(9, changement.getResolution());
                pstmt.setString(10, changement.getFormat());
                pstmt.setString(11, changement.getTitre());
                pstmt.setBoolean(12, changement.getReechantillonage());
                pstmt.setInt(13, objet.getId());
                System.out.println(pstmt);
                int nbColonnesModifiees = pstmt.executeUpdate();
                fonctionne = nbColonnesModifiees > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    	return fonctionne;
    }
    
    /**
     * Permet de supprimer un ouvrage de la base de données.
     * 
     * @param objet l'ouvrage cible qu'on souhaite supprimer
     * @return true si la suppression s'est effectuée, false sinon
     * @see SingleConnection
     */
    public boolean supprimer(Ouvrage objet) {
        try {
            PreparedStatement stmt=cn.prepareStatement("UPDATE lettrines "
                    + "SET idOuvrage=-1 WHERE idOuvrage=?");
            stmt.setInt(1,objet.getId());
            stmt.execute();
            stmt = cn.prepareStatement("DELETE FROM `ecrit` "
                    + "WHERE `idOuvrage`=?");
            stmt.setInt(1,objet.getId());
            stmt.execute();
            stmt=cn.prepareStatement("DELETE FROM `ouvrages` "
                    + "WHERE `idOuvrage`=?");
            stmt.setInt(1,objet.getId());
            int nbColonnesModifiees = stmt.executeUpdate();
            return nbColonnesModifiees > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Permet de rechercher un ou plusieurs ouvrages dans la base de données
     * selon un ou plusieurs critères.
     *
     * @param objet CCMS avec tous les paramètres null sauf ceux à chercher
     * @return renvoie une liste des ouvrages qui correspondent aux critères
     *         de recherche
     * @see SingleConnection
     */
    public ArrayList<Ouvrage> chercher(Ouvrage objet) {
        PreparedStatement stmt= null;
        ArrayList list = new ArrayList();
        /*Permet d'ajouter les AND dans la requête si ce n'est pas
        la première condition */
        boolean premier=true;
        String sql="SELECT * FROM ouvrages WHERE";
    	if (objet.getLibraire() != null) {
            sql+=" libraire="+objet.getLibraire().getId();
            premier=false;
    	}	
    	if (objet.getImprimeur() != null) {
            if (!premier)
    			sql+=" AND";
            sql+=" imprimeur="+objet.getImprimeur().getId();
            premier=false;
    	}    		
    	if (objet.getLieuImpression() != null) {
            if (!premier)
    			sql+=" AND";
            sql+=" lieuImpression='"+objet.getLieuImpression()+"'";
            premier=false;
    	}
    	if (objet.getDateEdition() != -1) {
            if (!premier)
    			sql+=" AND";
            sql+=" dateEdition="+objet.getDateEdition();
            premier=false;
    	}
    	if (objet.getLien() != null) {
            if (!premier)
    			sql+=" AND";
            sql+=" lien='"+objet.getLien()+"'";
            premier=false;
    	}
    	if (objet.getNbPage() != -1) {
            if (!premier)
    			sql+=" AND";
            sql+=" nbPage="+objet.getNbPage();
            premier=false;
    	}
    	if (objet.getCopyright() != null) {
            if (!premier)
    			sql+=" AND";
            sql+=" copyright='"+objet.getCopyright()+"'";
            premier=false;
    	}
    	if (objet.getCreditPhoto() != null) {
            if (!premier)
    			sql+=" AND";
            sql+=" creditPhoto='"+objet.getCreditPhoto()+"'";
            premier=false;
    	}
    	if (objet.getResolution() != null) {
            if (!premier)
    			sql+=" AND";
            sql+=" resolution='"+objet.getResolution()+"'";
            premier=false;
    	}
    	if (objet.getFormat() != null) {
            if (!premier)
    			sql+=" AND";
            sql+=" format='"+objet.getFormat()+"'";
            premier=false;
    	}
    	if (objet.getTitre() != null) {
            if (!premier)
    			sql+=" AND";
            sql+=" titre='"+objet.getTitre()+"'";
            premier=false;
    	}
        //En SQL le boolean est un tinyint égal à 0 ou 1
    	int intReechantillonage;
    	if(objet.getReechantillonage())
    		intReechantillonage=1;
    	else
    		intReechantillonage=0;
    	if (!premier)
			sql+=" AND";
        sql+=" reechantillonage="+intReechantillonage;
    	
        try {
            stmt = cn.prepareStatement(sql);
            ResultSet rs=stmt.executeQuery();
            while(rs.next()){
                Ouvrage o2=new Ouvrage();
                o2.setId(rs.getInt("idOuvrage"));
                o2.setLibraire(getPersonne(rs.getInt("libraire")));
                o2.setImprimeur(getPersonne(rs.getInt("imprimeur")));
                o2.setLieuImpression(rs.getString("lieuImpression"));
                o2.setDateEdition(rs.getInt("dateEdition"));
                o2.setLien(rs.getString("lien"));
                o2.setNbPage(rs.getInt("nbPage"));
                o2.setCopyright(rs.getString("copyright"));
                o2.setCreditPhoto(rs.getString("creditPhoto"));
                o2.setResolution(rs.getString("resolution"));
                o2.setFormat(rs.getString("format"));
                o2.setTitre(rs.getString("titre"));
                o2.setReechantillonage(rs.getBoolean("reechantillonage"));
                o2.setAuteurs(listeAuteur(o2.getId()));

                list.add(o2);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Permet d'obtenir la liste des auteurs ayant écrit un ouvrage.
     * @param id l'identifiant de l'ouvrage
     * @return la liste des auteurs ayant écrit l'ouvrage
     */
    private ArrayList listeAuteur(int id){
        ArrayList l = new ArrayList();
        try {
            PreparedStatement stmt = cn.prepareStatement("SELECT * "
                    + "FROM `personnes` "
                    + "WHERE `idPersonne`=?");
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
     * Permet d'obtenir une personne grâce à son id.
     * @param id l'identifiant de la personne
     * @return la personne
     */
    private Personne getPersonne(int id){
        PreparedStatement stmt= null;
        try {
            stmt = cn.prepareStatement("SELECT * FROM `personnes` "
                    + "WHERE `idPersonne`=?");
            stmt.setInt(1,id);
            ResultSet rs =stmt.executeQuery();
            Personne p = new Personne();
            if(rs.next()){
                p.setId(rs.getInt(1));
                p.setNom(rs.getString(2));
                p.setPrenom(rs.getString(3));
                p.setNote(rs.getString(4));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}