package Whole;

import Whole.daoPackage.UtilisateurDAO;

public class Main {
    /**
     * Permet de démarrer l'application
     *
     * @param args String[]
     */

    public static void main(String[] args) {
        Controleur c = new Controleur();
        SingleConnection.getInstance("jdbc:mysql://localhost:3306/fprojectcolmar?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
        Controleur.utilisateurDAO = new UtilisateurDAO("jdbc:mysql://localhost:3306/fprojectcolmar?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");

        System.out.println(c.ajouterUtilisateur("andreasmulard@gmail.com", "motdepasseSafe101_", "motdepasseSafe101_", "admin"));


        /**
         try {

         // Two absolute paths
         //"C:\\Users\\andre\\Projet-Colmar\\Projet-Colmar\\code\\ProjetColmar\\src\\main\\java\\Whole\\daoPackage\\AdminDAO.java"
         //"C:\\Users\\andre\\Projet-Colmar\\Projet-Colmar\\code\\ProjetColmar\\src\\main\\shell\\exportSQL.sh"


         File file1 = new File("C:\\Users\\andre\\Projet-Colmar\\Projet-Colmar\\code\\ProjetColmar\\src\\main\\shell\\exportSQL.sh");
         System.out.println("Absolute Path1: " + file1);
         File file2 = new File("C:\\Users\\andre\\Projet-Colmar\\Projet-Colmar\\code\\ProjetColmar");
         System.out.println("Absolute Path2: " + file2);

         String absolutePath1 = file1.toString();
         System.out.println("Absolute Path1: " + absolutePath1);
         String absolutePath2 = file2.toString();
         System.out.println("Absolute Path2: " + absolutePath2);

         // get the relative path
         String relativePath = absolutePath1.substring(absolutePath2.length());
         System.out.println("Absolute Path: " + relativePath);

         } catch (Exception e) {
         e.getStackTrace();
         }
         */
        /**
         Lettrine l1 = new Lettrine();
         l1.setLien("louis");
         l1.setNbPage(12);
         Lettrine l2 = new Lettrine();
         l2.setLien("louis");
         l2.setNbPage(12);
         System.out.println(l1.equals(l2));


         //executeScriptPB();**/
        /**ArrayList<ArrayList<String>> list2 = new ArrayList<>();
         ArrayList<String> list11 = new ArrayList<>();
         ArrayList<String> list12 = new ArrayList<>();
         list12.add("lo'is");
         list12.add("sup/er");
         list11.add("test");
         list11.add("vernie");
         list11.add("sa");

         list2.add(list11);
         list2.add(list12);
         testCSV(list2);
         ExportCSV exportCSV = new ExportCSV();
         exportCSV.export(new File("fileTest.csv"),list2);**/
    }
    /**public static void testCSV(ArrayList<ArrayList<String>> list){

     // create CSVWriter object filewriter object as parameter
     List<Object[]> nList= list.stream().map(e->e.toArray()).collect(Collectors.toList());
     for(Object[] str : nList){
     String string ="";
     for(Object objet : str){
     string+=objet;
     }
     System.out.println(string);
     }
     }**/

}
