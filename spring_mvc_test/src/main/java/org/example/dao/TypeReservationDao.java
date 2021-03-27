package org.example.dao;

import org.example.entities.TypeReservation;

import java.sql.SQLException;
import java.util.List;

public interface TypeReservationDao {

    public  void createTypeReservation(TypeReservation type)throws ClassNotFoundException, SQLException;
    public TypeReservation getTypeReservationById(long id)throws ClassNotFoundException, SQLException;
    public List<TypeReservation> getAllTypeReservation()throws ClassNotFoundException, SQLException;
    public void dropTypeReservation(long id)throws ClassNotFoundException, SQLException;
    public TypeReservation  updateTypeReservation(TypeReservation type)throws ClassNotFoundException, SQLException;
}
