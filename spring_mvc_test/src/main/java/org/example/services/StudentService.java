package org.example.services;

import org.example.entities.Student;
import java.sql.SQLException;
import java.util.List;

public interface StudentService {
    public List<Student> findAll() throws ClassNotFoundException, SQLException;
    public Student findById(Long id) throws ClassNotFoundException, SQLException;
    public void save(Student student) throws ClassNotFoundException, SQLException;
    public void delete(Long id) throws ClassNotFoundException, SQLException;

}
