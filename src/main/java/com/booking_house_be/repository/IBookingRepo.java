package com.booking_house_be.repository;

import com.booking_house_be.entity.Booking;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

import java.util.List;

public interface IBookingRepo extends JpaRepository<Booking, Integer> {
    @Query(nativeQuery = true, value = "select * from booking where account_id= :idAccount")
    Page<Booking> getByIdAccount(Pageable pageable, @Param("idAccount") int idAccount);

    List<Booking> findAllByHouseIdAndStatus(int houseId, String status);
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
    @Query("SELECT b FROM Booking b " +
            "JOIN House h ON h.id = b.house.id " +
            "WHERE (:nameSearch IS NULL OR h.name LIKE CONCAT('%', :nameSearch, '%')) " +
            "AND (" +
            "(:yearStart IS NULL OR :monthStart IS NULL OR :dayStart IS NULL) OR " +
            "(b.startTime >= CONCAT(:yearStart, '-', :monthStart, '-', :dayStart) " +
            "AND b.endTime <= CONCAT(:yearEnd, '-', :monthEnd, '-', :dayEnd))) " +
            "AND (:status IS NULL OR b.status LIKE CONCAT('%', :status, '%')) " +
            "AND h.owner.id = :ownerId")
    Page<Booking> findByHouseAndStartTimeAndEndTimeAndStatus(
            @Param("ownerId") int ownerId,
            @Param("nameSearch") String nameSearch,
            @Param("status") String status,
            @Param("yearStart") int yearStart,
            @Param("monthStart") int monthStart,
            @Param("dayStart") int dayStart,
            @Param("yearEnd") int yearEnd,
            @Param("monthEnd") int monthEnd,
            @Param("dayEnd") int dayEnd,
            Pageable pageable
    );


    @Query("SELECT b FROM Booking b " +
            "JOIN House h ON h.id = b.house.id " +
            "WHERE (:nameSearch IS NULL OR h.name LIKE CONCAT('%', :nameSearch, '%')) " +
            "AND (:status IS NULL OR b.status LIKE CONCAT('%', :status, '%')) " +
            "AND h.owner.id = :ownerId")
    Page<Booking> findByHouseAndStatus(
            @Param("ownerId") int ownerId,
            @Param("nameSearch") String nameSearch,
            @Param("status") String status,
            Pageable pageable
    );

    @Query( "SELECT b FROM Booking b WHERE b.house.owner.id = :ownerId")
    Page<Booking> findBookingsByOwnerId(@Param("ownerId") int ownerId, Pageable pageable);

    public interface BookingRepository extends JpaRepository<Booking, Integer> {
        @Query("SELECT b FROM Booking b " +
                "WHERE (b.house.name LIKE CONCAT('%', :nameSearch, '%') OR :nameSearch IS NULL) " +
                "AND ((:startDate IS NULL AND :endDate IS NULL) OR (b.startTime >= :startDate AND b.endTime <= :endDate)) " +
                "AND (b.status LIKE CONCAT('%', :status, '%') OR :status IS NULL)")
        List<Booking> findBookingsByNameAndDateRangeAndStatus(@Param("nameSearch") String nameSearch,
                                                              @Param("startDate") LocalDate startDate,
                                                              @Param("endDate") LocalDate endDate,
                                                              @Param("status") String status);
    }


}
