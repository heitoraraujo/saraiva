package com.books.business;

import com.books.dto.BookDTO;
import com.books.dto.PaginateDTO;
import com.books.entities.Book;
import com.books.mapper.BookMapper;
import com.books.mapper.PaginateMapper;
import com.books.repository.filter.BookFilterData;
import com.books.service.BookService;
import com.books.util.paginate.Page;
import com.books.util.paginate.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by ham.heitormartins on 15/03/2018.
 */
@Component
public class BookBusiness {

    @Autowired
    private BookService service;

    @Autowired
    private BookMapper mapper;

    @Autowired
    private PaginateMapper<BookDTO> paginateMapper;


    public BookDTO create(BookDTO country) {
        return mapper.entityToVo(service.create(mapper.voToEntity(country)));
    }

    public BookDTO createDTO(Book book) {
        return mapper.entityToVo(book);
    }


    public BookDTO update(BookDTO book, Long code) {
        return mapper.entityToVo(service.update(mapper.voToEntity(book), code));
    }

    public PaginateDTO<BookDTO> getCollections(Integer page, Integer limit, Double price) {

            Page<Book> actualPage = service.getCollections(PageParam.create(page, limit),
                    BookFilterData.create(price));

            List<BookDTO> countries = actualPage
                    .getItens()
                    .stream()
                    .map(actualCountry -> mapper.entityToVo(actualCountry))
                    .collect(Collectors.toList());

            return paginateMapper.voToEntity(actualPage, countries);

    }

    public BookDTO getOne(long code) {
        return Optional.ofNullable(service.getOne(code))
                .map(city -> mapper.entityToVo(city))
                .orElse(null);
    }

    public boolean exist(long code) {
        return service.exist(code);
    }

    public void delete(long code) {
        service.delete(code);
    }
}
