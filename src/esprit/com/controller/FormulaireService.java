/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.controller;

import esprit.com.entite.Formulaire;
import esprit.com.utils.ConnexionSingleton;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Walid
 */
public class FormulaireService {
     
    private static FormulaireService instance;
    private Statement st;
    private ResultSet rs;
    
    
    
    
    public FormulaireService() {
        ConnexionSingleton cs=ConnexionSingleton.getInstance();
        try {
            st=cs.getCnx().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(FormulaireService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
    
   public static FormulaireService getInstance(){
        if(instance==null) 
            instance=new FormulaireService();
        return instance;
    }
   
    
      public void add(Formulaire p) throws SQLException{
        
          System.out.println(p.getId_user());
          System.out.println(p.getId_user_cli());
          System.out.println(p.getService_demande());
          System.out.println(p.getNum_tel());
          System.out.println(p.getDate_limit());
          System.out.println(p.getStatus());
          System.out.println(p.getDate_creation());
          
          String req =" insert into formulaire (id_user,id_user_cli,service_demande, num_tel, date_limite,status,date_creation) values (" +p.getId_user()+"  , "+p.getId_user_cli()+"  , '"+p.getService_demande()+" ' , '"+p.getNum_tel()+" ' , '"+p.getDate_limit()+" ' , '"+p.getStatus()+" ' ,CURDATE() )"; 
           st.executeUpdate(req);
          System.out.println(req);
          


    }
            
    
    
  
   
      
     // a refaire selon kol shay
    public boolean update(Formulaire p) {
        String qry = "UPDATE formulaire SET status = '"+p.getId_user()+"  , "+p.getId_user_cli()+"  , '"+p.getService_demande()+" ' , '"+p.getNum_tel()+" ' , '"+p.getDate_limit()+" ' , '"+p.getStatus()+" ' ,CURDATE() ";
       // String qry = "UPDATE formulaire SET status = '"+p.getStatus()+"',  '"+"' WHERE id = "+p.getId_form();
        
        try {
            if (st.executeUpdate(qry) > 0) {
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FormulaireService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
     public void delete(Formulaire p) {
        String req="delete from formulaire where id_form="+p.getId_form();
        
          if(p!=null)
              try {
           
            st.executeUpdate(req);
             
        } catch (SQLException ex) {
            Logger.getLogger(Formulaire.class.getName()).log(Level.SEVERE, null, ex);
        }else System.out.println("n'existe pas");
    }
     
     
      
    public ObservableList<Formulaire> displayAll() {
        String req="select * from formulaire";
        ObservableList<Formulaire> list=FXCollections.observableArrayList();       
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Formulaire p=new Formulaire();
                p.setId_form(rs.getInt("id_form"));
                p.setService_demande(rs.getString("service_demande"));
                p.setStatus(rs.getString("status"));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FormulaireService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
      public List<Formulaire> displayAllList() {
        String req="select * from formulaire";
        List<Formulaire> list=new ArrayList<>();
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Formulaire p=new Formulaire();
                 p.setId_form(rs.getInt("id_form"));
                p.setService_demande(rs.getString("service_demande"));
                 p.setStatus(rs.getString("status"));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FormulaireService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
  
      public void updateStatus (Formulaire p){
           String qry = "UPDATE formulaire SET status = '"+p.getStatus()+"',  '"+"' WHERE id = "+p.getId_form()+"'";
             try {
            st.executeUpdate(qry);
            System.out.println("status modifié avec succées!");
        } catch (SQLException ex) {
            Logger.getLogger(FormulaireService.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
      
   
    
}
