package org.example.controller;


import org.example.DAO.TypeResDaoImpl;
import org.example.Entity.*;
import org.example.Auth.AuthenticatedUser;
import org.example.Repostory.ReservationRepostory;
import org.example.service.ReservationService;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private UserService userService;

    @Autowired
    private TypeResDaoImpl typeResDao;

    @RequestMapping(value = "/reserverAgain", method = RequestMethod.POST)
//Reserver une Reservation Par default Confirmer
    public  String Reserver(@ModelAttribute("reservation") ReservationEntity reservationEntity, HttpServletRequest req, Model model, HttpSession session)
    {
        reservationEntity.setUser(AuthenticatedUser.user);
        ReservationRepostory reservationRepostory=new ReservationRepostory();
        int idType = reservationEntity.getTypeRes().getId();
        TypereservationEntity typereservationEntity = typeResDao.getTypeResById(idType);
        if(typereservationEntity.getNomberClass()>reservationRepostory.getAllReservationsDat(reservationEntity.getDateRes()).size())
        {
            Object idUser=session.getAttribute("id");
            List<ReservationEntity> reservations = reservationRepostory.getAllReservationsById((Integer) idUser);
            reservationEntity.setConfirmation(true);
            model.addAttribute("reservations",reservations);
            reservationService.addRes(reservationEntity);
            model.addAttribute("msg",  "Reservation Ajouter");
            return "DashbordStudent";
        }
        else
        {
            Object idUser=session.getAttribute("id");
            List<ReservationEntity> reservations = reservationRepostory.getAllReservationsById((Integer) idUser);
            model.addAttribute("reservations",reservations);

            reservationEntity.setConfirmation(false);
            reservationService.addRes(reservationEntity);
            model.addAttribute("msg",  "Well add");
            return "DashbordStudent";
        }

    }
    //Get Reservation par Student
    @RequestMapping(value = "dashbord")
    public String reservationParStudent(@ModelAttribute("dashbord") ReservationEntity reservationEntity, Model model, HttpSession session){

        if(session.getAttribute("id")!=null&&session.getAttribute("role").equals("student"))
        {
            ReservationRepostory reservationRepostory=new ReservationRepostory();
            Object idUser=session.getAttribute("id");
            List<ReservationEntity> reservations = reservationRepostory.getAllReservationsById((Integer) idUser);
            model.addAttribute("msg", "");
            model.addAttribute("reservations",reservations);

            return "DashbordStudent";
        }
        else
        {
            return "redirect:/";

        }

    }
//Delete Reservation from Student
    
    @RequestMapping(value = "deleteRestudent")
    public String deleteRes(HttpServletRequest req)
    {

        int id= Integer.parseInt(req.getParameter("id"));

        reservationService.deleteRes(id);

        return "redirect:/dashbord";
    }

}
