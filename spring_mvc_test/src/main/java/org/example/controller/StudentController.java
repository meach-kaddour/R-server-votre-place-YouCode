package org.example.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.example.entities.Reservation;
import org.example.entities.Student;
import org.example.entities.Users;
import org.example.services.ReservationService;
import org.example.services.StudentService;
import org.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class StudentController {

	@Autowired
	private UserService userService;
	Users user;
	
	@Autowired
	private StudentService studentService;
	Student student ;
	
	@Autowired
	private ReservationService reservationService;
	Reservation reservation;
	
	
	//get student page
	@RequestMapping(value="/studentPage")
	public String showStudentPage(Model model) throws IOException{
		model.addAttribute("user", user);
		model.addAttribute("reservation", reservation);
		return "studentPage";
	}
	
	//get history Reservation page
	@RequestMapping(value="/studentHistory")
	public String showHistoryPage(Model model) throws IOException, ClassNotFoundException, SQLException{
		model.addAttribute("user", user);
		
		Long id=user.getUserId();
		
		List<Reservation> list=reservationService.findAllById(id);
		model.addAttribute("reservations", list);
		model.addAttribute("reservations", reservation);
		return "studentHistory";
	}

	@RequestMapping(value="/confirmReg")
	public String showconfirmRegPage(Model model) throws IOException{
		model.addAttribute("user", user);
		return "confirmReg";
	}
	@RequestMapping(value="/addStudent")
	public String loadDash(Model model) throws IOException{
		model.addAttribute("user", user);
		return "dashboard";
	}
	
	
	
	
	




}
