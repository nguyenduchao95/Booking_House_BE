package com.booking_house_be.service;

import com.booking_house_be.entity.Account;
import com.booking_house_be.entity.Owner;

public interface IOwnerService {
    void save(Owner owner);

    void edit(Owner owner);

    Owner getOwnerByAccount(int idAccount);
}
