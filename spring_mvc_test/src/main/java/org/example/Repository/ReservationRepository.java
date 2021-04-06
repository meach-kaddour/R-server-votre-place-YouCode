package org.example.Repository;

import java.util.Date;
import java.util.List;

import org.example.entities.Reservation;


public interface ReservationRepository {
	 public List<Reservation> getReservationStudent(Long id);
	 public List<Reservation> getReservationConfirmi(String date);
	 public List<Reservation> getReservationNonConfirmi(String date);
}
