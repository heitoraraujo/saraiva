package com.books.controller;

import com.books.business.BookBusiness;
import com.books.dto.BookDTO;
import com.books.dto.PaginateDTO;
import com.books.entities.enums.ExchangeConstants;
import com.books.i18n.MessageByLocaleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
@Api(value = "CRUD BOOK", description = "CRUD BOOK")
public class BookController {

    @Autowired
    private BookBusiness business;

    @Autowired
    private MessageByLocaleService messageService;

    @ApiOperation(value = "Find all", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved object"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @RequestMapping(value = ExchangeConstants.ALL_BOOK, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<PaginateDTO<BookDTO>> getCollections(@RequestParam(required = false, value = "lang") String lang,
                                                               @RequestParam(required = false, defaultValue = "0", value = "page") Integer page,
                                                               @RequestParam(required = false, defaultValue = "0", value = "limit") Integer limit,
                                                               @RequestParam(required = false, value = "price") Double price) {
        PaginateDTO<BookDTO> book = business.getCollections(page, limit, price);

        if (!book.getItens().isEmpty()) {
            return new ResponseEntity(book, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }


    @ApiOperation(value = "Update book", response = Iterable.class)
    @RequestMapping(value = ExchangeConstants.UPDATE_BOOK, method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<BookDTO> update(@PathVariable("code") long code,
                                          @RequestBody BookDTO book,
                                          @RequestParam(required = false, value = "lang") String lang) {
        if (business.exist(code)) {
            return new ResponseEntity<BookDTO>(business.update(book, code), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<BookDTO>(HttpStatus.NOT_FOUND);
        }
    }


    @ApiOperation(value = "Find book by id", response = Iterable.class)
    @RequestMapping(value = ExchangeConstants.ONE_BOOK, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<BookDTO> getOne(@PathVariable("code") long code,
                                          @RequestParam(required = false, value = "lang") String lang) {
        BookDTO book = business.getOne(code);

        if (book != null) {
            return new ResponseEntity<BookDTO>(book, HttpStatus.OK);
        } else {
            return new ResponseEntity<BookDTO>(HttpStatus.NOT_FOUND);
        }
    }


    @ApiOperation(value = "Delete book by id", response = Iterable.class)
    @RequestMapping(value = ExchangeConstants.DELETE_BOOK, method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable("code") long code,
                       @RequestParam(required = false, value = "lang") String lang) {
        business.delete(code);

    }

}
