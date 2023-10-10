package com.booking_house_be.service.impl;

import com.booking_house_be.entity.Owner;
import com.booking_house_be.repository.IOwnerRepo;
import com.booking_house_be.service.IOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerService implements IOwnerService {
    @Autowired
    IOwnerRepo ownerRepo;
    @Override
    public void save(Owner owner) {
        ownerRepo.save(owner);
    }
    @Override
    public void edit(Owner owner) {
        ownerRepo.save(owner);
    }
}
