package com.books.mapper;

import com.books.dto.BookDTO;
import com.books.entities.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * Created by ham.heitormartins on 15/03/2018.
 */
@Mapper(componentModel = "spring")
public interface BookMapper {

   default BookDTO entityToVo(Book entity){
        BookDTO dto = new BookDTO();
        dto.setSku(entity.getSku());
        dto.setMarca(entity.getMarca());
        dto.setNome(entity.getNome());
        dto.setMarca(entity.getMarca());
        return dto;

    }

    default Book voToEntity(BookDTO dto){
        Book book = new Book();
        book.setSku(dto.getSku());
        book.setMarca(dto.getMarca());
        book.setNome(dto.getNome());
        book.setMarca(dto.getMarca());
        return book;
    }

}

