package org.example.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "user_id")
@Table(name = "student")
public class Student extends Users implements Serializable {


    @OneToOne
    @JoinColumn(name = "user_id")
    private Users users;

    @OneToMany
    private List<Reservation> reservations;

    private boolean valide=false;
    //Getters and Setters

    public boolean isValide() {
        return valide;
    }

    public void setValide(boolean valide) {
        this.valide = valide;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    //Constructors
    public Student(){}

    public Student(Users  users){
        this.users=users;
    }

    public Student(Long userId, String userNom, String userPrenom, String userEmail, String userPassword, Administrator administrator, Student student, Roles role, Users users, List<Reservation> reservations, boolean valide) {
        super(userId, userNom, userPrenom, userEmail, userPassword, administrator, student, role);
        this.users = users;
        this.reservations = reservations;
        this.valide = valide;
    }

    public Student(String userNom, String userPrenom, String userEmail, String userPassword, Administrator administrator, Student student, Roles role, Users users, boolean valide) {
        super( userNom, userPrenom, userEmail, userPassword, administrator, student, role);
        this.users = users;
        this.valide = valide;
    }


}
