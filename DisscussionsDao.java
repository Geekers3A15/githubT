/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.dao;

import com.esprit.entity.Disscussions;
import com.esprit.utils.ConnexionSingleton;
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
public class DisscussionsDao {
    
    
    private static DisscussionsDao instance;
    private Statement st;
    private ResultSet rs;
    
    
    
    
    private DisscussionsDao() {
        ConnexionSingleton cs=ConnexionSingleton.getInstance();
        try {
            st=cs.getCnx().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(DisscussionsDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static DisscussionsDao getInstance(){
        if(instance==null) 
            instance=new DisscussionsDao();
        return instance;
    }
    
    public void insert(Disscussions o) {
        String req="insert into Disscussions (contenu) values ('"+o.getContenu()+"')";
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(DisscussionsDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
    
    
//     public void delete(Disscussions o) {
//        String req="delete from personne where id="+o.getId_disc();
//      //  Disscussions p=displayById(o.getId_disc());
//        
//          if(p!=null)
//              try {
//           
//            st.executeUpdate(req);
//             
//        } catch (SQLException ex) {
//            Logger.getLogger(DisscussionsDao.class.getName()).log(Level.SEVERE, null, ex);
//        }else System.out.println("n'existe pas");
//    }
    
    
    
 
    public ObservableList<Disscussions> displayAll() {
        String req="select * from Disscussions";
        ObservableList<Disscussions> list=FXCollections.observableArrayList();       
        
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
    
    
    public List<Disscussions> displayAllList() {
        String req="select * from Disscussions";
        List<Disscussions> list=new ArrayList<>();
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Disscussions p=new Disscussions();
                p.setId_disc(rs.getInt(1));
                p.setContenu(rs.getString("contenu"));
        
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DisscussionsDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
        
    }
    
    
    
//     public DisscussionsDao displayById(int id_disc) {
//           String req="select * from Disscussions where id ="+id_disc;
//           Disscussions p=new Disscussions();
//        try {
//            rs=st.executeQuery(req);
//           // while(rs.next()){
//            rs.next();
//                p.setId_disc(rs.getInt("id_disc"));
//                p.setContenu(rs.getString("contenu"));
//            //}  
//        } catch (SQLException ex) {
//            Logger.getLogger(Disscussions.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    return p;
//    }
    
    
     public boolean update(Disscussions p) {
        String qry = "UPDATE Disscussions SET contenu = '"+p.getContenu()+"' WHERE id = "+p.getId_disc();
        
        try {
            if (st.executeUpdate(qry) > 0) {
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Disscussions.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
