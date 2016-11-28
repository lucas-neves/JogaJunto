package com.jogajunto.tasks;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.jogajunto.modelo.Cliente;
import com.jogajunto.modelo.Favorito;
import com.jogajunto.requests.AutenticacaoRequests;
import com.jogajunto.requests.ClienteRequests;
import com.jogajunto.requests.FavoritosRequests;

import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;

/**
 * Created by lucasn on 23/10/2016.
 */

public class CadastroClienteTask extends AsyncTask<Cliente, Void, Boolean> {

    Context context;

    public CadastroClienteTask(Context context){
        this.context = context;
    }

    @Override
    public Boolean doInBackground(Cliente... params) {
        try{
            AutenticacaoRequests request = Feign.builder()
                    .encoder(new GsonEncoder())
                    .decoder(new GsonDecoder())
                    .logLevel(Logger.Level.FULL)
                    .target(AutenticacaoRequests.class, "http://jogajuntoapi.azurewebsites.net/api/");
            request.cadastrar(params[0]);
            return true;
        }catch (Exception e){
            Log.d("Exception", e.toString());
            return false;
        }
    }
}
