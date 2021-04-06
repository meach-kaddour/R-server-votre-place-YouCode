package org.example.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	Student student;

	@Autowired
	private ReservationService reservationService;
	Reservation reservation;

	// Get student page
	@RequestMapping(value = "/studentPage")
	public String showStudentPage(Model model, HttpSession session) throws IOException {
		//if (session.getAttribute("name")!= null) {
			model.addAttribute("user", user);
			model.addAttribute("reservation", reservation);
			return "studentPage";
		//}else {
			//return "redirect:/loginPage";
		//}

	}

	// Get history Reservation page

	@RequestMapping(value = "studentHistory")
	public String HisReservation(Model model, HttpSession session) throws ClassNotFoundException, SQLException {
		if (session.getAttribute("name") != null) {
			model.addAttribute("student", LoginController.user);
			Long id = LoginController.user.getUserId();
			List<Reservation> res = reservationService.findAllById(id);
			model.addAttribute("Reservation", res);

			return "studentHistory";
		} else {
			return "redirect:/loginPage";
		}
	}

	@RequestMapping(value = "/confirmReg")
	public String showconfirmRegPage(Model model) throws IOException {
		model.addAttribute("user", user);
		return "confirmReg";
	}

}
