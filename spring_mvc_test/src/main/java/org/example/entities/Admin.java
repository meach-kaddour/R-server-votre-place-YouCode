package org.example.entities;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@PrimaryKeyJoinColumn(name = "adminId")
@Table(name = "admin")
public class Admin extends  Users implements Serializable  {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String n) {
        name = n;
    }
}
