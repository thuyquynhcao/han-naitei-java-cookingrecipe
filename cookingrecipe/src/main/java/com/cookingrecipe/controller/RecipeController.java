package com.cookingrecipe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.cookingrecipe.model.category.PureCategory;
import com.cookingrecipe.model.recipe.RecipeRequest;
import com.cookingrecipe.model.comment.CommentRequest;
import com.cookingrecipe.model.recipe.RecipeResponse;
import com.cookingrecipe.service.category.ICategoryService;
import com.cookingrecipe.service.recipe.IRecipeService;

@Controller
@RequestMapping(path = "/recipes")
public class RecipeController {
	
	@Autowired
	@Qualifier(value="recipeServiceImp")
	private IRecipeService recipeService;
	
	@Autowired
	@Qualifier(value = "categoryServiceImp")
	private ICategoryService categoryService;
	
	@GetMapping(path = "/{idRecipe}")
	public String show(@PathVariable Integer idRecipe, ModelMap model) {
		RecipeResponse recipeResponse = recipeService.getById(idRecipe);
		model.addAttribute("recipe", recipeResponse);
		model.addAttribute("comment", new CommentRequest());
		return "recipeDetail";
	}
	
	@GetMapping("/create")
	public String create(Model model){
		List<PureCategory> categories = categoryService.findAll();
		model.addAttribute("categories", categories);
		model.addAttribute("recipe", new RecipeRequest());
		return "recipeForm";
	}
	

}
