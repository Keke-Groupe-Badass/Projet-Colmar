package Whole;

import Whole.daoPackage.UtilisateurDAO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


/**
 * Cœur de l'application, doit avant tout lancer ConnectionUniqueBD.
 */
public class Controleur {
    static ArrayList<String> configList;
    public static UtilisateurDAO utilisateurDAO;
    private static String login;
    /**
     * Permet de sauvegarder des métadonnées (ou autre) dans le but d'un
     * copier-coller.
     */
    private static Object pressePapier;

    /**
     * Getter de PressePapier.
     *
     * @return pressePapier
     */
    public static Object getPressePapier() {
        return pressePapier;
    }

    /**
     * Permet de sauvegarder n'importe quel type dans le but d'un copier-coller.
     *
     * @param objet objet à copier
     */
    public static void setPressePapier(Object objet) {
        pressePapier = pressePapier;
    }

    /**
     * Permet de se connecter à la base de données en faisant un appel de
     * SingleConnection avec les paramètres choisis.
     *
     * @param name nom d'utilisateur
     * @param pwd  mot de passe
     * @return True si l'utilisateur est connecté, false sinon
     * @see SingleConnection
     */
    public static Boolean login(String name, String pwd) {

        login = utilisateurDAO.connexion(name, pwd);
        return login != null;

    }

    /**
     * Demande à utilisateurDAO de créer un utilisateur.
     *
     * @param nom    nom d'utilisateur
     * @param mdp     mot de passe
     * @param confirm confirmation du mot de passe
     * @param statut  le statut d'utilisateur
     * @return true si l'utilisateur a pu être ajouté, false sinon
     */
    public Boolean ajouterUtilisateur(String nom, String mdp, String confirm,
                                      String statut) {
        if (!mdp.equals(confirm)) {
            return false;
        }
        return utilisateurDAO.creerUtilisateur(nom, mdp, statut); //en attendant de coder la fonction
    }

    public static Boolean init() {
        return false;
    }

    public Controleur() {
        try {
            configList = new ArrayList<>();
            lireConfigFile();
            System.out.println(configList);
            //utilisateurDAO = new UtilisateurDAO(configList.get(0),"utilisateurSeulement","");
            this.pressePapier = new Object();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public void lireConfigFile() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/configfile.txt"));
        String line;
        int i = 0;
        while ((line = br.readLine()) != null) {
            if (!line.isBlank()) {
                String[] lineList = line.split(";");
                if (lineList.length >= 1) {
                    if (lineList.length == 1) {
                        line = "";
                    } else {
                        line = line.split(";")[1];
                    }
                    configList.add(line);
                }
            }
            i++;
        }
    }

    public static ArrayList<String> getConfigList() {
        return configList;
    }

    public static String getLogin() {
        return login;
    }
}