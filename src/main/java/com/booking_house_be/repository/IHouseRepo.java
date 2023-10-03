package com.booking_house_be.repository;
import com.booking_house_be.entity.House;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IHouseRepo extends JpaRepository<House,Integer> {
}
