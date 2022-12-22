package Whole.ccmsPackage;

/**
 * Classe représentant les tags
 */
public class Tag implements CCMS<Tag> {

    private int id;


    private String nom;


    private String description;

    /**
     * Constructeur de la classe tag à utilisé en cas normal
     * @param id l'identifiant du tag dans la bd
     * @param nom le nom du tag
     * @param description la description du tag

     */
    public Tag(int id, String nom, String description) {
        this.id = id;
        this.nom = nom;
        this.description = description;
    }
    /**
     * Constructeur à utiliser pour les instances de changement
     */
    public Tag() {
        this.id = -2;
    }

    /**
     * permet de renvoyer l'id du tag dans la base de données
     * @return id int
     */
    public int getId() {
        return id;
    }
    /**
     * permet de renvoyer le nom du tag dans la base de données
     * @return nom String
     */
    public String getNom() {
        return nom;
    }
    
    /**
     * permet de renvoyer la description du tag dans la base de données
     * @return description String
     */
    public String getDescription() {
        return description;
    }

    /**
     * permet d'attribuer un nouvel id au tag
     * @param id : id du tag
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * permet de remplacer le nom du tag dans la base de données
     * @param nom String
     */



    public void setNom(String nom) {
        this.nom = nom;
    }
    /**
     * permet de remplacer la description du tag dans la base de données
     * @param description String
     */
    public void setDescription(String description) {
        this.description = description;
    }


    /**
     * Permet de verifier si 2 objets sont exactement similaires
     * @author Andreas
     * @param objet l'objet à comparer
     * @return renvoie true si les deux objets sont similaires, false sinons
     */
    @Override
    public Boolean estCLone(Tag objet) {
        if(objet!=null){
            return false;
        }
        if(this.getId()!=objet.getId()){
            return false;
        }
        if(!this.nom.equals(objet.getNom())){
            return false;
        }
        if(!this.description.equals(objet.getDescription())){
            return false;
        }
        return true;
    }
    public boolean equals(Tag objet){
        return this.estCLone(objet);
    }
}