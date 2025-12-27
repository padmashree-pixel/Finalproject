package com.examly.springapp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import com.examly.springapp.model.BookCategory;
import com.examly.springapp.repository.BookCategoryRepo;

@Service
public class BookCategoryServiceImpl implements BookCategoryService {

    @Autowired
    private BookCategoryRepo repo;

    public BookCategory addCategory(BookCategory category) {
        return repo.save(category);
    }

    public List<BookCategory> getAll() {
        return repo.findAll();
    }

    public BookCategory getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public BookCategory update(Long id, BookCategory category) {
        BookCategory existing = repo.findById(id).orElse(null);
        if (existing == null) return null;
        existing.setCategoryName(category.getCategoryName());
        return repo.save(existing);
    }

    public Page<BookCategory> getPaged(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("categoryId"));
        return repo.findAll(pageable);
    }
}
