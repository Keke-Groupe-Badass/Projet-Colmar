package Whole.FXPackage;

import Whole.Controleur;
import Whole.SingleConnection;
import Whole.daoPackage.*;
import Whole.exceptionPackage.mauvaisMDPException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import java.net.URL;

import java.sql.Connection;
import java.util.ResourceBundle;

public class FXLoginControleur implements Initializable {
    static String dbName;
    @FXML
    TextField mailTextField;
    @FXML
    PasswordField passwordTextField;
    @FXML
    TextField dbTextField;
    @FXML
    public void changementDeScene(ActionEvent event) throws mauvaisMDPException {
        try {
            if(dbTextField.getText()!=null){
                if(!dbTextField.getText().trim().isEmpty()){
                    Controleur.getConfigList().set(0,dbTextField.getText());
                }
            }
            Connection cn = SingleConnection.getInstance(Controleur.getConfigList().get(0),Controleur.getConfigList().get(1),Controleur.getConfigList().get(2));
            if(cn != null){

                ControleurFunctions.nom = mailTextField.getText();
                ControleurFunctions.lettrineDAO = new LettrineDAO(Controleur.getConfigList().get(0),Controleur.getConfigList().get(1),Controleur.getConfigList().get(2));
                ControleurFunctions.tagDAO = new TagDAO(Controleur.getConfigList().get(0),Controleur.getConfigList().get(1),Controleur.getConfigList().get(2));
                ControleurFunctions.ouvrageDAO = new OuvrageDAO(Controleur.getConfigList().get(0),Controleur.getConfigList().get(1),Controleur.getConfigList().get(2));
                ControleurFunctions.personneDAO = new PersonneDAO(Controleur.getConfigList().get(0),Controleur.getConfigList().get(1),Controleur.getConfigList().get(2));
                ControleurFunctions.adminDAO = new AdminDAO(Controleur.getConfigList().get(0),Controleur.getConfigList().get(1),Controleur.getConfigList().get(2));
                ControleurFunctions.utilisateurDAO = new UtilisateurDAO(Controleur.getConfigList().get(0),Controleur.getConfigList().get(1),Controleur.getConfigList().get(2));
                ControleurFunctions.statut = ControleurFunctions.utilisateurDAO.obtenirStatut(ControleurFunctions.nom);
                ControleurFunctions.adminDAO.setNom(mailTextField.getText());
                if(ControleurFunctions.utilisateurDAO.connexion(mailTextField.getText(),passwordTextField.getText())!=null){
                    ControleurFunctions.adminDAO.ecrireLog("c'est connecté");
                    Parent root = FXMLLoader.load(FXMain.class.getResource("/FXPackage/FxInterfaceMain.fxml"));
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }


                if(ControleurFunctions.statut==null){
                    ControleurFunctions.statut = "chercheur";
                }
            }
            else{
                throw new mauvaisMDPException();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ControleurFunctions.statut = "chercheur";
        dbTextField.setText(dbName);
    }
}
