package com.cookingrecipe.service.recipe;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cookingrecipe.dao.interfaces.IRecipeDAO;
import com.cookingrecipe.entity.Recipe;
import com.cookingrecipe.model.recipe.RecipeResponse;

@Service
@Transactional(readOnly = true)
public class RecipeServiceImp implements IRecipeService {
	@Autowired
	private IRecipeDAO recipeDAO;

	@Override
	public RecipeResponse getById(Integer id) {
		try {
			Recipe recipe = recipeDAO.getRecipeDetails(id);
			if (recipe == null)
				return null;
			RecipeResponse recipeResponse = new RecipeResponse();
			BeanUtils.copyProperties(recipe, recipeResponse);
			return recipeResponse;
		} catch (Exception e) {
			e.getCause();
			return null;
		}
	}
	
}
