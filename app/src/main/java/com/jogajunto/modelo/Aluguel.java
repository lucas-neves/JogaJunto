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

    public Aluguel(){

    }

    public Aluguel(Integer id_Aluguel, Date dataJogo, Date hora, String confirm, Integer id_Quadra, Integer id_Cliente) {
        Id_Aluguel = 0;
        DataJogo = dataJogo;
        Hora = hora;
        Confirm = confirm;
        Id_Quadra = id_Quadra;
        Id_Cliente = id_Cliente;
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
        Confirm = confirm;
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
}
