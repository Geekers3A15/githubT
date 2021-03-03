/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.dao;

import com.esprit.entity.Disscussions;
import com.esprit.entity.Formulaire;
import com.esprit.utils.ConnexionSingleton;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Walid
 */
public class FormulaireDao {
     
    private static FormulaireDao instance;
    private Statement st;
    private ResultSet rs;
    
    
    
    
    private FormulaireDao() {
        ConnexionSingleton cs=ConnexionSingleton.getInstance();
        try {
            st=cs.getCnx().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(DisscussionsDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
     public void insert(FormulaireDao d) {
        String req = "insert into formulaire (Service_demande,Num_tel) values ('" + d.getService_demande() + "','" + d.getNum_tel() + "','"+d.getDate_limit()+"','";


        try {
             st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(DisscussionsDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
        
        
////         @Override
////     public void delete(FormulaireDao d) {
////        String req="delete from DemandeService where id="+d.getId_form();
////        DemandeService p=displayById(d.getId_form());
////        
////          if(p!=null)
////              try {
////           
////            ste.executeUpdate(req);
////             
////        } catch (SQLException ex) {
////            Logger.getLogger(DemandeServiceDao.class.getName()).log(Level.SEVERE, null, ex);
////        }else System.out.println("n'existe pas");
////    }
//        
     
     
       public ObservableList<Formulaire> displayAll() {
        String req="select * from formulaire";
        ObservableList<Formulaire> list=FXCollections.observableArrayList();       
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Disscussions p=new Disscussions();
                p.setId_disc(rs.getInt(1));
                p.setContenu(rs.getString("contenu"));
       
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Disscussions.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
//// @Override
////    public boolean update(DemandeService d) {
////        String qry = "UPDATE DemandeService SET travail demande = '"+d.getService_demande() + "','" + d.getNum_tel()+  "','"+d.getDate_limit()+"','"+d.getType_pay()+
////                "' WHERE id = "+d.getId_form();
////        
////        try {
////            if (ste.executeUpdate(qry) > 0) {
////                return true;
////            }
////            
////        } catch (SQLException ex) {
////            Logger.getLogger(DemandeService.class.getName()).log(Level.SEVERE, null, ex);
////        }
////        return false;
////    }















        
        
  
    }
    
    
    
    
    
    
    
    
    
    

