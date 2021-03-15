package org.example.entities;

import java.io.Serializable;
import javax.persistence.*;



@Entity
@Table(name = "typeReservation")
public class TypeReserv implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String typeReserv;
    @Column(nullable = false)
    private int nomberPlass;

    //Constructors

    public TypeReserv() {
    }

    public TypeReserv(int id, String typeReserv, int nomberPlass) {
        this.id = id;
        this.typeReserv = typeReserv;
        this.nomberPlass = nomberPlass;
    }

    public TypeReserv(String typeReserv, int nomberPlass) {
        this.typeReserv = typeReserv;
        this.nomberPlass = nomberPlass;
    }

    //Getters and Setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeReserv() {
        return typeReserv;
    }

    public void setTypeReserv(String typeReserv) {
        this.typeReserv = typeReserv;
    }

    public int getNomberPlass() {
        return nomberPlass;
    }

    public void setNomberPlass(int nomberPlass) {
        this.nomberPlass = nomberPlass;
    }

    @Override
    public String toString() {
        return "TypeReserv{" +
                "id=" + id +
                ", typeReserv='" + typeReserv + '\'' +
                ", nomberPlass=" + nomberPlass +
                '}';
    }
}
