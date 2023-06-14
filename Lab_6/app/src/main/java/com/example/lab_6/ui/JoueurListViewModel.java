package com.example.lab_6.ui;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.lab_6.Info.Joueur;
import com.example.lab_6.Info.JoueurRepository;


import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class JoueurListViewModel extends ViewModel {

    private JoueurRepository joueurRepository;

    @Inject
    public JoueurListViewModel(JoueurRepository joueurRepository) {this.joueurRepository = joueurRepository; }


    public LiveData<List<Joueur>> getJoueurs() {return joueurRepository.getLiveDataJoueurs();}

    public void addJoueur( String nom, String courriel){joueurRepository.addJoueur(new Joueur( nom, courriel)); }

    public void deleteJoueur(Joueur object){joueurRepository.deleteJoueur(object); }
}
