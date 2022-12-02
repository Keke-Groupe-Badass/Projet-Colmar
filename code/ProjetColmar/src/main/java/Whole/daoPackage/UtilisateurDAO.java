package Whole.daoPackage;

import java.util.*;
import java.time.*;

/**
* Cette classe est appelée une fois pour créer un lien entre l'application et la base de données
* pour tout ce qui concerne les intéractions et les modifications de l'utilisateur
*/

public class UtilisateurDAO extends AbstractDao {
    /**
    * @param url 
    * @param login 
    * @param pwd
    * @return
    */
    public Connection connection(String url, String login, String pwd) {

    }

    /**
    * @param login 
    * @param mdp
    * @return
    */
    public Boolean changeMDP(String login, String mdp) {

    }

    /**
    * @param login
    * @return
    */
    public Boolean supprimerUtilisateur(String login) {
    
    }

    /**
    * @param login 
    * @param mdp 
    * @param mail
    */
    public Boolean creerUtilisateur(String login, String mdp, String mail) {

    }

    /**
     * 
     * @return
     */
    public String exportLog() {

    }

    /**
     * 
     * @return
     */
    public String exportDonnee() {

    }
}