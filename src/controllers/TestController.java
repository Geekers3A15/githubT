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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import Service.userService;

/**
 * FXML Controller class
 *
 * @author Sawssen Gharbi
 */
public class TestController implements Initializable {

    @FXML
    private TextField pseudoInput;
    @FXML
    private TextField mdpInput;
    @FXML
    private Button test;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handle_test(ActionEvent event) {
        userService us = userService.getInstance();
        List<user> users = us.getAllUsersTest();
        if (event.getSource() == test) {
            String nom = pseudoInput.getText();
            String mdp = mdpInput.getText();

            for (user u : users) {
                if (u.getPseudo().get().equals(nom) && u.getMdp().get().equals(mdp)) {
                    if (u.getRole().get().toLowerCase().equals("artiste")) {
                        System.out.println("artiste connecté");

                        try {
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/profil.fxml"));
                            Stage stage = new Stage(StageStyle.DECORATED);
                            stage.setScene(
                                    new Scene(loader.load())
                            );

                            stage.setResizable(false);

                            profilController controller = loader.getController();
                            controller.initData(u);

                            Stage oldStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            oldStage.close();

                            stage.show();

                        } catch (IOException ex) {
                            Logger.getLogger(profilController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        if (u.getRole().get().toLowerCase().equals("admin")) {

                            System.out.println("admin connecté");
                            try {
                                FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/adminpage.fxml"));
                                Stage stage = new Stage(StageStyle.DECORATED);
                                stage.setScene(
                                        new Scene(loader.load())
                                );

                                stage.setResizable(false);

                                AdminpageController controller = loader.getController();
                                controller.initData(u);

                                Stage oldStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                                oldStage.close();

                                stage.show();

                            } catch (IOException ex) {
                                Logger.getLogger(TestController.class.getName()).log(Level.SEVERE, null, ex);
                            }

                        } else {
                            if (u.getRole().get().toLowerCase().equals("client")) {
                                System.out.println("client connecté");
                                try {
                                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/weblogUser.fxml"));
                                    Stage stage = new Stage(StageStyle.DECORATED);
                                    stage.setScene(
                                            new Scene(loader.load())
                                    );

                                    stage.setResizable(false);

                                    weblogUserController controller = loader.getController();
                                    controller.initData(u);

                                    Stage oldStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                                    oldStage.close();

                                    stage.show();

                                } catch (IOException ex) {
                                    Logger.getLogger(TestController.class.getName()).log(Level.SEVERE, null, ex);
                                }

                            }

                        }
                    }
                }
            }
        }
    }

}
