package com.books.controller;

import com.books.business.WsSaraivaBusiness;
import com.books.dto.BookDTO;
import com.books.entities.enums.ExchangeConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ham.heitormartins on 15/03/2018.
 */
@RestController
@RequestMapping(ExchangeConstants.URL_VERSION)
@Api(value = "WS Saraiva Book", description = "WS Saraiva Book")
public class WsSaraivaController {

    @Autowired
    private WsSaraivaBusiness business;

    @ApiOperation(value = "Find zip code for ADM", response = Iterable.class)
    @RequestMapping(value = ExchangeConstants.WS_SARAIVA, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<BookDTO> findBooks(@RequestParam(required = false, value = "sku") Long sku,
                                             @RequestParam(required = false, value = "lang") String lang) {

        BookDTO book = business.getBooksWs(sku);

        if (book != null) {
            return new ResponseEntity<BookDTO>(book, HttpStatus.OK);
        } else {
            return new ResponseEntity<BookDTO>(book, HttpStatus.NO_CONTENT);
       }

    }

}
