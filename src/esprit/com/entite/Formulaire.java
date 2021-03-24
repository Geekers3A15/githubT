/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.entite;


import java.sql.Date;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Walid
 */
public class Formulaire {
    
    private SimpleIntegerProperty id_form;
    private SimpleIntegerProperty id_user;
    private SimpleIntegerProperty id_user_cli;
    private SimpleStringProperty service_demande;
    private SimpleIntegerProperty num_tel;
    private SimpleStringProperty date_limit;
    private SimpleStringProperty status;
    private Date date_creation;

    
    
    public Formulaire(){
        
    }

    public Formulaire(SimpleIntegerProperty id_form, SimpleIntegerProperty id_user, SimpleIntegerProperty id_user_cli, SimpleStringProperty service_demande, SimpleIntegerProperty num_tel, SimpleStringProperty date_limit, SimpleStringProperty status, Date date_creation) {
        this.id_form = id_form;
        this.id_user = id_user;
        this.id_user_cli = id_user_cli;
        this.service_demande = service_demande;
        this.num_tel = num_tel;
        this.date_limit = date_limit;
        this.status = status;
        this.date_creation = date_creation;
    }

    public Formulaire(SimpleStringProperty service_demande, SimpleIntegerProperty num_tel, SimpleStringProperty date_limit, SimpleStringProperty status, Date date_creation) {
        this.service_demande = service_demande;
        this.num_tel = num_tel;
        this.date_limit = date_limit;
        this.status = status;
        this.date_creation = date_creation;
    }

    public Formulaire(String service_demande, int num_tel, String date_limit) {
        this.service_demande =  new SimpleStringProperty(service_demande);
        this.num_tel = new SimpleIntegerProperty(num_tel);
        this.date_limit = new SimpleStringProperty(date_limit);
    }

    public Formulaire(SimpleStringProperty service_demande, SimpleIntegerProperty num_tel, SimpleStringProperty date_limit, SimpleStringProperty status) {
        this.service_demande = service_demande;
        this.num_tel = num_tel;
        this.date_limit = date_limit;
        this.status = status;
    }

    public SimpleIntegerProperty getId_form() {
        return id_form;
    }

    public SimpleIntegerProperty getId_user() {
        return id_user;
    }

    public SimpleIntegerProperty getId_user_cli() {
        return id_user_cli;
    }

    public SimpleStringProperty getService_demande() {
        return service_demande;
    }

    public SimpleIntegerProperty getNum_tel() {
        return num_tel;
    }

    public SimpleStringProperty getDate_limit() {
        return date_limit;
    }

    public SimpleStringProperty getStatus() {
        return status;
    }

    public Date getDate_creation() {
        return date_creation;
    }

    
    public void setId_form(int id_form) {
        this.id_form = new SimpleIntegerProperty(id_form);
    }

    public void setId_user(int id_user) {
        this.id_user = new SimpleIntegerProperty(id_user);
    }

    public void setId_user_cli(int id_user_cli) {
        this.id_user_cli = new SimpleIntegerProperty(id_user_cli);
    }

    public void setService_demande(String service_demande) {
        this.service_demande = new SimpleStringProperty(service_demande);
    }

    public void setNum_tel(int num_tel) {
        this.num_tel = new SimpleIntegerProperty(num_tel);
    }

    public void setDate_limit(String date_limit) {
        this.date_limit = new SimpleStringProperty(date_limit);
    }

    public void setStatus(String status) {
        this.status = new SimpleStringProperty(status);
    }

    public void setDate_creation(Date date_creation) {
        this.date_creation = date_creation;
    }

    
    

  

    

   

   
    

   

   
    

    @Override
    public String toString() {
        return "Formulaire{" + "id_form=" + id_form + ", id_user=" + id_user + ", service_demande=" + service_demande + ", num_tel=" + num_tel + ", date_limit=" + date_limit + '}';
    }

   

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Formulaire other = (Formulaire) obj;
        if (this.id_form != other.id_form) {
            return false;
        }
        if (this.id_user != other.id_user) {
            return false;
        }
        return true;
    }

   

    
    

    

}
    
    
    
    
    
    
    
    
    
    
    
    
    

