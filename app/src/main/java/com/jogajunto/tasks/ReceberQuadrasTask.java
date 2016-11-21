package com.jogajunto.tasks;

import android.os.AsyncTask;
import android.util.Log;

import com.jogajunto.modelo.Quadra;
import com.jogajunto.requests.QuadrasRequests;

import java.util.List;

import feign.Feign;
import feign.gson.GsonDecoder;

/**
 * Created by lucasn on 28/10/2016.
 */
public class ReceberQuadrasTask extends AsyncTask<Void, Void, List<Quadra>>{

    @Override
    public List<Quadra> doInBackground(Void... params) {

        QuadrasRequests requests = Feign.builder()
                .decoder(new GsonDecoder())
                .target(QuadrasRequests.class, "http://jogajuntoapi.azurewebsites.net/api/");

        List<Quadra> quadras = requests.receberQuadras();

        for (Quadra p : quadras) {
            Log.e("Quadra: ", p.getId_Quadra() + " " + p.getDescricao());
        }

        return quadras;

    }
}
