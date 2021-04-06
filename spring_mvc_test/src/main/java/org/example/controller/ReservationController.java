package org.example.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.example.entities.Reservation;
import org.example.entities.Student;
import org.example.services.ReservationService;
import org.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReservationController {

	@Autowired
	private ReservationService reservationService;
	// @Autowired
	// private UserService userservice;

	

	@RequestMapping(value = "/newReservation", method = RequestMethod.GET)
	public ModelAndView newRes(ModelAndView model) {
		Reservation reservation = new Reservation();
		model.addObject("reservation", reservation);
		model.setViewName("studentPage");
		
		return model;
	}
		//Reserver 
	@RequestMapping(value = "/addNewReservation", method = RequestMethod.POST)
	public ModelAndView saveReservation(HttpServletRequest request) throws ClassNotFoundException, SQLException {
		
		String date = request.getParameter("date");
		String type = request.getParameter("type");
		Reservation reservation = new Reservation();
		reservation.setDateRes(date);
		reservation.setTypeRes(type);
		reservation.setStudent((Student) LoginController.user);
		reservationService.save(reservation);
		return new ModelAndView("redirect:/studentPage");
	}
	// Delete Reservation

	@RequestMapping(value = "deleteReservation", method = RequestMethod.POST)
    public ModelAndView deleteReservation(HttpServletRequest request) {
         Long id = Long.valueOf(request.getParameter("id"));
         try {
			reservationService.delete(id);
		} catch (Exception ex) {
			ex.printStackTrace();
		} 
         return new ModelAndView("redirect:/dashboard");
    }
    	
	
	//confirm reservation
	@RequestMapping(value = "confirmReservation", method = RequestMethod.POST)
    public ModelAndView accepterReservation(HttpServletRequest request) throws ClassNotFoundException, SQLException{
        Long id = Long.valueOf(request.getParameter("id"));
        Reservation reservation =reservationService.findById(id);
        reservation.setConfirmation(true);
        reservationService.update(reservation);
        return new ModelAndView("redirect:/dashboard");
    }
}
