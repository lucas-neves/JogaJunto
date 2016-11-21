package com.jogajunto.modelo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by lucasn on 14/09/2016.
 */
public class Dono {

    @SerializedName("id_Dono")
    private Integer Id_Dono;

    @SerializedName("cpf")
    private String Cpf;

    @SerializedName("nome")
    private String Nome;

    @SerializedName("telefone")
    private String Telefone;

    @SerializedName("id_Acc")
    private Integer Id_Acc;

    @SerializedName("conta")
    private Conta Conta;

    public Dono(){

    }

    public Dono(Integer id_Dono, String cpf, String nome, String telefone, Integer id_Acc, Conta conta) {
        this.Id_Dono = id_Dono;
        this.Cpf = cpf;
        this.Nome = nome;
        this.Telefone = telefone;
        this.Id_Acc = id_Acc;
        this.Conta = conta;
    }

    public Integer getId_Dono() {
        return Id_Dono;
    }

    public void setId_Dono(Integer id_Dono) {
        Id_Dono = id_Dono;
    }

    public String getCpf() {
        return Cpf;
    }

    public void setCpf(String cpf) {
        Cpf = cpf;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String telefone) {
        Telefone = telefone;
    }

    public Integer getId_Acc() {
        return Id_Acc;
    }

    public void setId_Acc(Integer id_Acc) {
        Id_Acc = id_Acc;
    }

    public Conta getConta() {
        return Conta;
    }

    public void setConta(Conta conta) {
        Conta = conta;
    }
}
