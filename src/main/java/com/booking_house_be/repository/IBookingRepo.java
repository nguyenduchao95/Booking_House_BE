package com.booking_house_be.repository;

import com.booking_house_be.entity.Booking;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public interface IBookingRepo extends JpaRepository<Booking, Integer> {


    @Query(nativeQuery = true, value =
            "SELECT MONTH(b.start_time) AS month," +
                    " SUM(b.total) AS revenue FROM Booking b left join house h on h.id = b.house_id" +
                    " WHERE YEAR(b.end_time) = :year AND h.owner_id = :ownerId GROUP BY MONTH(b.start_time)")
    List<Object[]> getMonthlyRevenueByOwnerAndYear(
            @Param("ownerId") int ownerId,
            @Param("year") int year
    );


    @Query(nativeQuery = true, value =
            "SELECT DAY(b.start_time) AS day," +
                    " SUM(b.total) AS revenue FROM Booking b " +
                    "LEFT JOIN house h ON h.id = b.house_id " +
                    "WHERE YEAR(b.end_time) = :year AND " +
                    "MONTH(b.start_time) = :month AND h.owner_id = :ownerId " +
                    "GROUP BY DAY(b.start_time)")

    List<Object[]> getDailyRevenueByOwnerAndMonth(
            @Param("ownerId") int ownerId,
            @Param("year") int year,
            @Param("month") int month);


    @Query(nativeQuery = true, value =
            "SELECT DAY(b.start_time) AS day," +
                    " SUM(b.total) AS revenue FROM Booking b " +
                    "LEFT JOIN house h ON h.id = b.house_id " +
                    "WHERE YEAR(b.end_time) = :year AND " +
                    "MONTH(b.start_time) = :month AND h.owner_id = :ownerId AND " +
                    "DAY(b.start_time) BETWEEN :startDay AND :endDay " +
                    "GROUP BY DAY(b.start_time)")
    List<Object[]> getDailyRevenueByOwnerAndWeek(
            @Param("ownerId") int ownerId,
            @Param("month") int month,
            @Param("year") int year,
            @Param("startDay") int startDay,
            @Param("endDay") int endDay);
}
