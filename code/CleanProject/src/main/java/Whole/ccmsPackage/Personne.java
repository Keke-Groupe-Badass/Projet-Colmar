package Whole.ccmsPackage;

/**
 * Classe représentant les auteurs
 */
public class Personne implements CCMS<Personne> {

    private int id;

    private String nom;

    private String prenom;

    private String note;



    /**
     * Constructeur de la classe Personne
     * @param id int
     * @param nom String
     * @param prenom String
     */
    public Personne(int id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }

    /**
     * Constructeur de la classe Personne
     * @param id int
     */
    public Personne(int id) {
        this.id = id;
    }

    /**
     * Constructeur à utiliser pour les instances de changement
     */
    public Personne(){
        this.id=-2;
        this.nom=null;
        this.prenom=null;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    /**
     * renvoie l'id de la personne dans la base
     * @return id int
     */
    public int getId() {
        return id;
    }

    /**
     * renvoie le nom de la personne
     * @return nom String
     */
    public String getNom() {
        return nom;
    }

    /**
     * renvoie le prenom de la personne
     * @return prenom String
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * change le nom de la personne par le nom passé en param
     * @param nom String
     */
    public void setNom(String nom) {

        this.nom = nom;
    }

    /**
     * change le prenom de la personne par le prénom passé en param
     * @param prenom String
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * Permet de verifier si 2 objets sont exactement similaires
     * @author Andreas
     * @param objet l'objet à comparer
     * @return renvoie true si les deux objets sont similaires, false sinons
     */
    @Override
    public Boolean estClone(Personne objet) {
        if(objet==null){
            return false;
        }
        if(!objet.getNom().equals(this.nom)){
            return false;
        }
        if(objet.getId()!=this.getId()){
            return false;
        }
        if(!objet.getPrenom().equals(this.prenom)){
            return false;
        }
        return true;
    }
    public boolean equals(Personne objet){
        return this.estClone(objet);
    }
}