package org.example.Repository;

import java.util.List;

import org.example.entities.Reservation;


public interface ReservationRepository {
	 public List<Reservation> getReservationStudent(Long id);
}
