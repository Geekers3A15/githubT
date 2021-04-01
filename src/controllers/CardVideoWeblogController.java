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
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Sawssen Gharbi
 */
public class CardVideoWeblogController implements Initializable {

    @FXML
    private VBox idBox;
    @FXML
    private MediaView idVideo;
    MediaPlayer mediaplayer;
    String path;
    weblog weblog;
    user user;
    contenu contenu;
    @FXML
    private Button idplay;
    @FXML
    private Button idpause;
    @FXML
    private Button idreset;

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
        path = "src\\contenu\\" + contenu.getVideo().get();
        System.out.println("path" + path);

        Media media = new Media(new File(path).toURI().toURL().toExternalForm());

        mediaplayer = new MediaPlayer(media);

        idVideo.setMediaPlayer(mediaplayer);

    }

    @FXML
    public void playMedia() {

        mediaplayer.play();

    }

    @FXML
    public void pauseMedia() {

        mediaplayer.pause();

    }

    @FXML
    public void resetMedia() {

        if (mediaplayer.getStatus() != MediaPlayer.Status.READY) {

            mediaplayer.seek(Duration.seconds(0.0));

        }

    }

}
