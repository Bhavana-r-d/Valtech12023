package com.valtech.training.firstspringboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreatingsController {
	//@RequestMapping(method = RequestMethod.GET, path = "/hello")
	//@ResponseBody
	@GetMapping("/hello")
	//public String hello(HttpServletRequest request,HttpServletResponse response,Model model) {
	public String hello(@RequestParam("name") String name,Model model) {
		//return "Hello Spring ";
      //  String name =request.getParameter("name");
        System.out.println("Name= "+name);
        model.addAttribute("name",name);
		return "hello";
	}

}
