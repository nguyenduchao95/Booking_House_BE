package com.booking_house_be.service;


import com.booking_house_be.dto.HouseDto;
import com.booking_house_be.entity.House;

public interface IHouseService {
    House findById(int id);
    House createHouse(HouseDto houseDto);
}
