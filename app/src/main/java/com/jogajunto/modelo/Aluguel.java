package com.jogajunto.modelo;

import com.google.gson.annotations.SerializedName;
import com.jogajunto.R;

import java.sql.Date;

/**
 * Created by lucasn on 14/09/2016.
 */
public class Aluguel {

    @SerializedName("Id_Aluguel")
    private Integer Id_Aluguel;

    @SerializedName("DataJogo")
    private Date DataJogo;

    @SerializedName("Hora")
    private Date Hora;

    @SerializedName("Confirm")
    private String Confirm;

    @SerializedName("Id_Quadra")
    private String Id_Quadra;

    @SerializedName("Id_Cliente")
    private String Id_Cliente;

    public Aluguel(){

    }

    public Aluguel(Integer id_Aluguel, Date dataJogo, Date hora, String confirm, String id_Quadra, String id_Cliente) {
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

    public String getId_Quadra() {
        return Id_Quadra;
    }

    public void setId_Quadra(String id_Quadra) {
        Id_Quadra = id_Quadra;
    }

    public String getId_Cliente() {
        return Id_Cliente;
    }

    public void setId_Cliente(String id_Cliente) {
        Id_Cliente = id_Cliente;
    }
}
