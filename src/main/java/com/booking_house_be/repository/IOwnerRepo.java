package com.booking_house_be.repository;
import com.booking_house_be.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOwnerRepo extends JpaRepository<Owner, Integer> {
}
