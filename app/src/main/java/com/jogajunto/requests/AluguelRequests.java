package com.jogajunto.requests;

import com.jogajunto.modelo.Aluguel;
import com.jogajunto.modelo.Quadra;

import java.util.List;

import feign.Param;
import feign.RequestLine;

/**
 * Created by lucasn on 28/10/2016.
 */
public interface AluguelRequests {

    @RequestLine("POST Aluguel/")
    Aluguel reservar(Aluguel reserva);

//    @RequestLine("GET /posts/{id}")
//    Quadra receberQuadra(@Param("id") Integer id);
}
