package com.miitoya.repository;

import com.miitoya.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("select s from Book s where s.name like ?1 ")
    Book findByBookAndTitle(String name);
}
