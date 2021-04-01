/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entités;

import java.util.Objects;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Sawssen
 */
public class weblog {

    private SimpleIntegerProperty id_web;
    private SimpleIntegerProperty id_artiste;
    private SimpleStringProperty categorie;
    private SimpleStringProperty titre;
    private SimpleIntegerProperty rating;

    public weblog() {
    }

   
    

    public SimpleIntegerProperty getId_web() {
        return id_web;
    }

    public SimpleIntegerProperty getId_artiste() {
        return id_artiste;
    }

    public SimpleStringProperty getCategorie() {
        return categorie;
    }

    public SimpleStringProperty getTitre() {
        return titre;
    }

    public SimpleIntegerProperty getRating() {
        return rating;
    }
    

    public void setId_web(int id_web) {
        this.id_web = new SimpleIntegerProperty(id_web);
    }

    public void setId_artiste(int id_artiste) {
        this.id_artiste = new SimpleIntegerProperty(id_artiste);
    }

    public void setCategorie(String categorie) {
        this.categorie = new SimpleStringProperty(categorie);
    }

    public void setTitre(String titre) {
        this.titre = new SimpleStringProperty(titre);
    }

    public void setRating(int rating) {
        this.rating = new SimpleIntegerProperty(rating);
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
        final weblog other = (weblog) obj;
        if (!Objects.equals(this.id_web, other.id_web)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "weblog{" + "id_web=" + id_web + ", id_artiste=" + id_artiste + ", categorie=" + categorie + ", titre=" + titre + '}';
    }

}
