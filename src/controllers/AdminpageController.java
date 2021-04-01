/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Entités.user;
import Entités.weblog;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import Service.userService;
import Service.weblogService;

/**
 * FXML Controller class
 *
 * @author Sawssen Gharbi
 */
public class AdminpageController implements Initializable {

    user currentUser;
    @FXML
    private Label nomPrenomLabel;
    @FXML
    private Label pseudLabelAlt;
    @FXML
    private VBox idvWeblog;
    @FXML
    private ScrollPane idScrollpane;
    @FXML
    private GridPane idGridPane;
    @FXML
    private TextField tfchercher;
    @FXML
    private ImageView chercher;
    @FXML
    private Button Afficherbtn;
    @FXML
    private Label profil;
    @FXML
    private Label modifierProfil;

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
        weblogService ws = weblogService.getInstance();
        List<weblog> weblogs = ws.getAllWeblogs();
        userService us = userService.getInstance();
        List<user> users = us.getAllUsers();
        int column = 0;
        int row = 1;
        try {
            for (weblog w : weblogs) {
                for (user ur : users) {
                    if (ur.getId_user().get() == w.getId_artiste().get()) {
                        FXMLLoader fXMLLoader = new FXMLLoader();
                        fXMLLoader.setLocation(getClass().getResource("/views/gestioncardweblog.fxml"));
                        VBox vbox = fXMLLoader.load();
                        GestionCardWeblogController gestioncardweblogcontroller = fXMLLoader.getController();
                        gestioncardweblogcontroller.setData(w, ur);
                        if (column == 3) {
                            column = 0;
                            ++row;
                        }
                        idGridPane.add(vbox, column++, row);
                        GridPane.setMargin(vbox, new Insets(10));

                    }
                }
            }
        } catch (IOException e) {
        }

    }

    @FXML
    private void handle_weblogs(MouseEvent event) {
    }

    @FXML
    private void handle_Chercher(MouseEvent event) {
        String texte = tfchercher.getText();
        if (texte.equals("")) {
            handle_afficherBtn(event);
        } else {

            weblogService ws = weblogService.getInstance();
            List<weblog> weblogs = ws.getAllWeblogs();
            userService us = userService.getInstance();
            List<user> users = us.getAllUsers();
            if (weblogs.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("INCORRECT NOM WEBLOG");
                alert.setHeaderText(null);
                alert.setContentText("PAS DU WEBLOG AVEC CE NOM");
                alert.showAndWait();
            } else {
                int column = 0;
                int row = 1;
                try {
                    for (weblog w : weblogs) {
                        for (user u : users) {
                            if (u.getId_user().get() == w.getId_artiste().get()) {
                                FXMLLoader fXMLLoader = new FXMLLoader();
                                fXMLLoader.setLocation(getClass().getResource("/views/gestioncardweblog.fxml"));
                                VBox vbox1 = fXMLLoader.load();
                                GestionCardWeblogController gestioncardweblogcontroller = fXMLLoader.getController();
                                gestioncardweblogcontroller.setData(w, u);
                                if (column == 3) {
                                    column = 0;
                                    ++row;
                                }
                                idGridPane.getChildren().clear();
                                idGridPane.add(vbox1, column++, row);
                                GridPane.setMargin(vbox1, new javafx.geometry.Insets(10));

                            }
                        }
                    }
                } catch (IOException e) {
                    Logger.getLogger(weblogController.class.getName()).log(Level.SEVERE, null, e);

                }
            }
        }
    }

    @FXML
    private void handle_afficherBtn(MouseEvent event) {
        weblogService ws = weblogService.getInstance();
        List<weblog> weblogs = ws.getAllWeblogs();
        userService us = userService.getInstance();
        List<user> users = us.getAllUsers();
        int column = 0;
        int row = 1;
        try {
            for (weblog w : weblogs) {
                for (user ur : users) {
                    if (ur.getId_user().get() == w.getId_artiste().get()) {
                        FXMLLoader fXMLLoader = new FXMLLoader();
                        fXMLLoader.setLocation(getClass().getResource("/views/gestioncardweblog.fxml"));
                        VBox vbox = fXMLLoader.load();
                        GestionCardWeblogController gestioncardweblog = fXMLLoader.getController();
                        gestioncardweblog.setData(w, ur);
                        if (column == 3) {
                            column = 0;
                            ++row;
                        }
                        idGridPane.add(vbox, column++, row);
                        GridPane.setMargin(vbox, new javafx.geometry.Insets(10));

                    }
                }
            }
        } catch (IOException e) {
        }
    }

    @FXML
    private void handle_profil(MouseEvent event) {
    }

    @FXML
    private void handle_modfierProfil(MouseEvent event) {
    }

}
