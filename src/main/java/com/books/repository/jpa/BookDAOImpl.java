package com.books.repository.jpa;


import com.books.entities.Book;
import com.books.repository.BookRepository;
import com.books.repository.filter.BookFilter;
import com.books.repository.filter.BookFilterData;
import com.books.repository.filter.BookRootCriteria;
import com.books.util.criteria.CriteriaHelper;
import com.books.util.paginate.Page;
import com.books.util.paginate.PageCount;
import com.books.util.paginate.PageHelper;
import com.books.util.paginate.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

/**
 * Created by ham.heitormartins on 15/03/2018.
 */
@Component
public class BookDAOImpl implements BookDAO {

    @Autowired
    private PageHelper pageHelper;

    @Autowired
    private CriteriaHelper criteriaHelper;

    @Autowired
    private BookFilter bookFilter;

    @Autowired
    private EntityManager em;

    @Autowired
    private BookRepository repository;

    @Override
    public BookRepository getRepository() {
        return this.repository;
    }

    @Override
    public Page<Book> getCollections(PageParam pageParam, BookFilterData data) {
        BookRootCriteria crit = new BookRootCriteria();
        BookRootCriteria root = crit.create(data, em, Book.class);

        CriteriaQuery<Book> criteria = bookFilter.query(root);

        return pageHelper.createPageCriteria(pageParam, criteria, count(data));
    }

    private Long count(BookFilterData data) {
        BookRootCriteria crit = new BookRootCriteria();
        BookRootCriteria root = crit.create(data, em, Book.class);

        return criteriaHelper.getTotal(new PageCount(root.getBuilder(), root.getCriteria(),
                root.getRoot()), bookFilter.filter(root));
    }

    @Override
    public Book getOneBook(Long code){
        BookRootCriteria crit = new BookRootCriteria();
        BookRootCriteria root = crit.create(new BookFilterData(code), em, Book.class);

        CriteriaQuery<Book> criteriaCity = bookFilter.query(root);
        List<Book> coins = em.createQuery(criteriaCity).getResultList();

        return coins.get(0);
    }

}
