package org.example.entities;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "Role")
public class Roles implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, unique = true)
    private String roleName;
    //Constructor
    public Roles(){}

    public Roles(int id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    public Roles(String roleName) {
        this.roleName = roleName;
    }

    //Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "Roles{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
