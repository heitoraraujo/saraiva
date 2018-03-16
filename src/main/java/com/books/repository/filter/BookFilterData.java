package com.books.repository.filter;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

@Getter
@Setter
public class BookFilterData {

    private Double preco;
    private Long sku;

    public BookFilterData(Long sku) {
        this.sku = sku;
    }

    public static BookFilterData create(Long sku) {

        return new BookFilterData(sku);
    }

    public BookFilterData(Double preco) {
        this.preco = preco;
    }

    public static BookFilterData create(Double preco) {

        return new BookFilterData(preco);
    }

    public boolean hasSku() {
        return sku != null;
    }

    public boolean hasPreco() {
        return preco != null;
    }

}
