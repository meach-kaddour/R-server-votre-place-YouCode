package org.example.controller;

import java.io.IOException;
import java.sql.SQLException;

import org.example.entities.Users;
import org.example.services.UserService;
import org.example.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HomeController {
	@Qualifier("UserService")
	@Autowired
	private UserService userService;

	Users user;


	@RequestMapping(value="/")
	public String test(Model model) throws IOException{
		model.addAttribute("user", user);
		return "home";
	}
	//get login page
	@RequestMapping(value="/login")
	public String login(Model model) throws IOException{
		model.addAttribute("user", user);
		return "login";
	}
	//login
	@RequestMapping(value = "/Login",method= RequestMethod.POST)
	public String login(@ModelAttribute Users user, Model model) throws SQLException, ClassNotFoundException {

		String email=user.getUserEmail();
		String password=user.getUserPassword();

		System.out.println(email);
		System.out.println(password);


		if (userService.validate(email,password)== true ){
			System.out.println("login successful");
			return "redirect:/studentPage";
		}else{
			return "redirect:/login";
		}
	}



/*
	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		return new ModelAndView("home");
	}*/
	/*
	@RequestMapping(value="/login")
	public ModelAndView loginPage(HttpServletResponse response) throws IOException{
		return new ModelAndView("login");
	}

	@RequestMapping(value ="/register" ,method= RequestMethod.POST)
	public ModelAndView register(@ModelAttribute("student") Student student, BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return new ModelAndView("register");
		}
		getStudentService().registerStudent(student);

		ModelAndView modelAndView = new ModelAndView("confirmation");
		modelAndView.addObject("student", student);
		return modelAndView;
	}*/
	/*@RequestMapping(value ="/loginSuccess" ,method=RequestMethod.POST)
	public ModelAndView loginSuccess(@Valid @ModelAttribute("studentCredential") StudentCredential studentCredential,BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return new ModelAndView("login");
		}

		ModelAndView modelAndView = new ModelAndView("welcome");
		Student student = getStudentService().validateStudentCredential(studentCredential.getEmail(), studentCredential.getPassword());
		if(student!= null){
			modelAndView.addObject("student", student);
			return modelAndView;
		}else{
			modelAndView = new ModelAndView("notFound");
		}
		return modelAndView;
	}*/


}
