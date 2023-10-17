package com.booking_house_be.service;


import com.booking_house_be.entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Optional;

public interface IAccountService extends UserDetailsService {
    void edit(Account account);

    Account getById(int id);

    Optional<Account> getAccountById(int id);

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    Account getAccountLogin(String username, String password);

    Account checkRegister(Account account);

    Account getAccountByUsername(String username);

    Account getAccountByEmail(String email);

    void save(Account account);

    List<Account> findAdmins();

    Page<Account> findByLastnameContaining(String nameSearch, Pageable pageable);

    Page<Account> findByRoleName(String roleName, Pageable pageable);

    Page<Account> findByLastnameContainingAndRoleName(String nameSearch, String roleName, Pageable pageable);

    Page<Account> findAll(Pageable pageable);
    Page<Account> findByNameANdRoleName(String nameSearch,  String roleName , Pageable pageable );
}
