package com.booking_house_be.service.impl;

import com.booking_house_be.dto.HouseDto;
import com.booking_house_be.entity.House;
import com.booking_house_be.entity.Image;
import com.booking_house_be.repository.IHouseRepo;
import com.booking_house_be.repository.IImageRepo;
import com.booking_house_be.service.IHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
        House house = new House(houseDto);
        house.setStatus("Đang trống");
        house.setCreateAt(LocalDate.now());
        House houseDB = houseRepo.save(house);
        List<Image> imageList = houseDto.getImages();
        for (Image image : houseDto.getImages()) {
            image.setHouse(houseDB);
        }
        imageRepo.saveAll(imageList);
        return houseDB;
    }

    @Override
    public House editHouse(HouseDto houseDto) {
        imageRepo.saveAll(houseDto.getImages());
        imageRepo.deleteAll(houseDto.getImagesDelete());
        House house = new House(houseDto);
        house.setUpdateAt(LocalDate.now());
        return houseRepo.save(house);
    }

    @Override
    public House saveHouse(House house) {
        return houseRepo.save(house);
    }

    @Override
    public Page<House> findAllByPriceRange(Pageable pageable, double minPrice, double maxPrice) {
        return houseRepo.findAllByPriceRange(pageable, minPrice, maxPrice);
    }

    @Override
    public Page<House> findHousesByNameAndPriceRange(Pageable pageable, String nameSearch, double minPrice, double maxPrice) {
        return houseRepo.findHousesByNameAndPriceRange(pageable, nameSearch, minPrice, maxPrice);
    }

    @Override
    public Page<House> findHousesByNameAndPriceRangeAndLocal(Pageable pageable, String nameSearch, String province, double minPrice, double maxPrice) {
        return houseRepo.findHousesByNameAndPriceRangeAndLocal(pageable, nameSearch, province, minPrice, maxPrice);
    }

    public House updateStatus(int id, String status) {
        House house = houseRepo.findById(id).orElse(null);
        if (house != null) {
            house.setStatus(status);
            return houseRepo.save(house);
        }
        return null;
    }

    @Override
    public List<Integer> getTopBookingHouseId() {
        return houseRepo.getTopBookingHouseId();
    }

    @Override
    public Page<IHouseRepo.HouseInfo> findByOwnerIdAndNameAndStatus(int id, String name, String status, Pageable pageable) {
        return houseRepo.findByOwnerIdAndNameAndStatus(id, name, status, pageable);
    }

    @Override
    public List<IHouseRepo.HouseInfo> findByOwnerId(int ownerId) {
        return houseRepo.findByOwnerId(ownerId);
    }

    @Override
    public Page<IHouseRepo.HouseInfo> findByOwnerId(int ownerId, Pageable pageable) {
        return houseRepo.findByOwnerId(ownerId, pageable);
    }


    @Override
    public House findByIdAndOwnerId(int houseId, int ownerId) {
        return houseRepo.findByIdAndOwnerId(houseId, ownerId);
    }

}
