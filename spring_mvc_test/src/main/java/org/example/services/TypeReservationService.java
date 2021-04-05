package org.example.services;

import org.example.entities.TypeReservation;

import java.sql.SQLException;
import java.util.List;

public interface TypeReservationService {
    public List<TypeReservation> findAll() throws ClassNotFoundException, SQLException;
    public TypeReservation findById(Long id) throws ClassNotFoundException, SQLException;
    public void save(TypeReservation typeReservation) throws ClassNotFoundException, SQLException;
    public void delete(Long id) throws ClassNotFoundException, SQLException;
}
