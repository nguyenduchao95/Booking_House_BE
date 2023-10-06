package com.booking_house_be.service.impl;

import com.booking_house_be.entity.Account;
import com.booking_house_be.entity.Role;
import com.booking_house_be.repository.IAccountRepo;
import com.booking_house_be.repository.IRoleRepo;
import com.booking_house_be.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private IAccountRepo accountRepo;
    @Autowired
    private IRoleRepo roleRepo;

    @Override
    public Account getById(int id) {
        return accountRepo.findById(id).get();
    }

    @Override
    public void edit(Account account) {
        accountRepo.save(account);
    }
    @Override
    public Optional<Account> getAccountById(int id) {
        return accountRepo.findById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepo.findByUsername(username);
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(account.getRole());
        return new User(account.getUsername(), account.getPassword(), roles);
    }

    @Override
    public Account getAccountLogin(String username, String password) {
        return accountRepo.getAccountLogin(username, password);
    }

    @Override
    public Account checkRegister(Account account) {
        Account account1 = accountRepo.findByUsername(account.getUsername());
        if (account1 != null || account.getPassword().isEmpty()) {
            return null;
        } else {
            Role role = roleRepo.findByName("ROLE_USER");
            account.setRole(role);
            return accountRepo.save(account);
        }
    }

    @Override
    public Account getAccountByUsername(String username) {
        return accountRepo.findByUsername(username);
    }

    @Override
    public Account getAccountByEmail(String email) {
        return accountRepo.findByEmail(email);
    }

    @Override
    public void save(Account account) {
        accountRepo.save(account);
    }

    @Override
    public List<Account> findAdmins() {
        return accountRepo.findAdmins();
    }

}
