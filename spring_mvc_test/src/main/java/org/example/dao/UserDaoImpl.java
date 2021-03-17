package org.example.dao;

import org.example.HibernateUtil.HibernateUtil;
import org.example.entities.Users;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserDaoImpl implements UserDao{
    Session session=null;
    Transaction transaction=null;

    @Override
    public void createUser(Users user) {
        session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
    }

    @Override
    public Users getUserById(Long id) {
        session = HibernateUtil.getSession();
        session.beginTransaction();
        Users user = session.find(Users.class, id);
        session.getTransaction().commit();
        return user;
    }

    @Override
    public List<Users> getAllUsers() {
        session = HibernateUtil.getSession();
        session.beginTransaction();
        List<Users> userList = session.createQuery("From Users ").list();
        session.getTransaction().commit();
        return userList;
    }

    @Override
    public void dropUser(Long id) {
        Users user;
        session = HibernateUtil.getSession();
        session.beginTransaction();
        user = session.find(Users.class, id);
        if (user != null){
            session.delete(user);
            session.flush();
            System.out.println("drop user");
        }else{
            System.out.println("User Not Exist");
        }
        session.getTransaction().commit();
    }

    @Override
    public Users updateUser(Users user) {
        Users userUp;
        session = HibernateUtil.getSession();
        session.beginTransaction();
        userUp = session.find(Users.class, user.getUserId());
        if (userUp != null){
            userUp.setUserPrenom(user.getUserPrenom());
            userUp.setUserNom(user.getUserNom());
            userUp.setUserEmail(user.getUserEmail());
            userUp.setUserPassword(user.getUserPassword());
            userUp.setRole(user.getRole());
            System.out.println("User updated");
        }else{
            System.out.println("User Not Exist");
        }
        session.getTransaction().commit();
        return userUp;
    }
}
