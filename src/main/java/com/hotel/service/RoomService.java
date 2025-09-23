package com.hotel.service;

import com.hotel.dto.RoomDto;
import com.hotel.model.Room;
import com.hotel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public List<Room> getAvailableRooms() {
        return roomRepository.findByAvailableTrue();
    }

    public List<Room> getAvailableRooms(LocalDate checkIn, LocalDate checkOut) {
        return roomRepository.findAvailableRooms(checkIn, checkOut);
    }

    public Optional<Room> getRoomById(Long id) {
        return roomRepository.findById(id);
    }

    public Room createRoom(RoomDto roomDto) {
        Room room = new Room();
        room.setName(roomDto.getName());
        room.setDescription(roomDto.getDescription());
        room.setPrice(roomDto.getPrice());
        room.setImageUrl(roomDto.getImageUrl());
        room.setAmenities(roomDto.getAmenities());
        room.setMaxGuests(roomDto.getMaxGuests());
        room.setAvailable(roomDto.getAvailable());
        
        return roomRepository.save(room);
    }

    public Room updateRoom(Long id, RoomDto roomDto) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Room not found with id: " + id));

        room.setName(roomDto.getName());
        room.setDescription(roomDto.getDescription());
        room.setPrice(roomDto.getPrice());
        room.setImageUrl(roomDto.getImageUrl());
        room.setAmenities(roomDto.getAmenities());
        room.setMaxGuests(roomDto.getMaxGuests());
        room.setAvailable(roomDto.getAvailable());

        return roomRepository.save(room);
    }

    public void deleteRoom(Long id) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Room not found with id: " + id));
        roomRepository.delete(room);
    }
}