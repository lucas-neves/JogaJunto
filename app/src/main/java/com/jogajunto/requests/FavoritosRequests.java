package com.jogajunto.requests;

import com.jogajunto.modelo.Favorito;

import java.util.List;

import feign.Param;
import feign.RequestLine;

/**
 * Created by lucasn on 28/10/2016.
 */
public interface FavoritosRequests {

    @RequestLine("POST /Favoritoes")
    void favoritarQuadra(Favorito favorito);

    @RequestLine("GET /Favoritoes")
    List<Favorito> receberFavoritos();

    @RequestLine("GET /Favoritoes/{id}")
    Favorito receberFavorito(@Param("id") Integer id);
}
