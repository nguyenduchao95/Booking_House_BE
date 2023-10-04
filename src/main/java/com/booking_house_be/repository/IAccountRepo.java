package com.booking_house_be.repository;
import com.booking_house_be.entity.Account;
import com.booking_house_be.entity.House;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IAccountRepo extends JpaRepository<Account,Integer> {
}
