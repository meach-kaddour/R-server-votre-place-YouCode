package org.example.entities;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@PrimaryKeyJoinColumn(name = "studentId")
@Table(name = "student")
public class Student extends Users implements Serializable {
    @Column(nullable = false)
    private String nombreReservation;

    public String getNombreReservation() {
        return nombreReservation;
    }

    public void setNombreReservation(String reservationMax) {
        this.nombreReservation = reservationMax;
    }

}
