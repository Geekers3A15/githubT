/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entités.user;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import services.userService;

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

    }

    @FXML
    private void handle_modfierProfil(MouseEvent event) {

    }

    @FXML
    private void handle_enregistrement(ActionEvent event) {
        userService us = userService.getInstance();
        user u = new user(currentUser.getId_user());

        if (event.getSource() == btnEnregistrer) {
            if (tfNom.getText().equals("")||tfPrenom.getText().equals("") ||tfPseduo.getText().equals("")||tfDate.getText().equals("")|| tfTelep.getText().equals("")||tfEmail.getText().equals("")||tabio.getText().equals("")) {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Boîte d'avertissement ");
                alert.setContentText("Vérifier que tous les champs sont remplis!");

                alert.showAndWait();
            }
            else{
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
    private void handle_NomPrenomPseudo(MouseEvent event) {
        nomPrenomLabel.setText("Bienvenue " + currentUser.getNom().getValue() + " " + currentUser.getPrenom().getValue());
        pseudLabelAlt.setText("@" + currentUser.getPseudo().getValue());
    }

    @FXML
    private void handle_details(MouseEvent event) {

        tfNom.setText(currentUser.getNom().get());
        tfPrenom.setText(currentUser.getPrenom().get());
        tfPseduo.setText(currentUser.getPseudo().get());
        tfTelep.setText(String.valueOf(currentUser.getTel().get()));
        tfDate.setText(currentUser.getDate_naiss().get());
        tfEmail.setText(currentUser.getEmail().get());
        tabio.setText(currentUser.getBio().get());
    }
}
