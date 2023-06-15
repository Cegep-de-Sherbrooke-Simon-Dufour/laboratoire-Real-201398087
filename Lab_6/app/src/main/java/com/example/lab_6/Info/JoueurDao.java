package com.example.lab_6.Info;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface JoueurDao {

    @Query("SELECT * FROM Joueur")
    LiveData<List<Joueur>> getJoueurs();

    @Query("SELECT image FROM Joueur WHERE joueur_id = MAX(joueur_id)")
    int getPrevPhoto();
    @Query("SELECT * FROM joueur WHERE joueur_id IN (:joueursIds)")
    LiveData<List<Joueur>> loadAllByIds(int[] joueursIds);

    @Query("SELECT * FROM joueur WHERE nom LIKE :first AND " + "courriel LIKE :last AND " + " image LIKE :image LIMIT 1")
    Joueur findByName(String first, String last, int image);

    @Insert
   void insert(Joueur ... joueur);

    @Delete
    void delete(Joueur joueur);

}

