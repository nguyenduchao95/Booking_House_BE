package com.booking_house_be.service.impl;

import com.booking_house_be.dto.query.OwnerDto;
import com.booking_house_be.entity.Owner;
import com.booking_house_be.repository.IOwnerRepo;
import com.booking_house_be.service.IOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public Owner getOwnerByAccount(int idAccount) {
        return ownerRepo.getOwnerByAccount(idAccount);
    }
    @Override
    public List<Owner> getAll() {
        return ownerRepo.findAll();
    }

    @Override
    public List<Owner> getAllByStatus(String status) {
        return ownerRepo.getAllByStatus(status);
    }

    @Override
    public Owner findOwnerById(int id) {
        return ownerRepo.findOwnerById(id);
    }

    @Override
    public Page<OwnerDto> getOwnerDto(Pageable pageable , String nameSearch) {
        return getOwnerDto(pageable , nameSearch);
    }
}
