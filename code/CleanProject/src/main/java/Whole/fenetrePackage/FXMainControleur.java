package Whole.fenetrePackage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class FXMainControleur {
    private FXInterface fx;
    @FXML
    protected void handleModifierOuvrageAction(ActionEvent event) {
        try {
            fx.changeScene("FxInterfaceModifierOuvrage");
        } catch (IOException e) {
            fx.afficherMessage(new String[] {"Erreur","Impossible d'accder à cette page"});
        }
    }
    @FXML
    protected void handleModifierTagAction(ActionEvent event) {
        try {
            fx.changeScene("FxInterfaceModifierTag");
        } catch (IOException e) {
            fx.afficherMessage(new String[] {"Erreur","Impossible d'accder à cette page"});
        }
    }
    @FXML
    protected void handleModifierPersonneAction(ActionEvent event) {
        try {
            fx.changeScene("FxInterfaceModifierPersonne");
        } catch (IOException e) {
            fx.afficherMessage(new String[] {"Erreur","Impossible d'accder à cette page"});
        }
    }
    @FXML
    protected void handleModifierLettrineAction(ActionEvent event) {
        try {
            fx.changeScene("FxInterfaceModifierLettrine");
        } catch (IOException e) {
            fx.afficherMessage(new String[] {"Erreur","Impossible d'accder à cette page"});
        }
    }
    @FXML
    protected void handleCreerOuvrageAction(ActionEvent event) {
        try {
            fx.changeScene("FxInterfaceCreerOuvrage");
        } catch (IOException e) {
            fx.afficherMessage(new String[] {"Erreur","Impossible d'accder à cette page"});
        }
    }
    @FXML
    protected void handleCreerTagAction(ActionEvent event) {
        try {
            fx.changeScene("FxInterfaceCreerTag");
        } catch (IOException e) {
            fx.afficherMessage(new String[] {"Erreur","Impossible d'accder à cette page"});
        }
    }
    @FXML
    protected void handleCreerPersonneAction(ActionEvent event) {
        try {
            fx.changeScene("FxInterfaceCreerPersonne");
        } catch (IOException e) {
            fx.afficherMessage(new String[] {"Erreur","Impossible d'accder à cette page"});
        }
    }
    @FXML
    protected void handleCreerLettrineAction(ActionEvent event) {
        try {
            fx.changeScene("FxInterfaceCreerLettrine");
        } catch (IOException e) {
            fx.afficherMessage(new String[] {"Erreur","Impossible d'accder à cette page"});
        }
    }
    @FXML
    protected void handleProfilOuvrageAction(ActionEvent event) {
        try {
            fx.changeScene("FxInterfaceProfilOuvrage");
        } catch (IOException e) {
            fx.afficherMessage(new String[] {"Erreur","Impossible d'accder à cette page"});
        }
    }
    @FXML
    protected void handleProfilTagAction(ActionEvent event) {
        try {
            fx.changeScene("FxInterfaceProfilTag");
        } catch (IOException e) {
            fx.afficherMessage(new String[] {"Erreur","Impossible d'accder à cette page"});
        }
    }
    @FXML
    protected void handleProfilPersonneAction(ActionEvent event) {
        try {
            fx.changeScene("FxInterfaceProfilPersonne");
        } catch (IOException e) {
            fx.afficherMessage(new String[] {"Erreur","Impossible d'accder à cette page"});
        }
    }
    @FXML
    protected void handleProfilLettrineAction(ActionEvent event) {
        try {
            fx.changeScene("FxInterfaceProfilLettrine");
        } catch (IOException e) {
            fx.afficherMessage(new String[] {"Erreur","Impossible d'accder à cette page"});
        }
    }
}