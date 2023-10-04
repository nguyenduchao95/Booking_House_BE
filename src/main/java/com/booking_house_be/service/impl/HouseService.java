package com.booking_house_be.service.impl;

import com.booking_house_be.entity.House;
import com.booking_house_be.repository.IHouseRepo;
import com.booking_house_be.service.IHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseService implements IHouseService {
    @Autowired
    private IHouseRepo houseRepo;
    @Override
    public House findById(int id) {
        return houseRepo.findById(id).get();
    }
}
