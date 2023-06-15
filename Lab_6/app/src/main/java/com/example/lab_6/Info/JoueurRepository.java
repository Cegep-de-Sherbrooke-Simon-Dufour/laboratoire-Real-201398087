package com.example.lab_6.Info;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;


import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class JoueurRepository {

    private final JoueurDao joueursDao;
    private final LiveData<List<Joueur>> joueursLiveData;

    @Inject
    public JoueurRepository(AppDatabase database) {
        joueursDao = database.getDao();
        joueursLiveData = joueursDao.getJoueurs();
    }

    public int getPrevPhoto() {
        Executors.newSingleThreadExecutor().execute(() -> {
            joueursDao.getPrevPhoto();
        });
    }


    public void addJoueur(Joueur joueur) {
        Executors.newSingleThreadExecutor().execute(() -> {
            joueursDao.insert(joueur);

        });
        }
    public void deleteJoueur(Joueur joueur) {
            Executors.newSingleThreadExecutor().execute(() -> {
        joueursDao.delete(joueur);

    });
        }
    public LiveData<List<Joueur>> getLiveDataJoueurs() {return joueursLiveData; }



}
