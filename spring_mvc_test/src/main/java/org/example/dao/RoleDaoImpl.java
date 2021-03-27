package org.example.dao;

import org.example.HibernateUtil.HibernateUtil;
import org.example.entities.Roles;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository("RoleDao")
@Component
public class RoleDaoImpl implements RoleDao{
    Session session=null;
    Transaction transaction=null;
    @Override
    public void createRole(Roles role) throws ClassNotFoundException, SQLException {

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.persist(role);
            // lancer des mises à jour dans la session et faire automatiquement le commit
            session.flush();
            // transaction.commit();
            System.out.println("role est bien crée !");
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
    public Roles getRoleById(long id) throws ClassNotFoundException, SQLException {
        Roles role = null;
        try {

            session = HibernateUtil.getSessionFactory().openSession();
            // get user by id
            role = session.get(Roles.class, id);
            System.out.println("role lu !");
        } finally {
            if (session != null) {
                session.close();
            }

        }

        return role;
    }

    @Override
    public List<Roles> getAllRoles() throws ClassNotFoundException, SQLException {
        List<Roles> roles = null;
        try {

            session = HibernateUtil.getSessionFactory().openSession();
            org.hibernate.query.Query<Roles> query = session.createQuery("SELECT r FROM Roles  r", Roles.class);
            roles = query.getResultList();

            System.out.println("roles lus !");
        } finally {
            if (session != null) {
                session.close();
            }

        }

        return roles;
    }

    @Override
    public void dropRole(long id) throws ClassNotFoundException, SQLException {
        Roles role = getRoleById(id);
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            session.delete(role);
            transaction.commit();
            System.out.println("role deleted !");

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
    public Roles updateRole(Roles role) throws ClassNotFoundException, SQLException {
        return null;
    }
}
