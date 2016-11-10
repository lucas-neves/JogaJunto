package com.jogajunto.modelo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by lucasn on 14/09/2016.
 */
public class Cliente {

    @SerializedName("Id_Cliente")
    private Integer Id_Cliente;

    @SerializedName("Username")
    private String Username;

    @SerializedName("Senha")
    private String Senha;

    @SerializedName("Email")
    private String Email;

    @SerializedName("Id_Acc")
    private Integer Id_Acc;

    @SerializedName("Id_End")
    private Integer Id_End;

    @SerializedName("Telefone")
    private String Telefone;

    public Cliente(){

    }

    public Cliente(Integer Id_Cliente, String username, String senha, String email, Integer id_Acc, Integer id_End, String telefone) {
        Id_Cliente = 0;
        Username = username;
        Senha = senha;
        Email = email;
        Id_Acc = id_Acc;
        Id_End = id_End;
        Telefone = telefone;
    }


    public Integer getId_Cliente() {
        return Id_Cliente;
    }

    public void setId_Cliente(Integer id_Cliente) {
        Id_Cliente = id_Cliente;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Integer getId_Acc() {
        return Id_Acc;
    }

    public void setId_Acc(Integer id_Acc) {
        Id_Acc = id_Acc;
    }

    public Integer getId_End() {
        return Id_End;
    }

    public void setId_End(Integer id_End) {
        Id_End = id_End;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String telefone) {
        Telefone = telefone;
    }

}
