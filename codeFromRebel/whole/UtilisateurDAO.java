/*
* This code has been generated by the Rebel: a code generator for modern Java.
*
* Drop us a line or two at feedback@archetypesoftware.com: we would love to hear from you!
*/
package whole;

import java.sql.Connection;
import java.util.*;
import java.time.*;



// ----------- << imports@AAAAAAGEEKfwRPbK0gk= >>
// ----------- >>

/**
* Est appelé une fois pour créer un lien entre l'application et la base de donnée
*/

// ----------- << class.annotations@AAAAAAGEEKfwRPbK0gk= >>
// ----------- >>
public class UtilisateurDAO extends AbstractDao {
    /**
    * @param url 
    * @param login 
    * @param pwd
    */

    // ----------- << method.annotations@AAAAAAGEFGJMb+vb2Rc= >>
    // ----------- >>
    public Connection connection(String url, String login, String pwd) {
    // ----------- << method.body@AAAAAAGEFGJMb+vb2Rc= >>
    // ----------- >>
    }
    /**
    * @param login 
    * @param mdp
    */

    // ----------- << method.annotations@AAAAAAGEdi9GpwYx3lc= >>
    // ----------- >>
    public Boolean changeMDP(String login, String mdp) {
    // ----------- << method.body@AAAAAAGEdi9GpwYx3lc= >>
    // ----------- >>
    }
    /**
    * @param login
    */

    // ----------- << method.annotations@AAAAAAGEdi/mQAvesjE= >>
    // ----------- >>
    public Boolean supprimerUtilisateur(String login) {
    // ----------- << method.body@AAAAAAGEdi/mQAvesjE= >>
    // ----------- >>
    }
    /**
    * @param login 
    * @param mdp 
    * @param mail
    */

    // ----------- << method.annotations@AAAAAAGEdjCyqhhkHuM= >>
    // ----------- >>
    public Boolean creerUtilisateur(String login, String mdp, String mail) {
    // ----------- << method.body@AAAAAAGEdjCyqhhkHuM= >>
    // ----------- >>
    }
    // ----------- << method.annotations@AAAAAAGEdjJsC0KnGFk= >>
    // ----------- >>
    public String exportLog() {
    // ----------- << method.body@AAAAAAGEdjJsC0KnGFk= >>
    // ----------- >>
    }
    // ----------- << method.annotations@AAAAAAGEdjKinkcVP4o= >>
    // ----------- >>
    public String exportDonee() {
    // ----------- << method.body@AAAAAAGEdjKinkcVP4o= >>
    // ----------- >>
    }
// ----------- << class.extras@AAAAAAGEEKfwRPbK0gk= >>
// ----------- >>
}