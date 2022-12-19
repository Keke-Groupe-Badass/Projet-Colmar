package Whole;

import Whole.ccmsPackage.Lettrine;
import Whole.fenetrePackage.FXInterface;

import java.io.File;


public class Main {
    /**
     * Permet de démarrer l'application
     * @param args String[]
     */

    public static void main(String[] args) {
        FXInterface f = new FXInterface();
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
        Lettrine l1 = new Lettrine();
        l1.setLien("louis");
        l1.setNbPage(12);
        Lettrine l2 = new Lettrine();
        l2.setLien("louis");
        l2.setNbPage(12);
        System.out.println(l1.equals(l2));


        //executeScriptPB();
    }
    public static void executeScriptPB(){
        try{
            System.out.println("hi");
            System.out.println(new File("C:/Users/andre/Projet-Colmar/Projet-Colmar/code/ProjetColmar/src/main/shell/exportSQL.sh").getAbsoluteFile());
            System.out.println(new File("src/main/shell/exportSQL.sh").getAbsoluteFile());
            String os = System.getProperty("os.name");
            String type="sh";
            if(os.contains("Windows")){
                type="cmd.exe";
            }
            String[] cmd = { type, "exportSQL.sh", "src/main/shell/exportSQL.sh"};
            Runtime.getRuntime().exec(cmd);

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
