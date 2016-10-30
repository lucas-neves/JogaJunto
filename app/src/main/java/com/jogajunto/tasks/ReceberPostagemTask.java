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
public class ReceberPostagemTask extends AsyncTask<Integer, Void, Postagem>{

    @Override
    public Postagem doInBackground(Integer... params) {

        PostagensRequests requests = Feign.builder()
                .decoder(new GsonDecoder())
                .target(PostagensRequests.class, "https://jsonplaceholder.typicode.com");

        Postagem postagem = requests.receberPostagem(params[0]);

        System.out.println(postagem);

        return postagem;

    }
}
