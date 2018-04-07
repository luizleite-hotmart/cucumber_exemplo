package com.luizleiteoliveira.cucumber.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Livro {

    private String titulo;
    private String autor;
    private Date publicacao;

    public Livro(String titulo, String autor, Date publicacao) {
        this.titulo = titulo;
        this.autor = autor;
        this.publicacao = publicacao;
    }
}
