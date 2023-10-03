package com.booking_house_be.repository;
import com.booking_house_be.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountRepo extends JpaRepository<Account,Integer> {

}
