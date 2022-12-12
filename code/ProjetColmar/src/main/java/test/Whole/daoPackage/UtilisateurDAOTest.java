package test.Whole.daoPackage;

import Whole.daoPackage.UtilisateurDAO;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class UtilisateurDAOTest {
    public static UtilisateurDAO u;
    public static Connection cn;
    public static void main(String[] args) {
         u = new UtilisateurDAO();
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
        assertTrue(u.connexion("root","",cn).equals("root"));
    }
    @Test
    void connexionLoginNull() {
        assertTrue(u.connexion(null,"",cn).equals(null));
    }
    @Test
    void connexionPWDNull() {
        assertTrue(u.connexion("root",null,cn).equals(null));
    }
    @Test

    void connexionConnectionNull() {
        assertTrue(u.connexion("root","",null).equals(null));
    }
    @Test
    void changeMDPNormal() {
        assertTrue(!u.changeMDP("root","MotDePasseValide1_",cn));
    }
    @Test

    void changeMDPLoginNull() {
        assertTrue(!u.changeMDP(null,"MotDePasseValide1_",cn));
    }
    @Test

    void changeMDPPwdNull() {
        assertTrue(!u.changeMDP("root",null,cn));
    }
    @Test

    void changeMDPCnNull() {
        assertTrue(!u.changeMDP("root","MotDePasseValide1_",null));
    }
    @Test

    void changeMDPNormalPasChar() {
        assertTrue(!u.changeMDP("root","MotDePasseValide1aa",cn));
    }
    @Test

    void changeMDPNormalPasNombre() {
        assertTrue(!u.changeMDP("root","MotDePasseValide_aa",cn));
    }
    @Test

    void changeMDPNormalPasMaj() {
        assertTrue(!u.changeMDP("root","motdepassevalide_aa1",cn));
    }
    @Test

    void changeMDPNormalPasMin() {
        assertTrue(!u.changeMDP("root","MOTDEPASSEVALIDE_AA1",cn));
    }
    @Test

    void changeMDPNormalCourt() {
        assertTrue(!u.changeMDP("root","ptI_5",cn));
    }
    @Test

    void changeMDPNormalCharProhibited() {
        assertTrue(!u.changeMDP("root","Motdepassevalide_aa1'",cn));
    }
    @Test

    void changeMDPNormalEspace() {
        assertTrue(!u.changeMDP("root","Motdepassevalide_ ",cn));
    }
    @Test
    void supprimerUtilisateurValide() {
        assertTrue(u.supprimerUtilisateur("Didier",cn));
    }
    @Test
    void supprimerUtilisateurPasNom() {
        assertFalse(u.supprimerUtilisateur(null,cn));
    }
    @Test
    void supprimerUtilisateurPasCn() {
        assertFalse(u.supprimerUtilisateur("didier",null));
    }
    @Test
    void supprimerUtilisateurPasExistant() {
        assertFalse(u.supprimerUtilisateur("",cn));
    }
    @Test
    void supprimerUtilisateurAdmin() {
        assertFalse(u.supprimerUtilisateur("nomAdmin",cn));
    }

    @Test
    void creerUtilisateur() {
        assertTrue(u.creerUtilisateur("login","password","email@form.fr",cn));
    }
    @Test
    void creerUtilisateurPasLogin() {
        assertFalse(u.creerUtilisateur(null,"password","email@form.fr",cn));
    }
    @Test
    void creerUtilisateurPasPwd() {
        assertFalse(u.creerUtilisateur("login",null,"email@form.fr",cn));
    }
    @Test
    void creerUtilisateurPasEmail() {
        assertFalse(u.creerUtilisateur("login","password",null,cn));
    }
    @Test
    void creerUtilisateurPasCn() {
        assertFalse(u.creerUtilisateur("login","password","email",null));
    }
    @Test
    void creerUtilisateurNomDejaPris() {
        assertFalse(u.creerUtilisateur("Didier","password","email",null));
    }
}