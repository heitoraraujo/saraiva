package com.books.util.paginate;

public class PageParam {

    private Integer page;
    private Integer limit;

    private PageParam(Integer page, Integer limit) {
        this.page = page;
        this.limit = limit;
    }

    public static PageParam create(Integer page, Integer limit) {
        return new PageParam(page, limit);
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
