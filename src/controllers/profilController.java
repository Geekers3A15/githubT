/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Entités.user;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import Service.userService;

/**
 * FXML Controller class
 *
 * @author Sawssen Gharbi
 */
public class profilController implements Initializable {

    @FXML
    private Label nomLabel;
    @FXML
    private Label prenomLabel;
    @FXML
    private Label pseudoLabel;
    @FXML
    private Label dateLabel;
    @FXML
    private Label telLabel;
    @FXML
    private Label mailLabel;
    @FXML
    private Label bioLabel;

    user currentUser;
    @FXML
    private Label nomPrenomLabel;
    @FXML
    private Label pseudLabelAlt;
    @FXML
    private Label modifierProfil;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        

    }
     public void initData(user u) {
        this.currentUser = u;
        System.out.println("identifiant : " + u.getId_user().get());
        userService us = userService.getInstance();
        currentUser = us.getUserById(currentUser.getId_user().get());
        nomPrenomLabel.setText("Bienvenue " + currentUser.getNom().getValue() + " " + currentUser.getPrenom().getValue());
        pseudLabelAlt.setText("@" + currentUser.getPseudo().getValue());
        nomLabel.setText(currentUser.getNom().getValue());
        prenomLabel.setText(currentUser.getPrenom().getValue());
        pseudoLabel.setText(currentUser.getPseudo().getValue());
        dateLabel.setText(currentUser.getDate_naiss().getValue());
        telLabel.setText(currentUser.getTel().getValue());
        mailLabel.setText(currentUser.getEmail().getValue());
        bioLabel.setText(currentUser.getBio().getValue());
     }

    @FXML
    private void handle_modfierProfil(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/views/modifierProfil.fxml"));
            Parent page2 = loader.load();
            modifierProfilController controller = loader.getController();
            controller.initData(currentUser);
            Scene scene = new Scene(page2);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);

            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(modifierProfilController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void handle_weblog(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/views/weblog.fxml"));
            Parent page2 = loader.load();
            weblogController controller = loader.getController();
            controller.initData(currentUser);
            Scene scene = new Scene(page2);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);

            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(weblogController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void handle_NomPrenomPseudo(MouseEvent event) {
        nomPrenomLabel.setText("Bienvenue " + currentUser.getNom().getValue() + " " + currentUser.getPrenom().getValue());
        pseudLabelAlt.setText("@" + currentUser.getPseudo().getValue());
    }

    @FXML
    private void handle_listecommandes(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/views/listeCommandes.fxml"));
            Parent page2 = loader.load();
            ListeCommandesController controller = loader.getController();
            controller.initData(currentUser);
            Scene scene = new Scene(page2);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);

            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(weblogController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
