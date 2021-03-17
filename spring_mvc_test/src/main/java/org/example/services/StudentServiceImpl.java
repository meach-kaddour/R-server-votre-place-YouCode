package org.example.services;

import org.example.Repository.StudentRepository;
import org.example.dao.StudentDao;
import org.example.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("studentService")
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private StudentRepository studentRepository;

    public StudentDao getStudentDao() {
        return studentDao;
    }

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public StudentRepository getStudentRepository() {
        return studentRepository;
    }

    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public boolean validateStudent(String email, String password) {
        Student student = getStudentRepository().getStudentDetailsByEmailAndPassword(email, password);
        return student;
    }

    @Override
    public boolean registerStudent(Student student) {
        boolean isRegister=false;
        boolean saveStudent = getStudentDao().createStudent(student);
        if(saveStudent)
            isRegister=true;
        return isRegister;
    }
}
