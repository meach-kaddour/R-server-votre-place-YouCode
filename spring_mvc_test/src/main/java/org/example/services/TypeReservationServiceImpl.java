package org.example.services;

import org.example.dao.TypeReservationDao;
import org.example.entities.TypeReservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
@Service
@Component("TypeReservationService")
public class TypeReservationServiceImpl implements TypeReservationService{
	
    @Autowired
    private TypeReservationDao typeReservationDao ;

    @Override
    public List<TypeReservation> findAll() throws ClassNotFoundException, SQLException {
        return typeReservationDao.getAllTypeReservation();
    }

    @Override
    public TypeReservation findById(Long id) throws ClassNotFoundException, SQLException {
        return typeReservationDao.getTypeReservationById(id);
        
    }

    @Override
    public void save(TypeReservation typeReservation) throws ClassNotFoundException, SQLException {
    	typeReservationDao.createTypeReservation(typeReservation);
    }

    @Override
    public void delete(Long id) throws ClassNotFoundException, SQLException {
    	typeReservationDao.dropTypeReservation(id);
    }
}
