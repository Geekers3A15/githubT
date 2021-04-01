/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Entités.user;
import Entités.weblog;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.controlsfx.control.Rating;
import Service.contenuService;
import Service.userService;
import Service.weblogService;

/**
 * FXML Controller class
 *
 * @author Sawssen Gharbi
 */
public class CardUserWeblogController implements Initializable {

    @FXML
    private VBox idBox;
    @FXML
    private ImageView idImg;
    @FXML
    private Label idTitre;
    @FXML
    private Label idCat;
    @FXML
    private Label idnomArtiste;
    @FXML
    private Label idWeblog;
    @FXML
    private Label idArtiste;
    @FXML
    private Rating idRating;
    @FXML
    private ImageView ConsulterWeblog;

    user currentUser;
    @FXML
    private Button id_commande;
    weblog weblog;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setData(weblog weblog, user user) {
        this.weblog = weblog;
        if (user.getPhoto_profil().get().equals("")) {
            Image image = new Image(getClass().getResourceAsStream("/assets/name.png"));
            idImg.setImage(image);
        } else {
            Image image = new Image(getClass().getResourceAsStream(user.getPhoto_profil().get()));
            idImg.setImage(image);
        }
        idTitre.setText(weblog.getTitre().get());
        idCat.setText(weblog.getCategorie().get());
        idnomArtiste.setText(user.getNom().get());
        idRating.setRating(weblog.getRating().get());
        idWeblog.setText(String.valueOf(weblog.getId_web().get()));
        idArtiste.setText(String.valueOf(user.getId_user().get()));

    }

    @FXML
    private void handle_ConsulterWeblog(MouseEvent event) throws URISyntaxException {

    }

    @FXML
    private void handle_commande(ActionEvent event) {
    }
}
