package com.jogajunto.tasks;

import android.os.AsyncTask;

import com.jogajunto.modelo.Aluguel;

import com.jogajunto.requests.AluguelRequests;

import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;

/**
 * Created by lucasn on 23/10/2016.
 */

public class PostAluguelTask extends AsyncTask<Aluguel, Void, Aluguel> {

    @Override
    public Aluguel doInBackground(Aluguel... params) {
        try{
            AluguelRequests request = Feign.builder()
                    .encoder(new GsonEncoder())
                    .decoder(new GsonDecoder())
                    .logLevel(Logger.Level.FULL)
                    .target(AluguelRequests.class, "http://jogajunto.azurewebsites.net/api/");// lá em PostagemRequest, as URIS
            //serão pegas a partir desta URL
            Aluguel aluguel = request.reservar(params[0]);
            return aluguel;
        }catch (Exception e){
            System.err.println("Erro de comunicação,");
            e.printStackTrace();
            return null;
        }
    }
}
