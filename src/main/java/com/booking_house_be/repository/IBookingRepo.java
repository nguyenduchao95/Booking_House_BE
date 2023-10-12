package com.booking_house_be.repository;

import com.booking_house_be.entity.Booking;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public interface IBookingRepo extends JpaRepository<Booking, Integer> {
    @Query(nativeQuery = true , value = "select * from booking where account_id= :idAccount")
    Page<Booking> getByIdAccount(Pageable pageable , @Param("idAccount") int idAccount);
    Booking findById(int id);







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
