package com.booking_house_be.repository;
import com.booking_house_be.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBookingRepo extends JpaRepository<Booking, Integer> {
    List<Booking> findAllByHouseId(int houseId);
}
