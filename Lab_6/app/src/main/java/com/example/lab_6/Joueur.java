package com.example.lab_6;

import java.util.Objects;

public class Joueur {


    private String nom;
   private String courriel;
   int image;

    public Joueur(String nom, String courriel, int image) {

        this.nom = nom;
        this.courriel = courriel;
        this.image = image;
    }

    public Joueur(String nom, String courriel) {

        this.nom = nom;
        this.courriel = courriel;
        this.image = R.drawable.a;

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCourriel() {
        return courriel;
    }

    public void setCourriel(String courriel) {
        this.courriel = courriel;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void delete(Joueur joueur){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Joueur joueur = (Joueur) o;
        return nom.equals(joueur.nom) && courriel.equals(joueur.courriel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, courriel);
    }
}
