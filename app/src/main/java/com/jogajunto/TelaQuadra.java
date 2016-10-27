package com.jogajunto;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

public class TelaQuadra extends AppCompatActivity {

    private ImageButton btnMaps;
    private FragmentManager fragmentManager;
    private MapsFragment mapa = new MapsFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_quadra);

        btnMaps = (ImageButton) findViewById(R.id.btnMaps);
        btnMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFragment(mapa, "Local da quadra");
            }
        });
        fragmentManager = getSupportFragmentManager();
    }

    private void showFragment(Fragment fragment, String nome){
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.content_maps, mapa, "MapsFragment");
        transaction.commitAllowingStateLoss();
        btnMaps.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onBackPressed() {
        if(mapa.isVisible()){
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.remove(mapa);
            transaction.commit();
            btnMaps.setVisibility(View.VISIBLE);
        }else{
            Intent fav = new Intent(this, Favoritos.class);
            startActivity(fav);
            this.finish();
        }
    }
}
