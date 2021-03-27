package org.example.entities;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "users")
@NamedQuery(query = "SELECT u FROM Users u where u.userEmail = :email", name = "userByEmail")
//@NamedQuery(query = "SELECT u FROM Users u", name = "users.All")
public class Users implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long userId;

    @Column(nullable = false)
    private  String userNom;

    @Column(nullable = false)
    private  String userPrenom;

    //@Column(unique = true,nullable = false)
    private  String userEmail;
    @Column(nullable = false)
    private  String userPassword;

    @OneToOne
    private Administrator administrator;


    @OneToOne
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "roleId")
    private  Roles role;

    //Constructors

    public Users() {
    }

    public Users(String userNom, String userPrenom, String userEmail, String userPassword, Administrator administrator, Student student, Roles role) {
        this.userNom = userNom;
        this.userPrenom = userPrenom;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.administrator = administrator;
        this.student=student;
        this.role = role;
    }

    public Users(Long userId, String userNom, String userPrenom, String userEmail, String userPassword, Administrator administrator, Student student, Roles role) {
        this.userId = userId;
        this.userNom = userNom;
        this.userPrenom = userPrenom;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.administrator = administrator;
        this.student=student;
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
    public Administrator getAdmin() {
        return administrator;
    }

    public void setAdmin(Administrator administrator) {
        this.administrator = administrator;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
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
