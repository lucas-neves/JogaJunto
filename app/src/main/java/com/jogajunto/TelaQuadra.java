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

    ImageButton btnMaps;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_quadra);

        btnMaps = (ImageButton) findViewById(R.id.btnMaps);
        btnMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFragment(new MapsFragment(), "Local da quadra");
            }
        });
        fragmentManager = getSupportFragmentManager();

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.content_maps, new MapsFragment(), "MapsFragment");
        transaction.commitAllowingStateLoss();
    }

    private void showFragment(Fragment fragment, String nome){
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.content_maps, fragment, nome);

        if (fragment.isHidden()) {
            transaction.show(fragment);
            Log.d("hidden","Show");
        } else {
            transaction.hide(fragment);
            Log.d("Shown","Hide");
        }

        transaction.commit();
    }
}
