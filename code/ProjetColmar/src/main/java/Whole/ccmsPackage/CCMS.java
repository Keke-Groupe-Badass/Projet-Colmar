package Whole.ccmsPackage;

public interface CCMS {
    /**
     * Modifie un CCMS, appel une méthode d'un objet de type AbstractDAO
     * @see Whole.AbstractDAO
     */
    void modifier();
    /**
     * Cherche un CCMS, appel une méthode d'un objet de type AbstractDAO
     * @see Whole.AbstractDAO
     */
    void chercher();
    /**
     * Créer un CCMS, appel une méthode d'un objet de type AbstractDAO
     * @see Whole.AbstractDAO
     */
    void creer();
    /**
     * Supprime un CCMS, appel une méthode d'un objet de type AbstractDAO
     * @see Whole.AbstractDAO
     */
    void supprimer();
}