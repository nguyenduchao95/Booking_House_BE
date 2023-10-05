package com.booking_house_be.service.impl;
import com.booking_house_be.entity.House;
import com.booking_house_be.repository.IAccountRepo;
import com.booking_house_be.repository.IHouseRepo;
import com.booking_house_be.repository.IHouseRepo;
import com.booking_house_be.service.IHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class HouseService implements IHouseService {
    @Autowired
    private IHouseRepo houseRepo;
    @Override
    public House findById(int id) {
        return houseRepo.findById(id).get();
    }

    @Override
    public Page<IHouseRepo.HouseInfo> getHousesByOwnerId(int ownerId,Pageable pageable) {
        return houseRepo.findHouseInfoByOwnerId(ownerId,pageable);
    }

    @Override
    public Page<House> findByOwnerIdAndNameContains(int id, String name, Pageable pageable) {
        return houseRepo.findByOwnerIdAndNameContains(id,name, pageable);
    }

    @Override
    public Page<House> findByOwnerIdAndStatus(int id, String status, Pageable pageable) {
        return houseRepo.findByOwnerIdAndStatus(id,status,pageable);
    }


}
