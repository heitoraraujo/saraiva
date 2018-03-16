package com.books.repository.filter;

import com.books.entities.Book;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ham.heitormartins on 15/03/2018.
 */
@Component
public class BookFilter {


    // filter
    public CriteriaQuery<Book> query(BookRootCriteria data) {

        data.getCriteria().select(data.getRoot());

        data.getCriteria().where(filter(data).toArray(new Predicate[]{}));

        return data.getCriteria();
    }


    public List<Predicate> filter(BookRootCriteria data) {

        //predicates
        List<Predicate> predicates = new ArrayList<>();

        if (data.getFilterData().hasSku()) {
            predicates.add(data.getBuilder().equal(data.getRoot().get("sku"), data.getFilterData().getSku()));
        }

        if (data.getFilterData().hasPreco()) {
            predicates.add(data.getBuilder().equal(data.getRoot().get("preco"), data.getFilterData().getPreco()));

        }

        return predicates;
    }

}
