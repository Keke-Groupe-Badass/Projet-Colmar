package Whole.ccmsPackage;

import java.util.ArrayList;

/**
 * Classe représentant les ouvrages
 */
public class Ouvrage implements CCMS<Ouvrage> {
    private String titre;

    private ArrayList<Personne> personnes;

    private Personne libraire;

    private Personne imprimeur;

    private String lieuEdition;

    private int dateEdition;

    private int nbPage;

    private int id;

    private String format;

    private String resolution;

    private String creditPhoto;

    private boolean reechantillonage;

    private String copyright;

    private String lien;

    /**
     * Constructeur à utiliser pour les instances de changement
     */
    public Ouvrage() {
        this.id = -2;
        this.nbPage = -2;

    }

    /**
     * Constructeur de la classe ouvrage à utiliser en cas normal
     * @param titre String
     * @param id int
     */
    public Ouvrage(String titre, int id) {
        this.titre = titre;
        this.id = id;
    }

    /**
     * Constructeur à utilisé pour les copies uniquements
     * @param titre String
     * @param personnes ArrayList<String>
     * @param libraire Personne
     * @param imprimeur Personne
     * @param lieuEdition String
     * @param dateEdition String
     * @param nbPage int
     * @param id int
     * @param format String
     * @param resolution String
     * @param creditPhoto String
     * @param reechantillonage boolean
     * @param copyright String
     */
    public Ouvrage(String titre, ArrayList<Personne> personnes, Personne libraire, Personne imprimeur, String lieuEdition, int dateEdition, int nbPage, int id, String format, String resolution, String creditPhoto, boolean reechantillonage, String copyright, String lien) {
        this.titre = titre;
        this.personnes = new ArrayList<>();
        this.libraire = libraire;
        this.imprimeur = imprimeur;
        this.lieuEdition = lieuEdition;
        this.dateEdition = dateEdition;
        this.nbPage = nbPage;
        this.id = id;
        this.format = format;
        this.resolution = resolution;
        this.creditPhoto = creditPhoto;
        this.reechantillonage = reechantillonage;
        this.copyright = copyright;
        this.lien=lien;
        for(Personne a: personnes){
            this.personnes.add(a);
        }

    }


    public void setId(int id) {
        this.id = id;
    }

    /**
     * getter de l'attribut format
     * @return format
     */
    public String getFormat() {
        return format;
    }

    /**
     * setter de l'attribut format
     * @param format String
     */
    public void setFormat(String format) {
        this.format = format;
    }

    /**
     * getter de l'attribut résolution
     * @return resolution
     */
    public String getResolution() {
        return resolution;
    }

    /**
     * setter de l'attribut résolution
     * @param resolution String
     */
    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    /**
     * getter de l'attribut CreditResolution
     * @return ceditResolution
     */
    public String getCreditPhoto() {
        return creditPhoto;
    }

    /**
     * setter de l'attribut creditResolution
     * @param creditPhoto String
     */
    public void setCreditPhoto(String creditPhoto) {
        this.creditPhoto = creditPhoto;
    }

    /**
     * equivalent getter de l'attribut reechantillonage
     * @return reechantillonage
     */
    public boolean isReechantillonage() {
        return reechantillonage;
    }

    /**
     * setter de l'attribut reechantillonage
     * @param reechantillonage boolean
     */
    public void setReechantillonage(boolean reechantillonage) {
        this.reechantillonage = reechantillonage;
    }

    /**
     * getter de l'attribut copyright
     * @return copytight
     */
    public String getCopyright() {
        return copyright;
    }

    /**
     * setter de l'attribut copyright
     * @param copyright String
     */
    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    /**
     * renvoie le titre de l'ouvrage
     * @return titre String
     */
    public String getTitre() {
        return titre;
    }

    /**
     * renvoie les personnes de l'ouvrage
     * @return personnes String
     */
    public ArrayList<Personne> getAuteurs() {
        return personnes;
    }


    /**
     * renvoie le lieu où l'ouvrage a été imprimé
     * @return lieuEdition String
     */
    public String getLieuEdition() {
        return lieuEdition;
    }

    /**
     * renvoie la date d'édition de l'ouvrage
     * @return dateEdition String
     */
    public int getDateEdition() {
        return dateEdition;
    }

    /**
     * renvoie le nombre de pages de l'ouvrage
     * @return nbPages int
     */
    public int getNbPage() {
        return nbPage;
    }

    public ArrayList<Personne> getPersonnes() {
        return personnes;
    }

    public void setPersonnes(ArrayList<Personne> personnes) {
        ArrayList<Personne> list = new ArrayList<>();
        for(Personne p : personnes){
            list.add(p);
        }
        this.personnes = list;
    }

    public Personne getLibraire() {
        return libraire;
    }

    public void setLibraire(Personne libraire) {
        this.libraire = libraire;
    }

    public Personne getImprimeur() {
        return imprimeur;
    }

    public void setImprimeur(Personne imprimeur) {
        this.imprimeur = imprimeur;
    }

    /**
     * renvoie l'id de l'ouvrage dans la base
     * @return id int
     */
    public int getId() {
        return id;
    }

    /**
     * change le titre de l'ouvrage par le titre passé en paramètre
     * @param titre String
     */
    public void setTitre(String titre) {
        this.titre = titre;
    }

    /**
     * change les personnes de l'ouvrage par les personnes passés en paramètre
     * @param personnes String
     */
    public void setAuteurs(ArrayList<Personne> personnes) {
        this.personnes = new ArrayList<>();
        for(Personne personne : personnes){
            this.personnes.add(personne);
        }
    }


    /**
     * Change le lieu d'édition de l'ouvrage par le lieu d'édition passé en paramètre
     * @param lieuEdition String
     */
    public void setLieuEdition(String lieuEdition) {
        this.lieuEdition = lieuEdition;
    }

    /**
     * Permet de copier les valeurs d'un ouvrage
     * @author Andreas
     * @return la copie exacte d'un ouvrage
     */
    public Ouvrage copie(){
        return new Ouvrage( titre, (ArrayList<Personne>) personnes.clone(), libraire,  imprimeur,  lieuEdition,  dateEdition,  nbPage,    id,  format,  resolution, creditPhoto,  reechantillonage, copyright,lien);
    }
    /**
     * Change la date d'édition de l'ouvrage par la date passée en paramètre
     * @param dateEdition String
     */
    public void setDateEdition(int dateEdition) {
        this.dateEdition = dateEdition;
    }

    /**
     * change le nombre de pages de l'ouvrage par le nombre de pages passé en paramètres
     * @param nbPage int
     */
    public void setNbPage(int nbPage) {
        this.nbPage = nbPage;
    }


    public String getLien() {
        return lien;
    }

    public void setLien(String lien) {
        this.lien = lien;
    }

    /**
     * Ajoute à la liste des Auteurs un auteur
     * @param a l'auteur à ajouter
     */

    public void addAuteur(Personne a){
        if(a!=null){
            if(!personnes.contains(a)){
                personnes.add(a);
            }
        }
    }
    /**
     * Supprime à la liste des Auteurs un auteur
     * @param a l'auteur à supprimer
     */
    public void retirerAuteur(Personne a){
        if(a!=null){
            personnes.remove(a);
        }
    }

    /**
     * Permet de verifier si 2 objets sont exactement similaires
     * @author Andreas
     * @param objet l'objet à comparer
     * @return renvoie true si les deux objets sont similaires, false sinons
     */
    @Override
    public Boolean estCLone(Ouvrage objet) {
        if(objet!=null){
            return false;
        }

        if(!objet.getCopyright().equals(this.getCopyright())){
            return false;
        }

        if(!objet.getFormat().equals(this.format)){
            return false;
        }
        if(!objet.getCreditPhoto().equals(this.creditPhoto)){
            return false;
        }
        if(!objet.getTitre().equals(this.titre)){
            return false;
        }

        if(!objet.getLieuEdition().equals(this.lieuEdition)){
            return false;
        }
        if(!objet.getResolution().equals(this.resolution)){
            return false;
        }
        if(objet.getNbPage()!=this.getNbPage()){
            return false;
        }
        if(objet.getId()!=this.id){
            return false;
        }
        if(objet.getDateEdition()!=this.dateEdition){
            return false;
        }
        for(Personne personne : this.personnes){
            if(!objet.getAuteurs().contains(personne)){
                return false;
            }
        }
        return true;
    }
    public boolean equals(Ouvrage objet){
        return this.estCLone(objet);
    }
}