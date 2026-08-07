package com.otel_rezervasyon.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.otel_rezervasyon.api.entity.Reservation;
import com.otel_rezervasyon.api.entity.Room;
import com.otel_rezervasyon.api.entity.Customer;

import com.otel_rezervasyon.api.repository.CustomerRepository;
import com.otel_rezervasyon.api.repository.ReservationRepository;
import com.otel_rezervasyon.api.repository.RoomRepository;

@Service
public class ReservationService {

    private final CustomerRepository customerRepository;
    private final RoomRepository roomRepository;
    private final ReservationRepository reservationRepository;

    public ReservationService(CustomerRepository customerRepository, RoomRepository roomRepository,
            ReservationRepository reservationRepository) {
        this.customerRepository = customerRepository;
        this.roomRepository = roomRepository;
        this.reservationRepository = reservationRepository;
    }

    public Reservation saveReservation(Reservation reservation) {

        Customer customer = customerRepository.findById(reservation.getCustomer().getId())
                .orElseThrow(() -> new RuntimeException("Müşteri Bulunamadi."));

        Room room = roomRepository.findById(reservation.getRoom().getId())
                .orElseThrow(() -> new RuntimeException("Oda Bulunamadi."));

        if (!room.isAvailable()) {
            throw new RuntimeException("Oda Şuan Müsait Değil");
        }

        room.setAvailable(false);
        roomRepository.save(room);

        reservation.setCustomer(customer);
        reservation.setRoom(room);

        return reservationRepository.save(reservation);
    }

    public List<Reservation> rezervasyonlariGetir() {
        return reservationRepository.findAll();
    }

    public Reservation getReservationById(Long id) {

        return reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rezervasyon bulunamadı."));
    }

    // Rezervasyon sil
    public void deleteReservation(Long id) {

        reservationRepository.deleteById(id);
    }
}
