package com.books.util.paginate;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Created by ham.heitormartins on 23/02/2018.
 */
public class PageCount {

    private CriteriaBuilder builder;
    private CriteriaQuery criteria;
    private Root root;

    public PageCount(CriteriaBuilder builder, CriteriaQuery criteria, Root root) {
        this.builder = builder;
        this.criteria = criteria;
        this.root = root;
    }

    public CriteriaBuilder getBuilder() {
        return builder;
    }

    public void setBuilder(CriteriaBuilder builder) {
        this.builder = builder;
    }

    public CriteriaQuery getCriteria() {
        return criteria;
    }

    public void setCriteria(CriteriaQuery criteria) {
        this.criteria = criteria;
    }

    public Root getRoot() {
        return root;
    }

    public void setRoot(Root root) {
        this.root = root;
    }
}
