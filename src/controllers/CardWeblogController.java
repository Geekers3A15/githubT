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
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import org.controlsfx.control.Rating;
import Service.contenuService;
import Service.userService;
import Service.weblogService;

/**
 * FXML Controller class
 *
 * @author Sawssen Gharbi
 */
public class CardWeblogController implements Initializable {

    @FXML
    private VBox idBox;
    @FXML
    private ImageView idImg;
    @FXML
    private Label idTitre;
    @FXML
    private Label idCat;
    @FXML
    private Label idArtiste;
    @FXML
    private Rating idRating;
    @FXML
    private ImageView ConsulterWeblog;
    @FXML
    private ImageView SupprimerWeblog;
    @FXML
    private ImageView ModifierWeblog;
    user currentUser;
    int id;
    @FXML
    private Label idWeblog;
    @FXML
    private Label idnomArtiste;

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
         System.out.println("identifiant: " + currentUser.getId_user().get());

    }

    public void setData(weblog weblog, user user) {
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
        weblogService ws = weblogService.getInstance();
        contenuService cs = contenuService.getInstance();
        userService us = userService.getInstance();
        id = Integer.parseInt(idWeblog.getText());
        weblog w = ws.getWeblogById(id);
        int id_artiste = Integer.parseInt(idArtiste.getText());

        if (event.getSource() == ConsulterWeblog){
            user u = us.getUserById(id_artiste);
            this.currentUser = u;
            

        
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/views/consulterMediaWeblog.fxml"));
                Parent page2 = loader.load();
                consulterMediaWeblogController controller = loader.getController();
                controller.initData(currentUser,w);
                Scene scene = new Scene(page2);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);

                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(CardWeblogController.class.getName()).log(Level.SEVERE, null, ex);

            }
        }
       
    }

    @FXML
    private void handle_supprimerweblog(MouseEvent event) {
        weblogService ws = weblogService.getInstance();
        contenuService cs = contenuService.getInstance();
        userService us = userService.getInstance();
        id = Integer.parseInt(idWeblog.getText());
        int id_artiste = Integer.parseInt(idArtiste.getText());

        if (event.getSource() == SupprimerWeblog) {
            System.out.println("id" + id);
            cs.deleteContenu(id);
            ws.deleteWeblog(id);
            user u = us.getUserById(id_artiste);
            this.currentUser = u;
            Image img = new Image("assets/trash.png", 50, 50, false, false);
            Notifications notificationsBuilder = Notifications.create()
                    .text(" Weblog supprimé avec succées!")
                    .graphic(new ImageView(img))
                    .hideAfter(Duration.seconds(6))
                    .position(Pos.TOP_LEFT);
            notificationsBuilder.darkStyle();

            notificationsBuilder.show();

            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/views/weblog.fxml"));
                Parent page2 = loader.load();
                weblogController controller = loader.getController();
                controller.initData(u);
                Scene scene = new Scene(page2);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);

                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(CardWeblogController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void handle_modifierweblog(MouseEvent event) {
        weblogService ws = weblogService.getInstance();
        contenuService cs = contenuService.getInstance();
        userService us = userService.getInstance();
        int id = Integer.parseInt(idWeblog.getText());
        int id_artiste = Integer.parseInt(idArtiste.getText());

        if (event.getSource() == ModifierWeblog) {
            System.out.println("id" + id);
            user u = us.getUserById(id_artiste);
            this.currentUser = u;
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/views/modifierWeblog.fxml"));
                Parent page2 = loader.load();
                ModifierWeblogController controller = loader.getController();
                controller.initData(u, id);
                Scene scene = new Scene(page2);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);

                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(CardWeblogController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
