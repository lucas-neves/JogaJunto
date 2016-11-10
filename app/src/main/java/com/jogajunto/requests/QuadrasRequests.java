package com.jogajunto.requests;

import com.jogajunto.modelo.Quadra;

import java.util.List;

import feign.Param;
import feign.RequestLine;

/**
 * Created by lucasn on 28/10/2016.
 */
public interface QuadrasRequests {

    @RequestLine("GET /Quadras")
    List<Quadra> receberQuadras();

    @RequestLine("GET /Quadras/{Id_Quadra}")
    Quadra receberQuadra(@Param("Id_Quadra") Integer id);
}
