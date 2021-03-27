package org.example.dao;

import org.example.entities.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentDao {
    public  void createStudent(Student student)throws ClassNotFoundException, SQLException;
    public Student getStudentById(long id)throws ClassNotFoundException, SQLException;
    public List<Student> getAllStudents()throws ClassNotFoundException, SQLException;
    public void dropStudent(long id)throws ClassNotFoundException, SQLException;
    public Student updateStudent(Student student)throws ClassNotFoundException, SQLException;
}
