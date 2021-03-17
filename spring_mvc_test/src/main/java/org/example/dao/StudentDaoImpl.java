package org.example.dao;

import org.example.HibernateUtil.HibernateUtil;
import org.example.entities.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("StudentDao")
public class StudentDaoImpl implements StudentDao{

    Session session=null;
    Transaction transaction =null;
    @Override
    public boolean createStudent(Student student) {
        try {
            session = HibernateUtil.getSession();
            transaction = session.beginTransaction();
            session.persist(student);
            // lancer des mises à jour dans la session et faire automatiquement le commit
            session.flush();
            // transaction.commit();
            System.out.println("student est bien crée !");
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
        return false;
    }

    @Override
    public Student getStudentById(Long id) {
        Student student=null;
        try {

            session = HibernateUtil.getSession();
            // get joueur by id
            student = session.get(Student.class, id);
            System.out.println("lu");
        } finally {
            if (session != null) {
                session.close();
            }

        }

        return student;
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> students = null;
        try {

            session = HibernateUtil.getSession();
            org.hibernate.query.Query<Student> query = session.createQuery("SELECT t FROM Student t", Student.class);
            //org.hibernate.query.Query<Student> query = session.createNamedQuery("Student.All", Student.class);
            students = query.getResultList();

            System.out.println("students lu !");
        } finally {
            if (session != null) {
                session.close();
            }

        }

        return students;
    }

    @Override
    public void dropStudent(Long id) {
        Student student = getStudentById(id);

        try {
            session = HibernateUtil.getSession();
            transaction = session.beginTransaction();
            session.delete(student);
            transaction.commit();
            System.out.println("student suprimé !");

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
    public Student updateStudent(Student student) {
        return null;
    }
}
