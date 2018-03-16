package com.books.util.paginate;

public class PageRequest {

    private Integer limit;
    private Integer page;
    private Long total;
    private Integer firstResult;
    private Long totalPages;

    private PageRequest(Integer page, Integer limit, Long total, Integer firstResult, Long totalPages) {
        this.page = page;
        this.limit = limit;
        this.total = total;
        this.firstResult =  firstResult;
        this.totalPages = totalPages;
    }

    public static PageRequest create(Integer newPage, Integer limit, Long total, Integer firstResult, Long totalPages) {
        return new PageRequest(newPage, limit, total, firstResult, totalPages);
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Integer getFirstResult() {
        return firstResult;
    }

    public void setFirstResult(Integer firstResult) {
        this.firstResult = firstResult;
    }

    public Long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Long totalPages) {
        this.totalPages = totalPages;
    }
}
