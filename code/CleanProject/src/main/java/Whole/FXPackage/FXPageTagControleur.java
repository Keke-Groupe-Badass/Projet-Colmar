package Whole.FXPackage;

import Whole.ccmsPackage.Lettrine;
import Whole.ccmsPackage.Tag;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class FXPageTagControleur implements Initializable {
    public static Tag tag;
    @FXML
    ListView<Lettrine> listView;
    @FXML
    Label nomLabel;
    @FXML
    Label idLabel;
    @FXML
    Label descriptionLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nomLabel.setText(tag.getNom());
        idLabel.setText(idLabel.getText()+tag.getId());
        descriptionLabel.setText(tag.getDescription());
        listView.getItems().addAll(ControleurFunctions.tagDAO.lettrinesAssociees(tag));
    }
    @FXML
    protected void clickOnTag(ActionEvent event) {
        Lettrine l = listView.getSelectionModel().getSelectedItem();
        if(l!=null){
            FXPageLettrineControleur.lettrine = l;
            ControleurFunctions.changeScene(event, "FxInterfacePageLettrine.fxml");
        }
    }
    @FXML
    protected void retour(ActionEvent event) {
        ControleurFunctions.changeScene(event, "FxInterfaceTags.fxml");
    }
    @FXML
    protected void modifierScene(ActionEvent event) {
        FXModifierTagsControleur.tag=tag;
        ControleurFunctions.changeScene(event, "FxInterfaceModifierTag.fxml");
    }

}
