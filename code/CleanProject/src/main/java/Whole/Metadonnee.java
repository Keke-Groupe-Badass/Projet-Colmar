package Whole;

public class Metadonnee {
    private String nom;

    private int id;

    private String valeur;

    private String unite;

    private String description;

    private int idLettrine;


    /**
     * Constructeur de la classe Metadonnee
     *
     * @param nom         String : nom de la métadonnée
     * @param id          int : id de la métadonnée
     * @param valeur      String : valeur de la métadonnée
     * @param unite       String : unité de la métadonnée
     * @param description String : description de la métadonnée
     * @param idLettrine  int : id de la lettrine associée à la métadonnée
     */

    public Metadonnee(String nom, int id, String valeur, String unite, String description, int idLettrine) {
        this.nom = nom;
        this.id = id;
        this.valeur = valeur;
        this.unite = unite;
        this.description = description;
        this.idLettrine = idLettrine;
    }

    public Metadonnee(String nom, int id, String valeur, String unite, String description) {
        this.nom = nom;
        this.id = id;
        this.valeur = valeur;
        this.unite = unite;
        this.description = description;
        this.idLettrine = -1;
    }

    public Metadonnee() {

    }

    public Metadonnee(String nom, String valeur, String unite, String description, int idLettrine) {
        this.nom = nom;
        this.valeur = valeur;
        this.unite = unite;
        this.description = description;
        this.idLettrine = idLettrine;
    }

    public Metadonnee(String nom, String valeur, String unite, String description) {
        this.nom = nom;
        this.valeur = valeur;
        this.unite = unite;
        this.description = description;
        this.idLettrine = -1;
    }

    /**
     * renvoie le nom de la métadonnée
     *
     * @return nom String
     */
    public String getNom() {
        return nom;
    }

    /**
     * renvoie l'id de la métadonnée dans la base de données
     *
     * @return id int
     */
    public int getId() {
        return id;
    }


    /**
     * renvoie la valeur de la métadonnée (ex : nom = "couleur", valeur = "rouge")
     *
     * @return entree String
     */
    public String getValeur() {
        return valeur;
    }

    /**
     * renvoie l'unité de la métadonnée si elle existe
     *
     * @return unite String
     */
    public String getUnite() {
        return unite;
    }

    /**
     * renvoie la description de la métadonnée
     *
     * @return description String
     */
    public String getDescription() {
        return description;
    }

    /**
     * définit l'id de la métadonnée
     *
     * @param id : id de la métadonnée
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * change le nom de la métadonnée
     *
     * @param nom String : nouveau nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * change la valeur de la métadonnée par l'entree passée en paramètre
     *
     * @param valeur String
     */
    public void setValeur(String valeur) {
        this.valeur = valeur;
    }

    /**
     * change l'unité de la métadonnée
     *
     * @param unite String : nouvelle unité
     */
    public void setUnite(String unite) {
        this.unite = unite;
    }

    /**
     * change la description de la métadonnée
     *
     * @param description String : nouvelle description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Renvoie l'id de la lettrine à laquelle est associée la métadonnée.
     *
     * @return idLettrine
     */
    public int getIdLettrine() {
        return idLettrine;
    }

    /**
     * Change l'id de la lettrine à laquelle est associée la métadonnée.
     *
     * @param idLettrine nouvel id
     */
    public void setIdLettrine(int idLettrine) {
        this.idLettrine = idLettrine;
    }

    @Override
    public String toString() {
        return
                "nom:" + nom +
                ", entree:" + valeur +
                ", unite:" + unite + ", id:" + id
                ;
    }
}