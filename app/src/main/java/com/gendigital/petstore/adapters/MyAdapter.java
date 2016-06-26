package com.gendigital.petstore.adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gendigital.petstore.db.DB_Conexion;
import com.gendigital.petstore.db.DB_Manager;
import com.gendigital.petstore.db.PetInfo;
import com.gendigital.petstore.R;

import java.util.ArrayList;

/**
 * Created by Gaby on 10/06/2016.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.petViewHolder> {
    private Activity activity;
    private ArrayList<PetInfo> petDataset;
    private DB_Manager dbManager;

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(ArrayList<PetInfo> myDataset, Activity activity) {
        this.petDataset = myDataset;
        this.activity = activity;
    }

    public static class petViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFoto;
        private TextView tvNombreCV;
        private TextView tvMeGusta;
        private ImageButton btnMegusta;

        public petViewHolder(View itemView) {
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombreCV = (TextView) itemView.findViewById(R.id.tvNombreCV);
            tvMeGusta = (TextView) itemView.findViewById(R.id.tvMeGusta);
            btnMegusta = (ImageButton) itemView.findViewById(R.id.btnMegusta);
        }
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.petViewHolder onCreateViewHolder(ViewGroup parent,int viewType) {
        // create a new view
        View vw = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_pet, parent, false);
        petViewHolder vh = new petViewHolder(vw);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final petViewHolder vHolder, int position) {
        // - get element from your dataset at this position

        final PetInfo petinfo = petDataset.get(position);
        //vHolder.tvNombreCV.setText("[" + Integer.toString(petinfo.getId()) + "] " + petinfo.getNombre() + "(" + Integer.toString(petinfo.getFoto()) + ")" + "(" + Integer.toString(petinfo.getLikes()) + ")");
        vHolder.tvNombreCV.setText( petinfo.getNombre());
        vHolder.imgFoto.setImageResource(petinfo.getFoto());
        vHolder.tvMeGusta.setText(Integer.toString(petinfo.getLikes()));
        vHolder.btnMegusta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (petinfo.incrementaLikes()) {
                    Toast.makeText(activity, "Entro a favoritos " + petinfo.getNombre(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(activity, "Diste like a " + petinfo.getNombre(), Toast.LENGTH_SHORT).show();
                }
                vHolder.tvMeGusta.setText(Integer.toString(petinfo.getLikes()));
                dbManager = new DB_Manager(activity);
                dbManager.actualizarMascota(petinfo);
            }
        });

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return petDataset.size();
    }
}
