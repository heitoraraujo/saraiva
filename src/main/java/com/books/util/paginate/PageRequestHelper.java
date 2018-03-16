package com.books.util.paginate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
/**
 * Created by ham.heitormartins on 15/03/2018.
 */

@Component
public class PageRequestHelper {

    @Autowired
    private EntityManager em;

    @Value("${limit.pagination.max.size}")
    private Integer DEFAULT_LIMIT_VALUE;

    private static final Integer DEFAULT_PAGE = 1;

    //criteria
    public <T> PageRequest createPageRequestCriteria(Integer page, Integer limit, Long count) {
        Integer newPage = hasValue(page) ? page : DEFAULT_PAGE;
        Integer newLimit = hasValue(limit) ? limit : DEFAULT_LIMIT_VALUE;

        Long total = count;
        Long totalPages = availablePages(total, newLimit);

        Integer firstResult = firstResult(newPage, newLimit);
        return PageRequest.create(newPage, newLimit, total, firstResult, totalPages);
    }

    private Integer firstResult(Integer page, Integer limit) {
        return (page - 1) * limit;
    }

    private boolean hasValue(Integer value) {
        return (value != null && value > 0);
    }

    private Long availablePages(Long total, Integer limit) {
        long availablePages = total/limit;

        if ((total % limit) == 0) {
            return availablePages;
        }

        return availablePages + 1;
    }
}
