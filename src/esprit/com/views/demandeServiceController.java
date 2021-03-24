/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.views;

import esprit.com.controller.FormulaireService;
import esprit.com.entite.Formulaire;
import java.net.URL;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import  java.time.temporal.TemporalQueries.*;
import static java.time.temporal.TemporalQueries.localDate;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *
 * @author Walid
 */


public class demandeServiceController implements Initializable {
    
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    @FXML
    private TextField txtprenom;

    @FXML
    private TextField txtnom;

    @FXML
     TextArea txtserv;

    @FXML
     DatePicker txtdate;

    @FXML
    private TextField txtnum;

    @FXML
    private Button btn_env;

    @FXML
    private Button btn_ret;

    @FXML
    void cancel(ActionEvent event) {

    }
    
     

    @FXML
    void envoyer(ActionEvent event) throws SQLException {
        Formulaire f=new Formulaire();
        f.setService_demande( txtserv.getText());
        f.setNum_tel(Integer.parseInt(txtnum.getText()));
       //f.getDate_limit = new DatePicker();
       
 
       LocalDate localDate = txtdate.getValue();
Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
Date date = Date.from(instant);
f.setDate_limit("2021-02-05");
System.out.println(date);
        f.setId_user(1);
        f.setId_user_cli(3);
        f.setStatus("en attente");
        
//        FormulaireService sp=new FormulaireService();
//        sp.add(f);

    }

    
    
    
}
