/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.entity;


import java.util.Objects;

/**
 *
 * @author Walid
 */
public class Formulaire {
    
     private int id_form;
    private String service_demande;
    private int num_tel;
    private String date_limit;

    
    
    public Formulaire(){
        
    }

    public Formulaire(int id_form, String service_demande, int num_tel, String date_limit) {
        this.id_form = id_form;
        this.service_demande = service_demande;
        this.num_tel = num_tel;
        this.date_limit = date_limit;
    }

    

    public int getId_form() {
        return id_form;
    }

    public String getService_demande() {
        return service_demande;
    }

    public int getNum_tel() {
        return num_tel;
    }

    public String getDate_limit() {
        return date_limit;
    }
    
    



    public void setId_form(int id_form) {
        this.id_form = id_form;
    }

    public void setService_demande(String service_demande) {
        this.service_demande = service_demande;
    }

    public void setNum_tel(int num_tel) {
        this.num_tel = num_tel;
    }

    public void setDate_limit(String date_limit) {
        this.date_limit = date_limit;
    }

    @Override
    public String toString() {
        return "Formulaire{" + "id_form=" + id_form + ", service_demande=" + service_demande + ", num_tel=" + num_tel + ", date_limit=" + date_limit + '}';
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
        return true;
    }


  

   

   

   

   
   
    
    
  
    
    
    
    
    
    
    
    
    
    
    
   
    
    
    
    
    
    
    
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

