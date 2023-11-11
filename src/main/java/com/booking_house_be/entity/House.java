package com.booking_house_be.entity;

import com.booking_house_be.dto.HouseDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;
    private String province;
    private String district;
    private String ward;
    private String houseNumber;
    private int bedroom;
    private int bathroom;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Column(columnDefinition = "TEXT")
    private String facility;
    private double price;
    private int sale;
    private double area;
    @Column(columnDefinition = "TEXT")
    private String thumbnail;
    private String status;
    private LocalDate createAt;
    private LocalDate updateAt;
    @ManyToOne
    private Account owner;

    public House(HouseDto houseDto){
        this.id = houseDto.getId();
        this.name = houseDto.getName();
        this.address = houseDto.getAddress();
        this.province = houseDto.getProvince();
        this.district = houseDto.getDistrict();
        this.ward = houseDto.getWard();
        this.houseNumber = houseDto.getHouseNumber();
        this.bathroom = houseDto.getBathroom();
        this.bedroom = houseDto.getBedroom();
        this.description = houseDto.getDescription();
        this.facility = houseDto.getFacility();
        this.price = houseDto.getPrice();
        this.sale = houseDto.getSale();
        this.area = houseDto.getArea();
        this.thumbnail = houseDto.getThumbnail();
        this.owner = houseDto.getOwner();
        this.status = houseDto.getStatus();
    }
}
