package com.books.service;

import com.books.entities.Book;
import com.books.exception.CbcFieldValidationException;
import com.books.exception.FieldErrorMessage;

import static com.books.exception.FieldErrorMessage.*;

import com.books.i18n.MessageByLocaleService;
import com.books.repository.BookRepository;
import com.books.repository.filter.BookFilterData;
import com.books.repository.jpa.BookDAO;
import com.books.util.paginate.Page;
import com.books.util.paginate.PageParam;
import com.books.util.validation.CbcValidator;

import static com.books.util.validation.CbcValidator.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;


/**
 * Created by ham.heitormartins on 15/03/2018.
 */
@Component
public class BookServiceImpl implements BookService {

    @Autowired
    private MessageByLocaleService messageService;

    @Autowired
    private BookDAO bookDAO;

    private BookRepository repository() {
        return bookDAO.getRepository();
    }

    @Transactional
    @Override
    public Book create(Book book) {

        CbcValidator<FieldErrorMessage> validator = validateBook(book);

        validator.assertFalse(skuAlreadyExist(book.getSku()),
                createFieldError("sku", messageService.getMessage("sku.already.exist")));

        if (validator.hasErrors()) {
            throw new CbcFieldValidationException(validator.errors(), HttpStatus.BAD_REQUEST);
        }

        return repository().save(book);

    }

    @Override
    public Page<Book> getCollections(PageParam pageParam, BookFilterData data) {
         return bookDAO.getCollections(pageParam, data);
    }

    @Override
    public Book getOne(long code) {
        return bookDAO.getOneBook(code);
    }


    @Transactional
    @Override
    public Book update(Book book, Long code) {

        CbcValidator<FieldErrorMessage> validator = validateBook(book);

        if (validator.hasErrors()) {
            throw new CbcFieldValidationException(validator.errors(), HttpStatus.BAD_REQUEST);
        }

        return Optional.ofNullable(repository().findOne(code))
                .map(actual -> {
                    actual.setMarca(book.getMarca());
                    actual.setNome(book.getNome());
                    actual.setPreco(book.getPreco());
                    return  repository().save(actual);
                })
                .orElse(null);



    }


    @Override
    public boolean exist(long code) {
        return repository().exists(code);
    }

    @Transactional
    @Override
    public void delete(long code) {
        bookDAO.getRepository().delete(code);
    }


    public boolean skuAlreadyExist(Long sku) {
        return repository().skyAlreadyExist(sku);
    }

    private CbcValidator validateBook(Book book) {
        return ensureThat()
                .assertFalse(book.getSku() == null, createFieldError("sku", messageService.getMessage("sky.require.book")))
                .assertFalse(book.getNome() == null, createFieldError("nome", messageService.getMessage("nome.require.book")));

    }

    private CbcValidator validateBookUpdate(Book book) {
        return ensureThat()
                .assertFalse(book.getMarca() == null, createFieldError("sku", messageService.getMessage("marca.require.book")))
                .assertFalse(book.getPreco() == null, createFieldError("sku", messageService.getMessage("preco.require.book")))
                .assertFalse(book.getNome() == null, createFieldError("nome", messageService.getMessage("nome.require.book")));

    }
}
