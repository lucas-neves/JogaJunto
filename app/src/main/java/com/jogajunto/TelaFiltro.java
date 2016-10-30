package com.jogajunto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class TelaFiltro extends AppCompatActivity {

    Spinner spinner1;
    CheckBox checkEstacionamento;
    CheckBox checkVestiario;
    CheckBox checkLanchonete;
    CheckBox checkChurrasqueira;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String test = "quadra"+"id";
        setContentView(R.layout.activity_tela_filtro);

        checkEstacionamento = (CheckBox) findViewById(R.id.checkEstacionamento);
        checkVestiario = (CheckBox) findViewById(R.id.checkVestiario);
        checkLanchonete = (CheckBox) findViewById(R.id.checkLanchonete);
        checkChurrasqueira = (CheckBox) findViewById(R.id.checkChurrasqueira);


        spinner1 = (Spinner) findViewById(R.id.spinner1);


        List<String> list = new ArrayList<String>();
        list.add("Selecione uma opção");
        list.add("Futebol Society");
        list.add("Futebol de salão");
        list.add("Futebol de campo");
        list.add("Quadras Poliesportivas");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item,list);

        dataAdapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);

        spinner1.setAdapter(dataAdapter);





    }

    public void filtrarConteudo(View v){

        if(checkChurrasqueira.isChecked()){


        }
        if(checkEstacionamento.isChecked()){

        }
        if(checkLanchonete.isChecked()){

        }
        if(checkVestiario.isChecked()){

        }


        Toast.makeText(getApplicationContext(), "FILTRANDO...", Toast.LENGTH_SHORT).show();
    }

}
