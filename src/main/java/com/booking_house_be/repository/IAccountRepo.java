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

    Page<Account> findByLastnameContaining(String nameSearch, Pageable pageable);

    Page<Account> findAllByRoleName(String roleName, Pageable pageable);

    Page<Account> findByLastnameContainingAndRoleName(String nameSearch, String roleName, Pageable pageable);

   @Query(
            nativeQuery = true,
            value = "SELECT * FROM account a " +
                    "WHERE a.id IN (SELECT m.sender_id FROM message m WHERE m.receiver_id = :userId) " +
                    "OR a.id IN (SELECT m.receiver_id FROM message m WHERE m.sender_id = :userId) " +
                    "GROUP BY a.id"
    )
    List<Account> listUserMessage(@Param("userId") int userId);


    @Query("SELECT a FROM Account a WHERE a.username LIKE CONCAT('%', :username, '%') AND a.id != :accountId AND a.status != 'Bị khóa'")
    List<Account> findAllByUsernameContainsAndNotAccountLogin(@Param("username") String username, @Param("accountId") int accountId);
}
