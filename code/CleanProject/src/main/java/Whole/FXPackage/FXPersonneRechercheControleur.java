package Whole.FXPackage;

import Whole.ccmsPackage.Personne;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class FXPersonneRechercheControleur {

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

    protected void itemCLick(ActionEvent event){
        FXPagePersonneControleur.personne= lv.getSelectionModel().getSelectedItem();
        ControleurFunctions.changeScene(event,"FxInterfacePagePersonne.fxml");
    }
}
