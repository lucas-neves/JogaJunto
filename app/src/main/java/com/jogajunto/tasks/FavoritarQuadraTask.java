package com.jogajunto.tasks;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.jogajunto.Autenticacao;
import com.jogajunto.modelo.Aluguel;
import com.jogajunto.modelo.Favorito;
import com.jogajunto.requests.AluguelRequests;
import com.jogajunto.requests.AutenticacaoRequests;
import com.jogajunto.requests.FavoritosRequests;

import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;

/**
 * Created by lucasn on 23/10/2016.
 */

public class FavoritarQuadraTask extends AsyncTask<Favorito, Void, Boolean> {

    Context context;

    public FavoritarQuadraTask(Context context){
        this.context = context;
    }

    @Override
    public Boolean doInBackground(Favorito... params) {
        try{
            FavoritosRequests request = Feign.builder()
                    .encoder(new GsonEncoder())
                    .decoder(new GsonDecoder())
                    .logLevel(Logger.Level.FULL)
                    .target(FavoritosRequests.class, "http://jogajuntoapi.azurewebsites.net/api/");
            request.favoritarQuadra(params[0]);
            return true;
        }catch (Exception e){
            Log.d("Exception", e.toString());
            return false;
        }
    }
}
