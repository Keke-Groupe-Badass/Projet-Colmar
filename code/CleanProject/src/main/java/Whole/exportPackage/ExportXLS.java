/*
* This code has been generated by the Rebel: a code generator for modern Java.
*
* Drop us a line or two at feedback@archetypesoftware.com: we would love to hear from you!
*/
package Whole.exportPackage;

import java.io.File;

import java.util.ArrayList;



/**
 * Implémentation de ExportTypeIntetface pour le SQL
 * @see ExportTypeInterface
 */
public class ExportXLS implements ExportTypeInterface {
    String name="XLS";
    /**
     *  Implémante en XLS la sauvegarde de la base de donnée dans un fichier
     * @param f Fichier de sauvegarde
     * @return true si la base peut être exportée, false sinon
     * @see Whole.daoPackage.AdminDAO#exportDonee
     */
    @Override
    public Boolean export(File f, ArrayList<ArrayList<String>> list) {
        return true;
    }

}