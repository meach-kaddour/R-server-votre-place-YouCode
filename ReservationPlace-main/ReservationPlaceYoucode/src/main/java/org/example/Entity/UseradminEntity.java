package org.example.Entity;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "useradmin")
public class UseradminEntity implements Serializable {
    //Properties
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private int  phone;

    @Column(nullable = false)
    private boolean accepted;

    @OneToOne
   private RoleEntity role;

    
    //Constructors
    public UseradminEntity() {
    }

    public UseradminEntity(String firstName, String lastName, String email, String password, int phone, RoleEntity role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.role = role;
    }

    public UseradminEntity(int id, String firstName, String lastName, String email, String password, int phone, RoleEntity role) {
        this.idUser = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.role = role;
    }

    public UseradminEntity(int id, String firstName, String lastName, String email, String password) {
        this.idUser = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;

    }

    public UseradminEntity(int id, boolean accepted) {
        this.idUser = id;
        this.accepted=accepted;

    }



    //Getters And Setters
    public int getId() {
        return idUser;
    }

    public void setId(int id) {
        this.idUser = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public RoleEntity getRole() {
        return role;
    }

    public void setRole(RoleEntity role) {
        this.role = role;
    }


    public boolean isAccepted() {
        return accepted;
    }

    public boolean setAccepted(boolean accepted) {
       return this.accepted = accepted;
    }


}
