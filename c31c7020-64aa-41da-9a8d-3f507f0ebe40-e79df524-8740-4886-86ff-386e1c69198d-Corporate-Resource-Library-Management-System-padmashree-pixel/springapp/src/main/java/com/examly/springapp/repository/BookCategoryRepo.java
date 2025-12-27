package com.examly.springapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examly.springapp.model.BookCategory;

@Repository
public interface BookCategoryRepo
        extends JpaRepository<BookCategory, Long> {


    List<BookCategory> findByCategoryName(String categoryName);
}
