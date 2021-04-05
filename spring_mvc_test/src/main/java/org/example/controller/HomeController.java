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
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {

	@Autowired
	private UserService userService;
	Users user;
	@Autowired
	private ReservationService reservationService;
	Reservation reservation;
	
	@Autowired
	private StudentService studentService;
	Student student ;
		
	@RequestMapping(value="/")
	public String showHomePage(Model model) throws IOException{
		model.addAttribute("user", user);
		return "home";
	}
	@RequestMapping(value="/index")
	public String showHomePageIn(Model model) throws IOException{
		model.addAttribute("user", user);
		return "home";
	}
	//get login page
	@RequestMapping(value="/loginPage")
	public String ShowLoginPage(Model model) throws IOException{
		model.addAttribute("user", user);
		return "login";
	}
	 //lister users
    @RequestMapping(value="/adminHistory")
	public String loadReser(Model model,ModelMap modelMap) throws IOException, ClassNotFoundException, SQLException{
		
    	model.addAttribute("user", user);
		model.addAttribute("reservation", reservation);
		List<Users> userList = userService.findAll();
		modelMap.put("etudiants", userList);
		
		return "adminHistory";
	}
	
	
	




}
