package com.jogajunto.modelo;

import com.google.gson.annotations.SerializedName;

import java.sql.Date;

/**
 * Created by lucasn on 14/09/2016.
 */
public class Endereco {

    @SerializedName("id_End")
    private Integer Id_End;

    @SerializedName("logradouro")
    private String Logradouro;

    @SerializedName("complemento")
    private String Complemento;

    @SerializedName("cep")
    private String Cep;

    @SerializedName("bairro")
    private String Bairro;

    @SerializedName("cidade")
    private String Cidade;

    public Endereco(){

    }

    public Endereco(Integer id_End, String logradouro, String complemento, String cep, String bairro, String cidade) {
        this.Id_End = id_End;
        this.Logradouro = logradouro;
        this.Complemento = complemento;
        this.Cep = cep;
        this.Bairro = bairro;
        this.Cidade = cidade;
    }

    public Integer getId_End() {
        return Id_End;
    }

    public void setId_End(Integer id_End) {
        Id_End = id_End;
    }

    public String getLogradouro() {
        return Logradouro;
    }

    public void setLogradouro(String logradouro) {
        Logradouro = logradouro;
    }

    public String getComplemento() {
        return Complemento;
    }

    public void setComplemento(String complemento) {
        Complemento = complemento;
    }

    public String getCep() {
        return Cep;
    }

    public void setCep(String cep) {
        Cep = cep;
    }

    public String getBairro() {
        return Bairro;
    }

    public void setBairro(String bairro) {
        Bairro = bairro;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String cidade) {
        Cidade = cidade;
    }
}
