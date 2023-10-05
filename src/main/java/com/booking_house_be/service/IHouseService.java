package com.booking_house_be.service;

import com.booking_house_be.dto.HouseDto;
import com.booking_house_be.entity.House;
import com.booking_house_be.repository.IHouseRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IHouseService {
    House findById(int id);


    House createHouse(HouseDto houseDto);

    Page<IHouseRepo.HouseInfo> getHousesByOwnerId(int ownerId, Pageable pageable);

    Page<House> findByOwnerIdAndNameContains(int id, String name, Pageable pageable);

    Page<House> findByOwnerIdAndStatus(int id, String status, Pageable pageable);

    Page<House> getAll(Pageable pageable);

    Page<House> findByNameContaining(String name, Pageable pageable);

    Double findMaxPrice();

    Page<House> findHousesByPriceRange(double minPrice, double maxPrice, Pageable pageable);

}
