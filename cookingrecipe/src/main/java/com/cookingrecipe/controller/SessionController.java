package com.cookingrecipe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SessionController {
	
	@GetMapping(value="/login")
	public String loginForm() {
		return "login";
	}
	
	@PostMapping(value="/login")
	public String login() {
		return "redirect:/";
	}
}
