package org.example.Repository;

import org.example.HibernateUtil.HibernateUtil;
import org.example.entities.Student;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;


@Repository("StudentRepository")
public class StudentRepositoryImpl implements StudentRepository {

    @Override
    public Student getStudentDetailsByEmailAndPassword(String email, String password) {
        Transaction transaction = null;
        Student student = null;
        try  {
            Session session = HibernateUtil.getSession();
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            student = (Student) session.createQuery("FROM Student U WHERE U.userEmail = :email").setParameter("email", email)
                    .uniqueResult();

            if (student != null && student.getUserPassword().equals(password)) {
                return student;
            }
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return null;
    }


}
