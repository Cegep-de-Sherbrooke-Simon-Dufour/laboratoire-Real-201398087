package com.example.lab_6;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class RecycleView extends AppCompatActivity {

private String nom;
private String courriel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycleview);

        FloatingActionButton ajout = findViewById(R.id.btAjout);


        RecyclerView recyclerView = findViewById(R.id.recycleview);

        List<Joueur> joueurs = new ArrayList<Joueur>();
        joueurs.add(new Joueur("John wick", "john.wick@email.com", R.drawable.a));
        joueurs.add(new Joueur("Robert j", "robert.j@email.com", R.drawable.b));
        joueurs.add(new Joueur("James Gunn", "james.gunn@email.com", R.drawable.c));
        joueurs.add(new Joueur("Ricky tales", "rickey.tales@email.com", R.drawable.d));
        joueurs.add(new Joueur("Micky mose", "mickey.mouse@email.com", R.drawable.e));
        joueurs.add(new Joueur("Pick War", "pick.war@email.com", R.drawable.f));
        joueurs.add(new Joueur("Leg piece", "leg.piece@email.com", R.drawable.g));
        joueurs.add(new Joueur("Apple Mac", "apple.mac@email.com", R.drawable.g));
        joueurs.add(new Joueur("John wick", "john.wick@email.com", R.drawable.a));
        joueurs.add(new Joueur("Robert j", "robert.j@email.com", R.drawable.b));
        joueurs.add(new Joueur("James Gunn", "james.gunn@email.com", R.drawable.c));
        joueurs.add(new Joueur("Ricky tales", "rickey.tales@email.com", R.drawable.d));
        joueurs.add(new Joueur("Micky mose", "mickey.mouse@email.com", R.drawable.e));
        joueurs.add(new Joueur("Pick War", "pick.war@email.com", R.drawable.f));
        joueurs.add(new Joueur("Leg piece", "leg.piece@email.com", R.drawable.g));
        joueurs.add(new Joueur("Apple Mac", "apple.mac@email.com", R.drawable.g));


        MyAdaptater adaptater = new MyAdaptater();
        ActivityResultLauncher<Intent> mGetContent = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        Intent data = result.getData();
                        nom =data.getStringExtra("nom");
                        courriel =data.getStringExtra("courriel");
                        joueurs.add(new Joueur(nom,courriel));
                        adaptater.submitList(new ArrayList<>(joueurs));
                    }
                });

        ajout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecycleView.this, NouveauxJoueur.class);
                mGetContent.launch(intent);
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adaptater.setCallback(object -> {
            joueurs.remove(object);
            adaptater.submitList(new ArrayList<>(joueurs));
        });
        recyclerView.setAdapter(adaptater);
        adaptater.submitList(new ArrayList<>(joueurs));
    }


    }

