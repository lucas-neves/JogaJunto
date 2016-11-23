package com.jogajunto.tasks;

import android.os.AsyncTask;
import android.util.Log;

import com.jogajunto.Autenticacao;
import com.jogajunto.modelo.Cliente;
import com.jogajunto.requests.AutenticacaoRequests;

import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;

/**
 * Created by lucasn on 23/10/2016.
 */

public class AutenticarTask extends AsyncTask<String, Void, Cliente> {

    @Override
    public Cliente doInBackground(String... params) {
        try{
            AutenticacaoRequests request = Feign.builder()
                    .encoder(new GsonEncoder())
                    .decoder(new GsonDecoder())
                    .logLevel(Logger.Level.FULL)
                    .target(AutenticacaoRequests.class, "http://jogajuntoapi.azurewebsites.net/api/");

            Cliente cliente = request.autenticar(params[0], params[1]);
            Autenticacao.idCliente = cliente.getId_Cliente();
            Log.e("ID DO CLIENTE: ", String.valueOf(Autenticacao.idCliente));
            return cliente;
        }catch (Exception e){
            Log.d("Exception", e.toString());
            return null;
        }
    }
}
