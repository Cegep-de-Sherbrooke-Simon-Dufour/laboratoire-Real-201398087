package com.example.lab_6.Info;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class JoueurRepository {

    @Inject
    public JoueurRepository() {}
    private final ArrayList<Joueur> joueurs = new ArrayList<>();
    private final MutableLiveData<List<Joueur>> joueursLiveData = new MutableLiveData<>(joueurs);

    public void addJoueur(Joueur joueur) {
        joueurs.add(joueur);
        joueursLiveData.setValue(joueurs);
    }
    public void deleteJoueur(Joueur joueur) {
        joueurs.remove(joueur);
    }
    public LiveData<List<Joueur>> getLiveDataJoueurs() {return joueursLiveData; }



}
