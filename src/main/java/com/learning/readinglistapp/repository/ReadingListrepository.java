package com.learning.readinglistapp.repository;

import com.learning.readinglistapp.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReadingListrepository extends JpaRepository<Book, Long> {

      List<Book> findByReader(final String reader);

}
