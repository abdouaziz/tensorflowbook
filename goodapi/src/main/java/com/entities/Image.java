package com.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id ;
    private String chemin ;

    public Image() {
    }

    public Image(Long id, String chemin) {
        this.id = id;
        this.chemin = chemin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChemin() {
        return chemin;
    }

    public void setChemin(String chemin) {
        this.chemin = chemin;
    }

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", chemin='" + chemin + '\'' +
                '}';
    }
}
