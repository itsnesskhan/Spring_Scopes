package com.spring.controller;

import java.net.http.HttpRequest;
import java.time.LocalDate;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.tomcat.util.http.SameSiteCookies;
import org.hibernate.validator.internal.util.privilegedactions.NewInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.mysql.cj.protocol.Resultset;
import com.spring.dao.StudentDao;
import com.spring.editors.LocalDateEditor;
import com.spring.editors.UserNameEditor;
import com.spring.formatter.NameFormatter;
import com.spring.models.Name;
import com.spring.models.Student;

@Controller
public class SignUpController {

	@Autowired
	private StudentDao studentDao;

	@RequestMapping(method = RequestMethod.GET, path = "/signup")
	public String showSignUpForm(@ModelAttribute("student") Student student, Model model, HttpSession session,
			HttpServletRequest request) {
		model.addAttribute("title", "Sign Up Form");
		System.out.println("signup-form");
//		student.setName(new Name("Mohit", "Sharma"));
//		Student student = new Student();
//		model.addAttribute("student", student);
//		model.addAttribute("hobbies", getHobbies());
		System.out.println(session.getServletContext().getContextPath());
		System.out.println(request.getRealPath("/"));
		return "signup-form";
	}

	@RequestMapping(path = "/register")
	public RedirectView signUpUser(@Valid @ModelAttribute("student") Student student, HttpSession session,
			BindingResult result) {
		if (result.hasErrors()) {
			System.out.println(result);
		}
		student.setProfile("default.jpg");
		studentDao.addStudent(student);
		RedirectView redirectView = new RedirectView("profile");
//		redirectAttributes.addFlashAttribute("student", student);
		session.setAttribute("student", student);
		return redirectView;
	}

	@RequestMapping("profile")
	public String userProfile(Model model) {
		model.addAttribute("msg", "User registered successfully!");
		return "register-success";
	}

	@GetMapping(path = "update/{id}")
	public String updateInfo(@PathVariable("id") int userid, Model model, HttpSession session) {
		Student student = studentDao.getStudentById(userid);
		System.out.println(student);
		model.addAttribute("student", student);
		return "update-form";
	}

	@RequestMapping(path = "updatehandler", method = RequestMethod.POST)
	public String updateHandler(@ModelAttribute Student student, Model model) {
		studentDao.updateStudent(student);
		model.addAttribute("msg", "User updated successfully!");
		return "redirect:profile";
	}

	@ModelAttribute("hobbies")
	public HashMap<String, String> getHobbies() {
		HashMap<String, String> hobbies = new HashMap<String, String>();
		hobbies.put("Cricket", "Cricket");
		hobbies.put("Programming", "Programming");
		hobbies.put("Dancing", "Dancing");
		hobbies.put("Football", "Football");

		return hobbies;
	}

	@InitBinder
	public void initBlinder(WebDataBinder blinder) {
		LocalDateEditor dateEditor = new LocalDateEditor();
		blinder.registerCustomEditor(LocalDate.class, dateEditor);
		UserNameEditor userNameEditor = new UserNameEditor();
//		blinder.registerCustomEditor(Name.class, userNameEditor);
		blinder.addCustomFormatter(new NameFormatter());

	}
}
