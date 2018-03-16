package com.books.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Optional;
/**
 * Created by ham.heitormartins on 15/03/2018.
 */
@Getter
@Setter
public class PaginateDTO<Item> {

    private Long total;
    private Integer pages;
    private Long totalPages;
    private List<Item> itens;


    public PaginateDTO(Long total, Integer pages, Long totalPages, List<Item> itens) {
        this.total = total;
        this.pages = pages;
        this.totalPages = totalPages;
        this.itens = itens;
    }

}
