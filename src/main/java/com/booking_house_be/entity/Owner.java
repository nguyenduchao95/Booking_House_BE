package com.booking_house_be.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(columnDefinition = "TEXT")
    private String frontside;
    @Column(columnDefinition = "TEXT")
    private String backside;
    private String status;
    @OneToOne
    private Account account;
}
