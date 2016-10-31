package com.jogajunto.modelo;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by aluno on 07/10/2016.
 */
public class Quadra {

    @SerializedName("Id_Quadra")
    private Integer Id_Quadra;

    @SerializedName("Id_Dono")
    private Integer Id_Dono;
    
    @SerializedName("Id_End")
    private Integer Id_End;
    
    @SerializedName("CoordenateOne")
    private String CoordenateOne;

    @SerializedName("CoordenateTwo")
    private String CoordenateTwo;

    @SerializedName("Opcionais")
    private String Opcionais;

    @SerializedName("Email")
    private String Tipo_Quadra;

    public Jogador(){

    }

    public Jogador(String nome, String apelido, String _email, String _senha, String genero){
        this.Email = _email;
        this.Senha = _senha;
        this.Nome = nome;
        this.Apelido = apelido;
        this.Genero = genero;
        HorasJogadas = 0;
        KmCaminhados = 0;
        Id = 0;
    }

    public Jogador(String _email, String _senha){
        Email = _email;
        Senha = _senha;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        this.Nome = nome;
    }

    public String getApelido() {
        return Apelido;
    }

    public void setApelido(String apelido) {
        this.Apelido = apelido;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String genero) {
        this.Genero = genero;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        this.Senha = senha;
    }

    public int getHorasJogadas() {
        return HorasJogadas;
    }

    public void setHorasJogadas(int horasJogadas) {
        this.HorasJogadas = horasJogadas;
    }

    public int getKmCaminhados() {
        return KmCaminhados;
    }

    public void setKmCaminhados(int kmCaminhados) {
        this.KmCaminhados = kmCaminhados;
    }
}
