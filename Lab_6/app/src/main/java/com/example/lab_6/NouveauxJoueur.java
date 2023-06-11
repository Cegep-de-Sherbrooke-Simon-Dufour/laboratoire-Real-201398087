package com.example.lab_6;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;



public class NouveauxJoueur extends AppCompatActivity {
    private String nom;
    private String courriel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nouveaux_joueur);

        Button ajouter = findViewById(R.id.btAjouter);
        ajouter.setOnClickListener(ajouterOnClickListener);
        Button annuler = findViewById(R.id.btAnnuler);
        annuler.setOnClickListener(annulerOnClickListener);
    }

    View.OnClickListener ajouterOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick (View v) {
            EditText nom = findViewById(R.id.nom);
            EditText courriel = findViewById(R.id.courriel);
            String nomAjout = nom.getText().toString();
            String courrielAjout = courriel.getText().toString();
            Intent resultIntent = new Intent();
            resultIntent.putExtra("nom", nomAjout);
            resultIntent.putExtra("courriel", courrielAjout );
            setResult(RESULT_OK, resultIntent);
            finish();
        }
    };

    View.OnClickListener annulerOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick (View v) {
            finish();
        }
    };
}
