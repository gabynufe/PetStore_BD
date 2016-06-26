package com.gendigital.petstore.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gendigital.petstore.PerfilInfo;
import com.gendigital.petstore.R;
import com.gendigital.petstore.adapters.MyAdapterPerfil;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {

    private static final String TAG = "RecyclerViewFragment";
    public ArrayList<PerfilInfo> listaData;
    private RecyclerView.LayoutManager mLayoutManager;
    private ImageView imgFoto;
    private TextView tvNombreCV;

    public PerfilFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        cargaDatos();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);
        v.setTag(TAG);

        RecyclerView mRecyclerView = (RecyclerView) v.findViewById(R.id.rvPerfil);
        GridLayoutManager llm = new GridLayoutManager(getActivity(),3);
        llm.setOrientation(GridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(llm);
        MyAdapterPerfil mAdapter = new MyAdapterPerfil(listaData, getActivity());
        mRecyclerView.setAdapter(mAdapter);


        imgFoto = (ImageView) v.findViewById(R.id.imgFoto);
        tvNombreCV = (TextView) v.findViewById(R.id.tvNombreCV);

        return v;
    }

    public void cargaDatos() {
        listaData = new ArrayList<PerfilInfo>();
        listaData.add(new PerfilInfo(R.drawable.pez, 11));
        listaData.add(new PerfilInfo(R.drawable.pez, 12));
        listaData.add(new PerfilInfo(R.drawable.pez, 13));
        listaData.add(new PerfilInfo(R.drawable.pez, 14));
        listaData.add(new PerfilInfo(R.drawable.pez, 15));
        listaData.add(new PerfilInfo(R.drawable.pez, 16));
        listaData.add(new PerfilInfo(R.drawable.pez, 17));
        listaData.add(new PerfilInfo(R.drawable.pez, 18));
        listaData.add(new PerfilInfo(R.drawable.pez, 19));
        listaData.add(new PerfilInfo(R.drawable.pez, 20));
        listaData.add(new PerfilInfo(R.drawable.pez, 21));
        listaData.add(new PerfilInfo(R.drawable.pez, 22));
        listaData.add(new PerfilInfo(R.drawable.pez, 23));

    }

}