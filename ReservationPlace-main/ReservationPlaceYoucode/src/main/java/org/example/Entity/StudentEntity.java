package org.example.Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
//@PrimaryKeyJoinColumn(name = "studentId")
@Table(name = "student")
public class StudentEntity extends UseradminEntity implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(nullable = false)
    private int nombreReservation ;

    public StudentEntity() {
    }

    public StudentEntity(String firstName, String lastName, String email, String password, int phone, RoleEntity role, int nombreReservation) {
        super(firstName, lastName, email, password, phone, role);
        this.nombreReservation = nombreReservation;
    }

	public int getNombreReservation() {
		return nombreReservation;
	}

	public void setNombreReservation(int nombreReservation) {
		this.nombreReservation = nombreReservation;
	}

   
}
