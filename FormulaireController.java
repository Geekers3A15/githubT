/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.controller;

/**
 *
 * @author Walid
 */
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Walid
 */
public class FormulaireController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    
     private AnchorPane rootLayout;
    private Stage primaryStage;
    @FXML
    private Button btn_ret;
    @FXML
    private Button btn_env;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        btn_env.setOnAction(event -> {
            try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/com/esprit/view/Notifications.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(FormulaireController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        
        btn_env.setOnAction(event -> {
            try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/com/esprit/view/weblog.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(FormulaireController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        
        }
          
}