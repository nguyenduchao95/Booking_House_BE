package com.booking_house_be.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;
    private int bedroom;
    private int bathroom;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Column(columnDefinition = "TEXT")
    private String facility;
    private double oldPrice;
    private double newPrice;
    private String thumbnail;
    private String status;
    private LocalDate createAt;
    private LocalDate updateAt;
    @ManyToOne
    private Account owner;
    @ManyToOne
    private Category category;
}
