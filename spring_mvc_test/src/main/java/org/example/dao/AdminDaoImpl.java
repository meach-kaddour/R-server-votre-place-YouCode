package org.example.dao;

import org.example.HibernateUtil.HibernateUtil;
import org.example.entities.Administrator;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository("AdminDao")
@Component
public class AdminDaoImpl implements AdminDao{

    Session session = null;
    Transaction transaction = null;
    @Override
    public void createAdministrator(Administrator admin) throws ClassNotFoundException, SQLException {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.persist(admin);
            // lancer des mises à jour dans la session et faire automatiquement le commit
            session.flush();
            // transaction.commit();
            System.out.println("admin est bien crée !");
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
    public Administrator getAdministratorById(long id) throws ClassNotFoundException, SQLException {
        Administrator admin = null;
        try {

            session = HibernateUtil.getSessionFactory().openSession();
            // get user by id
            admin = session.get(Administrator.class, id);
            System.out.println("Admin lu !");
        } finally {
            if (session != null) {
                session.close();
            }

        }

        return admin;
    }
    @Override
    public List<Administrator> getAllAdministrators() throws ClassNotFoundException, SQLException {
        List<Administrator> admins = null;
        try {

            session = HibernateUtil.getSessionFactory().openSession();
            org.hibernate.query.Query<Administrator> query = session.createQuery("SELECT a FROM Administrator a", Administrator.class);
            //org.hibernate.query.Query<Student> query = session.createNamedQuery("students.All", Student.class);
            admins = query.getResultList();

            System.out.println("Admins lus !");
        } finally {
            if (session != null) {
                session.close();
            }

        }

        return admins;
    }

    @Override
    public void dropAdministrator(long id) throws ClassNotFoundException, SQLException {
        Administrator admin = getAdministratorById(id);
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            session.delete(admin);
            transaction.commit();
            System.out.println("admin deleted !");

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
    public Administrator updateAdministrator(Administrator admin) throws ClassNotFoundException, SQLException {
        return null;
    }
}
