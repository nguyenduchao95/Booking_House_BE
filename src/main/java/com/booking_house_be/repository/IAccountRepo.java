package com.booking_house_be.repository;

import com.booking_house_be.entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface IAccountRepo extends JpaRepository<Account, Integer> {
    Account findByUsername(String username);

    Account findByEmail(String email);

    @Query(nativeQuery = true, value = "SELECT * FROM Account where username= :username and password= :password")
    Account getAccountLogin(@Param("username") String username, @Param("password") String password);

    List<Account> findByRoleName(String name);
//
    Page<Account> findByLastnameContaining(String nameSearch, Pageable pageable);
    Page<Account> findAllByRoleName(String roleName, Pageable pageable);
    Page<Account> findByRoleNameAndLastnameContains( String roleName,String nameSearch, Pageable pageable);
    Page<Account> findByRoleNameAndLastnameContainsAndStatus( String roleName,String nameSearch,String status, Pageable pageable);

    Page<Account> findByRoleNameAndStatus(String roleName,String status, Pageable pageable);

}
