package com.booking_house_be.service;


import com.booking_house_be.entity.Account;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public interface IAccountService extends UserDetailsService {
    Optional<Account> getAccountById(int id);
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
    Account getAccountLogin(String username, String password);
    Account checkRegister(Account account);
    Account getAccountByUsername(String username);
    Account getAccountByEmail(String email);
    void save(Account account);
}
