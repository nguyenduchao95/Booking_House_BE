package com.booking_house_be.service.impl;

import com.booking_house_be.dto.HouseDto;
import com.booking_house_be.entity.House;
import com.booking_house_be.entity.Image;
import com.booking_house_be.repository.IAccountRepo;
import com.booking_house_be.repository.IHouseRepo;
import com.booking_house_be.repository.IHouseRepo;
import com.booking_house_be.repository.IImageRepo;
import com.booking_house_be.service.IHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HouseService implements IHouseService {
    @Autowired
    private IHouseRepo houseRepo;
    @Autowired
    private IImageRepo imageRepo;

    @Override
    public House findById(int id) {
        return houseRepo.findById(id).get();
    }

    @Override
    public House createHouse(HouseDto houseDto) {
        House house = houseRepo.save(new House(houseDto));
        if (house != null){
            List<Image> imageList = new ArrayList<>();
            for (String url : houseDto.getImages()){
                imageList.add(new Image(url, house));
            }
            imageRepo.saveAll(imageList);
        }
        return house;
    }

    @Override
    public Page<IHouseRepo.HouseInfo> getHousesByOwnerId(int ownerId, Pageable pageable) {
        return houseRepo.findHouseInfoByOwnerId(ownerId, pageable);
    }

    @Override
    public Page<House> findByOwnerIdAndNameContains(int id, String name, Pageable pageable) {
        return houseRepo.findByOwnerIdAndNameContains(id,name, pageable);
    }

    @Override
    public Page<House> findByOwnerIdAndStatus(int id, String status, Pageable pageable) {
        return houseRepo.findByOwnerIdAndStatus(id, status, pageable);
    }


    @Override
    public Page<House> getAll(Pageable pageable) {
        return houseRepo.findAll(pageable);
    }

    @Override
    public Page<House> findByNameContaining(String name, Pageable pageable) {
        return houseRepo.findByNameContaining(name, pageable);
    }

    @Override
    public Page<House> findHousesByPriceRange(double minPrice, double maxPrice, Pageable pageable) {
        return houseRepo.findHousesByPriceRange(minPrice, maxPrice, pageable);
    }

    @Override
    public Double findMaxPrice() {
        return houseRepo.findMaxPrice();
    }
}
