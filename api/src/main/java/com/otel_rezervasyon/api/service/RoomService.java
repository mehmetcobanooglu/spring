package com.otel_rezervasyon.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.otel_rezervasyon.api.entity.Room;
import com.otel_rezervasyon.api.repository.RoomRepository;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public Room saveRoom(Room room) {
        return roomRepository.save(room);
    }

    public List<Room> tümOdalariGetir() {
        return roomRepository.findAll();
    }

    public Room getRoomById(Long id) {
        return roomRepository.findById(id).orElse(null);
    }

    public void odayiSil(Long id) {
        roomRepository.deleteById(id);
    }

    public List<Room> müsaitOdalar() {
        return roomRepository.findByAvailableTrue();
    }

}
