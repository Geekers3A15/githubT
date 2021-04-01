/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artcom;

import Entités.weblog;
import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import Service.weblogService;

/**
 *
 * @author Sawssen
 */
public class Artcom  extends Application {

     @Override
    public void start(Stage primaryStage) throws IOException {
        
        FXMLLoader laoder = new FXMLLoader(getClass().getResource("/views/test.fxml"));
        Parent root = laoder.load();
        
        //primaryStage.initStyle(StageStyle.UNDECORATED);
        
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        
        primaryStage.setTitle("Artcom | Artcom Platform");
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/assets/logo.png")));

        primaryStage.setResizable(false);
        
        primaryStage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
