package Whole.ccmsPackage;

import Whole.daoPackage.AbstractDAO;

/**
 * Interface implémentant les méthodes Créer Chercher Modifier Supprimer
 */
public interface CCMS <CCMS>{
    /**
     * Modifie un CCMS, appel une méthode d'un objet de type AbstractDAO
     * @see AbstractDAO
     */
    void modifier(CCMS objet);
    /**
     * Cherche un CCMS, appel une méthode d'un objet de type AbstractDAO
     * @see AbstractDAO
     */
    void chercher(CCMS objet);
    /**
     * Créer un CCMS, appel une méthode d'un objet de type AbstractDAO
     * @see AbstractDAO
     */
    void creer(CCMS objet);
    /**
     * Supprime un CCMS, appel une méthode d'un objet de type AbstractDAO
     * @see AbstractDAO
     */
    void supprimer();
}