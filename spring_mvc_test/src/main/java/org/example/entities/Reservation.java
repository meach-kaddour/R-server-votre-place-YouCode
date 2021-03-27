package org.example.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Reservation")
public class Reservation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Date dateRes;

    private boolean confirmation;
    @ManyToOne
    @JoinColumn(name = "userId")
    private Student student;

    @OneToOne(cascade=CascadeType.ALL)
    private TypeReservation typeRes;


//Constructors

    public Reservation(){}

    public Reservation(Student student, Date dateRes, boolean confirmation, TypeReservation typeRes) {
        this.student = student;
        this.dateRes = dateRes;
        this.confirmation = confirmation;
        this.typeRes = typeRes;
    }

    public Reservation(Long id, Student student, Date dateRes, boolean confirmation, TypeReservation typeRes) {
        this.id = id;
        this.student = student;
        this.dateRes = dateRes;
        this.confirmation = confirmation;
        this.typeRes = typeRes;
    }

    //Getters and Stters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateRes() {
        return dateRes;
    }

    public void setDateRes(Date dateRes) {
        this.dateRes = dateRes;
    }

    public boolean isConfirmation() {
        return confirmation;
    }

    public void setConfirmation(boolean confirmation) {
        this.confirmation = confirmation;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public TypeReservation getTypeRes() {
        return typeRes;
    }

    public void setTypeRes(TypeReservation typeRes) {
        this.typeRes = typeRes;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", dateRes=" + dateRes +
                ", confirmation=" + confirmation +
                ", student=" + student +
                ", typeRes=" + typeRes +
                '}';
    }
}
