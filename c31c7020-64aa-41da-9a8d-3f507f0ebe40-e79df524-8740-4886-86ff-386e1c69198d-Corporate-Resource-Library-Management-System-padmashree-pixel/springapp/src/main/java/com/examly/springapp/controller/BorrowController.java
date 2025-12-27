package com.examly.springapp.controller;

import com.examly.springapp.model.Borrow;
import com.examly.springapp.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/borrows")
public class BorrowController {

    @Autowired
    private BorrowService borrowService;

    @PostMapping
    public ResponseEntity<Borrow> addBorrow(@RequestBody Borrow borrow) {
        Borrow saved = borrowService.addBorrow(borrow);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Borrow>> getAllBorrows() {
        List<Borrow> borrows = borrowService.getAll();
        if (borrows.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(borrows);
    }

  
    @GetMapping("/{id}")
    public ResponseEntity<?> getBorrowById(@PathVariable Long id) {
        Borrow borrow = borrowService.getById(id);
        if (borrow == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Borrow not found");
        return ResponseEntity.ok(borrow);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBorrow(@PathVariable Long id, @RequestBody Borrow borrow) {
        Borrow updated = borrowService.update(id, borrow);
        if (updated == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Borrow not found");
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBorrow(@PathVariable Long id) {
        Borrow existing = borrowService.getById(id);
        if (existing == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Borrow not found");
        borrowService.delete(id);
        return ResponseEntity.ok().build();
    }
}
