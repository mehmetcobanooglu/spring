package com.otel_rezervasyon.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.otel_rezervasyon.api.entity.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {

    List<Room> findByAvailableTrue();

}