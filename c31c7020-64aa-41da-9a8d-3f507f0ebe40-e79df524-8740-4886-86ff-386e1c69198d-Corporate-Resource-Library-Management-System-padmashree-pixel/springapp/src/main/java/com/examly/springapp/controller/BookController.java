package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.Book;
import com.examly.springapp.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService service;

    @PostMapping
    public ResponseEntity<Book> add(@RequestBody Book book) {
        return new ResponseEntity<>(service.save(book), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id).get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> update(@PathVariable Long id, @RequestBody Book book) {
        book.setBookId(id);
        return ResponseEntity.ok(service.save(book));
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<?> getByTitle(@PathVariable String title) {
        List<Book> list = service.findByTitle(title);
        if (list.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No book found with title: " + title);
        }
        return ResponseEntity.ok(list);
    }

    @GetMapping("/category/{name}")
    public ResponseEntity<List<Book>> getByCategory(@PathVariable String name) {
        return ResponseEntity.ok(service.findByCategoryName(name));
    }
}
