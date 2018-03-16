package com.books.repository;

import com.books.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by ham.heitormartins on 23/02/2018.
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("select count(b) > 0 from Book b where b.sku = :sku ")
     boolean skyAlreadyExist(@Param("sku") Long sku);
}
