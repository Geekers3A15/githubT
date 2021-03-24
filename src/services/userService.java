/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entités.user;
import entités.weblog;
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
public class userService {

    private static userService instance;
    private Statement st;
    private ResultSet rs;

    private userService() {
        dbconnexion db = dbconnexion.getInstance();
        try {
            st = db.getCnx().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(userService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static userService getInstance() {
        if (instance == null) {
            instance = new userService();
        }
        return instance;
    }

    public List<user> getAllUsers() {
        String req = "select * from user";
        List<user> list = new ArrayList<>();

        try {
            rs = st.executeQuery(req);
            while (rs.next()) {
                user u = new user();
                u.setId_user(rs.getInt(1));
                u.setNom(rs.getString("nom"));
                list.add(u);
            }

        } catch (SQLException ex) {
            Logger.getLogger(userService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public ObservableList<user> getAllUsersObservable() {
        String req = "select * from user";
        ObservableList<user> list = FXCollections.observableArrayList();

        try {
            rs = st.executeQuery(req);
            while (rs.next());
            user p = new user();
            p.setId_user(rs.getInt(1));
            p.setNom(rs.getString("nom"));
            p.setPrenom(rs.getString("prenom"));
            p.setPseudo(rs.getString("pseudo"));
            p.setDate_naiss(rs.getString("date_naiss"));
            p.setTel(rs.getString("tel"));
            p.setEmail(rs.getString("email"));
            p.setRole(rs.getString("role"));
            p.setBio(rs.getString("bio"));

            list.add(p);

        } catch (SQLException ex) {
            Logger.getLogger(userService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public user getUserById(int id_user) {
        String req = "select * from user  where id_user  =" + id_user;
        user p = new user();
        try {
            rs = st.executeQuery(req);

            while (rs.next()) {

                p.setId_user(rs.getInt(1));
                p.setNom(rs.getString("nom"));
                p.setPrenom(rs.getString("prenom"));
                p.setPseudo(rs.getString("pseudo"));
                p.setDate_naiss(rs.getString("date_naiss"));
                p.setTel(rs.getString("tel"));
                p.setEmail(rs.getString("email"));
                p.setRole(rs.getString("role"));
                p.setBio(rs.getString("bio"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(userService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }
    public void updateUser(user u) {
        
       String req="update user set nom ='"+u.getNom().get()+"',prenom ='"+u.getPrenom().get()+"',pseudo ='"+u.getPseudo().get()+"',date_naiss ='"+u.getDate_naiss().get()+"',tel ='"+u.getTel().get()+"',email ='"+u.getEmail().get()+"',bio ='"+u.getBio().get()+"'where id_user='"+u.getId_user().get()+"'";
        
        try {
            st.executeUpdate(req);
            System.out.println("user modifié avec succées!");
        } catch (SQLException ex) {
            Logger.getLogger(userService.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }

}
