package com.examly.springapp.service;

import com.examly.springapp.model.Borrow;
import com.examly.springapp.repository.BorrowRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BorrowServiceImpl implements BorrowService {

    @Autowired
    private BorrowRepo borrowRepo;

    @Override
    public Borrow addBorrow(Borrow borrow) {
        return borrowRepo.save(borrow);
    }

    @Override
    public List<Borrow> getAll() {
        return borrowRepo.findAll();
    }

    @Override
    public Borrow getById(Long id) {
        Optional<Borrow> optional = borrowRepo.findById(id);
        return optional.orElse(null);
    }

    @Override
    public Borrow update(Long id, Borrow borrow) {
        Optional<Borrow> optional = borrowRepo.findById(id);
        if (optional.isPresent()) {
            Borrow existing = optional.get();
            existing.setBook(borrow.getBook());
            existing.setMember(borrow.getMember());
            existing.setBorrowDate(borrow.getBorrowDate());
            existing.setReturnDate(borrow.getReturnDate());
            existing.setReturned(borrow.isReturned());
            return borrowRepo.save(existing);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        borrowRepo.deleteById(id);
    }
}
