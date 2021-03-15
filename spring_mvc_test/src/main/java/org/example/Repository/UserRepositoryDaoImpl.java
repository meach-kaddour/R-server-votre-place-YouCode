package org.example.Repository;

import org.example.HibernateUtil.HibernateUtil;
import org.example.entities.Users;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class UserRepositoryDaoImpl implements UserRepositoryDao{
    Session session;
    @Override
    public Users getUserByEmail(String email) {
        session = HibernateUtil.getSession();
        session.beginTransaction();
        Query query =  session.createQuery("from Users where userEmail=: email");
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
