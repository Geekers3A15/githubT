/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.views;

import esprit.com.controller.FormulaireService;
import esprit.com.entite.Formulaire;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Walid
 */
public class MesoffresController implements Initializable {

    /**
     * Initializes the controller class.
     */
     @FXML
    private TableView<Formulaire> tablee;

    
     @FXML
    private TableColumn<Formulaire, String> cli;

    @FXML
    private TableColumn<Formulaire, String> off;
    
      @FXML
    private TableColumn<Formulaire, String> stat;



//    @FXML
//    private Button btn_acc;

//    @FXML
//    private Button btn_ref;

    @FXML
    void accepter(ActionEvent event) {

    }

    @FXML
    void refuser(ActionEvent event) {

    }
     ListData listData = new ListData();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         FormulaireService sp =FormulaireService.getInstance();
        List<Formulaire> formulaire=sp.displayAll();
        tablee.setItems(listData.getForm());
        off.setCellValueFactory(cell -> cell.getValue().getService_demande());
        stat.setCellValueFactory(cell -> cell.getValue().getStatus());
        
           TableColumn<Formulaire, Formulaire> accepterCol = new TableColumn<>("Accepter");
accepterCol.setCellValueFactory(
    param -> new ReadOnlyObjectWrapper<>(param.getValue())
);
tablee.getColumns().add(accepterCol);
accepterCol.setCellFactory(param -> new TableCell<Formulaire, Formulaire>() {
    private final Button accepteButton = new Button("accepter");
    
     @Override
    protected void updateItem(Formulaire formulaire, boolean empty) {
        super.updateItem(formulaire, empty);

        if (formulaire == null) {
            setGraphic(null);
            return;
        }

        setGraphic(accepteButton);
        accepteButton.setOnAction(
            event -> {
                formulaire.setStatus("acceptée");
                FormulaireService sp=FormulaireService.getInstance();
                sp.updateStatus(formulaire);
            }
        );
    }
});

  TableColumn<Formulaire, Formulaire> refuserCol = new TableColumn<>("Refuser");
refuserCol.setCellValueFactory(
    param -> new ReadOnlyObjectWrapper<>(param.getValue())
);
tablee.getColumns().add(refuserCol);
refuserCol.setCellFactory(param -> new TableCell<Formulaire, Formulaire>() {
    private final Button refuserButton = new Button("refuser");
    
     @Override
    protected void updateItem(Formulaire formulaire, boolean empty) {
        super.updateItem(formulaire, empty);

        if (formulaire == null) {
            setGraphic(null);
            return;
        }

        setGraphic(refuserButton);
        refuserButton.setOnAction(
            event -> {
                 formulaire.setStatus("refusée");
                FormulaireService sp=FormulaireService.getInstance();
                sp.updateStatus(formulaire);
                
            }
        );
    }
});
        







        
    }  
    
}
    
        
