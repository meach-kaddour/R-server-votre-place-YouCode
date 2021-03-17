package org.example.Repository;

import org.example.entities.Student;


public interface StudentRepository {

    public Student getStudentDetailsByEmailAndPassword(String email,String password);

}
