package Whole.FXPackage;

import Whole.Metadonnee;
import Whole.ccmsPackage.Lettrine;
import Whole.ccmsPackage.Ouvrage;
import Whole.ccmsPackage.Personne;
import Whole.ccmsPackage.Tag;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.net.URL;

import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class FXModifierLettrineControleur extends FXMenuBarAbstractControleur implements Initializable {

    public static Lettrine lettrine;

    @FXML
    Label labelModifier;
    @FXML
    TextField pageTextField;
    @FXML
    TextField lienTextField;
    @FXML
    TextField ouvrageTextField;
    @FXML
    TextField createurTextField;
    @FXML
    TextField plagiatTextField;
    @FXML
    Button annulerBtn;
    @FXML
    Button confirmerBtn;
    @FXML
    TextField tagTextField;
    @FXML
    Button ajouterTagBtn;
    @FXML
    TextField nomMetaTextField;
    @FXML
    TextField valeurMetaTextField;
    @FXML
    TextField uniteValeurMetaTextField;
    @FXML
    TextField descriptionMetaTextField;
    @FXML
    Button ajouterMetaBtn;
    @FXML
    CheckBox suppresionMeta;
    @FXML
    CheckBox suppresionTag;
    @FXML
    ListView<Metadonnee> metaListView;
    @FXML
    ListView<Tag> tagListView;

    ArrayList<Tag> newTag = new ArrayList<>();
    ArrayList<Metadonnee> newMeta = new ArrayList<>();

    ArrayList<Tag> removeTag = new ArrayList<>();
    ArrayList<Metadonnee> removeMeta = new ArrayList<>();

    ObservableList<Tag> listTag = FXCollections.observableArrayList();
    ObservableList<Metadonnee> listMeta = FXCollections.observableArrayList();
    @FXML
    Button supprimerBtn;

    @FXML
    public void valider(ActionEvent event) {
        Lettrine newLettrine = new Lettrine();
        if(pageTextField.getText()==null){
            newLettrine.setNbPage(-1);
        }else {
            newLettrine.setNbPage(Integer.parseInt(pageTextField.getText()));
        }

        if(plagiatTextField.getText()==null){
            newLettrine.setIdentique(0);
        }else{
            newLettrine.setIdentique(Integer.parseInt(plagiatTextField.getText()));
        }

        newLettrine.setLien(lienTextField.getText());
        if(ouvrageTextField.getText()!=null){
            try{
                newLettrine.setOuvrage(new Ouvrage(Integer.parseInt(ouvrageTextField.getText())));
            }catch (NumberFormatException exception){

            }
        }
        if(createurTextField.getText()!=null){
            try{
                newLettrine.setCreateur(new Personne(Integer.parseInt(createurTextField.getText())));
            }catch (NumberFormatException exception){

            }
        }

        if(ControleurFunctions.lettrineDAO.modifier(lettrine,newLettrine)){


            for(Tag tag : newTag){
                tag = ControleurFunctions.tagDAO.getTag(tag.getId());
                ControleurFunctions.lettrineDAO.taguer(lettrine,tag);
                lettrine.ajouterTag(tag);
            }
            for(Tag tag : removeTag){
                ControleurFunctions.lettrineDAO.detaguer(lettrine,tag);
                lettrine.retirerTag(tag);
            }
            for(Metadonnee meta : newMeta){
                meta.setIdLettrine(lettrine.getId());
                ControleurFunctions.lettrineDAO.ajouterMeta(meta);
                lettrine.ajouterMetadonnees(meta);
            }
            for(Metadonnee meta : removeMeta){
                ControleurFunctions.lettrineDAO.supprimerMeta(meta);
                lettrine.supprimerMetadonnees(meta);
            }
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Lettrine Modifiée");
            alert.setHeaderText(null);
            alert.setContentText("La lettrine à été modifiée.");
            alert.showAndWait();
            newLettrine.setTags(lettrine.getTags());
            newLettrine.setMetadonnees(lettrine.getMetadonnees());
            newLettrine.setId(lettrine.getId());
            FXPageLettrineControleur.lettrine = newLettrine;
            ControleurFunctions.adminDAO.ecrireLog("à modifier lettrine "+lettrine.getId());


            ControleurFunctions.changeScene(event, "FxInterfacePageLettrine.fxml");
        }else{

        }
    }
    @FXML
    protected void annuler(ActionEvent event){
        ControleurFunctions.changeScene(event, "FxInterfacePageLettrine.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pageTextField.setText(""+lettrine.getNbPage());
        lienTextField.setText(lettrine.getLien());
        if(lettrine.getOuvrage()!=null){
            ouvrageTextField.setText(""+lettrine.getOuvrage().getId());
        }
        if(lettrine.getCreateur()!=null){
            createurTextField.setText(""+lettrine.getCreateur().getId());
        }
        plagiatTextField.setText(""+lettrine.getIdentique());
        labelModifier.setText("Modification - Lettrine n°"+lettrine.getId());

        for(Metadonnee meta:lettrine.getMetadonnees()){
            listMeta.add(meta);
        }
        metaListView.setItems(listMeta);
        for(Tag tag:lettrine.getTags()){
            listTag.add(tag);
        }
        tagListView.setItems(listTag);
    }
    @FXML
    protected void ajouterTag(ActionEvent event){
        if(tagTextField.getText()!=null){
            Tag t = new Tag(Integer.parseInt(tagTextField.getText()));
            if(!listTag.contains(t)){
                newTag.add(t);
                listTag.add(t);
                tagListView.refresh();
            }
        }
    }
    @FXML
    protected void ajouterMeta(ActionEvent event){
        if(nomMetaTextField.getText()!=null){
            Metadonnee m = new Metadonnee(nomMetaTextField.getText(),valeurMetaTextField.getText(),uniteValeurMetaTextField.getText(),descriptionMetaTextField.getText());
            newMeta.add(m);
            listMeta.add(m);
            metaListView.refresh();
            ControleurFunctions.adminDAO.ecrireLog("à crée "+m.getId());

        }
    }
    @FXML
    protected void clickListViewTag(MouseEvent event){
        if(suppresionTag.isSelected()){
            Tag t = tagListView.getSelectionModel().getSelectedItem();
            if(newTag.contains(t)){
                newTag.remove(t);
            }
            else{
                removeTag.add(t);
            }
            listTag.remove(t);
            tagListView.refresh();
        }
    }
    @FXML
    protected void clickListViewMeta(MouseEvent event){
        if(suppresionMeta.isSelected()){
            Metadonnee m = metaListView.getSelectionModel().getSelectedItem();
            if(newMeta.contains(m)){
                newMeta.remove(m);
            }
            else{
                removeMeta.add(m);
            }
            listMeta.remove(m);
            metaListView.refresh();
        }
    }
    @FXML
    protected void supprimer(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Supprimer");
        alert.setHeaderText("Voulez-vous vraiment supprimer cette lettrine?");
        alert.setContentText("Cette action est irreversible");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            if(ControleurFunctions.lettrineDAO.supprimer(lettrine)){
                ControleurFunctions.adminDAO.ecrireLog("à supprimer lettrine "+lettrine.getId());

                ControleurFunctions.changeScene(event, "FxInterfaceLettrines.fxml");
            }
        } else {
            // ... user chose CANCEL or closed the dialog
        }

    }

}
