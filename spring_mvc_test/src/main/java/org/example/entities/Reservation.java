package org.example.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Reservation")
public class Reservation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    private Users user;
    @Column(nullable = false)
    private Date dateRes;
    private boolean confirmation;

    @OneToOne
    private TypeReserv typeRes;


//Constructors

    public Reservation(){}
    public Reservation(Users user, Date dateRes, boolean confirmation, TypeReserv typeRes) {
        this.user = user;
        this.dateRes = dateRes;
        this.confirmation = confirmation;
        this.typeRes = typeRes;
    }

    public Reservation(int id, Users user, Date dateRes, boolean confirmation, TypeReserv typeRes) {
        this.id = id;
        this.user = user;
        this.dateRes = dateRes;
        this.confirmation = confirmation;
        this.typeRes = typeRes;
    }

    //Getters and Stters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
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

    public TypeReserv getTypeRes() {
        return typeRes;
    }

    public void setTypeRes(TypeReserv typeRes) {
        this.typeRes = typeRes;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", user=" + user +
                ", dateRes=" + dateRes +
                ", confirmation=" + confirmation +
                ", typeRes=" + typeRes +
                '}';
    }
}
