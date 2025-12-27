package com.examly.springapp.service;

import java.util.List;
import org.springframework.data.domain.Page;
import com.examly.springapp.model.BookCategory;

public interface BookCategoryService {
    BookCategory addCategory(BookCategory category);
    List<BookCategory> getAll();
    BookCategory getById(Long id);
    BookCategory update(Long id, BookCategory category);
    Page<BookCategory> getPaged(int page, int size);
}
