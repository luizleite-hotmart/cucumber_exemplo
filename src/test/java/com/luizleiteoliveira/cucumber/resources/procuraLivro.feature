Feature: Procura Livros
  Permite que o cliente ache o livro desejado

  Scenario: Procura livro pelo ano
    Given um livro de titulo 'Primeiro livro', escrito por 'Eu', publicado em 14 March 2013
    And outro livro de titulo 'Some other book', escrito por 'Tim Tomson', publicado em 23 August 2014
    And outro livro de titulo 'How to cook a dino', escrito por 'Fred Flintstone', publicado em 01 January 2012
    When o cliente procura por livros entre 2013 and 2014
    Then 2 livros devem ser encontrados
    And Livro 1 deve ter o titulo 'Some other book'
    And Livro 2 deve ter o titulo 'Primeiro livro'

  Scenario: Search books by publication year
    Given um livro de titulo 'One good another', escrito por 'Luiz Oliveira', publicado em 14 March 2016
    And outro livro de titulo 'Some other book', escrito por 'Tim Tomson', publicado em 23 August 2014
    And outro livro de titulo 'How to cook a dino', escrito por 'Fred Flintstone', publicado em 01 January 2012
    When o cliente procura por livros entre 2013 and 2014
    Then 1 livros devem ser encontrados
    And Livro 1 deve ter o titulo 'Some other book'