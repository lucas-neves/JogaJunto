package com.jogajunto.tasks;

import android.os.AsyncTask;

import com.jogajunto.modelo.Postagem;
import com.jogajunto.requests.PostagensRequests;

import java.util.List;

import feign.Feign;
import feign.gson.GsonDecoder;

/**
 * Created by aluno on 28/10/2016.
 */
public class ReceberPostagensTask extends AsyncTask<Void, Void, List<Postagem>>{

    @Override
    public List<Postagem> doInBackground(Void... params) {

        PostagensRequests requests = Feign.builder()
                .decoder(new GsonDecoder())
                .target(PostagensRequests.class, "https://jsonplaceholder.typicode.com");

        List<Postagem> postagens = requests.receberPostagens();

        for (Postagem p:postagens) {
            System.out.println(p);
        }

        return postagens;

    }
}
