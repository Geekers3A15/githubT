/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.entity;

/**
 *
 * @author Walid
 */
public class Disscussions {
    
    private int id_disc;
    private String contenu;
    
    public  Disscussions(){
    
}

    public Disscussions(int id_disc, String contenu) {
        this.id_disc = id_disc;
        this.contenu = contenu;
    }

    public int getId_disc() {
        return id_disc;
    }

    public String getContenu() {
        return contenu;
    }

    public void setId_disc(int id_disc) {
        this.id_disc = id_disc;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    @Override
    public String toString() {
        return "Disscussions{" + "id_disc=" + id_disc + ", contenu=" + contenu + '}';
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
        final Disscussions other = (Disscussions) obj;
        if (this.id_disc != other.id_disc) {
            return false;
        }
        return true;
    }
    
    
    
    
    
    
    
    
}
