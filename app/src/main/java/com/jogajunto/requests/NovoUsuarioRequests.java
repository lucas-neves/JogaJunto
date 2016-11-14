package com.jogajunto.requests;

import com.jogajunto.modelo.Aluguel;

import feign.RequestLine;

/**
 * Created by lucasn on 28/10/2016.
 */
public interface NovoUsuarioRequests {

    @RequestLine("POST Autenticar/user/")
    void usuarioExiste(String email);
}
