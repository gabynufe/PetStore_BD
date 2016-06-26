package com.gendigital.petstore.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.gendigital.petstore.db.PetInfo;
import com.gendigital.petstore.R;
import com.gendigital.petstore.adapters.MyAdapterFav;
import com.gendigital.petstore.db.Pet_Favoritos;

import java.util.ArrayList;

/**
 * Created by Gaby on 16/06/2016.
 */

public class FavoritosActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public ArrayList<PetInfo> listaData2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

        Toolbar actionBar = (Toolbar) findViewById(R.id.barraSup);
        setSupportActionBar(actionBar);

        actionBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FavoritosActivity.this, "Regresando", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        /*
        listaData2 = new ArrayList<PetInfo>();
        listaData2.add(Pet_Favoritos.getItem(0));
        listaData2.add(Pet_Favoritos.getItem(1));
        listaData2.add(Pet_Favoritos.getItem(2));
        listaData2.add(Pet_Favoritos.getItem(3));
        listaData2.add(Pet_Favoritos.getItem(4));
        */


        mRecyclerView = (RecyclerView) findViewById(R.id.rvPetFav);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MyAdapterFav(Pet_Favoritos.listaFav, this);
        mRecyclerView.setAdapter(mAdapter);


    }

}
