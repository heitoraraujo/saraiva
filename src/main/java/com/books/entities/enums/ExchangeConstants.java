package com.books.entities.enums;

/**
 * Created by ham.heitormartins on 15/03/2018.
 */
public interface ExchangeConstants {
    String URL_VERSION = "/api/v1";

    String WS_SARAIVA = "/ws/all/books";
    String UPDATE_BOOK = "/update/book/{code}";
    String DELETE_BOOK = "/delete/book/{code}";
    String ONE_BOOK = "/one/book/{code}";
    String ALL_BOOK = "/all/book";

    interface URL_SARAIVA {
        String URL = "https://api.saraiva.com.br/sc/produto/pdp/";
        String COMPLEMENT = "/0/0/1";
    }

}
