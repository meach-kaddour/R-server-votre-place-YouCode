package org.example.controller;

import org.example.dao.StudentDao;
import org.example.dao.UserDao;
import org.example.entities.Student;
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
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@Controller
public class AdminController {

	//@Qualifier("UserService")
	//@Autowired
	//private UserService userService;
	@Qualifier("UserDao")
	@Autowired
	private UserDao userDao;
	Users user;
	/*@RequestMapping(value="/list")
	public String showHomePage(Model model) throws IOException, SQLException, ClassNotFoundException {

		//List<Users> theUser=userService.findAll();
		List<Student> theUser=studentDao.getAllStudents();
		model.addAttribute("student", theUser);
		return "dashboard";
	}*/
	@RequestMapping(value="/dash")
	public ModelAndView showList(HttpServletResponse response, ModelMap modelMap) throws IOException, ClassNotFoundException, SQLException {
		modelMap.put("etudiants", userDao.getAllUsers());
		return new ModelAndView("dashboard");
	}





}
