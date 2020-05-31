package com.codename1.uikit.pheonixui.entities;

public class Users {
    private String nom;
    private String prenom;
    private int tel;


    public Users(String nom, String prenom, int tel)
    {
        this.nom=nom;
        this.prenom=prenom;
        this.tel=tel;

    }


    public Users() {
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

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }
}
