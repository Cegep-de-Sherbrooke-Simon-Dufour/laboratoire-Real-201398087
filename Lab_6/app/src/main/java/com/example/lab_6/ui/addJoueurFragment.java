package com.example.lab_6.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.lab_6.Info.Joueur;
import com.example.lab_6.R;


public class addJoueurFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_joueur, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        JoueurListViewModel viewModel = new ViewModelProvider(requireActivity()).get(JoueurListViewModel.class);

        EditText nom = view.findViewById(R.id.nom);
        EditText courriel = view.findViewById(R.id.courriel);


        Button btajouter = view.findViewById(R.id.btAjouter);
        btajouter.setOnClickListener(v-> {
            viewModel.addJoueur(nom.getText().toString(), courriel.getText().toString());
            Navigation.findNavController(view).navigateUp();
        });
        Button annuler = view.findViewById(R.id.btAnnuler);
        annuler.setOnClickListener(v-> {
            Navigation.findNavController(view).navigateUp();
        });
    }

}