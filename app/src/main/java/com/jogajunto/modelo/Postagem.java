package com.jogajunto.modelo;

/**
 * Created by aluno on 28/10/2016.
 */
public class Postagem {

    private Integer userId;
    private Integer id;
    private String title;
    private String body;

    @Override
    public String toString() {
        return userId+" "+id+" "+title;
    }
}
