/*package org.example.controller;

import org.example.entities.SignUp;
import org.example.services.SignUpService;
import org.example.services.SignUpServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.sql.SQLException;

@Controller
public class RegisterController {

    private SignUpService signUpService=new SignUpServiceImpl();
    @RequestMapping(value ="/register", method = RequestMethod.POST)
    public String Register(SignUp model) throws IOException, SQLException, ClassNotFoundException {
        //SignUp user=signUpService.save(model);
        signUpService.save(model);
        System.out.println("register done");
        return "redirect:/";
    }


    /*@Qualifier("SignUpService")
    @Autowired
    private SignUpService signUpService;
    SignUp sign;

    @RequestMapping(value ="/register" ,method= RequestMethod.POST)
    public ModelAndView register(@Valid @ModelAttribute("SignUp") SignUp sign){
            try {
                signUpService.save(sign);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException troubles) {
                troubles.printStackTrace();
            }
            ModelAndView modelAndView = new ModelAndView("confirmRegistre");
            modelAndView.addObject("SignUp", sign);
            return modelAndView;
        }
         }*/





