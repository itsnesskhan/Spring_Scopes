package com.spring.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.models.Address;
import com.spring.models.ApplicationScopeBean;
import com.spring.models.Student;

@ResponseBody
@Controller
public class SecondController {
	
	@Autowired
	Student student;
	
	@Autowired
	ApplicationScopeBean appBean;
	
//	@Autowired
//	Address address;
	
	@RequestMapping("secondtest")
	public String welcomeMsg(HttpServletResponse response) throws IOException {
		System.out.println(appBean.getName());
		System.out.println(student);
		return "Welcome to my site";
	}

}
