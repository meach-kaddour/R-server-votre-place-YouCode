package org.example.dao;

import org.example.HibernateUtil.HibernateUtil;
import org.example.entities.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import java.sql.SQLException;
import java.util.List;


@Repository("StudentDao")
@Component
public class StudentDaoImpl implements StudentDao{
    Session session = null;
    Transaction transaction = null;
    @Override
    public void createStudent(Student student) throws ClassNotFoundException, SQLException {

        try {
            session = HibernateUtil.getSessionFactory().openSession();
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
    }

    @Override
    public Student getStudentById(long id) throws ClassNotFoundException, SQLException {
        Student student = null;
        try {

            session = HibernateUtil.getSessionFactory().openSession();
            // get student by id
            student = session.get(Student.class, id);
            System.out.println("Student lu !");
        } finally {
            if (session != null) {
                session.close();
            }

        }

        return student;
    }

    @Override
    public List<Student> getAllStudents() throws ClassNotFoundException, SQLException {
        List<Student> students = null;
        try {

            session = HibernateUtil.getSessionFactory().openSession();
            org.hibernate.query.Query<Student> query = session.createQuery("SELECT s FROM Student s", Student.class);
            //org.hibernate.query.Query<Student> query = session.createNamedQuery("students.All", Student.class);
            students = query.getResultList();

            System.out.println("Students lus !");
        } finally {
            if (session != null) {
                session.close();
            }

        }

        return students;
    }

    @Override
    public void dropStudent(long id) throws ClassNotFoundException, SQLException {
        Student student = getStudentById(id);
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            session.delete(student);
            transaction.commit();
            System.out.println("student deleted !");

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
    public Student updateStudent(Student student) throws ClassNotFoundException, SQLException {
        return null;
    }
}
