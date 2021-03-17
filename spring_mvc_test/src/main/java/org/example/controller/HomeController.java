package org.example.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.example.entities.Student;
import org.example.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	@Autowired
	private StudentService studentService;

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}




	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		return new ModelAndView("home");
	}
	@RequestMapping(value="/login")
	public ModelAndView loginPage(HttpServletResponse response) throws IOException{
		return new ModelAndView("login");
	}

	@RequestMapping(value ="/register" ,method= RequestMethod.POST)
	public ModelAndView register(@ModelAttribute("student") Student student, BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return new ModelAndView("register");
		}
		getStudentService().registerStudent(student);

		ModelAndView modelAndView = new ModelAndView("confirmation");
		modelAndView.addObject("student", student);
		return modelAndView;
	}
	/*@RequestMapping(value ="/loginSuccess" ,method=RequestMethod.POST)
	public ModelAndView loginSuccess(@Valid @ModelAttribute("studentCredential") StudentCredential studentCredential,BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return new ModelAndView("login");
		}

		ModelAndView modelAndView = new ModelAndView("welcome");
		Student student = getStudentService().validateStudentCredential(studentCredential.getEmail(), studentCredential.getPassword());
		if(student!= null){
			modelAndView.addObject("student", student);
			return modelAndView;
		}else{
			modelAndView = new ModelAndView("notFound");
		}
		return modelAndView;
	}*/
	private void authenticate(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		if (studentService.validateStudent(email, password) == true) {
			loginPage()
		} else {
			throw new Exception("Login not successful..");
		}
	}

}
