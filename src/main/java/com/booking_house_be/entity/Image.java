package com.booking_house_be.entity;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String url;
    @ManyToOne
    private House house;
}
