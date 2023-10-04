package com.booking_house_be.service;


import com.booking_house_be.entity.Account;

import java.util.List;

public interface IAccountService {

    Account getById(int id);

    void edit(Account account);
}
