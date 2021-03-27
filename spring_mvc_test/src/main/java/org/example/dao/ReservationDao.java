package org.example.dao;

import org.example.entities.Reservation;

import java.sql.SQLException;
import java.util.List;

public interface ReservationDao {
    public  void createReservation(Reservation reservation)throws ClassNotFoundException, SQLException;
    public Reservation getReservationById(long id)throws ClassNotFoundException, SQLException;
    public List<Reservation> getAllReservations()throws ClassNotFoundException, SQLException;
    public void dropReservation(long id)throws ClassNotFoundException, SQLException;
    public Reservation updateReservation(Reservation reservation)throws ClassNotFoundException, SQLException;
}
