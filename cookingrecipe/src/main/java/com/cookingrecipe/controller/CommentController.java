package com.cookingrecipe.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cookingrecipe.model.comment.CommentRequest;
import com.cookingrecipe.model.comment.CommentResponse;
import com.cookingrecipe.model.recipe.RecipeResponse;
import com.cookingrecipe.service.comment.ICommentService;
import com.cookingrecipe.service.recipe.IRecipeService;

@Controller
@RequestMapping(path = "/recipes/{idRecipe}/comments")
public class CommentController {
	@Autowired
	@Qualifier(value = "commentServiceImp")
	private ICommentService commentService;
	
	@Autowired
	@Qualifier(value="recipeServiceImp")
	private IRecipeService recipeService;
	@PostMapping("")
	public String create(@PathVariable Integer idRecipe, @ModelAttribute("comment") @Valid CommentRequest commentRequest,
			BindingResult bindingResult, Model model) throws Exception{
		if (bindingResult.hasErrors()) {
			RecipeResponse recipeResponse = recipeService.getById(idRecipe);
			model.addAttribute("recipe", recipeResponse);
			return "recipeDetail";
		}
		commentRequest.setRecipeId(idRecipe);
		commentRequest.setUserId(1);
		CommentResponse commentResponse = commentService.save(commentRequest);
		return "redirect:/recipes/"+commentResponse.getRecipe().getId();
	}
}
