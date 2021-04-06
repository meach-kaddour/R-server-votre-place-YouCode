package org.example.controller;


import org.example.entities.Administrator;
import org.example.entities.Reservation;
import org.example.entities.Users;
import org.example.services.ReservationService;
import org.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

@Controller
public class LoginController {
	
	
  
    @Autowired
    private UserService userService;
    static Users user;

    //login
    @RequestMapping(value = "/Login",method= RequestMethod.POST)
    public String login(HttpServletRequest request,Model model, ModelMap modelmap, HttpSession session) throws SQLException, ClassNotFoundException {
    	//Store Email && Pass 
        String email=request.getParameter("email");
        String password=request.getParameter("password");
       
        //validate Email && Pass
        if (userService.validate(email,password)== true){
            user=userService.getByEmail(email);
            
            session.setAttribute("userId", user.getUserId());
            session.setAttribute("role", user.getRole());

            String name=user.getUserNom();
            String lastName=user.getUserPrenom();
            modelmap.put("name",name);
            	//Check Role 
            if(user.getRole().getRoleName().equals("Admin")){
                model.addAttribute("model", name);
                model.addAttribute("model", lastName);
                
                return "redirect:/dashboard";
            }

            else{
                model.addAttribute("model", name);
                model.addAttribute("model", lastName);
                System.out.println(name);
                return
                        "redirect:/studentPage";
            }

        }else{
            System.out.println("Compte not found");
           

            return "redirect:/loginPage";
        }
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
    	session.removeAttribute("name");
        return "redirect:/loginPage";
    }
}

