package com.examly.springapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Book;
import com.examly.springapp.repository.BookRepo;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepo repo;

    public Book save(Book book) {
        return repo.save(book);
    }

    public List<Book> findAll() {
        return repo.findAll();
    }

    public Optional<Book> findById(Long id) {
        return repo.findById(id);
    }

    public List<Book> findByTitle(String title) {
        return repo.findByTitle(title);
    }

    public List<Book> findByCategoryName(String categoryName) {
        return repo.findByBookCategory_CategoryName(categoryName);
    }
}
