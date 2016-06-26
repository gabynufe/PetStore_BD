package com.gendigital.petstore.activities;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.gendigital.petstore.R;
import com.gendigital.petstore.adapters.PageAdapter;
import com.gendigital.petstore.fragments.LineasFragment;
import com.gendigital.petstore.fragments.PerfilFragment;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar actionBar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actionBar = (Toolbar) findViewById(R.id.barraSup);
        if (actionBar != null) {
            setSupportActionBar(actionBar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        }

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        setUpTabs();

    }

    public void verFavoritos() {
        Toast.makeText(getApplicationContext(), "Ver los 5 favoritos!",
                Toast.LENGTH_LONG).show();
        Intent ventanaFav = new Intent(this, FavoritosActivity.class);
        startActivity(ventanaFav);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mFavoritos:
                verFavoritos();
                break;
            case R.id.mContacto:
                Intent ventanaContacto = new Intent(this, ContactoActivity.class);
                startActivity(ventanaContacto);
                break;
            case R.id.mAcerca:
                Intent ventanaAcerca = new Intent(this, AcercaActivity.class);
                startActivity(ventanaAcerca);
                break;
        }
        return true;
    }

    public void setUpTabs() {
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new LineasFragment());
        fragments.add(new PerfilFragment());

        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), fragments));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_photos);
    }

}