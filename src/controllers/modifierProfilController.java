/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Entités.user;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import Service.userService;

/**
 * FXML Controller class
 *
 * @author Sawssen Gharbi
 */
public class modifierProfilController implements Initializable {

    @FXML
    private Label modifierProfil;
    user currentUser;
    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfPrenom;
    @FXML
    private TextField tfPseduo;
    @FXML
    private TextField tfTelep;
    @FXML
    private TextField tfEmail;

    @FXML
    private Button btnEnregistrer;
    @FXML
    private Label nomPrenomLabel;
    @FXML
    private Label pseudLabelAlt;
    @FXML
    private TextArea tabio;
    @FXML
    private TextField tfDate;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tabio.setWrapText(true);
       
    }

    public void initData(user u) {
        this.currentUser = u;
        System.out.println("identifiant : " + u.getId_user().get());
        tfNom.setText(currentUser.getNom().get());
        tfPrenom.setText(currentUser.getPrenom().get());
        tfPseduo.setText(currentUser.getPseudo().get());
        tfTelep.setText(String.valueOf(currentUser.getTel().get()));
        tfDate.setText(currentUser.getDate_naiss().get());
        tfEmail.setText(currentUser.getEmail().get());
        tabio.setText(currentUser.getBio().get());
        nomPrenomLabel.setText("Bienvenue " + currentUser.getNom().getValue() + " " + currentUser.getPrenom().getValue());
        pseudLabelAlt.setText("@" + currentUser.getPseudo().getValue());

    }

    @FXML
    private void handle_modfierProfil(MouseEvent event) {

    }

    @FXML
    private void handle_enregistrement(ActionEvent event) {
        userService us = userService.getInstance();
        user u = new user(currentUser.getId_user());

        if (event.getSource() == btnEnregistrer) {
            if (tfNom.getText().equals("") || tfPrenom.getText().equals("") || tfPseduo.getText().equals("") || tfDate.getText().equals("") || tfTelep.getText().equals("") || tfEmail.getText().equals("") || tabio.getText().equals("")) {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Boîte d'avertissement ");
                alert.setContentText("Vérifier que tous les champs sont remplis!");

                alert.showAndWait();
            } else {
                u.setNom(tfNom.getText());
                u.setPrenom(tfPrenom.getText());
                u.setPseudo(tfPseduo.getText());
                u.setDate_naiss(tfDate.getText());
                u.setTel(tfTelep.getText());
                u.setEmail(tfEmail.getText());
                u.setBio(tabio.getText());

                us.updateUser(u);
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Boîte d'information");
                alert.setHeaderText(null);
                alert.setContentText("Changements effectué avec succès!!");
                //alert.setX(800);
                //alert.setY(70);

                alert.showAndWait();

            }
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
    private void handle_profil(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/views/profil.fxml"));
            Parent page2 = loader.load();
            profilController controller = loader.getController();
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
