/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entités.weblog;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.dbconnexion;

/**
 *
 * @author Sawssen
 */
public class weblogService {

    private static weblogService instance;
    private Statement st;
    private ResultSet rs;

    public weblogService() {
        dbconnexion db = dbconnexion.getInstance();
        try {
            st = db.getCnx().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(weblogService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static weblogService getInstance() {
        if (instance == null) {
            instance = new weblogService();
        }
        return instance;
    }

    public void insertWeblog(weblog w) {
        String req = "insert into weblog (id_artiste,categorie,contenu,photo,video) values ('" + w.getId_artiste() + "','" + w.getCategorie() + "','" + w.getContenu() + "','" + w.getPhoto() + "','" + w.getVideo() + "')";
        try {
            st.executeUpdate(req);
            System.out.println("weblog ajouté!");
        } catch (SQLException ex) {
            Logger.getLogger(weblogService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void deleteWeblog(weblog w) {
        String req = "delete from weblog where id_artiste=" + w.getId_artiste() + "&& id_web = " + w.getId_web();

        try {
            st.executeUpdate(req);
            System.out.println("weblog supprimé");
        } catch (SQLException ex) {
            Logger.getLogger(weblogService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateWeblog(weblog w) {
        
        String req="update weblog set categorie ='"+w.getCategorie()+"',contenu ='"+w.getContenu()+"',photo ='"+w.getPhoto()+"',video ='"+w.getVideo()+"'where id_web='"+w.getId_web()+"'";

        try {
            st.executeUpdate(req);
            System.out.println("weblog modifié avec succées!");
        } catch (SQLException ex) {
            Logger.getLogger(weblogService.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }
}



