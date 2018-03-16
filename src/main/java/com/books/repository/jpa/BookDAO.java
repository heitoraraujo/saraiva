package com.books.repository.jpa;

import com.books.entities.Book;
import com.books.repository.BookRepository;
import com.books.repository.filter.BookFilterData;
import com.books.util.paginate.Page;
import com.books.util.paginate.PageParam;

public interface BookDAO {

    BookRepository getRepository();

    Book getOneBook(Long code);

    Page<Book> getCollections(PageParam pageParam, BookFilterData data);
}
