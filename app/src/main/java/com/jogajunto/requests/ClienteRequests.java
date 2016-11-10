package com.jogajunto.requests;

import com.jogajunto.modelo.Cliente;

import java.util.List;

import feign.Param;
import feign.RequestLine;

/**
 * Created by lucasn on 28/10/2016.
 */
public interface ClienteRequests {

    @RequestLine("GET /Clientes")
    List<Cliente> receberClientes();

    @RequestLine("GET /Clientes/{Id_Cliente}")
    Cliente receberCliente(@Param("Id_Cliente") Integer id);

    @RequestLine("GET /Clientes/{Username}")
    boolean autenticarCliente(@Param("Id_Cliente") Integer id);
}
