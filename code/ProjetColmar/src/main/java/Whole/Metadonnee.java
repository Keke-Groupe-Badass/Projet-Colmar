package Whole;

import Whole.ccmsPackage.Lettrine;

public class Metadonnee {
    private String nom;

    private int id;

    private String entree;

    private String unite;

    private String description;


    /**
     * Constructeur de la classe Metadonnee
     * @param nom String : nom de la metadonnee
     * @param id int : id de la metadonnee
     * @param entree String : valeur de la métadonnee
     * @param unite String : unité de la métadonnée
     * @param description String : desctiption de la métadonnee
     */

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
    public String getNom() {
        return nom;
    }

    /**
     * renvoie l'id de la métadonnée dans la base de données
     * @return id int
     */
    public int getId() {
        return id;
    }


    /**
     * renvoie la valeur de la métadonnée (ex : nom = "couleur", valeur = "rouge")
     * @return entree String
     */
    public String getEntree() {
        return entree;
    }

    /**
     * renvoie l'unité de la métadonnée si elle existe
     * @return unite String
     */
    public String getUnite() {
        return unite;
    }

    /**
     * renvoie la description de la métadonnée
     * @return description String
     */
    public String getDescription() {
        return description;
    }

    /**
     * définit l'id de la métadonnée
     * @param id : id de la métadonnée
     */
    public void setId(int id) {this.id = id;}

    /**
     * change le nom de la métadonnée
     * @param nom String : nouveau nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * change la valeur de la métadonnée par l'entree passée en paramètre
     * @param entree String
     */
    public void setEntree(String entree) {
        this.entree = entree;
    }

    /**
     * change l'unité de la métadonnée
     * @param unite String : nouvelle unité
     */
    public void setUnite(String unite) {
        this.unite = unite;
    }

    /**
     * change la description de la métadonnée
     * @param description String : nouvelle description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
    * @param meta Metadonnee : métadonnée à modifier
    */
    public void Modifier(Metadonnee meta) {

    }
}