package Whole.daoPackage;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Andreas
 */
class UtilisateurDAOTest {
    public static UtilisateurDAO u;
    public static Connection cn;
    public static void main(String[] args) {
         u = new UtilisateurDAO("root","login","pwd");
        try {
            Class.forName("com.mysql.jdbc.Driver");

            cn= DriverManager.getConnection("root","login","pwd");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    void connexionNormal() {
        assertTrue(u.connexion("root","").equals("root"));
    }
    @Test
    void connexionLoginNull() {
        assertTrue(u.connexion(null,"").equals(null));
    }
    @Test
    void connexionPWDNull() {
        assertTrue(u.connexion("root",null).equals(null));
    }

    @Test
    void changeMDPNormal() {
        assertTrue(!u.changeMDP("root","MotDePasseValide1_"));
    }
    @Test

    void changeMDPLoginNull() {
        assertTrue(!u.changeMDP(null,"MotDePasseValide1_"));
    }
    @Test

    void changeMDPPwdNull() {
        assertTrue(!u.changeMDP("root",null));
    }

    @Test

    void changeMDPNormalPasChar() {
        assertTrue(!u.changeMDP("root","MotDePasseValide1aa"));
    }
    @Test

    void changeMDPNormalPasNombre() {
        assertTrue(!u.changeMDP("root","MotDePasseValide_aa"));
    }
    @Test

    void changeMDPNormalPasMaj() {
        assertTrue(!u.changeMDP("root","motdepassevalide_aa1"));
    }
    @Test

    void changeMDPNormalPasMin() {
        assertTrue(!u.changeMDP("root","MOTDEPASSEVALIDE_AA1"));
    }
    @Test

    void changeMDPNormalCourt() {
        assertTrue(!u.changeMDP("root","ptI_5"));
    }
    @Test

    void changeMDPNormalCharProhibited() {
        assertTrue(!u.changeMDP("root","Motdepassevalide_aa1'"));
    }
    @Test

    void changeMDPNormalEspace() {
        assertTrue(!u.changeMDP("root","Motdepassevalide_ "));
    }
    @Test
    void supprimerUtilisateurValide() {
        assertTrue(u.supprimerUtilisateur("Didier"));
    }
    @Test
    void supprimerUtilisateurPasNom() {
        assertFalse(u.supprimerUtilisateur(null));
    }
    @Test
    void supprimerUtilisateurPasExistant() {
        assertFalse(u.supprimerUtilisateur(""));
    }
    @Test
    void supprimerUtilisateurAdmin() {
        assertFalse(u.supprimerUtilisateur("nomAdmin"));
    }

    @Test
    void creerUtilisateur() {
        assertTrue(u.creerUtilisateur("login","password","email@form.fr"));
    }
    @Test
    void creerUtilisateurPasLogin() {
        assertFalse(u.creerUtilisateur(null,"password","email@form.fr"));
    }
    @Test
    void creerUtilisateurPasPwd() {
        assertFalse(u.creerUtilisateur("login",null,"email@form.fr"));
    }
    @Test
    void creerUtilisateurPasEmail() {
        assertFalse(u.creerUtilisateur("login","password",null));
    }
    @Test
    void creerUtilisateurPasCn() {
        assertFalse(u.creerUtilisateur("login","password","email"));
    }
    @Test
    void creerUtilisateurNomDejaPris() {
        assertFalse(u.creerUtilisateur("Didier","password","email"));
    }
}