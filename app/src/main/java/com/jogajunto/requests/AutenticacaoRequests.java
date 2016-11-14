package com.jogajunto.requests;

import feign.RequestLine;

/**
 * Created by lucasn on 28/10/2016.
 */
public interface AutenticacaoRequests {

    @RequestLine("POST Autenticar/login/")
    void autenticar(String email, String senha);
}
