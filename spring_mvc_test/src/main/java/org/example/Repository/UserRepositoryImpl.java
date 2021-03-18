package org.example.Repository;

import org.example.HibernateUtil.HibernateUtil;
import org.example.entities.Users;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserRepositoryImpl implements UserRepository{
    @Override
    public boolean validate(String email, String password) {
        Transaction transaction = null;
        Users user = null;
        try {
            // start a transaction
            Session session = HibernateUtil.getSession();
            transaction = session.beginTransaction();
            // get an user object
            user = (Users) session.createQuery("FROM Users U WHERE U.userEmail= :email").setParameter("email", email)
                    .uniqueResult();

            if (user != null && user.getUserPassword().equals(password)) {
                return true;
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
    }

