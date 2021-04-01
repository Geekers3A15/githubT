/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entités.user;
import Entités.weblog;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

    public List<weblog> getAllWeblogs() {
        String req = "select * from weblog";
        List<weblog> list = new ArrayList<>();

        try {
            rs = st.executeQuery(req);
            while (rs.next()) {
                weblog w = new weblog();

                w.setId_web(rs.getInt(1));
                w.setId_artiste(rs.getInt(2));
                w.setTitre(rs.getString("titre"));
                w.setCategorie(rs.getString("catégorie"));
                w.setRating(rs.getInt("rating"));
                list.add(w);
            }

        } catch (SQLException ex) {
            Logger.getLogger(weblogService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<weblog> getAllWeblogsOfUser(int id_user) {
        String req = "select * from weblog where id_artiste=" + id_user;
        List<weblog> list = new ArrayList<>();

        try {
            rs = st.executeQuery(req);
            while (rs.next()) {
                weblog w = new weblog();

                w.setId_web(rs.getInt(1));
                w.setId_artiste(rs.getInt(2));
                w.setTitre(rs.getString("titre"));
                w.setCategorie(rs.getString("catégorie"));
                w.setRating(rs.getInt("rating"));
                list.add(w);
            }

        } catch (SQLException ex) {
            Logger.getLogger(weblogService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void insertWeblog(weblog w) {
        String req = "insert into weblog (id_artiste,catégorie,titre,rating) values ('" + w.getId_artiste().get() + "','" + w.getCategorie().get() + "','" + w.getTitre().get() + "','" + w.getRating().get() + "')";
        try {
            st.executeUpdate(req);
            System.out.println("weblog ajouté!");
        } catch (SQLException ex) {
            Logger.getLogger(weblogService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ObservableList<weblog> getWeblogByTitreObservable(String titre,int id_artiste) {
        String req = "select * from weblog where titre LIKE '%" + titre + "%'&& id_artiste  = " + id_artiste;
        ObservableList<weblog> list = FXCollections.observableArrayList();

        try {
            rs = st.executeQuery(req);
            while (rs.next()) {
                weblog p = new weblog();
                p.setId_web(rs.getInt(1));
                p.setId_artiste(rs.getInt(2));
                p.setTitre(rs.getString("titre"));
                p.setCategorie(rs.getString("catégorie"));
                p.setRating(0);
                list.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(weblogService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    /*public void deleteWeblog(weblog w) {
        String req = "delete from weblog where id_artiste=" + w.getId_artiste() + "&& id_web = " + w.getId_web();

        try {
            st.executeUpdate(req);
            System.out.println("weblog supprimé");
        } catch (SQLException ex) {
            Logger.getLogger(weblogService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
    public void deleteWeblog(int id_weblog) {
        String req = "delete from weblog where id_web=" + id_weblog;

        try {
            st.executeUpdate(req);
            System.out.println("weblog supprimé");
        } catch (SQLException ex) {
            Logger.getLogger(weblogService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteWeblogCard(int id_artiste) {
        String req = "delete from weblog where id_artiste=" + id_artiste;

        try {
            st.executeUpdate(req);
            System.out.println("weblog supprimé");
        } catch (SQLException ex) {
            Logger.getLogger(weblogService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*public void updateWeblog(weblog w) {
        
        String req="update weblog set categorie ='"+w.getCategorie()+"',contenu ='"+w.getContenu()+"',photo ='"+w.getPhoto()+"',video ='"+w.getVideo()+"'where id_web='"+w.getId_web()+"'";

        try {
            st.executeUpdate(req);
            System.out.println("weblog modifié avec succées!");
        } catch (SQLException ex) {
            Logger.getLogger(weblogService.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }*/
    public void updateWeblog(weblog w) {
        String req = "update weblog set catégorie ='" + w.getCategorie().get() + "',titre ='" + w.getTitre().get() + "',rating ='" + w.getRating().get() + "'where id_web='" + w.getId_web().get() + "'";

        try {
            st.executeUpdate(req);
            System.out.println("weblog updated");
        } catch (SQLException ex) {
            Logger.getLogger(weblogService.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public void updateTitreWeblog(weblog w) {
        String req = "update weblog set titre ='" + w.getTitre().get() + "'";

        try {
            st.executeUpdate(req);
            System.out.println("weblog updated");
        } catch (SQLException ex) {
            Logger.getLogger(weblogService.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public weblog getLastWeblogCreated(int id_artiste) {
        String req = "select MAX(id_web) from weblog where id_artiste =" + id_artiste;
        weblog w = new weblog();
        try {
            rs = st.executeQuery(req);

            rs.next();
            w.setId_web(rs.getInt(1));

        } catch (SQLException ex) {
            Logger.getLogger(weblogService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return w;

    }

    public weblog getWeblogById(int id_weblog) {
        String req = "select * from weblog  where id_web  =" + id_weblog;
        weblog w = new weblog();
        try {
            rs = st.executeQuery(req);

            while (rs.next()) {

                w.setId_web(rs.getInt(1));
                w.setId_artiste(rs.getInt(2));
                w.setTitre(rs.getString("titre"));
                w.setCategorie(rs.getString("catégorie"));
                w.setRating(rs.getInt("rating"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(weblogService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return w;
    }
}
