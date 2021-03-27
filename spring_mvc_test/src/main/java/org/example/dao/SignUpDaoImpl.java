package org.example.dao;

import org.example.HibernateUtil.HibernateUtil;
import org.example.entities.SignUp;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository("SignUpDao")
@Component
public class SignUpDaoImpl implements SignUpDao {
    Session session = null;
    Transaction transaction = null;

    @Override
    public void createSignUp(SignUp signUp) throws ClassNotFoundException, SQLException {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.persist(signUp);
            // lancer des mises à jour dans la session et faire automatiquement le commit
            session.flush();
            // transaction.commit();
            System.out.println("user registeravec sucess ");
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
    public SignUp getSignUpById(long id) throws ClassNotFoundException, SQLException {
        SignUp signUp = null;
        try {

            session = HibernateUtil.getSessionFactory().openSession();
            // get user by id
            signUp = session.get(SignUp.class, id);
            System.out.println("user register lu !");
        } finally {
            if (session != null) {
                session.close();
            }

        }
        return signUp;
    }

    @Override
    public List<SignUp> getAllSignUp() throws ClassNotFoundException, SQLException {
        List<SignUp> signUpList = null;
        try {

            session = HibernateUtil.getSessionFactory().openSession();
            org.hibernate.query.Query<SignUp> query = session.createQuery("SELECT S FROM SignUp S", SignUp.class);
            signUpList = query.getResultList();

            System.out.println("Admins lus !");
        } finally {
            if (session != null) {
                session.close();
            }

        }

        return signUpList;
    }

    @Override
    public void dropSignUp(long id) throws ClassNotFoundException, SQLException {
        SignUp signUp = getSignUpById(id);
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            session.delete(signUp);
            transaction.commit();
            System.out.println("user Register deleted !");

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
    public SignUp updateSignUp(SignUp SignUp) throws ClassNotFoundException, SQLException {
        return null;
    }
}
