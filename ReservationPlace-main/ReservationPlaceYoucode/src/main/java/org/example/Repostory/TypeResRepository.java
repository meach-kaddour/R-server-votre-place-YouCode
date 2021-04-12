package org.example.Repostory;

import org.example.Entity.TypereservationEntity;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

@Component
public class TypeResRepository {
    Session session;
    public TypereservationEntity getTypeResbyName(String name){
        session = HibernateUtil.getSession();
        session.beginTransaction();
        Query query =  session.createQuery("from TypereservationEntity where typeRes=: name");
        query.setParameter("name", name);
        try {
            TypereservationEntity typeResEntity = (TypereservationEntity) query.getSingleResult();
            return typeResEntity;
        }
        catch (Exception e){
            return null;
        }
    }
}
