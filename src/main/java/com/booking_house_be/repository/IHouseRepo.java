package com.booking_house_be.repository;
import com.booking_house_be.entity.House;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface IHouseRepo extends JpaRepository<House, Integer> {
    Page<House> findAllByOwnerId(int id, Pageable pageable);

    @Query("SELECT h.id as id, h.name AS name,h.thumbnail AS thumbnail, h.newPrice AS price, h.address AS address, " +
            "SUM(CASE WHEN b.status = 'CONFIRMED' THEN b.total ELSE 0 END) AS revenue, " +
            "CASE WHEN COUNT(b.id) = 0 THEN 'Đang trống' " +
            "     WHEN SUM(CASE WHEN b.status = 'CONFIRMED' THEN 1 ELSE 0 END) > 0 THEN 'Đang cho thuê' " +
            "     ELSE 'Đang bảo trì' " +
            "END AS status " +
            "FROM House h " +
            "LEFT JOIN Booking b ON h.id = b.house.id " +
            "WHERE h.owner.id = :ownerId " +
            "GROUP BY h.id")
    Page<HouseInfo> findHouseInfoByOwnerId(@Param("ownerId") int ownerId, Pageable pageable);

    interface HouseInfo {
        int getId();

        String getName();
        String getThumbnail();

        double getPrice();

        String getAddress();
        double getRevenue();
        String getStatus();
    }


    Page<House> findByOwnerIdAndNameContains(int id, String name, Pageable pageable);
    Page<House> findByOwnerIdAndStatus(int id, String status, Pageable pageable);

}


