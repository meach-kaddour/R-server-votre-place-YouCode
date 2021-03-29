package org.example.controller;

import java.io.IOException;
import java.sql.SQLException;

import org.example.entities.Users;
import org.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;


@Controller
public class HomeController {

	@Qualifier("UserService")
	@Autowired
	private UserService userService;
	Users user;

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
	//get student page
	@RequestMapping(value="/studentPage")
	public String showStudentPage(Model model) throws IOException{
		model.addAttribute("user", user);
		return "studentPage";
	}
	//get dash admin page
	@RequestMapping(value="/dashboard")
	public String showDashbordPage(Model model) throws IOException{
		model.addAttribute("etudiants", user);
		return "dashboard";
	}

	//get history Reservation page
	@RequestMapping(value="/studentHistory")
	public String showHistoryPage(Model model) throws IOException{
		model.addAttribute("user", user);
		return "studentHistory";
	}



}
