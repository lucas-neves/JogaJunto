package com.jogajunto.modelo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by lucasn on 14/09/2016.
 */
public class Conta {

    @SerializedName("id_Acc")
    private Integer Id_Acc;

    @SerializedName("nr_Acc")
    private Integer Nr_Acc;

    @SerializedName("nr_Ag")
    private Integer Nr_Ag;

    @SerializedName("nr_Bank")
    private Integer Nr_Bank;

    public Conta(int id_Acc, int nr_Acc, int nr_Ag, int nr_Bank){
        this.Id_Acc = id_Acc;
        this.Nr_Acc = nr_Acc;
        this.Nr_Ag = nr_Ag;
        this.Nr_Bank = nr_Bank;
    }

    public Integer getId_Acc() {
        return Id_Acc;
    }

    public void setId_Acc(Integer id_Acc) {
        Id_Acc = id_Acc;
    }

    public Integer getNr_Acc() {
        return Nr_Acc;
    }

    public void setNr_Acc(Integer nr_Acc) {
        Nr_Acc = nr_Acc;
    }

    public Integer getNr_Ag() {
        return Nr_Ag;
    }

    public void setNr_Ag(Integer nr_Ag) {
        Nr_Ag = nr_Ag;
    }

    public Integer getNr_Bank() {
        return Nr_Bank;
    }

    public void setNr_Bank(Integer nr_Bank) {
        Nr_Bank = nr_Bank;
    }
}
