package Whole;

import Whole.ccmsPackage.Lettrine;

public class Metadonnee {
    private String nom;

    private int id;

    private String entree;

    private String unite;

    private String description;

    public Metadonnee(String nom, int id, String entree, String unite, String description) {
        this.nom = nom;
        this.id = id;
        this.entree = entree;
        this.unite = unite;
        this.description = description;
    }

    public Metadonnee() {

    }

    /**
     * renvoie le nom de la métadonnée
     * @return nom String
     */
    private String getNom() {
        return nom;
    }

    /**
     * renvoie l'id de la métadonnée dans la base de données
     * @return id int
     */
    private int getId() {
        return id;
    }


    /**
     * renvoie la valeur de la métadonnée (ex : nom = "couleur", valeur = "rouge")
     * @return entree String
     */
    private String getEntree() {
        return entree;
    }

    /**
     * renvoie l'unité de la métadonnée si elle existe
     * @return unite String
     */
    private String getUnite() {
        return unite;
    }

    /**
     * renvoie la description de la métadonnée
     * @return description String
     */
    private String getDescription() {
        return description;
    }

    /**
     * change le nom de la métadonnée
     * @param nom String : nouveau nom
     */
    private void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * change la valeur de la métadonnée par l'entree passée en paramètre
     * @param entree String
     */
    private void setEntree(String entree) {
        this.entree = entree;
    }

    /**
     * change l'unité de la métadonnée
     * @param unite String : nouvelle unité
     */
    private void setUnite(String unite) {
        this.unite = unite;
    }

    /**
     * change la description de la métadonnée
     * @param description String : nouvelle description
     */
    private void setDescription(String description) {
        this.description = description;
    }

    /**
    * @param meta Metadonnee : métadonnée à modifier
    */
    public void Modifier(Metadonnee meta) {

    }
}