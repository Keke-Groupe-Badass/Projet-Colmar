package Whole.FXPackage;

import Whole.ccmsPackage.Lettrine;
import Whole.ccmsPackage.Tag;

import Whole.daoPackage.LettrineDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class FXPageTagControleur extends FXMenuBarAbstractControleur implements Initializable {
    public static Tag tag;
    @FXML
    ListView<Lettrine> listView;
    @FXML
    Label nomLabel;
    @FXML
    Label idLabel;
    @FXML
    Label descriptionLabel;
    @FXML
    Button modifierBtn;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nomLabel.setText(tag.getNom());
        idLabel.setText(idLabel.getText()+tag.getId());
        descriptionLabel.setText(tag.getDescription());
        ArrayList<Lettrine> prelist =  ControleurFunctions.tagDAO.lettrinesAssociees(tag);
        ArrayList<Lettrine> listLettrine = new ArrayList<>();
        for(Lettrine lettrine : prelist){
            listLettrine.add(ControleurFunctions.lettrineDAO.chercher(lettrine).get(0));
        }
        listView.getItems().addAll(listLettrine);
        if(ControleurFunctions.statut.equals("chercheur")){
            modifierBtn.setDisable(true);
        }
    }
    @FXML
    protected void clickOnTag(MouseEvent event) {
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
