package com.cookingrecipe.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import com.cookingrecipe.dao.interfaces.IRecipeDAO;
import com.cookingrecipe.entity.Recipe;

public class RecipeDAOImp extends GenericDAOImp<Recipe, Integer> implements IRecipeDAO {

	public RecipeDAOImp() {
		super(Recipe.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Recipe getRecipeDetails(Integer id) {
		Session ss = getHibernateTemplate().getSessionFactory().getCurrentSession();
		String hql ="SELECT r FROM Recipe r inner join fetch r.steps WHERE r.id=:id";
		Query<Recipe> query = ss.createQuery(hql, Recipe.class)
				.setParameter("id", id);
		Recipe recipe = query.uniqueResult();
		hql = "SELECT r FROM Recipe r left join fetch r.comments WHERE r.id=:id";
		query = ss.createQuery(hql, Recipe.class)
				.setParameter("id", recipe.getId());
		recipe = query.uniqueResult();
		hql = "SELECT r FROM Recipe r left join fetch r.categories WHERE r.id=:id";
		query = ss.createQuery(hql, Recipe.class)
				.setParameter("id", recipe.getId());
		recipe = query.uniqueResult();
		return recipe;
	}
}
