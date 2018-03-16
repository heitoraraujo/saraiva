package com.books.business;

import com.books.dto.BookDTO;
import com.books.service.WsSaraivaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by ham.heitormartins on 15/03/2018.
 */
@Component
public class WsSaraivaBusiness {

    @Autowired
    private WsSaraivaService service;


    public BookDTO getBooksWs(Long sku) {
       return service.getBooksWs(sku);
    }
}
