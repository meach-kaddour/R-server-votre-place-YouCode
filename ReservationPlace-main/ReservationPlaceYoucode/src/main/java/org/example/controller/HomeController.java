package org.example.controller;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.example.DAO.RoleDaoImpl;
import org.example.Entity.*;
import org.example.Auth.AuthenticatedUser;
import org.example.Repostory.LoginRepostory;
import org.example.service.TypeResService;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;

	@Autowired
	private RoleDaoImpl roleDao;

	@Autowired
	private TypeResService typeResService;

	@Autowired
	PasswordEncoder passwordEncoder;

	private UseradminEntity user;

// Get Page Home /Login
	@RequestMapping(value = "/")
	public String getLogin(@ModelAttribute("userlogin") UseradminEntity useradminEntity) {
		return "login";
	}

//User Authentication for Student and admin 
	@RequestMapping(value = "/Login", method = RequestMethod.POST)
	public String Login(@ModelAttribute("userlogin") UseradminEntity useradminEntity, HttpSession session,
			Model model) {

		user = userService.getUserByEmail(useradminEntity.getEmail());
		AuthenticatedUser.user = user;

		System.out.println(useradminEntity.getPassword());
		System.out.println(user.getPassword());

		if (user != null && passwordEncoder.matches(useradminEntity.getPassword(), user.getPassword())
				&& user.isAccepted() == true) {
			session.setAttribute("id", AuthenticatedUser.user.getId());
			session.setAttribute("Fname", AuthenticatedUser.user.getFirstName());
			session.setAttribute("lasname", AuthenticatedUser.user.getLastName());
			session.setAttribute("role", user.getRole().getRoleName());
			if (session.getAttribute("role").equals("admin")) {
				return "redirect:/dashbordadmin";
			} else if (session.getAttribute("role").equals("student")) {

				return "redirect:/dashbord";
			}

		} else if (user != null && user.isAccepted() == false) {
			model.addAttribute("msg", "Votre compte Ne Pas confirmés a ce moment");
			return "redirect:/";
		} else if (user == null) {
			model.addAttribute("msg", " Failed Password or mail");
			return "redirect:/";
		}

		return "redirect:/";
	}

	
//Get Reservation form-page
	@RequestMapping(value = "Reserver")
	public String DisplayFormReservation(@ModelAttribute("reservation") ReservationEntity reservationEntity, Model model) {
		List<TypereservationEntity> typeList = typeResService.getAllTypeRes();
		model.addAttribute("list", typeList);

		LocalDate localDate = LocalDate.now();
		model.addAttribute("datee", localDate);
		return "ReservationForm";
	}

// Redirect To  Login Page
	@RequestMapping(value = "loginDirect")
	public String loginDerict() {

		return "redirect:/";
	}

// Get Page D'inscription 

	@RequestMapping(value = "registre")
	public String DisplayRegestre(@ModelAttribute("student") StudentEntity studentEntity) {
		return "inscription";
	}

	@RequestMapping(value = "registerForm", method = RequestMethod.POST)
	
	public String register(HttpServletRequest request, @ModelAttribute("student") StudentEntity studentEntity) {
		String Cpass = request.getParameter("re_pass"); 
		
		if (Cpass.equals(studentEntity.getPassword())) {
			studentEntity.setNombreReservation(10);
			RoleEntity roleEntity = roleDao.getRoleById(1);
			studentEntity.setRole(roleEntity);
			userService.addUser(studentEntity); // confirmation false 
			
			System.out.println(studentEntity.getFirstName());
			return "redirect:/loginDirect"; // URL
		} else {
			return "login";
		}

	}

}
