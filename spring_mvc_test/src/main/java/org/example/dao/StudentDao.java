package org.example.dao;

import org.example.entities.Student;
import org.example.entities.Users;

import java.util.List;

public interface StudentDao {
    public boolean createStudent(Student student);
    public Student getStudentById(Long id);
    public List<Student> getAllStudents();
    public void dropStudent(Long id);
    public Users updateStudent(Student student);
}
