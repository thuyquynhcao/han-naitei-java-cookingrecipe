package com.cookingrecipe.service.recipe;

import com.cookingrecipe.model.recipe.RecipeResponse;

public interface IRecipeService {
	RecipeResponse getById(Integer id);

}
