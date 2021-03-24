/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entités;

import java.sql.Date;
import java.util.Objects;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Sawssen
 */
public class user {

    private SimpleIntegerProperty id_user;
    private SimpleStringProperty nom;
    private SimpleStringProperty prenom;
    private SimpleStringProperty pseudo;
    private SimpleStringProperty mdp;
    private SimpleStringProperty date_naiss;
    private SimpleStringProperty tel;
    private SimpleStringProperty email;
    private SimpleStringProperty role;
    private SimpleStringProperty bio;
    private SimpleStringProperty photo_profil;

    public user() {
    }

    public user(SimpleIntegerProperty id_user) {
        this.id_user = id_user;
    }

    public SimpleIntegerProperty getId_user() {
        return id_user;
    }

    public SimpleStringProperty getNom() {
        return nom;
    }

    public SimpleStringProperty getPrenom() {
        return prenom;
    }

    public SimpleStringProperty getPseudo() {
        return pseudo;
    }

    public SimpleStringProperty getMdp() {
        return mdp;
    }

    public SimpleStringProperty getDate_naiss() {
        return date_naiss;
    }

    public SimpleStringProperty getTel() {
        return tel;
    }

    public SimpleStringProperty getEmail() {
        return email;
    }

    public SimpleStringProperty getRole() {
        return role;
    }

    public SimpleStringProperty getBio() {
        return bio;
    }

    public SimpleStringProperty getPhoto_profil() {
        return photo_profil;
    }

    public void setId_user(int id_user) {
        this.id_user = new SimpleIntegerProperty(id_user);
    }

    public void setNom(String nom) {
        this.nom = new SimpleStringProperty(nom);
    }

    public void setPrenom(String prenom) {
        this.prenom = new SimpleStringProperty(prenom);
    }

    public void setPseudo(String pseudo) {
        this.pseudo = new SimpleStringProperty(pseudo);
    }

    public void setMdp(String mdp) {
        this.mdp = new SimpleStringProperty(mdp);
    }

    public void setDate_naiss(String date_naiss) {
        this.date_naiss = new SimpleStringProperty(date_naiss);
    }

    public void setTel(String tel) {
        this.tel = new SimpleStringProperty(tel);
    }

    public void setEmail(String email) {
        this.email = new SimpleStringProperty(email);
    }

    public void setRole(String role) {
        this.role = new SimpleStringProperty(role);
    }

    public void setBio(String bio) {
        this.bio = new SimpleStringProperty(bio);
    }

    public void setPhoto_profil(String photo_profil) {
        this.photo_profil = new SimpleStringProperty(photo_profil);
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
        final user other = (user) obj;
        if (!Objects.equals(this.id_user, other.id_user)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "user{" + "id_user=" + id_user + ", nom=" + nom + ", prenom=" + prenom + ", pseudo=" + pseudo + ", mdp=" + mdp + ", date_naiss=" + date_naiss + ", tel=" + tel + ", email=" + email + ", role=" + role + ", bio=" + bio + ", photo_profil=" + photo_profil + '}';
    }

}
