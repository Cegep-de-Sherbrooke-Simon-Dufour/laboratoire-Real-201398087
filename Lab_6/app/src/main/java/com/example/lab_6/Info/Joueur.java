package com.example.lab_6.Info;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.lab_6.R;

import java.util.Objects;
import java.util.concurrent.Executors;

@Entity
public class Joueur  {


    public int imgPerso = photo();
        @PrimaryKey(autoGenerate = true)
        public int joueur_id;

        @ColumnInfo(name = "nom")
        public String nom;
        @ColumnInfo(name = "courriel")
        public String courriel;
        @ColumnInfo(name = "image")
        public int image;



public int photo(){
    int img = getPrevPhoto();
    if(img<R.drawable.h){
        img = (img+100);

    }else{
        img = R.drawable.a;
    }
    return img;
}

    private int getPrevPhoto() {
        return JoueurRepository.getPrevPhoto();
    }


    public Joueur(String nom, String courriel) {

        this.nom = nom;
        this.courriel = courriel;
        this.image = imgPerso;


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
