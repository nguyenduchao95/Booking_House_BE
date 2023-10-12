package com.booking_house_be.repository;
import com.booking_house_be.entity.Booking;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
public interface IBookingRepo extends JpaRepository<Booking, Integer> {
    @Query(nativeQuery = true , value = "select * from booking where account_id= :idAccount")
    Page<Booking> getByIdAccount(Pageable pageable , @Param("idAccount") int idAccount);
    Booking findById(int id);
}
