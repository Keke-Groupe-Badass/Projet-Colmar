package Whole.daoPackage;

import Whole.SingleConnection;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
* Cette classe est appel�e pour cr�er un lien entre l'application et la base de donn�es
* pour tout ce qui concerne les interactions et les modifications de l'utilisateur.
* @see AbstractDAO
*/

public class UtilisateurDAO {

    /**
	 * Constructeur de la classe UtilisateurDAO.
	 */
	public UtilisateurDAO() {
	}

	/**
	 * Permet � un utilisateur de se connecter sur l'application. On donne le login
	 * et le mot de passe de l'utilisateur, puis on fait une requ�te � la base de
	 * donn�es pour s'assurer que l'utilisateur existe et que le mot de passe est
	 * le bon.
	 * @param login Le nom d'utilisateur pour se connecter � la base de donn�e
	 * @param mdp Le mot de passe de la base de donn�e
	 * @param cn La connection � la base de donn�e
	 * @return renvoie le login sous forme de String si la connexion s'est correctement
	 * effectu�e, sinon elle renvoie null.
	 * @see SingleConnection
	 */
	public String connexion(String login, String mdp,Connection cn) {
		if (!mdpValide(mdp))
			return null;
		final String mdpEncrypte=encrypte(mdp);
		String sql="SELECT * FROM utilisateur WHERE email='"+login+"' AND password='"+mdpEncrypte+"'";
		try {
			Statement stmt=cn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			if (rs.next()) //Si l'utilisateur est trouv�
				return login;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
    }
	
    /**
    * Permet de changer le mot de passe de l'utilisateur. On donne le login et le
    * nouveau mot de passe souhaite, puis on retrouve l'utilisateur dans la base de
    * donnees � l'aide du login. Le nouveau mot de passe est encrypt� puis stock�
    * dans la base � la place de l'ancien.
    * @param login login de l'utilisateur, permet de l'identifier dans la BDD
    * @param mdp nouveau mot de passe qui doit venir remplacer l'ancien
	* @param cn La connection � la base de donn�es
	* @return renvoie true si la modification s'est correctement effectu�e, false sinon
	* @see SingleConnection
    */
    public boolean changeMDP(String login, String mdp, Connection cn) {
    	boolean fonctionne=false; 
    	if (mdpValide(mdp)) {
    		String sql="SELECT email FROM utilisateur WHERE email='"+login+"'";
        	try {
        		final String mdpEncrypte=encrypte(mdp);
    			Statement stmt=cn.createStatement();
    			ResultSet rs=stmt.executeQuery(sql);
    			if (rs.next()) { //Si l'utilisateur existe
    				sql="UPDATE utilisateur SET password='"+mdpEncrypte
    					+"' WHERE email='"+login+"'";
    				fonctionne=stmt.execute(sql);
    			}
    		} catch (SQLException e) {
    			e.printStackTrace();
    		}
    	}
    	return fonctionne;
    }

    /**
    * Permet de supprimer un utilisateur de la base de donn�es � partir de son login.
    * Le login est recherch� dans la base de donnees, puis si trouve l'utilisateur
    * correspondant est alors supprim�.
    * 
    * @param login login de l'utilisateur
	* @param cn La connection � la base de donn�es
	* @return true si la suppression s'est correctement pass�e, false sinon
	* @see SingleConnection
    */
    public boolean supprimerUtilisateur(String login, Connection cn) {
    	boolean fonctionne=false; 
    	String sql="SELECT email FROM utilisateur WHERE email='"+login+"'";
    	try {
			Statement stmt=cn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			if (rs.next()) { //Si l'utilisateur existe
				sql="DELETE FROM utilisateur WHERE email='"+login+"'";
				fonctionne=stmt.execute(sql);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return fonctionne;
    }

    /**
    * Permet de cr�er un nouvel utilisateur dans la base de donnees.
    * Si le login n'existe pas d�j�, on encrypte le mot de passe et on
    * effectue une requ�te d'insertion avec le login et le mot de passe
    * de l'utilisateur qu'on souhaite ajouter.
    *
    * @param login login de l'utilisateur � ajouter = mail
    * @param mdp mot de passe de l'utilisateur � ajouter
    * @param statut statut de l'utilisateur
	* @param cn La connection � la base de donn�es
	* @return renvoie true si l'insertion s'est correctement pass�e, false
	* sinon
	* @see SingleConnection
    */
    public boolean creerUtilisateur(String login, String mdp, String statut, Connection cn) {
    	boolean loginValide=false;
    	boolean statutValide=false;
    	//On v�rifie que rien n'est null, puis on v�rifie le format du login et du statut
    	if (login != null && mdp != null && statut!=null) {
    		String regex="^[a-zA-Z.]+@([a-zA-Z-]+.)+[a-zA-Z-]{2,4}$";
        	Pattern p = Pattern.compile(regex);
        	Matcher m = p.matcher(login);
        	loginValide=m.matches();
        	regex="^[a-zA-Z]*$";
    		p = Pattern.compile(regex);
    		m = p.matcher(statut);
    		statutValide=m.matches();
    	}
		
    	boolean fonctionne=false; 
    	if (loginValide && mdpValide(mdp) && statutValide) {
    		String sql="SELECT email FROM utilisateur WHERE email='"+login+"'";
        	try {
    			Statement stmt=cn.createStatement();
    			ResultSet rs=stmt.executeQuery(sql);
    			if (rs.next() == false) { //Si le login n'est pas deja utilise
    				final String mdpEncrypte=encrypte(mdp);
    				sql="INSERT INTO utilisateur VALUES(?, ?, ?)";
    				PreparedStatement pstmt=cn.prepareStatement(sql);
    				pstmt.setString(1, login);
    				pstmt.setString(2, mdpEncrypte);
    				pstmt.setString(3, statut);
    				fonctionne=pstmt.execute();
    			}
    		} catch (SQLException e) {
    			e.printStackTrace();
    		}
    	}
    	
    	return fonctionne;
    }
    
    /**
     * Permet de v�rifier que le mot de passe correspond au format
     * attendu. C'est � dire : 6 caract�res minimum, des majuscules et
     * des minuscules, des caract�res sp�ciaux sauf " et '
     * 
     * @param mdp mot de passe qu'on souhaite verifier
     * @return renvoie true si le mdp correspond aux conditions,
     * false sinon
     */
    public boolean mdpValide(String mdp) {
		String regex="^[A-Za-z0-9_!?=-]{6,}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(mdp);
		boolean valide=m.matches();
		return valide;
    }
    
    /**
     * Permet d'encrypter le mot de passe pour qu'il n'apparaisse
     * pas tel quel dans la base de donn�es.
     * 
     * @param mdp mot de passe qu'on souhaite encrypter
     * @return renvoie le mot de passe encrypte
     */
    public String encrypte(String mdp) {
    	String mdpEncrypte=null;
    	
		try {
			MessageDigest md=MessageDigest.getInstance("SHA-256");
			BigInteger nb=new BigInteger(1, md.digest(mdp.getBytes(StandardCharsets.UTF_8)));
			StringBuilder hexString=new StringBuilder(nb.toString(16));
			while (hexString.length() < 32) {
				hexString.insert(0, '0');
			}
			mdpEncrypte=hexString.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
    	
        return mdpEncrypte;
    }
}