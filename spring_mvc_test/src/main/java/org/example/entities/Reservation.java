package org.example.entities;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Reservation")
public class Reservation implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
    @Column(nullable = false)
    private String dateRes;

    private boolean confirmation;
    @ManyToOne
    @JoinColumn(name = "userId")
    private Student student;

    //@OneToOne(cascade=CascadeType.ALL)
    private String typeRes;


//Constructors

    public Reservation(){}

    public Reservation(Student student, String dateRes, boolean confirmation, String typeRes) {
        this.student = student;
        this.dateRes = dateRes;
        this.confirmation = confirmation;
        this.typeRes = typeRes;
    }

    public Reservation(Long id, Student student, String dateRes, boolean confirmation, String typeRes) {
        this.id = id;
        this.student = student;
        this.dateRes = dateRes;
        this.confirmation = confirmation;
        this.typeRes = typeRes;
    }

    //Getters and Stters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDateRes() {
        return dateRes;
    }

    public void setDateRes(String dateRes) {
        this.dateRes = dateRes;
    }

    public boolean isConfirmation() {
        return confirmation;
    }

    public void setConfirmation(boolean confirmation) {
        this.confirmation = confirmation;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getTypeRes() {
        return typeRes;
    }

    public void setTypeRes(String typeRes) {
        this.typeRes = typeRes;
    }

    @Override
	public String toString() {
		return "Reservation [id=" + id + ", dateRes=" + dateRes + ", confirmation=" + confirmation + ", student="
				+ student.getUserNom() + ", typeRes=" + typeRes + "]";
	}
}
