package org.example.entities;


import javax.persistence.*;

@Entity
@Table(name = "signUp")
public class SignUp {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String nom;
    @Column(nullable = false)
    private String prenom;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;


    public SignUp() {
    }

    public SignUp(Long id, String nom, String prenom, String email, String password) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;

    }

    public SignUp(String nom, String prenom, String email, String password) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String firstName) {
        this.nom = firstName;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String lastName) {
        this.prenom = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }




    public void showSignUp() {
        System.out.println("SignUp{" +
                "id=" + id +
                ", firstName='" + nom + '\'' +
                ", lastName='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}');
    }
}