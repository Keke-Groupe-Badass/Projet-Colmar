package Whole.FXPackage;

import Whole.Metadonnee;
import Whole.ccmsPackage.Lettrine;
import Whole.ccmsPackage.Tag;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;

import java.util.ResourceBundle;

public class FXModifierLettrineControleur implements Initializable {

    public Lettrine lettrine;

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

    Boolean tagSupression;
    Boolean metaSupression;





    public void valider(ActionEvent event) {
        ControleurFunctions.changeScene(event, "FxInterfaceLettrinesModifierValidation.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pageTextField.setText(""+lettrine.getNbPage());
        lienTextField.setText(lettrine.getLien());
        ouvrageTextField.setText(""+lettrine.getOuvrage().getId());
        createurTextField.setText(""+lettrine.getCreateur().getId());
        plagiatTextField.setText(""+lettrine.getIdentique());
        labelModifier.setText("Modification - Lettrine n°"+lettrine.getId());

        for(Metadonnee meta:lettrine.getMetadonnees()){
            metaListView.getItems().add(meta);
        }
        for(Tag tag:lettrine.getTags()){
            tagListView.getItems().add(tag);
        }
    }
}
