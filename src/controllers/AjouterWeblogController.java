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
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import Service.contenuService;
import Service.weblogService;

/**
 * FXML Controller class
 *
 * @author Sawssen Gharbi
 */
public class AjouterWeblogController implements Initializable {

    @FXML
    private Label nomPrenomLabel;
    @FXML
    private Label pseudLabelAlt;
    @FXML
    private Label modifierProfil;
    user currentUser;
    @FXML
    private TextField tfTitre;
    @FXML
    private ChoiceBox<String> boxCatégorie;
    @FXML
    private Hyperlink annulerWeblog;
    @FXML
    private Button btnchoisircontenu;
    @FXML
    private TextField tfUrl;
    @FXML
    private Button btnajoutercontenu;
    @FXML
    private Button btnajouterstatut;
    @FXML
    private Label nomcontenu;
    @FXML
    private Label nomcontenu1;
    @FXML
    private TextArea tastatut;
    @FXML
    private RadioButton rbphoto;
    @FXML
    private RadioButton rbvideo;
    @FXML
    private RadioButton rbstatut;
    @FXML
    private TextField tfnomcontenu;
    @FXML
    private TextField tfnomcontenu1;
    String sf;
    @FXML
    private TableView<contenu> table_contenu;
    @FXML
    private TableColumn<contenu, String> nomConCol;
    @FXML
    private TableColumn<contenu, String> contenucol;
    String nameOfFile;
    File destFile;
    private Button ajouterWeblog;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        boxCatégorie.getItems().addAll("photography", "design", "montage");
        ToggleGroup toggleGroup = new ToggleGroup();
        rbphoto.setToggleGroup(toggleGroup);
        rbvideo.setToggleGroup(toggleGroup);
        rbstatut.setToggleGroup(toggleGroup);

        nomcontenu.setVisible(false);
        tfnomcontenu.setVisible(false);
        tfUrl.setVisible(false);
        btnchoisircontenu.setVisible(false);
        btnchoisircontenu.setVisible(false);
        btnajoutercontenu.setVisible(false);

        nomcontenu1.setVisible(false);
        tfnomcontenu1.setVisible(false);
        tastatut.setVisible(false);
        btnajouterstatut.setVisible(false);

    }

    public void initData(user u) {
        this.currentUser = u;
        System.out.println("identifiant: " + u.getId_user().get());
        nomPrenomLabel.setText("Bienvenue " + currentUser.getNom().getValue() + " " + currentUser.getPrenom().getValue());
        pseudLabelAlt.setText("@" + currentUser.getPseudo().getValue());

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
            Logger.getLogger(AjouterWeblogController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handle_annulerWeblog(MouseEvent event) {
        weblogService ws = weblogService.getInstance();
        weblog w = ws.getLastWeblogCreated(currentUser.getId_user().get());
        contenuService cs = contenuService.getInstance();
        contenu c = new contenu();

        if (event.getSource() == annulerWeblog) {
            cs.deleteContenu(w.getId_web().get());
            ws.deleteWeblog(w.getId_web().get());
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
                Logger.getLogger(AjouterWeblogController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void handle_choisirContenu(MouseEvent event) {
        File SelectedFile = null;
        FileChooser fc = new FileChooser();
        String newPath = "src/contenu";
        if (rbphoto.isSelected()) {
            fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Images", "*.jpg", "*.jpeg", "*.png"));
            SelectedFile = fc.showOpenDialog(null);
        } else if (rbvideo.isSelected()) {
            fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Videos", "*.mp4"));
            SelectedFile = fc.showOpenDialog(null);
        }

        weblogService ws = weblogService.getInstance();
        weblog w = new weblog();

        if (SelectedFile != null) {
            tfUrl.setText(SelectedFile.getAbsolutePath());
            sf = SelectedFile.toString();
            nameOfFile = SelectedFile.getName();
            destFile = new File(newPath + "/" + SelectedFile.getName());
            try {
                Files.copy(SelectedFile.toPath(), destFile.toPath());
            } catch (IOException ex) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Nom Invalide");
                alert.setHeaderText(null);
                alert.setContentText("Changer le nom du votre contenu");
                alert.showAndWait();

            }

        }
    }

    @FXML
    private void handle_ajoutercontenu(MouseEvent event) {
        weblogService ws = weblogService.getInstance();
        weblog w = ws.getLastWeblogCreated(currentUser.getId_user().get());
        contenuService cs = contenuService.getInstance();
        contenu c = new contenu();
        if (event.getSource() == btnajoutercontenu) {
            if (nomcontenu.getText().equals("") || tfUrl.getText().equals("")) {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Boîte d'avertissement ");
                alert.setContentText("Vérifier que tous les champs sont remplis!");

                alert.showAndWait();
            } else {
                int i = sf.lastIndexOf(".");
                if (i > 0) {
                    String extension = sf.substring(i + 1);

                    if (rbphoto.isSelected() && extension.equals("jpg") || extension.equals("jpeg") || extension.equals("png")) {

                        System.out.println("ex" + extension);
                        System.out.println("sf" + sf);
                        c.setNom_contenu(tfnomcontenu.getText());
                        c.setId_weblog(w.getId_web().get());
                        c.setPhoto(nameOfFile);
                        c.setStatut("");
                        c.setVideo("");
                        System.out.println("contenu: " + c.toString());

                    } else if (rbvideo.isSelected() && extension.equals("mp4")) {
                        System.out.println("ex" + extension);
                        System.out.println("sf" + nameOfFile);
                        c.setNom_contenu(tfnomcontenu.getText());
                        c.setId_weblog(w.getId_web().get());
                        c.setPhoto("");
                        c.setStatut("");
                        c.setVideo(nameOfFile);
                    } else {
                        c.setNom_contenu(tfnomcontenu1.getText());
                        c.setId_weblog(w.getId_web().get());
                        c.setPhoto("");
                        c.setStatut(tastatut.getText());
                        c.setVideo("");

                    }

                }
                w.setTitre(tfTitre.getText());
                w.setCategorie(boxCatégorie.getValue());
                w.setId_artiste(currentUser.getId_user().get());
                w.setRating(0);
                cs.insertContenu(c);
                ws.updateWeblog(w);
                Image img = new Image("assets/tick.png", 50, 50, false, false);
                Notifications notificationsBuilder = Notifications.create()
                        .title("Weblog")
                        .text(" Weblog ajouter avec succée")
                        .graphic(new ImageView(img))
                        .hideAfter(Duration.seconds(6))
                        .position(Pos.TOP_LEFT);
                notificationsBuilder.darkStyle();

                notificationsBuilder.show();

            }
            ObservableList<contenu> contenu = FXCollections.observableArrayList();
            contenu = cs.getAllContenuByWeblog(w.getId_web().get());

            table_contenu.setItems(contenu);
            nomConCol.setCellValueFactory(cell -> cell.getValue().getNom_contenu());
            contenucol.setCellValueFactory(cell -> cell.getValue().getUrl());

        }
    }

    @FXML
    private void handle_radiobuttonphoto(MouseEvent event) {
        if (rbphoto.isSelected()) {
            nomcontenu.setVisible(true);
            tfnomcontenu.setVisible(true);
            tfUrl.setVisible(true);
            btnchoisircontenu.setVisible(true);
            btnajoutercontenu.setVisible(true);
            nomcontenu1.setVisible(false);
            tfnomcontenu1.setVisible(false);
            tastatut.setVisible(false);
            btnajouterstatut.setVisible(false);
        } else {
            nomcontenu.setVisible(false);
            tfnomcontenu.setVisible(false);
            tfUrl.setVisible(false);
            btnchoisircontenu.setVisible(false);
            btnajoutercontenu.setVisible(false);

        }

    }

    @FXML
    private void handle_radiobuttonvideo(MouseEvent event
    ) {
        if (rbvideo.isSelected()) {
            nomcontenu.setVisible(true);
            tfnomcontenu.setVisible(true);
            tfUrl.setVisible(true);
            btnchoisircontenu.setVisible(true);
            btnajoutercontenu.setVisible(true);
            nomcontenu1.setVisible(false);
            tfnomcontenu1.setVisible(false);
            tastatut.setVisible(false);
            btnajouterstatut.setVisible(false);
        } else {
            nomcontenu.setVisible(false);
            tfnomcontenu.setVisible(false);
            tfUrl.setVisible(false);
            btnchoisircontenu.setVisible(false);
            btnajoutercontenu.setVisible(false);

        }

    }

    @FXML
    private void handle_radiobuttonstatut(MouseEvent event
    ) {
        if (rbstatut.isSelected()) {
            nomcontenu.setVisible(false);
            tfnomcontenu.setVisible(false);
            tfUrl.setVisible(false);
            btnchoisircontenu.setVisible(false);
            btnajoutercontenu.setVisible(false);
            nomcontenu1.setVisible(true);
            tfnomcontenu1.setVisible(true);
            tastatut.setVisible(true);
            btnajouterstatut.setVisible(true);
        } else {

            nomcontenu1.setVisible(false);
            tfnomcontenu1.setVisible(false);
            tastatut.setVisible(false);
            btnajouterstatut.setVisible(false);
        }

    }

    @FXML
    private void handle_ajouterStatut(MouseEvent event) {
        weblogService ws = weblogService.getInstance();
        weblog w = ws.getLastWeblogCreated(currentUser.getId_user().get());
        contenuService cs = contenuService.getInstance();
        contenu c = new contenu();
        if (event.getSource() == btnajouterstatut) {
            w.setTitre(tfTitre.getText());
            w.setCategorie(boxCatégorie.getValue());
            w.setRating(0);
            c.setNom_contenu(tfnomcontenu1.getText());
            c.setStatut(tastatut.getText());
            c.setId_weblog(w.getId_web().get());
            c.setPhoto("");
            c.setVideo("");
            cs.insertContenu(c);
            ws.updateWeblog(w);

        }
        ObservableList<contenu> contenu = FXCollections.observableArrayList();
        contenu = cs.getAllContenuByWeblog(w.getId_web().get());

        table_contenu.setItems(contenu);
        nomConCol.setCellValueFactory(cell -> cell.getValue().getNom_contenu());
        contenucol.setCellValueFactory(cell -> cell.getValue().getUrl());

    }

}
