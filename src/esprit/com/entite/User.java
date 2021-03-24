/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.entite;

import java.sql.Date;

/**
 *
 * @author Walid
 */
public class User {
    
    private int id_user;
    private String nom ;
    private String prenom;
    private String pseudo;
    private String mdp;
    private Date date_naiss;
    private String role;
    private String bio;
    private String photo_profil;

    public User() {
    }

    public User(String nom, String prenom, String pseudo, String mdp, Date date_naiss, String role, String bio, String photo_profil) {
        this.nom = nom;
        this.prenom = prenom;
        this.pseudo = pseudo;
        this.mdp = mdp;
        this.date_naiss = date_naiss;
        this.role = role;
        this.bio = bio;
        this.photo_profil = photo_profil;
    }

    public User(int id_user, String nom, String prenom, String pseudo, String mdp, Date date_naiss, String role, String bio, String photo_profil) {
        this.id_user = id_user;
        this.nom = nom;
        this.prenom = prenom;
        this.pseudo = pseudo;
        this.mdp = mdp;
        this.date_naiss = date_naiss;
        this.role = role;
        this.bio = bio;
        this.photo_profil = photo_profil;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public Date getDate_naiss() {
        return date_naiss;
    }

    public void setDate_naiss(Date date_naiss) {
        this.date_naiss = date_naiss;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getPhoto_profil() {
        return photo_profil;
    }

    public void setPhoto_profil(String photo_profil) {
        this.photo_profil = photo_profil;
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
        final User other = (User) obj;
        if (this.id_user != other.id_user) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "user{" + "id_user=" + id_user + ", nom=" + nom + ", prenom=" + prenom + ", pseudo=" + pseudo + ", mdp=" + mdp + ", date_naiss=" + date_naiss + ", role=" + role + ", bio=" + bio + ", photo_profil=" + photo_profil + '}';
    }

    
}
