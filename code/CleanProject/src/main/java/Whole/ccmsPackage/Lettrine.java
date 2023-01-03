package Whole.ccmsPackage;

import Whole.Metadonnee;

import javafx.scene.image.Image;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.ArrayList;

/**
 * Classe représentant les lettrines
 */
public class Lettrine implements CCMS<Lettrine> {
    /**
     * L'ouvrage dans lequel se trouve la lettrine
     */
    private Ouvrage ouvrage;

    /**
     * Liste des métadonnées associées à la lettrine
     * @see Metadonnee
     */
    private ArrayList<Metadonnee> metadonnees;

    /**
     * numéro de la page sur laquelle figure la lettrine
     */
    private int nbPage;

    /**
     * id de la lettrine dans la base
     */
    private int id;

    /**
     * Liste des tags associés à la lettrine
     */
    private ArrayList<Tag> tags;
    /**
     * Le lien web de la lettrine
     */
    private String lien;

    /**
     * La personne qui a créé la lettrine
     */
    private Personne createur;

    /**
     * L'identifiant du groupe de lettrine identique
     */
    private int identique;


    /**
     * Constructeur de la classe Lettrine
     * @param ouvrage Ouvrage
     * @param metadonnees ArrayList<Metadonnee>
     * @param nbPage int
     * @param id int
     * @param tags ArrayList<Tag>
     */
    @Deprecated
    public Lettrine(Ouvrage ouvrage, ArrayList<Metadonnee> metadonnees, int nbPage, int id, ArrayList<Tag> tags, String lien) {
        this.ouvrage = ouvrage;
        this.metadonnees = metadonnees;
        this.nbPage = nbPage;
        this.id = id;
        this.tags = tags;
        this.lien = lien;
    }
    /**
     * Constructeur de la classe Lettrine
     * @param ouvrage Ouvrage
     * @param metadonnees ArrayList<Metadonnee>
     * @param nbPage int
     * @param id int
     * @param tags ArrayList<Tag>
     * @param identique le groupe de lettrine identique au quel la lettrine appartient
     * @param personne le créateur de la lettrine
     */
    public Lettrine(Ouvrage ouvrage, ArrayList<Metadonnee> metadonnees, int nbPage, int id, ArrayList<Tag> tags, String lien, int identique, Personne personne) {
        this.ouvrage = ouvrage;
        this.metadonnees = metadonnees;
        this.nbPage = nbPage;
        this.id = id;
        this.tags = tags;
        this.lien = lien;
        this.identique=identique;
        this.createur=personne;
    }


    /**.
     * Constructeur à utiliser pour les instances de changement
     */
    public Lettrine(){
        this.ouvrage = null;
        this.metadonnees = new ArrayList<>();
        this.nbPage = -2;
        this.id = -2;
        this.lien = null;
        this.tags=new ArrayList<>();
    }

    /**
     * Constructeur lors de la création d'une lettrine pour la première fois
     * @param ouvrage
     * @param nbPage
     * @param lien
     * @param createur
     * @param identique
     */
    public Lettrine(Ouvrage ouvrage, int nbPage, String lien, Personne createur, int identique) {
        this.ouvrage = ouvrage;
        this.nbPage = nbPage;
        this.lien = lien;
        this.createur = createur;
        this.identique = identique;
        this.tags=new ArrayList<>();
        this.metadonnees=new ArrayList<>();
    }

    /**.
     * Renvoie un objet de type Ouvrage
     * @return ouvrage
     */
    public Ouvrage getOuvrage() {
        return ouvrage;
    }

    /**.
     * Renvoie la liste des métadonnées associées à la lettrine
     * @return ArrayList<Metadonnees> liste des métadonnées associés
     * @see Metadonnee
     */
    public ArrayList<Metadonnee> getMetadonnees() {
        return metadonnees;
    }

    /**
     * Renvoie le numéro de la page sur laquelle la lettrine figure. Si le numero de page de la lettrine
     * est inconue : return -1
     * @return nbPage
     */
    public int getNbPage() {
        return nbPage;
    }

    /**
     * Renvoie l'id de la lettrine dans la base de données
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Renvoie la liste des tags associés à la lettrine
     * @return tags
     */
    public ArrayList<Tag> getTags() {
        return tags;
    }

    /**
     * renvoie le lien de la métadonnée
     * @return lien String : lien  de la métadonnée
     */
    public String getLien() {
        return lien;
    }

    /**
     * permet de modifier la valeur de l'ouvrage par l'objet en paramètre
     * @param ouvrage Ouvrage : nouvelle valeur de ouvrage
     */
    public void setOuvrage(Ouvrage ouvrage) {
        this.ouvrage = ouvrage;
    }

    /**
     * permet de modifier la valeur du numéro de la page par l'objet en paramètre
     * @param nbPage int : nouvelle valeur de nbPage. Si on ne connait pas le numéro de la page sur
     *                     laquelle la lettrine figure, nbPage = -1
     */
    public void setNbPage(int nbPage) {
        this.nbPage = nbPage;
    }


    /**
     * Remplace la valeur actuelle de metadonnees par la valeur passée en paramètre
     * @param metadonnees : ArrayList de métadonnées qui vient remplacer la valeur actuelle
     */
    public void setMetadonnees(ArrayList<Metadonnee> metadonnees) {
        this.metadonnees = new ArrayList<>();
        for(Metadonnee meta : metadonnees){
            this.metadonnees.add(meta);
        }
    }

    /**
     * Change la valeur de l'id
     * @param id Le nouvel identifiant de la lettrine
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Permet de donner une nouvelle liste comme tags sans lier la liste donnée en paramètre à la liste de la lettrine
     * @param tags la liste des tags lié à la lettrine
     */
    public void setTags(ArrayList<Tag> tags) {
        this.tags = new ArrayList<>();
        for(Tag tag : tags){
            this.tags.add(tag);
        }
    }

    public void setLien(String lien) {
        this.lien = lien;
    }

    public Personne getCreateur() {
        return createur;
    }

    public void setCreateur(Personne createur) {
        this.createur = createur;
    }

    public int getIdentique() {
        return identique;
    }

    public void setIdentique(int identique) {
        this.identique = identique;
    }

    /**
     * Cette methode permet d'ajouter la m�tadonn�e pass�e en param�tre � la lettrine.
     *Elle affecte la liste de m�tadonn�es metadonnees en y ajoutant la m�tadonn�e pass�e en param�tre.
     * @author Maxime
     * @param meta Metadonnee : metadonn�e � ajouter
     * @see Metadonnee
     */
    public void ajouterMetadonnees(Metadonnee meta) {
        if(meta!=null){
            if(metadonnees.contains(meta)==false) {
                metadonnees.add(meta);
            }
        }
    }

    /**
     * Cette m�thode permet de supprimer la m�tadonn�e pass�e en param�tre � la lettrine.
     * Elle affecte la liste de m�tadonn�es metadonnees en en retirant la m�tadonn�e pass�e en param�tre.
     * @author Maxime
     * @param meta : m�tadonn�e � supprimer
     * @see Metadonnee
     */
    public void supprimerMetadonnees(Metadonnee meta) {
            metadonnees.remove(meta);
    }

    /**
     * Permet de verifier si 2 objets sont exactement similaires
     * @author Andreas
     * @param objet l'objet à comparer
     * @return renvoie true si les deux objets sont similaires, false sinon
     */
    @Override
    public Boolean estClone(Lettrine objet) {
        if(objet==null){
            return false;
        }
        if(!objet.getLien().equals(this.getLien())){
            return false;
        }
        if(objet.getOuvrage()!=null){
            if(!objet.getOuvrage().equals(this.getOuvrage())){
                return false;
            }
        }
        if(objet.getId()!=this.getId()){
            return false;
        }
        if(objet.getCreateur()!=null){
            if(!objet.getCreateur().equals(this.createur)){
                return false;
            }
        }
        if(objet.getIdentique()!=this.identique){
            return false;
        }
        if(objet.getNbPage()!=this.getNbPage()){
            return false;
        }
        for(Tag tag: this.tags){
            if(!objet.getTags().contains(tag)){
                return false;
            }
        }
        for(Metadonnee meta: metadonnees){
            if(!objet.getMetadonnees().contains(meta)){
                return false;
            }
        }
        return true;
    }
    public boolean equals(Lettrine objet){
        return this.estClone(objet);
    }

    /**
     * Permet d'obtenir l'image d'une Lettrine
     * @return L'image si le lien est valide, sinon une lettrine par défaut et si problème
     * il y avec l'image alors null.
     */
    public Image getImage(){
        return loadImageFromWeb();
    }
    public Image loadImageFromWeb(){
        Image img;
        try {
             img = new Image(new FileInputStream(lien));
        } catch (IOException e) {
            try {
                img = new Image(new FileInputStream("src/lettrine.png"));
            } catch (FileNotFoundException ex) {
                img = null;
            }
        }
        return img;
    }

    /**
     * Permet de lire une image en locale
     * @param path le lien vers l'image
     * @return l'image si le fichier est trouvé et est une image sinon null
     * @deprecated
     */
    public BufferedImage loadImageFromFile(String path){
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            return null;
        }
    }
}