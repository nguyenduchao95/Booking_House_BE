package com.booking_house_be.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@NoArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String url;
    @ManyToOne
    private House house;
    public Image(String url, House house){
        this.url = url;
        this.house = house;
    }

    public Image(int id, String url){
        this.url = url;
        this.id = id;
    }
}
