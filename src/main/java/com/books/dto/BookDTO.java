package com.books.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDTO {

    private Long sku;

    private String nome;

    private String marca;

    private Double preco;

    public BookDTO(){}

    public BookDTO(Long sku, String nome, String marca, Double preco) {
        this.sku = sku;
        this.nome = nome;
        this.marca = marca;
        this.preco = preco;
    }
}
