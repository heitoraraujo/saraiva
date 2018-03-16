package com.books.service;

import com.books.entities.Book;
import com.books.repository.filter.BookFilterData;
import com.books.util.paginate.Page;
import com.books.util.paginate.PageParam;
/**
 * Created by ham.heitormartins on 15/03/2018.
 */
public interface BookService {

    Book create(Book book);

    Page<Book> getCollections(PageParam pageParam, BookFilterData bookFilterData);

    Book getOne(long code);

    Book update(Book book, Long code);

    boolean exist(long code);

    void delete(long code);

}

