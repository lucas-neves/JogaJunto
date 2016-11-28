package com.jogajunto;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.StrictMode;
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
import android.widget.TextView;
import android.widget.Toast;

import com.jogajunto.tasks.BackgroundMail;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class TelaQuadra extends AppCompatActivity {

    private ImageButton btnMaps;
    private FragmentManager fragmentManager;
    private MapsFragment mapa;

    ImageView fotoQuadra;
    TextView nomeQuadra;
    TextView endereco;
    TextView telefone;
    TextView valorQuadra;
    TextView opcionais;
    Spinner spinnerHorario;
    Spinner spinnerDia;
    Spinner spinnerMes;
    Spinner spinnerAno;
    AlertDialog alerta;
    Button botaoReservar;

    String[] informations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        if (!Autenticacao.autenticado) {
            Intent i = new Intent(this, LoginActivity.class);
            startActivity(i);
            finish();
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_quadra);

        //para garantir que a internet será acessada
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        
        Intent i = getIntent();
        informations = i.getStringArrayExtra("Quadra");

        fotoQuadra = (ImageView) findViewById(R.id.fotoQuadra);
        nomeQuadra = (TextView) findViewById(R.id.nomeQuadra);
        endereco = (TextView) findViewById(R.id.enderecoQuadra);
        telefone = (TextView) findViewById(R.id.telefoneQuadra);
        valorQuadra = (TextView) findViewById(R.id.valorQuadra);
        opcionais = (TextView) findViewById(R.id.opcionais);

        spinnerHorario = (Spinner)findViewById(R.id.spinnerHorario);
        spinnerDia = (Spinner)findViewById(R.id.spinnerDia);
        spinnerMes = (Spinner)findViewById(R.id.spinnerMes);
        spinnerAno = (Spinner)findViewById(R.id.spinnerAno);

        botaoReservar = (Button)findViewById(R.id.botaoReservar);
        botaoReservar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertaReserva(view);
            }
        });

        Picasso.with(this)
               .load(informations[0])
               .into(fotoQuadra);
        fotoQuadra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TelaQuadra.this, Pop.class).putExtra("URL", informations[0]));
            }
        });

        nomeQuadra.setText(informations[1]);
        nomeQuadra.setTypeface(null, Typeface.BOLD);;
        endereco.setText(informations[2]);
        endereco.setTypeface(null, Typeface.BOLD);
        telefone.setText(informations[3]);
        telefone.setTypeface(null, Typeface.BOLD);
        valorQuadra.setText("R$ "+informations[4]+"0");
        valorQuadra.setTypeface(null, Typeface.BOLD);
        opcionais.setText(informations[5]);
        opcionais.setTypeface(null, Typeface.BOLD);

        mapa = new MapsFragment();
        mapa.setLat1(Float.parseFloat(informations[6].replace(",",".")));
        mapa.setLat2(Float.parseFloat(informations[7].replace(",",".")));
        btnMaps = (ImageButton) findViewById(R.id.btnMaps);
        btnMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFragment(mapa, "Local da quadra");
            }
        });
        fragmentManager = getSupportFragmentManager();

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

    public void sendEmail(String dia, String mes, String ano, String horario){
        BackgroundMail sendMailTask = new BackgroundMail(TelaQuadra.this);
        sendMailTask.setGmailUserName("equipejogajunto@gmail.com");
        sendMailTask.setGmailPassword("Jog@junto123");
        sendMailTask.setMailTo("lucas_neves580@hotmail.com");
        sendMailTask.setFormSubject("Reserva efetuada!");
        sendMailTask.setFormBody("Seu jogo está marcado!\n\n" +
                "Local: "+informations[2]+"\n" +
                "Data: "+dia+"/"+mes+"/"+ano+" às "+horario+"\n\n" +
                "Para cancelar, ligue para (11)"+informations[3].replace(" ","")+" em até " +
                "1 semana antes do jogo. Sujeito a multa!\n\n");
        sendMailTask.setSendingMessage("Checando disponibilidade...");
        sendMailTask.setSendingMessageSuccess("Reserva efetuada com sucesso!");
        sendMailTask.send();
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

        //Validação Mês Fevereiro

        String dia = spinnerDia.getSelectedItem().toString();
        String mes = spinnerMes.getSelectedItem().toString();
        String ano = spinnerAno.getSelectedItem().toString();
        String horario = spinnerHorario.getSelectedItem().toString();

        if (mes == "Fevereiro") {
            if (Integer.parseInt(spinnerDia.getSelectedItem().toString()) > 28) {
                Toast.makeText(TelaQuadra.this, "Fevereiro tem somente 28 dias, Hehe!", Toast.LENGTH_SHORT).show();
                return;
            }
        }

        //Validação Mês com até 30 dias

        if (mes == "Abril" || mes == "Junho" || mes == "Setembro" || mes == "Novembro") {
            if (Integer.parseInt(spinnerDia.getSelectedItem().toString()) > 30) {
                Toast.makeText(TelaQuadra.this, "Este Mês tem somente 30 dias, Hehe!", Toast.LENGTH_SHORT).show();
                return;
            }
        }

        //Validação Dia vazio

        if (dia == "Dia") {
            Toast.makeText(TelaQuadra.this, "Selecione um Dia, Por Favor!", Toast.LENGTH_SHORT).show();
            return;
        }

        //Validação Mês vazio

        if (mes == "Mês") {
            Toast.makeText(TelaQuadra.this, "Selecione um Mês, Por Favor!", Toast.LENGTH_SHORT).show();
            return;
        }

        //Validação Ano vazio

        if (ano == "Ano") {
            Toast.makeText(TelaQuadra.this, "Selecione um Ano, Por Favor!", Toast.LENGTH_SHORT).show();
            return;
        }

        //Validação de horário vazio

        if (horario == "Selecione um horário") {
            Toast.makeText(TelaQuadra.this, "Selecione um horário, Por Favor!", Toast.LENGTH_SHORT).show();
            return;
        }

        sendEmail(dia, mes, ano, horario);
    }
}
