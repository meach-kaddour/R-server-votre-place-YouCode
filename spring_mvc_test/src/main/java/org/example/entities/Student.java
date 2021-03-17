package org.example.entities;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@PrimaryKeyJoinColumn(name = "studentId")
@Table(name = "student")
public class Student extends Users implements Serializable {
    @Column(nullable = false)
    private String nombreReservation;


    private boolean valide=false;
    //Getters and Setters

    public boolean isValide() {
        return valide;
    }

    public void setValide(boolean valide) {
        this.valide = valide;
    }



    public String getNombreReservation() {
        return nombreReservation;
    }

    public void setNombreReservation(String reservationMax) {
        this.nombreReservation = reservationMax;
    }


    //Constructors
    public Student(){}

    public Student(String userNom, String userPrenom, String userEmail, String userPassword, Roles role, String nombreReservation) {
        super(userNom, userPrenom, userEmail, userPassword, role);
        this.nombreReservation = nombreReservation;
    }

    public Student(Long userId, String userNom, String userPrenom, String userEmail, String userPassword, Roles role, String nombreReservation) {
        super(userId, userNom, userPrenom, userEmail, userPassword, role);
        this.nombreReservation = nombreReservation;
    }
}
