package org.example.controller;

import org.example.dao.RoleDao;
import org.example.dao.RoleDaoImpl;
import org.example.entities.Administrator;
import org.example.entities.Roles;
import org.example.entities.Student;
import org.example.entities.Users;
import org.example.services.StudentService;
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

/*
	@Autowired
	private StudentService studentService;
	Student student;*/
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
		
		RoleDao d=new RoleDaoImpl();
		Roles role=d.getRoleById(2L);
		
		user=new Users(firstName,lastName,email,password, null, null,role);
		userService.save(user);

		System.out.println("register done");
		return "redirect:/confirmReg";
	}


}
