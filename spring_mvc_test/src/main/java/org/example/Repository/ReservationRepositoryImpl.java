package org.example.Repository;

import java.util.List;
import org.example.HibernateUtil.HibernateUtil;
import org.example.entities.Reservation;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class ReservationRepositoryImpl implements ReservationRepository {

	@Override
	public List<Reservation> getReservationStudent(Long id) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();

		List<Reservation> reservations ;
		Query<Reservation> query = session.createQuery("from Reservation r  where r.student.userId= :id", Reservation.class);
		query.setParameter("id", id);
		try {
			reservations = query.list();
		} finally {
			if (session != null) {
				session.close();
			}

		}
		return reservations;
	}

	}

