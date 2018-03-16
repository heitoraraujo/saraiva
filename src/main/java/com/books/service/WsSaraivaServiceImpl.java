package com.books.service;

import com.books.business.BookBusiness;
import com.books.dto.BookDTO;
import com.books.entities.Book;
import com.books.entities.enums.ExchangeConstants;
import com.books.exception.CbcFieldValidationException;
import com.books.i18n.MessageByLocaleService;
import com.books.mapper.BookMapper;
import com.books.repository.jpa.BookDAO;
import com.books.util.validation.CbcValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

import static com.books.exception.FieldErrorMessage.createFieldError;
import static com.books.util.validation.CbcValidator.ensureThat;


/**
 * Created by ham.heitormartins on 23/02/2018.
 */
@Component
public class WsSaraivaServiceImpl implements WsSaraivaService {

    @Autowired
    private MessageByLocaleService messageService;

    @Autowired
    private BookBusiness business;

    @Autowired
    private BookMapper mapper;

    @Transactional
    @Override
    public BookDTO getBooksWs(Long sku) {

        RestTemplate restTemplate = new RestTemplate();

        String url = String.format("%s%s%s", ExchangeConstants.URL_SARAIVA.URL, sku, ExchangeConstants.URL_SARAIVA.COMPLEMENT);

        ResponseEntity<BookDTO> book = restTemplate.getForEntity(url, BookDTO.class);

        //save book in system
        Book newBook = new Book();
        newBook.setSku(book.getBody().getSku());
        newBook.setNome(book.getBody().getNome());
        newBook.setMarca(book.getBody().getMarca());
        newBook.setPreco(book.getBody().getPreco());

        return business.create(business.createDTO(newBook));

   }

}
