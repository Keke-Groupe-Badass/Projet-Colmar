package Whole.ccmsPackage;

import java.util.ArrayList;

/**
 * Classe représentant les ouvrages
 */
public class Ouvrage implements CCMS<Ouvrage> {
	private int id;
	private Personne libraire;
	private Personne imprimeur;
	private String lieuImpression;
	private int dateEdition;
	private String lien;
	private int nbPage;
	private String copyright;
	private String creditPhoto;
	private String resolution;
	private String format;
    private String titre;
    private ArrayList<Personne> auteurs;
	private boolean reechantillonage;

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
     * Constructeur à utiliser pour les copies uniquement
     * @param id int
     * @param libraire Personne
     * @param imprimeur Personne
     * @param lieuImpression String
     * @param dateEdition int
     * @param lien String
     * @param nbPage int
     * @param copyright String
     * @param creditPhoto String
     * @param resolution String
     * @param format String
     * @param titre String
     * @param auteurs ArrayList<Personne>
     */

    public Ouvrage(int id, Personne libraire, Personne imprimeur, String lieuImpression, int dateEdition, String lien,
			int nbPage, String copyright, String creditPhoto, String resolution, String format, String titre,
			ArrayList<Personne> personnes) {
		this.id = id;
		this.libraire = libraire;
		this.imprimeur = imprimeur;
		this.lieuImpression = lieuImpression;
		this.dateEdition = dateEdition;
		this.lien = lien;
		this.nbPage = nbPage;
		this.copyright = copyright;
		this.creditPhoto = creditPhoto;
		this.resolution = resolution;
		this.format = format;
		this.titre = titre;
		for(Personne a: auteurs){
            this.auteurs.add(a);
        }
		this.reechantillonage=reechantillonage;
	}

    /**
     * Renvoie l'id de l'ouvrage dans la base.
     * @return id int
     */
	public int getId() {
		return id;
	}

	/**
	 * Change l'id de l'ouvrage par l'id passé en paramètre.
	 * @param id id de l'ouvrage
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Renvoie l'éditeur de l'ouvrage.
	 * @return libraire
	 */
	public Personne getLibraire() {
		return libraire;
	}

	/**
	 * Change l'éditeur de l'ouvrage par l'éditeur passé en paramètre.
	 * @param libraire éditeur de l'ouvrage
	 */
	public void setLibraire(Personne libraire) {
		this.libraire = libraire;
	}

	public boolean isReechantillonage() {
		return reechantillonage;
	}

	public void setReechantillonage(boolean reechantillonage) {
		this.reechantillonage = reechantillonage;

	}

	/**
	 * Renvoie l'imprimeur de l'ouvrage.
	 * @return imprimeur
	 */
	public Personne getImprimeur() {
		return imprimeur;
	}

	/**
	 * Change l'imprimeur de l'ouvrage par l'imprimeur passé en paramètre.
	 * @param imprimeur imprimeur de l'ouvrage
	 */
	public void setImprimeur(Personne imprimeur) {
		this.imprimeur = imprimeur;
	}

	/**
	 * Renvoie le lieu d'impression de l'ouvrage.
	 * @return
	 */
	public String getLieuImpression() {
		return lieuImpression;
	}

	/**
     * Change le lieu d'impression de l'ouvrage par le lieu d'impression passé en paramètre.
     * @param lieuImpression String
     */
	public void setLieuImpression(String lieuImpression) {
		this.lieuImpression = lieuImpression;
	}

	/**
	 * Renvoie la date d'édition de l'ouvrage
	 * @return
	 */
	public int getDateEdition() {
		return dateEdition;
	}

	/**
     * Change la date d'édition de l'ouvrage par la date passée en paramètre
     * @param dateEdition String
     */
	public void setDateEdition(int dateEdition) {
		this.dateEdition = dateEdition;
	}

	/**
	 * Renvoie lien.
	 * @return lien
	 */
	public String getLien() {
		return lien;
	}

	/**
	 * Change le lien de l'ouvrage par le lien passé en paramètre.
	 * @param lien
	 */
	public void setLien(String lien) {
		this.lien = lien;
	}

	/**
	 * Renvoie le nombre de pages de l'ouvrage.
	 * @return nbPage
	 */
	public int getNbPage() {
		return nbPage;
	}

	/**
     * Change le nombre de pages de l'ouvrage par le nombre de pages passé en paramètres.
     * @param nbPage int
     */
	public void setNbPage(int nbPage) {
		this.nbPage = nbPage;
	}

	/**
	 * Renvoie le copyright de l'ouvrage.
	 * @return copyright
	 */
	public String getCopyright() {
		return copyright;
	}

	/**
	 * Change le copyright de l'ouvrage par le copyright passé en paramètres.
	 * @param copyright
	 */
	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	/**
	 * Renvoie le crédit de la photo de l'ouvrage.
	 * @return creditPhoto
	 */
	public String getCreditPhoto() {
		return creditPhoto;
	}

	/**
	 * Change le crédit de la photo de l'ouvrage par le crédit photo passé en paramètres.
	 * @param creditPhoto
	 */
	public void setCreditPhoto(String creditPhoto) {
		this.creditPhoto = creditPhoto;
	}

	/**
	 * Renvoie la résolution de l'ouvrage.
	 * @return resolution
	 */
	public String getResolution() {
		return resolution;
	}

	/**
	 * Change la résolution de l'ouvrage par la résolution passée en paramètres.
	 * @param resolution
	 */
	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	/**
	 * Renvoie le format de l'ouvrage.
	 * @return format
	 */
	public String getFormat() {
		return format;
	}

	/**
	 * Change le format de l'ouvrage par le format passé en paramètres.
	 * @param format
	 */
	public void setFormat(String format) {
		this.format = format;
	}

	/**
	 * Renvoie le titre de l'ouvrage.
	 * @return titre
	 */
	public String getTitre() {
		return titre;
	}

	/**
     * Change le titre de l'ouvrage par le titre passé en paramètre.
     * @param titre String
     */
	public void setTitre(String titre) {
		this.titre = titre;
	}

	/**
	 * Renvoie la liste d'auteurs de l'ouvrage.
	 * @return auteurs
	 */
	public ArrayList<Personne> getAuteurs() {
		return auteurs;
	}

	/**
     * Change les auteurs de l'ouvrage par les auteurs passés en paramètre.
     * @param auteurs String
     */
	public void setAuteurs(ArrayList<Personne> auteurs) {
		ArrayList<Personne> list = new ArrayList<>();
        for(Personne auteur : auteurs){
           	list.add(auteur);
        }
        this.auteurs = list;
	}

	/**
     * Ajoute à la liste des auteurs un auteur.
     * @param a l'auteur à ajouter
     */

    public void ajouterAuteur(Personne a){
        if(a!=null){
            if(!auteurs.contains(a)){
                auteurs.add(a);
            }
        }
    }
	
	/**
     * Supprime de la liste des auteurs un auteur.
     * @param a l'auteur à supprimer
     */
    public void retirerAuteur(Personne a){
        if(a!=null){
            auteurs.remove(a);
        }
    }
	
	/**
     * Permet de copier les valeurs d'un ouvrage.
     * @return la copie exacte d'un ouvrage
     */
    public Ouvrage copie(){
        return new Ouvrage(id, libraire, imprimeur, lieuImpression, dateEdition, lien, nbPage, copyright, creditPhoto, resolution, format, titre, (ArrayList<Personne>) auteurs.clone(),reechantillonage);

    }
    
    /**
     * Permet de verifier si 2 objets sont exactement similaires.
     * @param objet l'objet à comparer
     * @return renvoie true si les deux objets sont similaires, false sinon
     */
	@Override
	public Boolean estClone(Ouvrage objet) {
		if (objet==null)
            return false;
        if (!objet.getLibraire().equals(libraire))
        	return false;
        if (!objet.getImprimeur().equals(imprimeur))
        	return false;
        if (!objet.getLieuImpression().equals(lieuImpression))
        	return false;
        if (objet.getDateEdition() != dateEdition)
        	return false;
        if (!objet.getLien().equals(lien))
        	return false;
        if (objet.getNbPage() != nbPage)
        	return false;
        if (!objet.getCopyright().equals(copyright))
        	return false;
        if (!objet.getCreditPhoto().equals(creditPhoto))
        	return false;
        if (!objet.getResolution().equals(resolution))
        	return false;
        if (!objet.getFormat().equals(format))
        	return false;
        if (!objet.getTitre().equals(titre))
        	return false;
		if(objet.isReechantillonage()!=this.isReechantillonage()){
			return false;
		}
        for(Personne auteur : this.auteurs){
            if(!objet.getAuteurs().contains(auteur)){
                return false;
            }
        }
        return true;
	}
	
	/**
     * Permet de verifier si 2 objets sont exactement similaires.
     * @param objet l'objet à comparer
     * @return renvoie true si les deux objets sont similaires, false sinon
     * @see #estClone
     */
	public boolean equals(Ouvrage objet){
        return this.estClone(objet);
    }
}