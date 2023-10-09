package com.booking_house_be.service;

import com.booking_house_be.dto.HouseDto;
import com.booking_house_be.entity.House;
import com.booking_house_be.repository.IHouseRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IHouseService {
    House findById(int id);


    House createHouse(HouseDto houseDto);

    House editHouse(HouseDto houseDto);

    Page<IHouseRepo.HouseInfo> getHousesByOwnerId(int ownerId, Pageable pageable);

    Page<House> findByOwnerIdAndNameContains(int id, String name, Pageable pageable);

    Page<House> findByOwnerIdAndStatus(int id, String status, Pageable pageable);

    Page<House> findAllByPriceRange(Pageable pageable, double minPrice, double maxPrice);

    Page<House> findHousesByNameAndPriceRange(Pageable pageable, String nameSearch, double minPrice, double maxPrice);

    Page<House> findHousesByNameAndPriceRangeAndLocal(Pageable pageable, String nameSearch, String province, double minPrice, double maxPrice);

    House findByIdAndOwnerId(int houseId, int ownerId);
}
