package com.cookingrecipe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.cookingrecipe.model.recipe.RecipeResponse;
import com.cookingrecipe.service.recipe.IRecipeService;

@Controller
@RequestMapping(path = "/recipes")
public class RecipeController {
	
	@Autowired
	@Qualifier(value="recipeServiceImp")
	private IRecipeService recipeService;
	
	@GetMapping(path = "/{idRecipe}")
	public String show(@PathVariable Integer idRecipe, ModelMap model) {
		RecipeResponse recipeResponse = recipeService.getById(idRecipe);
		model.addAttribute("recipe", recipeResponse);
		return "recipeDetail";
	}
	
	@GetMapping("/recipes/create")
	public String create() {
		return "recipeForm";
	}
}
