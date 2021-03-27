package org.example.controller;

import org.example.dao.RoleDao;
import org.example.dao.RoleDaoImpl;
import org.example.entities.Roles;
import org.example.entities.Users;
import org.example.services.UserService;
import org.example.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

@Controller
public class LoginController {

    @Qualifier("UserService")
    @Autowired
    private UserService userService;
    Users user;

    //login
    @RequestMapping(value = "/Login",method= RequestMethod.POST)
    public String login(HttpServletRequest request, HttpSession session, Model model) throws SQLException, ClassNotFoundException {

        String email=request.getParameter("email");
        String password=request.getParameter("password");
        System.out.println(email);
        System.out.println(password);

        if (userService.validate(email,password)== true){
            user=userService.getByEmail(email);

            session.setAttribute("userId", user.getUserId());
            session.setAttribute("role", user.getRole());

            String name=user.getUserNom();
            String lastName=user.getUserPrenom();


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
        session.getAttribute("name");
        session.invalidate();
        return "redirect:/loginPage";
    }
}

