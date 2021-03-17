package org.example.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "Role")
public class Roles implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long RoleId;
    @Column(nullable = false, unique = true)
    private String roleName;

    //Constructor
    public Roles(){}



    //Getters and Setters

    public Long getId() {
        return RoleId;
    }

    public void setId(Long id) {
        this.RoleId = id;
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
                "id=" + RoleId +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
