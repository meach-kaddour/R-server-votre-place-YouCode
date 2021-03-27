package org.example.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@PrimaryKeyJoinColumn(name = "user_id")
@Table
public class Administrator extends Users implements Serializable {
    @OneToOne
    @JoinColumn(name = "user_id")
    private Users users;


    public Administrator() {

    }


    public Administrator(String userNom, String userPrenom, String userEmail, String userPassword, Administrator administrator, Student student, Roles role) {
        super(userNom, userPrenom, userEmail, userPassword, administrator, student, role);
        this.users = users;

    }

    public Administrator(Users users) {
        this.users = users;

    }


    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "user Mail =" + users.getUserEmail() +
                "user Nom =" + users.getUserNom() +
                '}';
    }
}
