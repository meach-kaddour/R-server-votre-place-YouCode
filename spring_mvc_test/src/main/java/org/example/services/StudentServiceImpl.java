package org.example.services;

import org.example.dao.StudentDao;
import org.example.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
@Service
@Component("StudentService")
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentDao studentDao ;


    @Override
    public List<Student> findAll() throws ClassNotFoundException, SQLException {
        return studentDao.getAllStudents();
    }

    @Override
    public Student findById(Long id) throws ClassNotFoundException, SQLException {
        return studentDao.getStudentById(id);
        
    }

    @Override
    public void save(Student student) throws ClassNotFoundException, SQLException {
    	studentDao.createStudent(student);
    }

    @Override
    public void delete(Long id) throws ClassNotFoundException, SQLException {
    	studentDao.dropStudent(id);
    }
}
