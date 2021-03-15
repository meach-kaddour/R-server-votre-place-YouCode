package org.example.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "users")
public class Users implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(nullable = false)
    private  String userNom;
    @Column(nullable = false)
    private  String userPrenom;
    @Column(unique = true,nullable = false)
    private  String userEmail;
    @Column(nullable = false)
    private  String userPassword;


    @OneToOne
    @JoinColumn(name = "id")
    private  Roles role;

    //Constructors

    public Users() {
    }

    public Users(String userNom, String userPrenom, String userEmail, String userPassword) {
        this.userNom = userNom;
        this.userPrenom = userPrenom;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
       // this.role = role;
    }

    public Users(Long userId, String userNom, String userPrenom, String userEmail, String userPassword, Roles role) {
        this.userId = userId;
        this.userNom = userNom;
        this.userPrenom = userPrenom;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.role = role;
    }

    //Getters and Setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserNom() {
        return userNom;
    }

    public void setUserNom(String userNom) {
        this.userNom = userNom;
    }

    public String getUserPrenom() {
        return userPrenom;
    }

    public void setUserPrenom(String userPrenom) {
        this.userPrenom = userPrenom;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Users{" +
                "userId=" + userId +
                ", userNom='" + userNom + '\'' +
                ", userPrenom='" + userPrenom + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", role=" + role +
                '}';
    }
}
