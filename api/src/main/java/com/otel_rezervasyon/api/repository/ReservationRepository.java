package com.otel_rezervasyon.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.otel_rezervasyon.api.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
