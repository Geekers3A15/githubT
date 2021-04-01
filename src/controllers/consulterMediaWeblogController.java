/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Entités.contenu;
import Entités.user;
import Entités.weblog;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import Service.contenuService;
import Service.userService;
import Service.weblogService;

/**
 * FXML Controller class
 *
 * @author Sawssen Gharbi
 */
public class consulterMediaWeblogController implements Initializable {

    @FXML
    private Label nomPrenomLabel;
    @FXML
    private Label pseudLabelAlt;
    @FXML
    private Label modifierProfil;
    @FXML
    private HBox listeCommandes;
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

    public void initData(user u, weblog w) throws URISyntaxException {

        this.currentUser = u;
        System.out.println("identifiant: " + u.getId_user().get());
        nomPrenomLabel.setText("Bienvenue " + u.getNom().getValue() + " " + u.getPrenom().getValue());
        pseudLabelAlt.setText("@" + u.getPseudo().getValue());
        weblogService ws = weblogService.getInstance();
        List<weblog> weblogs = ws.getAllWeblogsOfUser(u.getId_user().get());
        userService us = userService.getInstance();
        List<user> users = us.getAllUsers();
        contenuService cs = contenuService.getInstance();
        List<contenu> contenus = cs.getAllContenuByWeblog(w.getId_web().get());
        int column = 0;
        int row = 1;
        try {
            for (contenu c : contenus) {
                if (c.getUrl().get().endsWith("g")) {
                    FXMLLoader fXMLLoader = new FXMLLoader();
                    fXMLLoader.setLocation(getClass().getResource("/views/cardImageWeblog.fxml"));
                    VBox vbox = fXMLLoader.load();
                    CardImageController cardimagecontroller = fXMLLoader.getController();
                    cardimagecontroller.setData(w, u, c);
                    if (column == 3) {
                        column = 0;
                        ++row;
                    }
                    idGridPane.add(vbox, column++, row);
                    GridPane.setMargin(vbox, new javafx.geometry.Insets(10));

                } else {
                    if (c.getUrl().get().endsWith("4")) {
                        FXMLLoader fXMLLoader = new FXMLLoader();
                        fXMLLoader.setLocation(getClass().getResource("/views/cardVideoWeblog.fxml"));
                        VBox vbox = fXMLLoader.load();
                        CardVideoWeblogController cardVideoWeblogController = fXMLLoader.getController();

                        cardVideoWeblogController.setData(w, u, c);
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
    private void handle_listeCommandes(MouseEvent event) {
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

    @FXML
    private void handle_afficherBtn(MouseEvent event) {
    }

}
