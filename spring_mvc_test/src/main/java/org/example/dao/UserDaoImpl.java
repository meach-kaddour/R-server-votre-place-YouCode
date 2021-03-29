package org.example.dao;

import org.example.HibernateUtil.HibernateUtil;
import org.example.entities.Users;
import org.hibernate.Session;
import org.hibernate.Transaction;

import org.hibernate.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


import java.sql.SQLException;
import java.util.List;


@Repository("UserDao")
@Component
public class UserDaoImpl implements UserDao{
    @Override
    public void createUser(Users user) throws ClassNotFoundException, SQLException {
        Session session = null;
        Transaction transaction = null;
        try {

            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.persist(user);
            // lancer des mises à jour dans la session et faire automatiquement le commit
            session.flush();
            // transaction.commit();
            System.out.println("User est bien crée !");
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
    public Users getUserById(Long id) throws ClassNotFoundException, SQLException {
        Users user = null;
        Session session = null;
        try {

            session = HibernateUtil.getSessionFactory().openSession();
            // get user by id
            user = session.get(Users.class, id);
            System.out.println("User lu !");
        } finally {
            if (session != null) {
                session.close();
            }

        }

        return user;
    }

    @Override
    public List<Users> getAllUsers() throws ClassNotFoundException, SQLException {
        Session session = null;
        List<Users> users = null;
        try {

            session = HibernateUtil.getSessionFactory().openSession();
            //org.hibernate.query.Query<Users> query = session.createQuery("SELECT u FROM Users u", Users.class);
            //org.hibernate.query.Query<Users> query = session.createNamedQuery("GET_ALL_STUDENTS");
            Query query = session.createQuery("select u from Users u join Student s where u.userId = s.userId ");
            //query.setParameter("value1", "maValeur");
            users = query.getResultList();

            System.out.println("Users lus !");
        } finally {
            if (session != null) {
                session.close();
            }

        }

        return users;
    }

    @Override
    public void dropUser(long id) throws ClassNotFoundException, SQLException {
        Users user = getUserById(id);
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            session.delete(user);
            transaction.commit();
            System.out.println("user deleted !");

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
    public Users updateUser(Users user) throws ClassNotFoundException, SQLException {
        Users userUp = null;
        Session session = null;
        Transaction transaction = null;
        try{
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            userUp = session.find(Users.class, user.getUserId());
            if (userUp != null){
                userUp.setUserNom(user.getUserNom());
                userUp.setUserPrenom(user.getUserPrenom());
                userUp.setUserEmail(user.getUserEmail());
                userUp.setUserPassword(user.getUserPassword());
                userUp.setRole(user.getRole());
                System.out.println("User updated");
            }else{
                System.out.println("User does not exist");
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
        
        return userUp;
    }
}
