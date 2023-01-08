package Whole;

public class Main {
    /**
     * Permet de démarrer l'application
     *
     * @param args String[]
     */

    public static void main(String[] args) {
        Controleur c = new Controleur();
        SingleConnection.getInstance("jdbc:mysql://localhost:3306/fprojectcolmar?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
        //Controleur.utilisateurDAO = new UtilisateurDAO("jdbc:mysql://localhost:3306/fprojectcolmar?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
        //System.out.println(c.ajouterUtilisateur("andreasmulard@gmail.com", "motdepasseSafe101_", "motdepasseSafe101_", "admin"));
    }
}
