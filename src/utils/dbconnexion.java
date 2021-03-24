/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sawssen
 */
public class dbconnexion {

    private String url = "jdbc:mysql://localhost:3306/artcom";
    private String login = "root";
    private String pwd = "";
    private Connection cnx;
    private static dbconnexion instance;
    
    
    private dbconnexion() {
        try {
            cnx=DriverManager.getConnection(url, login, pwd);
        } catch (SQLException ex) {
            Logger.getLogger(dbconnexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static dbconnexion getInstance(){
        if(instance==null){
            instance = new dbconnexion();
        }
        return instance;
    }

    public Connection getCnx() {
        return cnx;
    }
    
    
    
    
    
    
    
    
    
    
}
