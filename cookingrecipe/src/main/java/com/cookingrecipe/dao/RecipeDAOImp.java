package com.cookingrecipe.dao;

import org.hibernate.FetchMode;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import com.cookingrecipe.dao.interfaces.IRecipeDAO;
import com.cookingrecipe.entity.Recipe;

public class RecipeDAOImp extends GenericDAOImp<Recipe, Integer> implements IRecipeDAO {

	public RecipeDAOImp() {
		super(Recipe.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Recipe getRecipeDetails(Integer id) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Recipe.class);
		criteria.setFetchMode("steps", FetchMode.JOIN);
		criteria.setFetchMode("categories", FetchMode.JOIN);
		criteria.setFetchMode("comments", FetchMode.JOIN);
		criteria.add(Restrictions.eq("id", id));
		return (Recipe) DataAccessUtils.uniqueResult(getHibernateTemplate().findByCriteria(criteria));
	}
	
}
