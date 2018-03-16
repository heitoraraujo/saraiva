package com.books.util.criteria;

import com.books.util.paginate.PageCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import java.util.List;

/**
 * Created by ham.heitormartins on 15/03/2018.
 */

@Component
public class CriteriaHelper {

    @Autowired
    private EntityManager em;

    public Long getTotal(PageCount data, List<Predicate> predicates) {

        if(!data.getRoot().getFetches().isEmpty()){
            data.getRoot().getFetches().clear();
        }

        data.getCriteria().select(data.getBuilder().count(data.getRoot()));

        //where and predicate
        data.getCriteria().where((predicates.toArray(new Predicate[]{})));
        TypedQuery<Long> queryCount = em.createQuery(data.getCriteria());
        return queryCount.getSingleResult();

    }

    public <T> ListCriteria list(CriteriaQuery<T> criteria) {

        List elements = result(criteria);
        return new ListCriteria<>(elements);

    }

    private List result(CriteriaQuery criteria) {

        Query query = em.createQuery(criteria);
        return query.getResultList();
    }
}
