package com.examly.springapp.service;

import java.util.List;
import java.util.Optional;
import com.examly.springapp.model.Book;

public interface BookService {

    Book save(Book book);

    List<Book> findAll();

    Optional<Book> findById(Long id);

    List<Book> findByTitle(String title);

    List<Book> findByCategoryName(String categoryName);
}
