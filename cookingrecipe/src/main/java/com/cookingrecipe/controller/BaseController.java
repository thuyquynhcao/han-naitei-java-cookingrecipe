package com.cookingrecipe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BaseController {
	
	@GetMapping(value = "/home")
	public String index() {
		return "home";
	}

}
