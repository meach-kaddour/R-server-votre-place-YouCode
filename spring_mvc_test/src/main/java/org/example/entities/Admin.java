package org.example.entities;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@PrimaryKeyJoinColumn(name = "adminId")
@Table(name = "admin")
public class Admin extends  Users implements Serializable  {

    private String Profession;

    public String getProfession() {
        return Profession;
    }

    public void setProfession(String profession) {
        Profession = profession;
    }
}
