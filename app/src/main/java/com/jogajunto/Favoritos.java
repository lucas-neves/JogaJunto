package com.jogajunto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.jogajunto.tasks.FavoritarQuadraTask;

public class Favoritos extends AppCompatActivity {

    private ListView list;

    FavoritarQuadraTask task = new FavoritarQuadraTask(this);
//    List<Favorito> favoritos


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

        list = (ListView) findViewById(R.id.List);

        final AdapterQuadra adapterQuadras = new AdapterQuadra(this, MainActivity.quadras);
        list.setAdapter(adapterQuadras);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> parent, View view, int position, long i)
            {
                Intent informations = new Intent(Favoritos.this, TelaQuadra.class);
                informations.putExtra("Quadra", adapterQuadras.getItem(position));
                startActivity(informations);
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tela_quadra, menu);
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
}

