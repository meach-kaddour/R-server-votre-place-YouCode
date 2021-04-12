package org.example.controller;

import org.example.Entity.ReservationEntity;
import org.example.Entity.UseradminEntity;
import org.example.Auth.AuthenticatedUser;
import org.example.Repostory.ReservationRepostory;
import org.example.Repostory.UserRepostory;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
public class AdminController {


    @Autowired
    private UserService userService;


    ReservationRepostory reservationRepostory=new ReservationRepostory();


    @RequestMapping(value = "dashbordadmin")
    public String rege(@ModelAttribute("dashbord")UseradminEntity useradminEntity, Model model,HttpSession session){

        if(session.getAttribute("id")!=null&&session.getAttribute("role").equals("admin"))
        {
            UserRepostory userRepostory=new UserRepostory();

            List<UseradminEntity> users = userRepostory.getAllStudents();

            model.addAttribute("users",users);
            System.out.println(users);

            return "AdmiDashbord";
        }

        else
        {
            return "redirect:/";

        }
    }


    @RequestMapping(value = "confirm")
    public String ConfirmEmail(HttpServletRequest req)
    {
        int id= Integer.parseInt(req.getParameter("id"));

      boolean accpeted=AuthenticatedUser.user.setAccepted(true);

        UseradminEntity useradminEntity=new UseradminEntity(id,accpeted);

        userService.setAcceptation(useradminEntity);

       useradminEntity=userService.getUserById(id);

        return "redirect:/dashbordadmin";
    }


    @RequestMapping(value = "deleteUser")
    public String deletemEmail(HttpServletRequest req)
    {

        int id= Integer.parseInt(req.getParameter("id"));

        boolean accpeted=AuthenticatedUser.user.setAccepted(false);

        UseradminEntity useradminEntity=new UseradminEntity(id,accpeted);

        userService.setAcceptation(useradminEntity);

        useradminEntity=userService.getUserById(id);

        return "redirect:/dashbordadmin";
    }



    @RequestMapping(value = "ShowRes")
    public String ShoweRes(@ModelAttribute("dashbord")ReservationEntity reservationEntity, Model model,HttpSession session){


        if(session.getAttribute("id")!=null&&session.getAttribute("role").equals("admin")) {

            Date dt = new Date();
            Calendar c = Calendar.getInstance();
            c.setTime(dt);
            c.add(Calendar.DATE, 1);
            dt = c.getTime();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd ");


            System.out.println(dt);


            List<ReservationEntity> reservations = reservationRepostory.getAllReservationsDat(formatter.format(dt));

            model.addAttribute("res", reservations);


            return "ShowReservation";
        }
        else
        {
            return "redirect:/";
        }
    }



    @RequestMapping(value = "confiRes")
    public String ConfirRes(HttpServletRequest req)
    {


        ReservationEntity res=new ReservationEntity();
        ReservationRepostory resevationRepostory=new ReservationRepostory();
        int id= Integer.parseInt(req.getParameter("id"));

        boolean accpeted=res.setConfirmation(true);

        ReservationEntity reservationEntity=new ReservationEntity(id,accpeted);

        resevationRepostory.Confirm(reservationEntity);




        return "redirect:/ShowRes";
    }


    @RequestMapping(value = "deleteRes")
    public String deleteRes(HttpServletRequest req)
    {

        ReservationEntity res=new ReservationEntity();
        ReservationRepostory resevationRepostory=new ReservationRepostory();
        int id= Integer.parseInt(req.getParameter("id"));

        boolean accpeted=res.setConfirmation(false);

        ReservationEntity reservationEntity=new ReservationEntity(id,accpeted);

        resevationRepostory.Confirm(reservationEntity);


        return "redirect:/ShowRes";
    }


    @RequestMapping(value = "ShowResByDate")
    public String ShoweResDate(@ModelAttribute("dashbord")ReservationEntity reservationEntity, Model model,HttpServletRequest req){

        String dateres=req.getParameter("date");


        List<ReservationEntity> reservations = reservationRepostory.getAllReservationsDat(dateres);

        model.addAttribute("res",reservations);


        return "ShowReservation";
    }


}
