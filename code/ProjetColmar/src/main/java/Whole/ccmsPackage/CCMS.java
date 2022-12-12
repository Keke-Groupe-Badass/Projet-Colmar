package Whole.ccmsPackage;


/**
 * Interface permettant la généralisation dans la classe AbstractDAO
 * @see Whole.daoPackage.AbstractDAO
 */
public interface CCMS <CCMS>{
    /**
     * Permet de verifier si 2 objets sont exactement similaires
     * @param objet l'objet à comparer
     * @return renvoie true si les deux objets sont similaires, false sinons
     */
    Boolean estCLone(CCMS objet);
}