package org.example.controller;

import org.example.entities.Users;
import org.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@Controller
public class RegistController {



	@Qualifier("UserService")
	@Autowired
	private UserService userService;

	Users user;
	//Registration
	@RequestMapping(value ="/register", method = RequestMethod.POST)
	public String Register(HttpServletRequest req,Model model) throws IOException, SQLException, ClassNotFoundException {

		String firstName=req.getParameter("prenom");
		String lastName=req.getParameter("nom");
		String email=req.getParameter("email");
		String password=req.getParameter("password");

		Users u=new Users(firstName,lastName,email,password,null,null,null);
		model.addAttribute("newUser",u);
		userService.save(u);
		System.out.println("register done");
		return "redirect:/confirmReg";
	}
/*
	@RequestMapping(value="/login")
	public ModelAndView loginPage(HttpServletResponse response) throws IOException{
		return new ModelAndView("login");
	}

	@RequestMapping(value ="/register" ,method= RequestMethod.POST)
	public ModelAndView register(@ModelAttribute("Users") Student student, BindingResult bindingResult){
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
