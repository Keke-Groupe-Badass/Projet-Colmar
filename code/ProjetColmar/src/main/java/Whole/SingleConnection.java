/*
* This code has been generated by the Rebel: a code generator for modern Java.
*
* Drop us a line or two at feedback@archetypesoftware.com: we would love to hear from you!
*/
package Whole;

import java.util.*;
import java.time.*;



// ----------- << imports@AAAAAAGEEKfwRPbK0gk= >>
// ----------- >>

/**
* Est appelé une fois pour créer un lien entre l'application et la base de donnée
*/

// ----------- << class.annotations@AAAAAAGEEKfwRPbK0gk= >>
// ----------- >>
public class SingleConnection {
    // ----------- << attribute.annotations@AAAAAAGEFF+AQYYZOVw= >>
    // ----------- >>
    private String url;

    // ----------- << attribute.annotations@AAAAAAGEFF+SrYf/lLw= >>
    // ----------- >>
    private String login;

    // ----------- << attribute.annotations@AAAAAAGEFF+WVIkTciQ= >>
    // ----------- >>
    private String password;

    private String getUrl() {
        return url;
    }

    private String getLogin() {
        return login;
    }

    private String getPassword() {
        return password;
    }

    private void setUrl(String url) {
        this.url = url;
    }

    private void setLogin(String login) {
        this.login = login;
    }

    private void setPassword(String password) {
        this.password = password;
    }

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
// ----------- << class.extras@AAAAAAGEEKfwRPbK0gk= >>
// ----------- >>
}