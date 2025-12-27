package com.examly.springapp.repository;

import com.examly.springapp.model.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowRepo extends JpaRepository<Borrow, Long> {

}
