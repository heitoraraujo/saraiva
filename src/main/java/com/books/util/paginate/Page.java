package com.books.util.paginate;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Optional;

@Getter
@Setter
public class Page<Item> {

    private Long totalOffersMarkets;
    private Long total;
    private Integer pages;
    private Long totalPages;
    private List<Item> itens;

    public Page(Long total, Integer pages, Long totalPages, List<Item> itens) {
        this.total = total;
        this.pages = pages;
        this.itens = itens;
        this.totalPages = totalPages;
    }

    public Page(Long total, Integer pages, Long totalPages, List<Item> itens, Long totalOffersMarkets) {
        this.total = total;
        this.pages = pages;
        this.itens = itens;
        this.totalPages = totalPages;
        this.totalOffersMarkets = totalOffersMarkets;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public Long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Long totalPages) {
        this.totalPages = totalPages;
    }

    public boolean hasContent() {
        return Optional.ofNullable(itens).isPresent();
    }

    public Long getTotalOffersMarkets() {
        return totalOffersMarkets;
    }

    public void setTotalOffersMarkets(Long totalOffersMarkets) {
        this.totalOffersMarkets = totalOffersMarkets;
    }
}
