package org.example.services;

import org.example.entities.Reservation;

import java.sql.SQLException;
import java.util.List;

public interface ReservationService {
    public List<Reservation> findAll() throws ClassNotFoundException, SQLException;
    public Reservation findById(Long id) throws ClassNotFoundException, SQLException;
    public void save(Reservation reservation) throws ClassNotFoundException, SQLException;
    public void delete(Long id) throws ClassNotFoundException, SQLException;
    public Reservation update(Reservation reservation)throws ClassNotFoundException, SQLException;
    public List<Reservation> findAllById(Long id) throws ClassNotFoundException, SQLException;
}
