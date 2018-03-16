package com.books.repository.filter;

import com.books.entities.Book;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Created by ham.heitormartins on 21/02/2018.
 */
@Getter
@Setter
public class BookRootCriteria<T> {

    private BookFilterData filterData;
    private CriteriaBuilder builder;
    private CriteriaQuery<T> criteria;
    private Root<Book> root;

    public BookRootCriteria() {
    }

    public BookRootCriteria(BookFilterData filterData,
                            CriteriaBuilder builder,
                            CriteriaQuery<T> criteria,
                            Root<Book> root) {

        this.filterData = filterData;
        this.builder = builder;
        this.criteria = criteria;
        this.root = root;


    }

    public BookRootCriteria create(BookFilterData filterData, EntityManager em, Class<T> clazz) {
        //builder
        CriteriaBuilder builder = em.getCriteriaBuilder();

        //criteria query
        criteria = builder.createQuery(clazz);

        //select cidade
        Root<Book> root = criteria.from(Book.class);


        return new BookRootCriteria(filterData, builder, criteria, root);
    }


}
