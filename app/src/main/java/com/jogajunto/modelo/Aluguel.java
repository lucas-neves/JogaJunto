package com.jogajunto.modelo;

import com.google.gson.annotations.SerializedName;
import com.jogajunto.R;

import java.sql.Date;

/**
 * Created by lucasn on 14/09/2016.
 */
public class Aluguel {

    @SerializedName("id_Aluguel")
    private Integer Id_Aluguel;

    @SerializedName("dataJogo")
    private Date DataJogo;

    @SerializedName("hora")
    private Date Hora;

    @SerializedName("confirm")
    private String Confirm;

    @SerializedName("id_Quadra")
    private Integer Id_Quadra;

    @SerializedName("id_Cliente")
    private Integer Id_Cliente;

    @SerializedName("quadra")
    private Quadra Quadra;

    @SerializedName("cliente")
    private Cliente Cliente;

    public Aluguel(){

    }

    public Aluguel(Integer id_Aluguel, Date dataJogo, Date hora, String confirm, Integer id_Quadra, Integer id_Cliente, Quadra quadra, Cliente cliente) {
        this.Id_Aluguel = id_Aluguel;
        this.DataJogo = dataJogo;
        this.Hora = hora;
        this.Confirm = confirm;
        this.Id_Quadra = id_Quadra;
        this.Id_Cliente = id_Cliente;
        this.Quadra = quadra;
        this.Cliente = cliente;
    }


    public Integer getId_Aluguel() {
        return Id_Aluguel;
    }

    public void setId_Aluguel(Integer id_Aluguel) {
        Id_Aluguel = id_Aluguel;
    }

    public Date getDataJogo() {
        return DataJogo;
    }

    public void setDataJogo(Date dataJogo) {
        DataJogo = dataJogo;
    }

    public Date getHora() {
        return Hora;
    }

    public void setHora(Date hora) {
        Hora = hora;
    }

    public String getConfirm() {
        return Confirm;
    }

    public void setConfirm(String confirm) {
        this.Confirm = confirm;
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

    public Quadra getQuadra() {
        return this.Quadra;
    }

    public void setQuadra(Quadra quadra) {
        this.Quadra = quadra;
    }

    public Cliente getCliente() {
        return this.Cliente;
    }

    public void setCliente(Cliente cliente) {
        this.Cliente = cliente;
    }

}
