package com.cookingrecipe.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;

import com.cookingrecipe.comparator.CategoryComparator;
import com.cookingrecipe.dao.interfaces.ICategoryDAO;
import com.cookingrecipe.entity.Category;

public class CategoryDAOImp extends GenericDAOImp<Category, Integer> implements ICategoryDAO{

	public CategoryDAOImp() {
		super(Category.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Category> findAll() throws Exception {
		DetachedCriteria criteria = DetachedCriteria.forClass(getEntityClass());
		criteria.addOrder(Order.asc("type"));
		List<Category> res = (List<Category>) getHibernateTemplate().findByCriteria(criteria);
		return res;
	}
}
