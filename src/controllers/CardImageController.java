/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Entités.contenu;
import Entités.user;
import Entités.weblog;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Sawssen Gharbi
 */
public class CardImageController implements Initializable {

    @FXML
    private VBox idBox;
    @FXML
    private ImageView idImage;
    String path;
    weblog weblog;
    user user;
    contenu contenu;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setData(weblog weblog, user user, contenu c) throws URISyntaxException, MalformedURLException {
        this.weblog = weblog;
        this.user = user;
        this.contenu = c;
        path = "src\\contenu\\" + contenu.getPhoto().get();
        System.out.println("path" + path);
        ImageView image = new ImageView(new File(path).toURI().toURL().toExternalForm());
        idImage.setImage(image.getImage());
    }

}
