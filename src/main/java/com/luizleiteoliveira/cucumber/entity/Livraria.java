package com.luizleiteoliveira.cucumber.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class Livraria {

    private final List<Livro> loja = new ArrayList<>();

    public void addLivro(final Livro livro) {
        loja.add(livro);
    }

    public List<Livro> findLivros(final Date from, final Date to) {
        Calendar end = Calendar.getInstance();
        end.setTime(to);
        end.roll(Calendar.YEAR, 1);
        return loja.stream().filter(livro -> {
            return from.before(livro.getPublicacao()) && end.getTime().after(livro.getPublicacao());
        }).sorted(Comparator.comparing(Livro::getPublicacao).reversed()).collect(Collectors.toList());
    }
}
