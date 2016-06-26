package com.gendigital.petstore.adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gendigital.petstore.PerfilInfo;
import com.gendigital.petstore.R;

import java.util.ArrayList;

/**
 * Created by Gaby on 10/06/2016.
 */
public class MyAdapterPerfil extends RecyclerView.Adapter<MyAdapterPerfil.ViewHolder> {
    private Activity activity;
    private ArrayList<PerfilInfo> mDataset;

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapterPerfil(ArrayList<PerfilInfo> myDataset, Activity activity) {
        this.mDataset = myDataset;
        this.activity = activity;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFoto;
        private TextView tvMeGusta;

        public ViewHolder(View itemView) {
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvMeGusta = (TextView) itemView.findViewById(R.id.tvMeGusta);
        }
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapterPerfil.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View vw = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_perfil, parent, false);
        ViewHolder vh = new ViewHolder(vw);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        // - get element from your dataset at this position

        final PerfilInfo petinfo = mDataset.get(position);
        holder.imgFoto.setImageResource(petinfo.getFoto());
        holder.tvMeGusta.setText(petinfo.getMeGusta());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
