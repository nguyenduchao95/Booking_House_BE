package com.booking_house_be.repository;
import com.booking_house_be.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IOwnerRepo extends JpaRepository<Owner, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM Owner where account_id= :idAccount")
    Owner getOwnerByAccount(@Param("idAccount") int idAccount);
}
