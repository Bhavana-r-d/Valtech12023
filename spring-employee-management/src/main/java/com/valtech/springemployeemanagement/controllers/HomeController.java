package com.valtech.springemployeemanagement.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@RequestMapping("home")
	//@ResponseBody
	private ModelAndView home(@RequestParam("name")String myname) {
		
		ModelAndView mv=new ModelAndView();
	
		mv.addObject("name",myname);
		mv.setViewName("home");
		
	 
		return mv;
	}

}
