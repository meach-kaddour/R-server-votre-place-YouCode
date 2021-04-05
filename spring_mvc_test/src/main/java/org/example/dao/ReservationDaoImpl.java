package org.example.dao;

import org.example.HibernateUtil.HibernateUtil;
import org.example.entities.Reservation;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository("ReservationDao")
@Component
public class ReservationDaoImpl implements ReservationDao{
    Session session=null;
    Transaction transaction=null;
    @Override
    public void createReservation(Reservation reservation) throws ClassNotFoundException, SQLException {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(reservation);
            // lancer des mises à jour dans la session et faire automatiquement le commit
            session.flush();
            // transaction.commit();
            System.out.println("reservation est bien crée !");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Reservation getReservationById(long id) throws ClassNotFoundException, SQLException {
        Reservation reservation = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            // get Reservation by id
            reservation = session.get(Reservation.class, id);
            System.out.println("Reservation lu !");
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return reservation;
    }

    @Override
    public List<Reservation> getAllReservations() throws ClassNotFoundException, SQLException {
        List<Reservation> reservations = null;
        try {

            session = HibernateUtil.getSessionFactory().openSession();
            org.hibernate.query.Query<Reservation> query = session.createQuery("SELECT rs FROM Reservation rs ", Reservation.class);
            //org.hibernate.query.Query<Student> query = session.createNamedQuery("students.All", Student.class);
            reservations = query.getResultList();
            System.out.println("Resrvations lus !");
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return reservations;
    }
    @Override
    public void dropReservation(long id) throws ClassNotFoundException, SQLException {
        Reservation reservation = getReservationById(id);
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            session.delete(reservation);
            transaction.commit();
            System.out.println("reservation deleted !");

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }

        }
    }
    @Override
    public Reservation updateReservation(Reservation reservation) throws ClassNotFoundException, SQLException {
        Reservation reservationUp = null;

        try{
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            reservationUp = session.find(Reservation.class, reservation.getId());
            if (reservationUp != null){
                reservationUp.setDateRes(reservation.getDateRes());
                reservationUp.setConfirmation(reservation.isConfirmation());
                reservationUp.setTypeRes(reservation.getTypeRes());
                System.out.println("Resrvation  updated");
            }else{
                System.out.println("Reservation does not exist");
            }
            session.getTransaction().commit();
        }catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
    }
        return reservationUp;
}
}
