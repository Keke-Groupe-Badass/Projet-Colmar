package Whole.FXPackage;

import Whole.ccmsPackage.Personne;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

public class FXPersonneRechercheControleur extends FXMenuBarAbstractControleur{

    @FXML TextField nomTextField;
    @FXML TextField prenomTextField;
    @FXML ListView<Personne> lv;

    public void retour(ActionEvent event) {
        ControleurFunctions.changeScene(event, "FxInterfacePersonnes.fxml");
    }

    public void validation(ActionEvent event) {
        Personne p = new Personne();
        if(!nomTextField.getText().isBlank()) {
            p.setNom(nomTextField.getText());
        }

        if(!prenomTextField.getText().isBlank()) {
            p.setPrenom(prenomTextField.getText());
        }

        ArrayList<Personne> arr = ControleurFunctions.personneDAO.chercher(p);
        ObservableList<Personne> observableList = lv.getItems();
        observableList.clear();
        observableList.addAll(arr);
        lv.refresh();
    }
    @FXML
    protected void itemCLick(MouseEvent event){
        Personne p= lv.getSelectionModel().getSelectedItem();
        if(p!=null){
            FXPagePersonneControleur.personne = p;
            ControleurFunctions.changeScene(event,"FxInterfacePagePersonne.fxml");
        }
    }
}
