package com.booking_house_be.repository;
import com.booking_house_be.entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface IAccountRepo extends JpaRepository<Account,Integer> {
    Account findByUsername(String username);
    Account findByEmail(String email);
    @Query(nativeQuery = true, value = "SELECT * FROM Account where username= :username and password= :password")
    Account getAccountLogin(@Param("username") String username, @Param("password") String password);

    @Query("SELECT a FROM Account a WHERE a.role.name = 'ROLE_ADMIN'")
    List<Account> findAdmins();
}
