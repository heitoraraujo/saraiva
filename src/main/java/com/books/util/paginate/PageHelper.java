package com.books.util.paginate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
/**
 * Created by ham.heitormartins on 15/03/2018.
 */

@Component
public class PageHelper {

    @Autowired
    private PageRequestHelper pageRequestHelper;

    @Autowired
    private EntityManager em;


    public <T> Page createPageCriteria(PageParam pageParam, CriteriaQuery<T> criteria, Long total) {
        PageRequest pageRequest = pageRequestHelper.createPageRequestCriteria(pageParam.getPage(),pageParam.getLimit(),total);

        List elements = result(pageRequest,criteria);

        return new Page<>(pageRequest.getTotal(), pageRequest.getPage(), pageRequest.getTotalPages(),elements);

    }

    private List result(PageRequest pageRequest, CriteriaQuery criteria) {

        Query query = em.createQuery(criteria);

        query.setMaxResults(pageRequest.getLimit());

        query.setFirstResult(pageRequest.getFirstResult());
        return query.getResultList();
    }

}
