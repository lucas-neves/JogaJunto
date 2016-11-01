package com.jogajunto.tasks;

import android.os.AsyncTask;

import com.jogajunto.modelo.Quadra;
import com.jogajunto.requests.QuadrasRequests;

import java.util.List;

import feign.Feign;
import feign.gson.GsonDecoder;

/**
 * Created by lucasn on 28/10/2016.
 */
public class ReceberQuadraTask extends AsyncTask<Integer, Void, Quadra>{

    @Override
    public Quadra doInBackground(Integer... params) {

        QuadrasRequests requests = Feign.builder()
                .decoder(new GsonDecoder())
                .target(QuadrasRequests.class, "http://jogajunto.azurewebsites.net/api/");

        Quadra quadra = requests.receberQuadra(params[0]);

        System.out.println(quadra);

        return quadra;

    }
}
