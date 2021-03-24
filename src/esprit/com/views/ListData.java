/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.views;

import esprit.com.controller.FormulaireService;
import esprit.com.entite.Formulaire;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Walid
 */
public class ListData { 
    
      ObservableList<Formulaire> form=FXCollections.observableArrayList();

    public ListData() {
        
        FormulaireService fs=FormulaireService.getInstance();
        form= fs.displayAll();
        System.out.println(form);
    }
    
    public ObservableList<Formulaire> getForm(){
        return form;
    }
    
}
