package com.jogajunto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Favoritos extends AppCompatActivity {

    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

        list = (ListView) findViewById(R.id.List);
        ArrayList<Quadra> quadras = new ArrayList<Quadra>();
        for (int i = 0; i < 10; i++)
            quadras.add(new Quadra());

        AdapterQuadra adapterQuadras = new AdapterQuadra(this, quadras);
        list.setAdapter(adapterQuadras);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> parent, View view, int position, long i)
            {
                Intent informations = new Intent(Favoritos.this, TelaQuadra.class);
                startActivity(informations);
                Favoritos.this.finish();
            }
        });

//        myList.setOnItemSelectedListener(new OnItemSelectedListener()
//        {
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long i)
//            {
//                TextView myPhone = (TextView)view.findViewById(R.id.txtphone);
//                MakeACall(myPhone.getText().toString());
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> arg0) {
//                // TODO Auto-generated method stub
//
//            }
//        });
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

