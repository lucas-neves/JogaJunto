package com.jogajunto.requests;

import com.jogajunto.modelo.Postagem;

import java.util.List;

import feign.Param;
import feign.RequestLine;

/**
 * Created by aluno on 28/10/2016.
 */
public interface PostagensRequests {

    @RequestLine("GET /posts")
    List<Postagem> receberPostagens();

    @RequestLine("GET /posts/{id}")
    Postagem receberPostagem(@Param("id") Integer id);

    @RequestLine("POST /posts/{id}")
    void fazXyz(@Param("id") Integer id);
}
