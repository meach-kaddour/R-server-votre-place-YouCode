package org.example.dao;

import org.example.HibernateUtil.HibernateUtil;

import org.example.entities.TypeReservation;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
@Repository("TypeReservationDao")
@Component
public class TypeReservationDaoImpl implements TypeReservationDao{
    Session session = null;
    Transaction transaction = null;
    @Override
    public void createTypeReservation(TypeReservation type) throws ClassNotFoundException, SQLException {

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(type);
            // lancer des mises à jour dans la session et faire automatiquement le commit
            session.flush();
            // transaction.commit();
            System.out.println("Type Reservation est bien crée !");
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
    public TypeReservation getTypeReservationById(long id) throws ClassNotFoundException, SQLException {
        TypeReservation type = null;
        try {

            session = HibernateUtil.getSessionFactory().openSession();
            // get student by id
            type = session.get(TypeReservation.class, id);
            System.out.println("Type Reservation lu !");
        } finally {
            if (session != null) {
                session.close();
            }

        }

        return type;
    }

    @Override
    public List<TypeReservation> getAllTypeReservation() throws ClassNotFoundException, SQLException {
        List<TypeReservation> types = null;
        try {

            session = HibernateUtil.getSessionFactory().openSession();
            org.hibernate.query.Query<TypeReservation> query = session.createQuery("SELECT t FROM TypeReservation t", TypeReservation.class);
            //org.hibernate.query.Query<Student> query = session.createNamedQuery("students.All", Student.class);
            types = query.getResultList();

            System.out.println("Type_Reservation lus !");
        } finally {
            if (session != null) {
                session.close();
            }

        }

        return types;
    }

    @Override
    public void dropTypeReservation(long id) throws ClassNotFoundException, SQLException {
        TypeReservation type = getTypeReservationById(id);
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            session.delete(type);
            transaction.commit();
            System.out.println("  TypeReservation deleted !");

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
    public TypeReservation updateTypeReservation(TypeReservation type) throws ClassNotFoundException, SQLException {
        return null;
    }
}
