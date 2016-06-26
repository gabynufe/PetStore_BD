package com.gendigital.petstore.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gendigital.petstore.db.DB_Manager;
import com.gendigital.petstore.db.PetInfo;
import com.gendigital.petstore.R;
import com.gendigital.petstore.adapters.MyAdapter;

import java.util.ArrayList;

/**
 * Created by Gaby on 18/06/2016.
 */
public class LineasFragment extends Fragment {
    private static final String TAG = "RecyclerViewFragment";
    public ArrayList<PetInfo> listaData;
    private DB_Manager dbManager;

    private RecyclerView.LayoutManager mLayoutManager;

    public LineasFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // obtiene lista
        dbManager = new DB_Manager(getActivity());
        listaData = dbManager.obtenerDatos();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_lista, container, false);
        v.setTag(TAG);

        RecyclerView mRecyclerView = (RecyclerView) v.findViewById(R.id.rvListaPets);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(llm);
        //mRecyclerView.setHasFixedSize(true);
        //mLayoutManager = new LinearLayoutManager(getActivity());
        //mRecyclerView.setLayoutManager(mLayoutManager);
        MyAdapter mAdapter = new MyAdapter(listaData, getActivity());
        mRecyclerView.setAdapter(mAdapter);
        return v;
    }

}