package com.jogajunto.tasks;

import android.os.AsyncTask;
import android.util.Log;

import com.jogajunto.modelo.Favorito;
import com.jogajunto.modelo.Quadra;
import com.jogajunto.requests.FavoritosRequests;
import com.jogajunto.requests.QuadrasRequests;

import java.util.ArrayList;
import java.util.List;

import feign.Feign;
import feign.gson.GsonDecoder;

/**
 * Created by lucasn on 28/10/2016.
 */
public class ReceberFavoritosTask extends AsyncTask<Void, Void, List<Quadra>>{

    @Override
    public List<Quadra> doInBackground(Void... params) {

        FavoritosRequests requests = Feign.builder()
                .decoder(new GsonDecoder())
                .target(FavoritosRequests.class, "http://jogajuntoapi.azurewebsites.net/api/");

        List<Favorito> favoritos = requests.receberFavoritos();
        List<Quadra> quadras = new ArrayList<>();

        for (Favorito p : favoritos) {
            quadras.add(p.getQuadra());
            Log.e("Favoritos: ", p.getQuadra().getDescricao());
        }

        return quadras;

    }
}
