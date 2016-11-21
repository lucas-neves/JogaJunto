package com.jogajunto.modelo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by lucasn on 14/09/2016.
 */
public class Favorito {

    @SerializedName("id_Favorito")
    private Integer Id_Favorito;

    @SerializedName("id_Quadra")
    private Integer Id_Quadra;

    @SerializedName("id_Cliente")
    private Integer Id_Cliente;

    @SerializedName("cliente")
    private Cliente Cliente;

    @SerializedName("quadra")
    private Quadra Quadra;

    public Favorito(int id_Favorito, int id_Quadra, int id_Cliente, Cliente cliente, Quadra quadra){
        this.Id_Favorito = id_Favorito;
        this.Id_Quadra = id_Quadra;
        this.Id_Cliente = id_Cliente;
        this.Cliente = cliente;
//        this.Cliente = new Cliente(cliente);
        this.Quadra = quadra;
    }

    public Integer getId_Favorito() {
        return Id_Favorito;
    }

    public void setId_Favorito(Integer id_Favorito) {
        Id_Favorito = id_Favorito;
    }

    public Integer getId_Quadra() {
        return Id_Quadra;
    }

    public void setId_Quadra(Integer id_Quadra) {
        Id_Quadra = id_Quadra;
    }

    public Integer getId_Cliente() {
        return Id_Cliente;
    }

    public void setId_Cliente(Integer id_Cliente) {
        Id_Cliente = id_Cliente;
    }

    public com.jogajunto.modelo.Quadra getQuadra() {
        return Quadra;
    }

    public void setQuadra(com.jogajunto.modelo.Quadra quadra) {
        Quadra = quadra;
    }

    public com.jogajunto.modelo.Cliente getCliente() {
        return Cliente;
    }

    public void setCliente(com.jogajunto.modelo.Cliente cliente) {
        Cliente = cliente;
    }
}
