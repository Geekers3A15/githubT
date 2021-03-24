/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.views;


import com.sun.prism.impl.Disposer.Record;
import esprit.com.controller.FormulaireService;
import esprit.com.entite.Formulaire;
import java.net.URL;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Worker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author Walid
 */
public class ListeController implements Initializable {

    /**
     * Initializes the controller class.
     */
      @FXML
    private TableView<Formulaire> table;
     @FXML
    private TableColumn<Formulaire, String> id;

    @FXML
    private TableColumn<Formulaire, String> art;

    @FXML
    private TableColumn<Formulaire, String> off;

    @FXML
    private TableColumn<?, ?> update;

//    @FXML
//    private TableColumn<?, ?> delete;

   
    
    @FXML
	private TableColumn<Formulaire,Button> delete;

    @FXML
    void delete(ActionEvent event) {
        
        

    }

    @FXML
    void update(ActionEvent event) {
        
        

    }
 
    ListData listData = new ListData();
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    //  List<Formulaire> ls = new ArrayList<Formulaire>();
       // FormulaireService sp=new FormulaireService();
        FormulaireService sp =FormulaireService.getInstance();
        List<Formulaire> formulaire=sp.displayAll();
        table.setItems(listData.getForm());
        id.setCellValueFactory(cell -> cell.getValue().getId_form().asString());
        off.setCellValueFactory(cell -> cell.getValue().getService_demande());
        
       
    //les offres de artiste  
    TableColumn<Formulaire, Formulaire> etatCol = new TableColumn<>("Etat");
etatCol.setCellValueFactory(
    param -> new ReadOnlyObjectWrapper<>(param.getValue())
);
table.getColumns().add(etatCol);
etatCol.setCellFactory(param -> new TableCell<Formulaire, Formulaire>() {
    private final Button etatButton = new Button("Encours");
    
     @Override
    protected void updateItem(Formulaire formulaire, boolean empty) {
        super.updateItem(formulaire, empty);

        if (formulaire == null) {
            setGraphic(null);
            return;
        }

        setGraphic(etatButton);
        etatButton.setOnAction(
            event -> getTableView().getItems().remove(formulaire)
               // event -> FormulaireService sp =new FormulaireService().updateStatus(formulaire)
        );
    }
});

    TableColumn<Formulaire, Formulaire> deleteCol = new TableColumn<>("delete");
deleteCol.setCellValueFactory(
    param -> new ReadOnlyObjectWrapper<>(param.getValue())
);
table.getColumns().add(deleteCol);
deleteCol.setCellFactory(param -> new TableCell<Formulaire, Formulaire>() {
    private final Button deleteButton = new Button("supprimer");
    
     @Override
    protected void updateItem(Formulaire formulaire, boolean empty) {
        super.updateItem(formulaire, empty);

        if (formulaire == null) {
            setGraphic(null);
            return;
        }

        setGraphic(deleteButton);
        deleteButton.setOnAction(
            event -> getTableView().getItems().remove(formulaire)
               // event -> FormulaireService sp =new FormulaireService().updateStatus(formulaire)
        );
    }
});
        
        
   
      
   
                   
        }
    }    
    

