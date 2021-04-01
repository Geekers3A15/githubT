/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Entités.user;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Sawssen Gharbi
 */
public class ListeCommandesUserController implements Initializable {

    @FXML
    private Label nomPrenomLabel;
    @FXML
    private Label pseudLabelAlt;
    @FXML
    private Label modifierProfil;
    @FXML
    private VBox idvWeblog;
    @FXML
    private ScrollPane idScrollpane;
    @FXML
    private GridPane idGridPane;
    @FXML
    private Button Afficherbtn;
    user currentUser;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void initData(user u) {
        this.currentUser = u;
        System.out.println("identifiant: " + u.getId_user().get());
        nomPrenomLabel.setText("Bienvenue " + currentUser.getNom().getValue() + " " + currentUser.getPrenom().getValue());
        pseudLabelAlt.setText("@" + currentUser.getPseudo().getValue());

    }

    @FXML
    private void handle_modfierProfil(MouseEvent event) {
    }

    @FXML
    private void handle_weblog(MouseEvent event) {
    }

    @FXML
    private void handle_afficherBtn(MouseEvent event) {
    }
}
