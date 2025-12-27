package com.examly.springapp.service;

import com.examly.springapp.model.Borrow;
import java.util.List;

public interface BorrowService {

    Borrow addBorrow(Borrow borrow);

    List<Borrow> getAll();

    Borrow getById(Long id);

    Borrow update(Long id, Borrow borrow);

    void delete(Long id);
}
