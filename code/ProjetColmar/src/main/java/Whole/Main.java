package Whole;

import java.io.File;
import java.net.URI;

public class Main {
    /**
     * Permet de démarrer l'application
     * @param args String[]
     */
    public static void main(String[] args) {
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



        /**
        try{
            System.out.println("hi");
            String[] cmd = { "sh", "MyFile.sh", "athOfTheFile"};
            Runtime.getRuntime().exec(cmd);

        }catch (Exception e){
            e.printStackTrace();
        }**/
    }
}
