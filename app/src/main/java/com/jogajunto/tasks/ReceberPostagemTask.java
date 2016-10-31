package com.jogajunto.tasks;

import android.os.AsyncTask;

import com.jogajunto.modelo.Quadra;
import com.jogajunto.requests.QuadraRequests;

import java.util.List;

import feign.Feign;
import feign.gson.GsonDecoder;

/**
 * Created by aluno on 28/10/2016.
 */
public class ReceberPostagemTask extends AsyncTask<Integer, Void, Quadra>{

    @Override
    public Quadra doInBackground(Integer... params) {

        QuadraRequests requests = Feign.builder()
                .decoder(new GsonDecoder())
                .target(QuadraRequests.class, "http://jogajunto.azurewebsites.net/api/");

        //List postagem = requests.receberQuadras(params[0]);
        
        Quadra quadra = requests.receberQuadra(params[0]);

        System.out.println(quadra);

        return quadra;

    }
}
