package Whole.daoPackage;

import Whole.SingleConnection;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Cette classe est appelée pour créer un lien entre l'application
 * et la base de données pour tout ce qui concerne les intéractions
 * et les modifications de l'utilisateur.
 *
 * @see SuperAbstractDAO
 */

public class UtilisateurDAO extends SuperAbstractDAO {
    /**
     * Constructeur de la classe UtilisateurDAO.
     *
     * @param url   url de la BDD
     * @param login login de la BDD
     * @param mdp   mot de passe pour la BDD
     */
    public UtilisateurDAO(String url, String login, String mdp) {
        super(url, login, mdp);
    }

    /**
     * Permet à un utilisateur de se connecter sur l'application. On
     * donne le login et le mot de passe de l'utilisateur, puis on
     * fait une requête à la base de données pour s'assurer que
     * l'utilisateur existe et que le mot de passe est le bon.
     *
     * @param login Le nom d'utilisateur pour se connecter à la base
     *              de données
     * @param mdp Le mot de passe de l'utilisateur dans la base de données
     * @return renvoie le login sous forme de String si la connexion
     *          s'est correctement effectuée,
     *          sinon elle renvoie null.
     * @author Emerance
     * @see SingleConnection
     */
    public String connexion(String login, String mdp) {
        /**
         *
         */
        if (!mdpValide(mdp))
            return null;
        final String mdpEncrypte = encrypte(mdp);
        String sql = "SELECT * FROM utilisateurs "
                + "WHERE email=? AND motDePasse=?";
        try {
            PreparedStatement stmt = cn.prepareStatement(sql);
            stmt.setString(1, login);
            stmt.setString(2, mdpEncrypte);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) //Si l'utilisateur est trouvé
                return login;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Permet de changer le mot de passe de l'utilisateur. On donne le login
     * et le nouveau mot de passe souhaité, puis on retrouve l'utilisateur
     * dans la base de données à l'aide du login. Le nouveau mot de passe
     * est encrypté puis stocké dans la base à la place de l'ancien.
     *
     * @param login login de l'utilisateur, permet de l'identifier dans la BDD
     * @param mdp nouveau mot de passe qui doit venir remplacer l'ancien
     * @return renvoie true si la modification s'est correctement
     *          effectuée, false sinon
     * @author Emerance
     * @see SingleConnection
     */
    public boolean changeMDP(String login, String mdp) {
        boolean fonctionne = false;
        if (mdp != null && login != null) {
            if (mdpValide(mdp)) {
                String sql = "SELECT email FROM utilisateurs "
                        + "WHERE email=?";
                try {
                    final String mdpEncrypte = encrypte(mdp);
                    PreparedStatement stmt = cn.prepareStatement(sql);
                    stmt.setString(1, login);
                    ResultSet rs = stmt.executeQuery();
                    if (rs.next()) { //Si l'utilisateur existe
                        sql = "UPDATE utilisateurs SET motDePasse=?"
                                + " WHERE email=?";
                        stmt = cn.prepareStatement(sql);
                        stmt.setString(1, mdpEncrypte);
                        stmt.setString(2, login);
                        int nbColonnes = stmt.executeUpdate();
                        fonctionne = nbColonnes > 0;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return fonctionne;
    }

    /**
     * Permet de supprimer un utilisateur de la base de données à partir
     * de son login. Le login est recherché dans la base de données,
     * puis si trouvé l'utilisateur correspondant est alors supprimé.
     *
     * @param login login de l'utilisateur
     * @return true si la suppression s'est correctement passée, false sinon
     * @author Emerance
     * @see SingleConnection
     */
    public boolean supprimerUtilisateur(String login) {
        boolean fonctionne = false;
        String sql = "SELECT email FROM utilisateurs "
                + "WHERE email=?";
        try {
            PreparedStatement stmt = cn.prepareStatement(sql);
            stmt.setString(1, login);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) { //Si l'utilisateur existe
                sql = "DELETE FROM utilisateurs WHERE email=?";
                stmt = cn.prepareStatement(sql);
                stmt.setString(1, login);
                int nbColonnes = stmt.executeUpdate();
                fonctionne = nbColonnes > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fonctionne;
    }

    /**
     * Permet de créer un nouvel utilisateur dans la base de données.
     * Si le login n'existe pas déjà, on encrypte le mot de passe et on
     * effectue une requête d'insertion avec le login et le mot de passe
     * de l'utilisateur qu'on souhaite ajouter.
     *
     * @param login  login de l'utilisateur à ajouter = mail
     * @param mdp    mot de passe de l'utilisateur à ajouter
     * @param statut statut de l'utilisateur
     * @return renvoie true si l'insertion s'est correctement passée, false
     *          sinon
     * @author Emerance
     * @see SingleConnection
     */
    public boolean creerUtilisateur(String login, String mdp, String statut) {
        boolean loginValide = false;
        boolean statutValide = false;
        //On vérifie que rien n'est null, puis on vérifie le format du login
        // et du statut

        if (login != null && mdp != null && statut != null) {
            String regex = "^[a-zA-Z.]+@([a-zA-Z-]+.)+[a-zA-Z-]{2,4}$";
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(login);
            loginValide = m.matches();
        }
        boolean fonctionne = false;

        if (loginValide && mdpValide(mdp)) {
            System.out.println("hi");

            String sql = "SELECT email FROM utilisateurs "
                    + "WHERE email=?";
            try {
                PreparedStatement stmt = cn.prepareStatement(sql);
                stmt.setString(1, login);
                ResultSet rs = stmt.executeQuery();
                rs.next();
                if (!rs.next()) { //Si le login n'est pas déjà utilisé
                    final String mdpEncrypte = encrypte(mdp);
                    System.out.println(mdpEncrypte);
                    sql = "INSERT INTO utilisateurs VALUES(?, ?, ?)";
                    stmt = cn.prepareStatement(sql);
                    stmt.setString(1, login);
                    stmt.setString(2, mdpEncrypte);
                    stmt.setString(3, statut);
                    int nbColonnes = stmt.executeUpdate();
                    System.out.println("hi");
                    System.out.println(login);
                    fonctionne = nbColonnes > 0;
                    login = login;
                    if(fonctionne){
                        sql = "CREATE USER '"+login+"'@'localhost' IDENTIFIED BY '"+mdpEncrypte+"'";
                        stmt = cn.prepareStatement(sql);
                        return stmt.execute();
                        //TODO trouver un moyen de verifier qur l'utilisateur est été enregistré pour la bd (pas dans la table utilisateur)
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return fonctionne;
    }

    /**
     * Permet de vérifier que le mot de passe correspond au format
     * attendu. C'est à dire : 6 caractères minimum, des majuscules et
     * des minuscules, des caractères spéciaux sauf " et '
     *
     * @param mdp mot de passe qu'on souhaite vérifier
     * @return renvoie true si le mdp correspond aux conditions,
     *          false sinon
     * @author Emerance
     */
    public boolean mdpValide(String mdp) {
        String regex = "^[A-Za-z0-9_!?=-]{6,}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(mdp);
        return m.matches();
    }

    /**
     * Permet d'encrypter le mot de passe pour qu'il n'apparaisse
     * pas tel quel dans la base de données.
     *
     * @param mdp mot de passe qu'on souhaite encrypter
     * @return renvoie le mot de passe encrypté
     * @author Emerance
     */
    public static String encrypte(String mdp) {
        String mdpEncrypte = null;

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            BigInteger nb = new BigInteger(1,
                    md.digest(mdp.getBytes(StandardCharsets.UTF_8)));
            StringBuilder hexString = new StringBuilder(nb.toString(16));
            while (hexString.length() < 32) {
                hexString.insert(0, '0');
            }
            mdpEncrypte = hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return mdpEncrypte;
    }

    /**
     * Permet d'obtenir le statut d'un utilisateur
     * @param email le mail d'un utilisateur
     * @return le statut si l'utilisateur est trouvé, null sinon
     */
    public String obtenirStatut(String email) {
        String sql;
        sql = "SELECT `statut` FROM `utilisateurs` WHERE `email`='" + email + "'";
        Statement stmt = null;
        try {
            stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                return rs.getString(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    /**
     * Permet de changer le statut d'un utilisateur
     * @param email l'email de l'utilisateur
     * @param statut le statut à donner
     * @return true si le statut a pu être changé, false sinon
     */
    public Boolean changeStatut(String email,String statut)  {
        String sql = "UPDATE utilisateurs SET statut='"+statut
                + "' WHERE email='"+email+"'";
        Statement stmt = null;
        try {
            stmt = cn.createStatement();
            int i = stmt.executeUpdate(sql);
            if(i==1){
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;

    }

    /**
     * Permet d'obtenir la liste des utilisateurs avec une recherche par leur email
     * @param login email possiblement incomplet
     * @return La liste des emails correspondants
     */
    public ArrayList<String> chercher(String login){
        ArrayList<String> list = new ArrayList<>();
        String sql = "SELECT `email` FROM `utilisateurs` WHERE `email` LIKE '"+login+"'";
        try {
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                list.add(rs.getString(0));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }
}