package Whole.FXPackage;

import Whole.Metadonnee;
import Whole.ccmsPackage.Lettrine;
import Whole.ccmsPackage.Tag;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;

import java.net.URL;

import java.util.ResourceBundle;

public class FXPageLettrineControleur implements Initializable {
    public static Lettrine lettrine =new Lettrine();
    @FXML
    Button modifierBtn;
    @FXML
    Button retourBtn;
    @FXML
    Label nbPageLabel;
    @FXML
    Label lienLabel;
    @FXML
    Button ouvrageBtn;
    @FXML
    Button createurBtn;
    @FXML
    Label plagiatLabel;
    @FXML
    Label labelModifier;
    @FXML
    ListView<Metadonnee> metaListView;
    @FXML
    ListView<Tag> tagListView;
    ObservableList<Tag> listTag = FXCollections.observableArrayList();
    ObservableList<Metadonnee> listMeta = FXCollections.observableArrayList();
    @FXML
    ImageView imageLettrine;
    @FXML
    public void modifierScene(ActionEvent event) {
        FXModifierLettrineControleur.lettrine=lettrine;
        ControleurFunctions.changeScene(event, "FxInterfaceModifierLettrine.fxml");
    }

    public void retour(ActionEvent event) {
        ControleurFunctions.changeScene(event, "FxInterfaceLettrines.fxml");
    }

    public void afficheLettrinesParTagname(ActionEvent event) {
        ControleurFunctions.changeScene(event, "FxInterfaceLettrines.fxml");
    }

    public void personnePage(ActionEvent event) {
        ControleurFunctions.changeScene(event, "FxInterfacePagePersonne.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nbPageLabel.setText(""+lettrine.getNbPage());
        lienLabel.setText(lettrine.getLien());
        if(lettrine.getOuvrage()!=null){
            ouvrageBtn.setText(""+lettrine.getOuvrage().toString());
        }
        if(lettrine.getCreateur()!=null){
            createurBtn.setText(""+lettrine.getCreateur().toString());
        }
        plagiatLabel.setText(""+lettrine.getIdentique());
        labelModifier.setText("Lettrine n°"+lettrine.getId());

        for(Metadonnee meta:lettrine.getMetadonnees()){
            listMeta.add(meta);
        }
        metaListView.setItems(listMeta);
        for(Tag tag:lettrine.getTags()){
            listTag.add(tag);
        }
        tagListView.setItems(listTag);
        imageLettrine.setImage(lettrine.getImage());
    }
    @FXML
    protected void clickOnTag(ActionEvent event) {
        Tag t = tagListView.getSelectionModel().getSelectedItem();
        if(t!=null){
            //TODO CHANGE TO TAG PAGE of the Tag T
            ControleurFunctions.changeScene(event, ".fxml");
        }
    }
}
