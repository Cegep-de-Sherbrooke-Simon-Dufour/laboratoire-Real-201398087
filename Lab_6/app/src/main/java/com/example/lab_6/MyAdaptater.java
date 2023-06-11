package com.example.lab_6;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;



public class MyAdaptater extends ListAdapter<Joueur, MyAdaptater.MyViewHolder> {

    private RecyclerCallback<Joueur> callback;

    public void setCallback(RecyclerCallback<Joueur> callback){ this.callback = callback;}
    public MyAdaptater() {
        super(new DiffUtil.ItemCallback<Joueur>() {
            @Override
            public boolean areItemsTheSame(Joueur oldUser, Joueur newUser) {
                return oldUser.getNom() == newUser.getNom();
            }

            @Override
            public boolean areContentsTheSame(Joueur oldUser, Joueur newUser) {
                return oldUser.equals(newUser);
            }
        });

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.joueur_view,parent,false));
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView nomView;
        TextView courrielView;
        Joueur joueurs;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nomView=itemView.findViewById(R.id.nom);
            courrielView=itemView.findViewById(R.id.courriel);
            imageView=itemView.findViewById(R.id.imageview);
            itemView.setOnClickListener(view -> {
                callback.returnValue(joueurs);
            });
        }
        public void bind(Joueur joueurs) {
            this.joueurs = joueurs;
            nomView.setText(joueurs.getNom());
            courrielView.setText(joueurs.getCourriel());
            imageView.setImageResource(joueurs.getImage());
        }
    }



}
