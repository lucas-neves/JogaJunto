package com.jogajunto.requests;

import com.jogajunto.modelo.Cliente;

import feign.Param;
import feign.RequestLine;
import feign.Body;

/**
 * Created by lucasn on 28/10/2016.
 */
public interface AutenticacaoRequests {

    @RequestLine("POST Autenticar/login/")
    @Body("email={email}&senha={senha}")
    Cliente autenticar(@Param("email") String email, @Param("senha") String senha);

    @RequestLine("POST Autenticar/user/")
    @Body("email={email}")
    void usuarioExiste(@Param("email") String email);
}
