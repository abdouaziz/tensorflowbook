package com.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Piece {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id  ;
    private  String datelivance ;
    private String type_id ;
    private String sexe ;
    private String nom ;
    private  String datexpiration ;
    private  String taille ;
    private  String lieudenaissance ;
    private  String adresse ;
    private  String image_id ;
    private  String prenom ;
    private  String datedenaissance ;
    private  String cni ;
    private  String status ;

    public Piece() {
    }





    public Piece(String datelivance, String type_id, String sexe, String nom, String datexpiration, String taille, String lieudenaissance, String adresse, String image_id, String prenom, String datedenaissance, String cni, String status) {

        this.datelivance = datelivance;
        this.type_id = type_id;
        this.sexe = sexe;
        this.nom = nom;
        this.datexpiration = datexpiration;
        this.taille = taille;
        this.lieudenaissance = lieudenaissance;
        this.adresse = adresse;
        this.image_id = image_id;
        this.prenom = prenom;
        this.datedenaissance = datedenaissance;
        this.cni = cni;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDatelivance() {
        return datelivance;
    }

    public void setDatelivance(String datelivance) {
        this.datelivance = datelivance;
    }

    public String getType_id() {
        return type_id;
    }

    public void setType_id(String type_id) {
        this.type_id = type_id;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDatexpiration() {
        return datexpiration;
    }

    public void setDatexpiration(String datexpiration) {
        this.datexpiration = datexpiration;
    }

    public String getTaille() {
        return taille;
    }

    public void setTaille(String taille) {
        this.taille = taille;
    }

    public String getLieudenaissance() {
        return lieudenaissance;
    }

    public void setLieudenaissance(String lieudenaissance) {
        this.lieudenaissance = lieudenaissance;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getImage_id() {
        return image_id;
    }

    public void setImage_id(String image_id) {
        this.image_id = image_id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDatedenaissance() {
        return datedenaissance;
    }

    public void setDatedenaissance(String datedenaissance) {
        this.datedenaissance = datedenaissance;
    }

    public String getCni() {
        return cni;
    }

    public void setCni(String cni) {
        this.cni = cni;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Piece{" +
                "id=" + id +
                ", datelivance='" + datelivance + '\'' +
                ", type_id='" + type_id + '\'' +
                ", sexe='" + sexe + '\'' +
                ", nom='" + nom + '\'' +
                ", datexpiration='" + datexpiration + '\'' +
                ", taille='" + taille + '\'' +
                ", lieudenaissance='" + lieudenaissance + '\'' +
                ", adresse='" + adresse + '\'' +
                ", image_id='" + image_id + '\'' +
                ", prenom='" + prenom + '\'' +
                ", datedenaissance='" + datedenaissance + '\'' +
                ", cni='" + cni + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
