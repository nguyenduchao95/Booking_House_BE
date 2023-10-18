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
    Page<Account> findByRoleNameAndUsernameContains( String roleName,String nameSearch, Pageable pageable);
    Page<Account> findByRoleNameAndUsernameContainsAndStatus( String roleName,String nameSearch,String status, Pageable pageable);

    Page<Account> findByRoleNameAndStatus(String roleName,String status, Pageable pageable);

    Page<Account> findByLastnameContainingAndRoleName(String nameSearch, String roleName, Pageable pageable);
    @Query(nativeQuery = true , value = "select a.* from account a" +
            " join role r on a.role_id = r.id where ((a.firstname like  CONCAT('%' , :nameSearch , '%')) or (a.lastname like CONCAT('%' , :nameSearch , '%'))) " +
            "and r.name = :roleName ")
    Page<Account> findRoleUser(@Param("roleName") String roleName ,@Param("nameSearch") String nameSearch , Pageable pageable);
}
