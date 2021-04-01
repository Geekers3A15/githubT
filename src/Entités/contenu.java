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
 * @author Sawssen Gharbi
 */
public class contenu {

    private SimpleIntegerProperty id_contenu;
    private SimpleIntegerProperty id_weblog;
    private SimpleStringProperty nom_contenu;
    private SimpleStringProperty photo;
    private SimpleStringProperty video;
    private SimpleStringProperty statut;
    private SimpleStringProperty url;

    public contenu() {
    }

    public SimpleIntegerProperty getId_contenu() {
        return id_contenu;
    }

    public SimpleIntegerProperty getId_weblog() {
        return id_weblog;
    }

    public SimpleStringProperty getNom_contenu() {
        return nom_contenu;
    }

    public SimpleStringProperty getPhoto() {
        return photo;
    }

    public SimpleStringProperty getVideo() {
        return video;
    }

    public SimpleStringProperty getStatut() {
        return statut;
    }

    public void setId_contenu(int id_contenu) {
        this.id_contenu = new SimpleIntegerProperty(id_contenu);
    }

    public void setId_weblog(int id_weblog) {
        this.id_weblog = new SimpleIntegerProperty(id_weblog);
    }

    public void setNom_contenu(String nom_contenu) {
        this.nom_contenu = new SimpleStringProperty(nom_contenu);
    }

    public void setPhoto(String photo) {
        this.photo = new SimpleStringProperty(photo);
    }

    public void setVideo(String video) {
        this.video = new SimpleStringProperty(video);
    }

    public void setStatut(String statut) {
        this.statut = new SimpleStringProperty(statut);
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
        final contenu other = (contenu) obj;
        if (!Objects.equals(this.id_contenu, other.id_contenu)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "contenu{" + "id_contenu=" + id_contenu + ", id_weblog=" + id_weblog + ", nom_contenu=" + nom_contenu + ", photo=" + photo + ", video=" + video + ", statut=" + statut + '}';
    }

    public SimpleStringProperty getUrl() {
        if (!this.photo.get().equals("")) {
            url = getPhoto();

            return url;

        } else if (!(this.video.get().equals(""))) {
            url = getVideo();
            return url;
        } else {

            return url = getStatut();
        }

    }
}
