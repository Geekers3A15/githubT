/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entités;

/**
 *
 * @author Sawssen
 */
public class weblog {

    private int id_web;
    private int id_artiste;
    private String categorie;
    private String contenu;
    private String photo;
    private String video;

    public weblog() {
    }

    public weblog(int id_web, int id_artiste, String categorie, String contenu, String photo, String video) {
        this.id_web = id_web;
        this.id_artiste = id_artiste;
        this.categorie = categorie;
        this.contenu = contenu;
        this.photo = photo;
        this.video = video;
    }

    public weblog(String categorie, String contenu, String photo, String video) {

        this.categorie = categorie;
        this.contenu = contenu;
        this.photo = photo;
        this.video = video;
    }

    public weblog(int id_artiste, String categorie, String contenu, String photo, String video) {
        this.id_artiste = id_artiste;
        this.categorie = categorie;
        this.contenu = contenu;
        this.photo = photo;
        this.video = video;
    }

    public int getId_artiste() {
        return id_artiste;
    }

    public void setId_artiste(int id_artiste) {
        this.id_artiste = id_artiste;
    }

    public int getId_web() {
        return id_web;
    }

    public void setId_web(int id_web) {
        this.id_web = id_web;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
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
        if (this.id_web != other.id_web) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "weblog{" + "id_web=" + id_web + ", id_artiste=" + id_artiste + ", categorie=" + categorie + ", contenu=" + contenu + ", photo=" + photo + ", video=" + video + '}';
    }

}
