package com.booking_house_be.repository;

import com.booking_house_be.dto.query.SpendingDto;
import com.booking_house_be.entity.Booking;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDateTime;
import java.util.List;;

public interface IBookingRepo extends JpaRepository<Booking, Integer> {
    @Query(nativeQuery = true, value = "select * from booking where account_id= :idAccount")
    Page<Booking> getByIdAccount(Pageable pageable, @Param("idAccount") int idAccount);

    @Query("SELECT b from Booking b WHERE b.house.id = :houseId AND b.status IN ('Chờ xác nhận', 'Chờ nhận phòng')")
    List<Booking> findAllByHouseIdAndStatus(@Param("houseId") int houseId);
    Booking findById(int id);

    @Query(nativeQuery = true, value =
            "SELECT DAY(b.start_time) AS day," +
                    " SUM(CASE WHEN b.status = 'Đã trả phòng' THEN b.total ELSE 0 END) AS revenue FROM booking b " +
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


    @Query("SELECT b FROM Booking b " +
            "JOIN House h ON h.id = b.house.id " +
            "WHERE (:nameSearch IS NULL OR h.name LIKE CONCAT('%', :nameSearch, '%')) " +
            "AND ((:startTime IS NULL OR b.startTime >= :startTime) " +
            "AND (:endTime IS NULL OR  b.endTime <= :endTime)) " +
            "AND (:status IS NULL OR b.status LIKE CONCAT('%', :status, '%')) " +
            "AND h.owner.id = :ownerId")
    Page<Booking> findByHouseAndStartTimeAndEndTimeAndStatus(
            @Param("ownerId") int ownerId,
            @Param("nameSearch") String nameSearch,
            @Param("status") String status,
            @Param("startTime") LocalDateTime startTime,
            @Param("endTime") LocalDateTime endTime,
            Pageable pageable
    );
    @Query(nativeQuery = true , value =  "select sum(b.total) as spending " +
            "from booking b where status = 'Đã trả phòng' and b.account_id = :idAccount ; ")
    SpendingDto getSpendingUser(@Param("idAccount") int idAccount);


    @Query(value = "SELECT * FROM booking b " +
            "JOIN house h ON h.id = b.house_id " +
            "WHERE (:houseName IS NULL OR h.name LIKE CONCAT('%', :houseName, '%')) " +
            "AND ((:startTime IS NULL OR b.start_time >= :startTime) " +
            "AND (:endTime IS NULL OR  b.end_time <= :endTime)) " +
            "AND (:status IS NULL OR b.status LIKE CONCAT('%', :status, '%')) " +
            "AND b.account_id = :idAccount"  , nativeQuery = true)
    Page<Booking> getHistoryRentalByIdAccount(Pageable pageable, @Param("idAccount") int idAccount
            , @Param("houseName") String houseName
            , @Param("startTime") LocalDateTime startTime
            , @Param("endTime") LocalDateTime endTime
            , @Param("status") String status);
}
