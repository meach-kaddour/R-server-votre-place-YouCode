package org.example.services;

import org.example.Repository.ReservationRepository;
import org.example.Repository.ReservationRepositoryImpl;
import org.example.dao.ReservationDao;
import org.example.entities.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;



@Service
@Component("ReservationService")
public class ReservationServiceImpl implements ReservationService{

    @Autowired
    private ReservationDao reservationDao ;
    
    private ReservationRepositoryImpl reservationRepository=new ReservationRepositoryImpl();

	@Override
	public List<Reservation> findAll() throws ClassNotFoundException, SQLException {
		return reservationDao.getAllReservations();
	}

	@Override
	public Reservation findById(Long id) throws ClassNotFoundException, SQLException {
		return reservationDao.getReservationById(id);
	}

	@Override
	public void save(Reservation reservation) throws ClassNotFoundException, SQLException {
		reservationDao.createReservation(reservation);
	}

	@Override
	public void delete(Long id) throws ClassNotFoundException, SQLException {
		reservationDao.dropReservation(id);
	}

	@Override
	public Reservation update(Reservation reservation) throws ClassNotFoundException, SQLException {
		return reservationDao.updateReservation(reservation);
	}

	@Override
	public List<Reservation> findAllById(Long id) throws ClassNotFoundException, SQLException {
		return reservationRepository.getReservationStudent(id);
	}
    
   
}
