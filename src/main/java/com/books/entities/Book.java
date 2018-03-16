package com.books.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by ham.heitormartins on 15/03/2018.
 */
@Getter
@Setter
@Entity
@Table(name="book")
public class Book {

    @Id
    private Long sku;

    @Column(name = "nome")
    private String nome;

    @Column(name = "marca")
    private String marca;

    @Column(name = "preco")
    private Double preco;
}
