package com.booking_house_be.service.impl;
import com.booking_house_be.entity.Account;
import com.booking_house_be.repository.IAccountRepo;
import com.booking_house_be.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService  implements IAccountService {
    @Autowired
    private IAccountRepo accountRepo;

    @Override
    public Account getById(int id) {
        return accountRepo.findById(id).get();
    }

    @Override
    public void edit(Account account) {
        accountRepo.save(account);
    }
}
