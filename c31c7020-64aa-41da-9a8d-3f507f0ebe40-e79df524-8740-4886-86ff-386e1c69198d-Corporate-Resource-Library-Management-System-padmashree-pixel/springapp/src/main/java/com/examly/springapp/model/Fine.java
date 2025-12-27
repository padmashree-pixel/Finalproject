package com.examly.springapp.model;

import jakarta.persistence.*;

@Entity
public class Fine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fineId;
}
