package Whole.FXPackage;

import Whole.ccmsPackage.Lettrine;
import Whole.ccmsPackage.Ouvrage;
import Whole.ccmsPackage.Personne;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class FXChercherUtilisateur {
    @FXML
    TextField emailTextField;
    @FXML
    ListView<String> listView;
    @FXML
    public void retourForm(ActionEvent event) {
        ControleurFunctions.changeScene(event, "FxInterfaceMain.fxml");
    }
    @FXML
    protected void chercher(ActionEvent event){
        if(!emailTextField.getText().isBlank()){
            ArrayList<String> list = ControleurFunctions.utilisateurDAO.chercher(emailTextField.getText());
            ObservableList observableList = listView.getItems();
            observableList.clear();
            observableList.addAll(list);
            listView.refresh();
        }

    }
    @FXML
    protected void itemCLick(ActionEvent event){
        String email = listView.getSelectionModel().getSelectedItem();
        FXModifierUtilisateur.utilisateur=email;
        ControleurFunctions.changeScene(event,"FxInterfaceModifierUtilisateur.fxml");
    }
}
