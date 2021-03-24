/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.views;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 *
 * @author Walid
 */
public class JavaFXApplication4 extends Application {
      private Stage primaryStage;
    private Parent parentPage;
    
    @Override
    public void start(Stage primaryStage) throws Exception {

        
         this.primaryStage = primaryStage;
        this.primaryStage.setTitle("ListView_Artiste");
        
      // parentPage = FXMLLoader.load(getClass().getResource("demandeService.fxml"));
    //parentPage = FXMLLoader.load(getClass().getResource("/esprit/com/views/Liste.fxml"));
       parentPage = FXMLLoader.load(getClass().getResource("/esprit/com/views/Mesoffres.fxml"));
        Scene scene = new Scene(parentPage);
        this.primaryStage.setScene(scene);
        this.primaryStage.show();
        
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
