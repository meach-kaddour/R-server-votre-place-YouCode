package org.example.entities;

import java.io.Serializable;
import javax.persistence.*;



@Entity
@Table(name = "typeReservation")
public class TypeReservation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column()
    private String typeReservation;
    @Column()
    private int nomberPlace;

    //Constructors

    public TypeReservation() {
    }

    public TypeReservation(int id, String typeReserv, int nomberPlace) {
        this.id = id;
        this.typeReservation = typeReserv;
        this.nomberPlace = nomberPlace;
    }

    public TypeReservation(String typeReserv, int nomberPlace) {
        this.typeReservation = typeReserv;
        this.nomberPlace = nomberPlace;
    }

    //Getters and Setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeReservation() {
        return typeReservation;
    }

    public void setTypeReservation(String typeReserv) {
        this.typeReservation = typeReserv;
    }

    public int getNomberPlace() {
        return nomberPlace;
    }

    public void setNomberPlace(int nomberPlass) {
        this.nomberPlace = nomberPlass;
    }

    @Override
    public String toString() {
        return "TypeReserv{" +
                "id=" + id +
                ", typeReserv='" + typeReservation + '\'' +
                ", nomberPlass=" + nomberPlace +
                '}';
    }
}
