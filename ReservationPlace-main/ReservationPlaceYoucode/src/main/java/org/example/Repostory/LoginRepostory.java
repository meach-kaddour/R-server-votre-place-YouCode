package org.example.Repostory;

import org.example.Entity.UseradminEntity;
import org.example.util.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.Query;

public class LoginRepostory {

	Session session;

	public UseradminEntity getUserByEmail(String email) {
		session = HibernateUtil.getSession();
		session.beginTransaction();
		Query query = session.createQuery("from UseradminEntity where email=: email");
		query.setParameter("email", email);
		try {
			UseradminEntity userEntity = (UseradminEntity) query.getSingleResult();
			return userEntity;
		} catch (Exception e) {
			return null;
		}
	}
}
