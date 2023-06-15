package com.example.lab_6.Info;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Joueur.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract JoueurDao getDao();
}