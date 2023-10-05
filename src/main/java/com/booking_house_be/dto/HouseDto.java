package com.booking_house_be.dto;

import com.booking_house_be.entity.Account;
import lombok.Data;

import java.util.List;

@Data
public class HouseDto {
    private String name;
    private String address;
    private String province;
    private String district;
    private String ward;
    private String houseNumber;
    private int bedroom;
    private int bathroom;
    private String description;
    private String facility;
    private double oldPrice;
    private double newPrice;
    private String thumbnail;
    private List<String> images;
    private Account owner;
}

