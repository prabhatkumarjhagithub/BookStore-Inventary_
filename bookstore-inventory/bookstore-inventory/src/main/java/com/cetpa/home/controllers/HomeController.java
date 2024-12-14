package com.cetpa.home.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("bookstore/inventory")
public class HomeController 
{
	@RequestMapping("")
	public String getLoginView()
	{
		return "home/login";
	}
	@RequestMapping("authentication")
	public String authenticateUser(String uid,String pass,Model model)
	{
		if(uid.equals("admin") && pass.equals("cetpa"))
		{
			return "redirect:home";
		}
		model.addAttribute("msg","Bad credentials");
		return "home/login";
	}
	@RequestMapping("home")
	public String getHomeView()
	{
		return "home/inventory-home";
	}
}
