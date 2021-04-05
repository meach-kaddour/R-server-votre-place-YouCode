package org.example.controller;

import org.example.entities.Reservation;
import org.example.entities.Roles;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping(value="/")
public class AdminController {

	@Autowired
	private UserService userService;
	Users user;
	@Autowired
	private ReservationService reservationService;
	Reservation reservation;
	
	@Autowired
	private StudentService studentService;
	Student student ;
	
	//lister reservations
	@RequestMapping(value="/dashboard" ,method= RequestMethod.GET)
	public ModelAndView showList(HttpServletResponse response,Model model) throws IOException, ClassNotFoundException, SQLException {
		
		List<Reservation> reservationList = reservationService.findAll();
		model.addAttribute("reservations", reservationList);
		
		return new ModelAndView("dashboard");
	}
    
	
	// confirm  registration  && add is a student
	
    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	public ModelAndView saveReservation(HttpServletRequest request)
			throws ClassNotFoundException, SQLException {
        Long id = Long.valueOf(request.getParameter("id"));
        user=userService.findById(id);
        
        String name=user.getUserPrenom();
    	String lastName=user.getUserNom();
    	String email=user.getUserEmail();
    	String pass=user.getUserPassword();
    	Roles role=user.getRole();
    	student=new Student(name,lastName,email,pass,null,student,role,user,true);
    	studentService.save(student);

		return new ModelAndView("redirect:/adminHistory");
	}
    
   

}
