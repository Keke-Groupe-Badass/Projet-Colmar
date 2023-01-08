package Whole.FXPackage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;

import java.net.URL;

import java.util.ResourceBundle;

public class FXModifierUtilisateur extends FXMenuBarAbstractControleur implements Initializable {

    @FXML
    Label nomLabel;
    @FXML
    PasswordField passwordField;
    @FXML
    PasswordField confirmPasswordField;
    @FXML
    ChoiceBox<String> choiceBox;
    @FXML
    Button supprimerBtn;
    String statut;
    public static String utilisateur;
    @FXML
    protected void supprimer(ActionEvent event) {
        if(!utilisateur.equals(ControleurFunctions.nom)){
            ControleurFunctions.utilisateurDAO.supprimerUtilisateur(ControleurFunctions.nom);
            ControleurFunctions.changeScene(event,"FxInterfaceMain.fxml");
        }
    }
    @FXML
    protected void valider(ActionEvent event) {
        if(passwordField.getText()!=null){
            if(passwordField.getText().equals(confirmPasswordField.getText())){
                ControleurFunctions.utilisateurDAO.changeMDP(utilisateur,passwordField.getText());
                ControleurFunctions.utilisateurDAO.changeStatut(utilisateur,choiceBox.getValue());
                ControleurFunctions.adminDAO.ecrireLog("à créer modifier utilisateur "+utilisateur);

                ControleurFunctions.changeScene(event,"FxInterfaceMain.fxml");
            }
        }
    }
    @FXML
    protected void annuler(ActionEvent event) {
        ControleurFunctions.changeScene(event,"FxInterfaceMain.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nomLabel.setText(utilisateur);
        ObservableList<String> options = FXCollections.observableArrayList("chercheur","modo","admin");
        statut = ControleurFunctions.utilisateurDAO.obtenirStatut(utilisateur);
        choiceBox.setValue(statut);
        choiceBox.setItems(options);
        if(!ControleurFunctions.statut.equals("admin")){
            choiceBox.setDisable(true);
            supprimerBtn.setDisable(true);
        }else if(ControleurFunctions.nom.equals(utilisateur)){
            choiceBox.setDisable(true);
            supprimerBtn.setDisable(true);
        }
        if(statut.equals("admin")){
            choiceBox.setDisable(true);
            supprimerBtn.setDisable(true);
        }
    }
}
