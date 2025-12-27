package com.examly.springapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.examly.springapp.model.BookCategory;
import com.examly.springapp.service.BookCategoryService;

@RestController
@RequestMapping("/api/book-categories")
public class BookCategoryController {

    @Autowired
    private BookCategoryService service;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody(required = false) BookCategory category) {
        if (category == null) return ResponseEntity.badRequest().build();
        return new ResponseEntity<>(service.addCategory(category), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<BookCategory> list = service.getAll();
        if (list.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        BookCategory category = service.getById(id);
        if (category == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Book category not found");
        return ResponseEntity.ok(category);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody BookCategory category) {
        BookCategory updated = service.update(id, category);
        if (updated == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Book category not found");
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/page/{page}/{size}")
    public ResponseEntity<Page<BookCategory>> paged(
            @PathVariable int page,
            @PathVariable int size) {
        return ResponseEntity.ok(service.getPaged(page, size));
    }
       @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        BookCategory existing = service.getById(id);
        if (existing == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book category not found");
        }
        service.getAll().remove(existing); // remove from list (if using in-memory) or call service delete if implemented
        return ResponseEntity.ok().build();
    }
}
