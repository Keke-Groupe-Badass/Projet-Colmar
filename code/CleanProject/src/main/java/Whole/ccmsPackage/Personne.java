package Whole.ccmsPackage;

/**
 * Classe représentant les auteurs.
 */
public class Personne implements CCMS<Personne> {
    /**
     * Id de la personne.
     */
    private int id;
    /**
     * Nom de la personne.
     */
    private String nom;
    /**
     * Prénom de la personne.
     */
    private String prenom;
    /**
     * Note de la personne.
     */
    private String note;


    /**
     * Constructeur de la classe Personne.
     *
     * @param id     int
     * @param nom    String
     * @param prenom String
     */
    public Personne(int id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }

    /**
     * Constructeur de la classe Personne.
     *
     * @param id int
     */
    public Personne(int id) {
        this.id = id;
    }

    /**
     * Constructeur à utiliser pour les instances de changement.
     */
    public Personne() {
        this.id = -2;
        this.nom = null;
        this.prenom = null;
    }

    /**
     * Remplace l'id de la personne par celui passé en paramètre.
     *
     * @param id id de la personne
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Renvoie la note de la personne.
     *
     * @return note
     */
    public String getNote() {
        return note;
    }

    /**
     * Remplace la note de la personne par celle passée en paramètre.
     *
     * @param note note de la personne
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * Renvoie l'id de la personne dans la base.
     *
     * @return id int
     */
    public int getId() {
        return id;
    }

    /**
     * Renvoie le nom de la personne.
     *
     * @return nom String
     */
    public String getNom() {
        return nom;
    }

    /**
     * Renvoie le prénom de la personne.
     *
     * @return prenom String
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Remplace le nom de la personne par celui passé en paramètre.
     *
     * @param nom String
     */
    public void setNom(String nom) {

        this.nom = nom;
    }

    /**
     * Remplace le prénom de la personne par celui passé en paramètre.
     *
     * @param prenom String
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * Permet de verifier si 2 objets sont identiques.
     *
     * @param objet l'objet à comparer
     * @return renvoie true si les deux objets sont identiques, false sinon
     * @author Andreas
     */
    @Override
    public Boolean estClone(Personne objet) {
        if (objet == null) {
            return false;
        }
        if (!objet.getNom().equals(this.nom)) {
            return false;
        }
        if (objet.getId() != this.getId()) {
            return false;
        }
        if (!objet.getPrenom().equals(this.prenom)) {
            return false;
        }
        return true;
    }

    /**
     * Permet de verifier si 2 personnes sont identiques en faisant appel
     * à estClone().
     *
     * @param objet personne à comparer
     * @return true si identiques, false sinon
     * @see #estClone(Personne)
     */
    public boolean equals(Personne objet) {
        return this.estClone(objet);
    }
}