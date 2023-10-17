package com.booking_house_be.repository;
import com.booking_house_be.dto.query.OwnerDto;
import com.booking_house_be.entity.Owner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IOwnerRepo extends JpaRepository<Owner, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM Owner where account_id= :idAccount")
    Owner getOwnerByAccount(@Param("idAccount") int idAccount);

    @Query(nativeQuery = true, value = "SELECT * FROM Owner where status= :status")
    List<Owner> getAllByStatus(@Param("status") String status);

    Owner findOwnerById(int id);
    @Query(value = "select a.* , count(h.id) as houseQuantity , SUM(CASE WHEN b.status = 'Đã trả phòng' THEN b.total ELSE 0 END) AS revenue" +
            "            from account a " +
            "                        join role r on a.role_id = r.id" +
            "                       join house h on a.id = h.owner_id" +
            "            join booking b on h.id = b.house_id" +
            "            where r.name = 'ROLE_OWNER' and ((a.firstname like concat('%' , :nameSearch , '%') or a.lastname like concat('%' , :nameSearch , '%'))) " +
            "            group by a.id" , nativeQuery = true )
    Page<OwnerDto> getOwnerDto(Pageable pageable ,@Param("nameSearch") String nameSearch);
}
