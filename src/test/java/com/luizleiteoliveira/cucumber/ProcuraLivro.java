package com.luizleiteoliveira.cucumber;

import com.luizleiteoliveira.cucumber.entity.Livraria;
import com.luizleiteoliveira.cucumber.entity.Livro;
import cucumber.api.Format;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class ProcuraLivro {

    Livraria livraria = new Livraria();
    List<Livro> result = new ArrayList<>();
    @Given(".+livro de titulo '(.+)', escrito por '(.+)', publicado em(.+)")
    public void addNewlivro(final String title, final String author, @Format("dd MMMMM yyyy") final Date published) {
        Livro book = new Livro(title, author, published);
        livraria.addLivro(book);
    }

    @When("^o cliente procura por livros entre (\\d+) and (\\d+)$")
    public void setSearchParameters(@Format("yyyy") final Date from, @Format("yyyy") final Date to) {
        result = livraria.findLivros(from, to);
    }

    @Then("(\\d+) livros devem ser encontrados$")
    public void verifyAmountOflivrosFound(final int booksFound) {
        assertThat(result.size(), equalTo(booksFound));
    }

    @Then("Livro (\\d+) deve ter o titulo '(.+)'$")
    public void verifylivroAtPosition(final int position, final String title) {
        assertThat(result.get(position - 1).getTitulo(), equalTo(title));
    }
}
