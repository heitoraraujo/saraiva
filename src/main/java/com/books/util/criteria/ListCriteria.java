package com.books.util.criteria;

import java.util.List;

public class ListCriteria<Item> {

    private List<Item> itens;

    public ListCriteria(List<Item> itens) {
         this.itens = itens;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }
}
