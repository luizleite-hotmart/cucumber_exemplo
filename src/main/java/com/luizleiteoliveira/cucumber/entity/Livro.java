package com.luizleiteoliveira.cucumber.entity;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@ToString
@EqualsAndHashCode
public class Livro {

    @Getter
    @Setter
    private String titulo;
    @Getter
    @Setter
    private String autor;
    @Getter
    @Setter
    private Date publicacao;

    public Livro(String titulo, String autor, Date publicacao) {
        this.titulo = titulo;
        this.autor = autor;
        this.publicacao = publicacao;
    }
}
