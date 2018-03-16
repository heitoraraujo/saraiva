package com.books.mapper;

import com.books.dto.PaginateDTO;
import com.books.util.paginate.Page;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PaginateMapper<Item> {

    default PaginateDTO voToEntity(Page page, List<Item> itens) {
        return new PaginateDTO(page.getTotal(), page.getPages(), page.getTotalPages(), itens);
    }

}
