package com.jogajunto.tasks;

import android.os.AsyncTask;

import com.jogajunto.modelo.Aluguel;

import com.jogajunto.requests.AluguelRequests;
import com.jogajunto.requests.AutenticacaoRequests;

import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;

/**
 * Created by lucasn on 23/10/2016.
 */

public class AutenticarTask extends AsyncTask<String, Void, Boolean> {

    @Override
    public Boolean doInBackground(String... params) {
        try{
            AutenticacaoRequests request = Feign.builder()
                    .logLevel(Logger.Level.FULL)
                    .target(AutenticacaoRequests.class, "http://jogajunto.azurewebsites.net/api/");// lá em PostagemRequest, as URIS
            //serão pegas a partir desta URL
            request.autenticar(params[0], params[1]);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
