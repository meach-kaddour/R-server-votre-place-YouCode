package org.example.Repository;

import org.example.HibernateUtil.HibernateUtil;
import org.example.entities.Roles;
import org.example.entities.Users;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class UserRepositoryImpl implements UserRepository{
    Session session=null;
    Transaction transaction=null;
    @Override
    public boolean validate(String email, String password) {

        Users user = null;
        try {
            // start a transaction
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            // get an user object
            user = (Users) session.createQuery("FROM Users U WHERE U.userEmail= :email").setParameter("email", email)
                    .uniqueResult();

            if (user != null && user.getUserPassword().equals(password)) {
                System.out.println("ok");
                return true;
            }else{
                System.out.println("not ok");

            }
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return false;
      }

    @Override
    public Roles getByRole(Long id) {
        Roles role = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            // get user by id
            role = session.get(Roles.class, id);
            System.out.println("User lu !");
        } finally {
            if (session != null) {
                session.close();
            }

        }

        return role;
    }

    @Override
    public Users getByEmail(String email) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query =  session.createQuery("from Users where userEmail= :email");
        query.setParameter("email", email);
        try {
            Users user = (Users) query.getSingleResult();
            return user;
        }
        catch (Exception e){
            return null;
        }
    }
}

