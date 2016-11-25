package com.jogajunto;

import android.content.Intent;
import android.os.Bundle;

import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.jogajunto.modelo.Quadra;

import java.util.List;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static List<Quadra> quadras;

    ImageButton yes;
    ImageButton no;
    ImageButton info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //para garantir que a internet será acessada
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        FrameLayout frame = (FrameLayout) findViewById(R.id.graphics_holder);
        final PlayAreaView image = new PlayAreaView(this);
        frame.addView(image);

        View header = LayoutInflater.from(this).inflate(R.layout.nav_header_main, null);
        navigationView.addHeaderView(header);
        TextView textViewUser = (TextView) header.findViewById(R.id.username);
        textViewUser.setText(Autenticacao.cliente.getUsername());
        TextView textViewEmail = (TextView) header.findViewById(R.id.userEmail);
        textViewEmail.setText(Autenticacao.cliente.getEmail());

        info = (ImageButton) findViewById(R.id.btnInfo);
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent info = new Intent(MainActivity.this, TelaQuadra.class);
                info.putExtra("Quadra", image.showInformations());
                startActivity(info);
            }
        });
        yes = (ImageButton) findViewById(R.id.btnYes);
        yes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                image.likeAction();
            }
        });
        no = (ImageButton) findViewById(R.id.btnNo);
        no.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                image.deslikeAction();
            }
        });
    }

    public void openInformations(View v){
        Intent informations = new Intent(MainActivity.this, TelaQuadra.class);
        startActivity(informations);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

//            ReceberQuadrasTask quadrasTask = new ReceberQuadrasTask();
//            List<Quadra> quadra = quadrasTask.doInBackground(null);
//
//        ReceberPostagemTask postagemTask = new ReceberPostagemTask();
//        Quadra quadra = postagemTask.doInBackground(33);

            Intent fav = new Intent(this, Favoritos.class);
            startActivity(fav);

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {
            //Tela configurações

            Intent filtro = new Intent(this, TelaFiltro.class);
            startActivity(filtro);
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
