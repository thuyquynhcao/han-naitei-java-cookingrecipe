package com.cookingrecipe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RecipeController {
	
	@GetMapping("/recipes/create")
	public String create() {
		return "recipeForm";
	}

}
