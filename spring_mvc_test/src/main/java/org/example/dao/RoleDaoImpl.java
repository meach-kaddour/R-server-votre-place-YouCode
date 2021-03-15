package org.example.dao;

import org.example.HibernateUtil.HibernateUtil;
import org.example.entities.Roles;
import org.hibernate.Session;

import java.util.List;

public class RoleDaoImpl implements RoleDao{
    Session session;
    @Override
    public void addRole(Roles role) {
        session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(role);
        session.getTransaction().commit();
    }

    @Override
    public Roles getRoleById(int id) {
        session = HibernateUtil.getSession();
        session.beginTransaction();
        Roles role = session.find(Roles.class, id);
        session.getTransaction().commit();
        return role;
    }

    @Override
    public List<Roles> getAllRoles() {
        session = HibernateUtil.getSession();
        session.beginTransaction();
        List<Roles> listRole = session.createQuery("From Roles ").list();
        session.getTransaction().commit();
        return listRole;
    }

    @Override
    public void deleteRole(int id) {
        Roles role;
        session = HibernateUtil.getSession();
        session.beginTransaction();
        role = session.find(Roles.class, id);
        if (role != null){
            session.delete(role);
            session.flush();
            System.out.println("Delete Role");
        }else{
            System.out.println("Role Not Exist");
        }
        session.getTransaction().commit();
    }

    @Override
    public Roles updateRole(Roles role) {
        Roles roleUp;
        session = HibernateUtil.getSession();
        session.beginTransaction();
        roleUp = session.find(Roles.class, role.getId());
        if (roleUp != null){
            roleUp.setRoleName(role.getRoleName());
            System.out.println("Role Updated");
        }else{
            System.out.println("Role Not Exist");
        }
        session.getTransaction().commit();
        return roleUp;
    }
}
