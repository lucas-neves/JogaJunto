package com.jogajunto;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class TelaQuadra extends AppCompatActivity {

    private ImageButton btnMaps;
    private FragmentManager fragmentManager;
    private MapsFragment mapa = new MapsFragment();

    ImageView image1;
    Spinner spinnerHorario;
    Spinner spinnerDia;
    Spinner spinnerMes;
    Spinner spinnerAno;
    AlertDialog alerta;
    Button botaoReservar;

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


        image1 = (ImageView) findViewById(R.id.image1);
        spinnerHorario = (Spinner)findViewById(R.id.spinnerHorario);
        spinnerDia = (Spinner)findViewById(R.id.spinnerDia);
        spinnerMes = (Spinner)findViewById(R.id.spinnerMes);
        spinnerAno = (Spinner)findViewById(R.id.spinnerAno);

        botaoReservar = (Button)findViewById(R.id.botaoReservar);

        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TelaQuadra.this, Pop.class));

            }
        });

        //ArrayList Spinner Horário

        List<String> listHorario = new ArrayList<String>();
        listHorario.add("Selecione um horário");
        listHorario.add("00:00");
        listHorario.add("02:00");
        listHorario.add("04:00");
        listHorario.add("06:00");
        listHorario.add("08:00");
        listHorario.add("10:00");
        listHorario.add("12:00");
        listHorario.add("14:00");
        listHorario.add("16:00");
        listHorario.add("18:00");


        ArrayAdapter<String> dataAdapterHorario = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item, listHorario);

        dataAdapterHorario.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);

        spinnerHorario.setAdapter(dataAdapterHorario);


        //ArrayList Spinner Dia

        List<String> listDia = new ArrayList<String>();
        listDia.add("Dia");
        listDia.add("01");listDia.add("02");listDia.add("03");listDia.add("04");listDia.add("05");listDia.add("06");listDia.add("07");listDia.add("08");listDia.add("09");
        listDia.add("10");listDia.add("11");listDia.add("12");listDia.add("13");listDia.add("14");listDia.add("15");listDia.add("16");listDia.add("17");listDia.add("18");listDia.add("19");
        listDia.add("20");listDia.add("21");listDia.add("22");listDia.add("23");listDia.add("24");listDia.add("25");listDia.add("26");listDia.add("27");listDia.add("28");listDia.add("29");
        listDia.add("30");
        listDia.add("31");


        ArrayAdapter<String> dataAdapterDia = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item, listDia);

        dataAdapterDia.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);

        spinnerDia.setAdapter(dataAdapterDia);


        //ArrayList Spinner Mes

        List<String> listMes = new ArrayList<String>();
        listMes.add("Mês");
        listMes.add("Janeiro");listMes.add("Fevereiro");listMes.add("Março");
        listMes.add("Abril");listMes.add("Maio");listMes.add("Junho");
        listMes.add("Julho");listMes.add("Agosto");listMes.add("Setembro");
        listMes.add("Outubro");listMes.add("Novembro");listMes.add("Dezembro");


        ArrayAdapter<String> dataAdapterMes = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item, listMes);

        dataAdapterMes.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);

        spinnerMes.setAdapter(dataAdapterMes);


        //ArrayList Spinner Ano

        List<String> listAno = new ArrayList<String>();
        listAno.add("Ano");
        listAno.add("2016");
        listAno.add("2017");
        listAno.add("2018");
        listAno.add("2019");
        listAno.add("2020");


        ArrayAdapter<String> dataAdapterAno = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item, listAno);

        dataAdapterAno.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);

        spinnerAno.setAdapter(dataAdapterAno);
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

    public void alertaReserva(View v) {
        //Cria o gerador do AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        //Validação Mês Fevereiro

        if (spinnerMes.getSelectedItem() == "Fevereiro") {
            if (Integer.parseInt(spinnerDia.getSelectedItem().toString()) > 28) {
                builder.setMessage("Fevereiro tem somente 28 dias!");

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        Toast.makeText(TelaQuadra.this, "Selecione um Dia Válido, Por Favor!", Toast.LENGTH_SHORT).show();
                    }
                });

                //cria o AlertDialog
                alerta = builder.create();
                //Exibe
                alerta.show();

                return;
            }
        }

        //Validação Mês com até 30 dias

        if (spinnerMes.getSelectedItem() == "Abril" ||
                spinnerMes.getSelectedItem() == "Junho" ||
                spinnerMes.getSelectedItem() == "Setembro" ||
                spinnerMes.getSelectedItem() == "Novembro") {

            if (Integer.parseInt(spinnerDia.getSelectedItem().toString()) > 30) {
                builder.setMessage("Este Mês tem somente 30 dias!");

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        Toast.makeText(TelaQuadra.this, "Selecione um Mês Válido, Por Favor!", Toast.LENGTH_SHORT).show();
                    }
                });

                //cria o AlertDialog
                alerta = builder.create();
                //Exibe
                alerta.show();

                return;
            }
        }

        //Validação Dia vazio

        if (spinnerDia.getSelectedItem() == "Dia") {
            builder.setMessage("Você não selecionou nenhum dia!");

            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface arg0, int arg1) {
                    Toast.makeText(TelaQuadra.this, "Selecione um Dia, Por Favor!", Toast.LENGTH_SHORT).show();
                }
            });

            //cria o AlertDialog
            alerta = builder.create();
            //Exibe
            alerta.show();

            return;

        }

        //Validação Mês vazio

        if (spinnerMes.getSelectedItem() == "Mês") {
            builder.setMessage("Você não selecionou nenhum mês!");

            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface arg0, int arg1) {
                    Toast.makeText(TelaQuadra.this, "Selecione um Mês, Por Favor!", Toast.LENGTH_SHORT).show();
                }
            });

            //cria o AlertDialog
            alerta = builder.create();
            //Exibe
            alerta.show();

            return;
        }
        //Validação Ano vazio

        if (spinnerAno.getSelectedItem() == "Ano") {
            builder.setMessage("Você não selecionou nenhum ano!");

            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface arg0, int arg1) {
                    Toast.makeText(TelaQuadra.this, "Selecione um Ano, Por Favor!", Toast.LENGTH_SHORT).show();
                }
            });

            //cria o AlertDialog
            alerta = builder.create();
            //Exibe
            alerta.show();

            return;
        }
        //Validação de horário vazio

        if (spinnerHorario.getSelectedItem() == "Selecione um horário") {
            builder.setMessage("Você não selecionou nenhum horário!");

            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface arg0, int arg1) {
                    Toast.makeText(TelaQuadra.this, "Selecione um horário, Por Favor!", Toast.LENGTH_SHORT).show();
                }
            });

            //cria o AlertDialog
            alerta = builder.create();
            //Exibe
            alerta.show();

            return;
        }


        //define o titulo
        builder.setTitle("Confirmado!");


        //define a mensagem
        builder.setMessage("Sua reserva do dia " + spinnerDia.getSelectedItem() + " de " + spinnerMes.getSelectedItem() + " de " + spinnerAno.getSelectedItem() + " às " + spinnerHorario.getSelectedItem() + "hs. Está Confirmada!");


        //define um botão como positivo
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                Toast.makeText(TelaQuadra.this, "Obrigado!", Toast.LENGTH_SHORT).show();
            }
        });

        //cria o AlertDialog
        alerta = builder.create();
        //Exibe
        alerta.show();
    }
}
