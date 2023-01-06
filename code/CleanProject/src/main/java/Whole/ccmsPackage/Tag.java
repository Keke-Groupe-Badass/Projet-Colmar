package Whole.ccmsPackage;

/**
 * Classe représentant les tags.
 */
public class Tag implements CCMS<Tag> {
    /**
     * Id du tag.
     */
    private int id;
    /**
     * Nom du tag.
     */
    private String nom;
    /**
     * Description du tag.
     */
    private String description;

    /**
     * Constructeur de la classe tag à utiliser en cas normal.
     *
     * @param id          l'identifiant du tag dans la bd
     * @param nom         le nom du tag
     * @param description la description du tag
     */
    public Tag(int id, String nom, String description) {
        this.id = id;
        this.nom = nom;
        this.description = description;
    }

    /**
     * Constructeur à utiliser pour les instances de changement.
     */
    public Tag() {
        this.id = -2;
    }

    /**
     * Permet de renvoyer l'id du tag dans la base de données.
     *
     * @return id int
     */
    public int getId() {
        return id;
    }

    /**
     * Permet de renvoyer le nom du tag dans la base de données.
     *
     * @return nom String
     */
    public String getNom() {
        return nom;
    }

    /**
     * Permet de renvoyer la description du tag dans la base de données.
     *
     * @return description String
     */
    public String getDescription() {
        return description;
    }

    /**
     * Permet d'attribuer un nouvel id au tag.
     *
     * @param id : id du tag
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Permet de remplacer le nom du tag dans la base de données.
     *
     * @param nom String
     */


    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Permet de remplacer la description du tag dans la base de données.
     *
     * @param description String
     */
    public void setDescription(String description) {
        this.description = description;
    }


    /**
     * Permet de verifier si 2 objets sont identiques.
     *
     * @param objet l'objet à comparer
     * @return renvoie true si les deux objets sont identiques, false sinon
     * @author Andreas
     */
    @Override
    public Boolean estClone(Tag objet) {
        if (objet == null) {
            return false;
        }
        if (this.getId() != objet.getId()) {
            return false;
        }
        if (!this.nom.equals(objet.getNom())) {
            return false;
        }
        if (!this.description.equals(objet.getDescription())) {
            return false;
        }
        return true;
    }

    /**
     * Vérifie si 2 tags sont identiques en faisant appel à estClone().
     * 
     * @param objet tag à comparer
     * @return renvoie true si identiques, false sinon
     * @see #estClone(Tag)
     */
    public boolean equals(Tag objet) {
        return this.estClone(objet);
    }

    /**
     * Constructeur prenant uniquement un id.
     *
     * @param id id du tag
     */
    public Tag(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "id: " + id +
                ", nom: '" + nom;
    }
}