package org.example.services;

import org.example.entities.Student;

public interface StudentService {
    public abstract boolean validateStudent(String email, String password);
    public abstract boolean registerStudent(Student student); }


