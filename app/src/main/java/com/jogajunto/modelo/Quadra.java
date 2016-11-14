package com.jogajunto.modelo;

import com.google.gson.annotations.SerializedName;
import com.jogajunto.R;

/**
 * Created by lucasn on 14/09/2016.
 */
public class Quadra {

    public int id;
    public String nome = "Rochdalão";
    public String descricao = "Osasco Fiao";
    public int icon = R.drawable.quadra1;
    public int icon1 = R.drawable.maps;
    public int icon2 = R.drawable.rating;


    @SerializedName("id_Quadra")
    private Integer Id_Quadra;

    @SerializedName("id_Dono")
    private Integer Id_Dono;

    @SerializedName("id_End")
    private Integer Id_End;

    @SerializedName("coordenateOne")
    private String CoordenateOne;

    @SerializedName("coordenateTwo")
    private String CoordenateTwo;

    @SerializedName("opcionais")
    private String Opcionais;

    @SerializedName("tipo_Quadra")
    private String Tipo_Quadra;

    public Quadra(){

    }

    public Quadra(int id_Dono, int id_End, String coordOne, String coordTwo, String opcionais, String tipoQuadra){
        this.Id_Dono = id_Dono;
        this.Id_End = id_End;
        this.CoordenateOne = coordOne;
        this.CoordenateTwo = coordTwo;
        this.Opcionais = opcionais;
        this.Tipo_Quadra = tipoQuadra;
        Id_Quadra = 0;
    }

    public Quadra(String coordOne, String coordTwo){
        CoordenateOne = coordOne;
        CoordenateTwo = coordTwo;
    }

    public Integer getId_Quadra() {
        return Id_Quadra;
    }

    public void setId_Quadra(Integer id_Quadra) {
        Id_Quadra = id_Quadra;
    }

    public String getTipo_Quadra() {
        return Tipo_Quadra;
    }

    public void setTipo_Quadra(String tipo_Quadra) {
        Tipo_Quadra = tipo_Quadra;
    }

    public String getOpcionais() {
        return Opcionais;
    }

    public void setOpcionais(String opcionais) {
        Opcionais = opcionais;
    }

    public String getCoordenateTwo() {
        return CoordenateTwo;
    }

    public void setCoordenateTwo(String coordenateTwo) {
        CoordenateTwo = coordenateTwo;
    }

    public String getCoordenateOne() {
        return CoordenateOne;
    }

    public void setCoordenateOne(String coordenateOne) {
        CoordenateOne = coordenateOne;
    }

    public Integer getId_End() {
        return Id_End;
    }

    public void setId_End(Integer id_End) {
        Id_End = id_End;
    }

    public Integer getId_Dono() {
        return Id_Dono;
    }

    public void setId_Dono(Integer id_Dono) {
        Id_Dono = id_Dono;
    }
}
