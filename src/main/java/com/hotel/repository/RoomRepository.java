package com.hotel.repository;

import com.hotel.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findByAvailableTrue();
    
    @Query("SELECT r FROM Room r WHERE r.available = true AND r.id NOT IN " +
           "(SELECT b.room.id FROM Booking b WHERE b.status = 'CONFIRMED' AND " +
           "((b.checkInDate <= :checkOut AND b.checkOutDate >= :checkIn)))")
    List<Room> findAvailableRooms(@Param("checkIn") LocalDate checkIn, 
                                  @Param("checkOut") LocalDate checkOut);
}