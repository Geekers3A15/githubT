/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entités.contenu;
import Entités.user;
import Entités.weblog;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.dbconnexion;

/**
 *
 * @author Sawssen Gharbi
 */
public class contenuService {

    private static contenuService instance;
    private Statement st;
    private ResultSet rs;

    private contenuService() {
        dbconnexion db = dbconnexion.getInstance();
        try {
            st = db.getCnx().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(contenuService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static contenuService getInstance() {
        if (instance == null) {
            instance = new contenuService();
        }
        return instance;
    }

    public void insertContenu(contenu c) {
        String req = "insert into contenu (id_weblog,nom_contenu,photo,video,statut)values ('" + c.getId_weblog().get() + "','" + c.getNom_contenu().get() + "','" + c.getPhoto().get() + "','" + c.getVideo().get() + "','" + c.getStatut().get() + "')";
        try {
            st.executeUpdate(req);
            System.out.println("contenu inséré!");
        } catch (SQLException ex) {
            Logger.getLogger(contenuService.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    public void deleteContenu(int id_weblog) {
        String req = "DELETE FROM contenu where id_weblog=" + id_weblog;
        try {
            st.executeUpdate(req);
            System.out.println("contenu supprimé!");
        } catch (SQLException ex) {
            Logger.getLogger(contenuService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void deleteContenuByIdContenu(int id_contenu) {
        String req = "DELETE FROM contenu where id_contenu=" + id_contenu;
        try {
            st.executeUpdate(req);
            System.out.println("contenu supprimé!");
        } catch (SQLException ex) {
            Logger.getLogger(contenuService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ObservableList<contenu> getAllContenuByWeblog(int id_weblog) {
        String req = "select * from contenu where id_weblog =" + id_weblog;
        ObservableList<contenu> list = FXCollections.observableArrayList();
        try {
            rs = st.executeQuery(req);
            while (rs.next()) {
                contenu c = new contenu();
                c.setId_contenu(rs.getInt(1));
                c.setId_weblog(rs.getInt(2));
                c.setNom_contenu(rs.getString("nom_contenu"));
                c.setPhoto(rs.getString("photo"));
                c.setVideo(rs.getString("video"));
                c.setStatut(rs.getString("statut"));
                list.add(c);
            }

        } catch (SQLException ex) {
            Logger.getLogger(contenuService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public contenu getContenuById(int id_weblog) {
        String req = "select * from contenu  where id_weblog  =" + id_weblog;
        contenu c = new contenu();
        try {
            rs = st.executeQuery(req);

            while (rs.next()) {

                c.setId_contenu(rs.getInt(1));
                c.setId_weblog(rs.getInt(2));
                c.setNom_contenu(rs.getString("nom_contenu"));
                c.setStatut(rs.getString("statut"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(weblogService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }

    public void updateRating(int id_rating,weblog w) {

        String req = "update weblog set rating ='" + id_rating + "'where id_web='" + w.getId_web().get() + "'";

        try {
            st.executeUpdate(req);
            System.out.println("vou avez evaulé le weblog avec succées!");
        } catch (SQLException ex) {
            Logger.getLogger(userService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
