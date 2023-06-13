package com.example.lab_6.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lab_6.Info.Joueur;
import com.example.lab_6.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;


public class JoueurListFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_joueur_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        JoueurListViewModel viewModel = new ViewModelProvider(requireActivity()).get(JoueurListViewModel.class);

        RecyclerView recyclerView = view.findViewById(R.id.joueur_list);
        FloatingActionButton button = view.findViewById(R.id.btAjout);

        JoueurAdapter adapter = new JoueurAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        viewModel.getJoueurs().observe(getViewLifecycleOwner(), new Observer<List<Joueur>>() {
            @Override
            public void onChanged(List<Joueur> joueurs) {
                adapter.submitList(joueurs);
            }
        });

        button.setOnClickListener(v -> {
            Navigation.findNavController(view).navigate(R.id.action_joueurListFragment_to_addJoueurFragment);
        });
    }
}
