package com.cookingrecipe.service.category;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cookingrecipe.dao.interfaces.ICategoryDAO;
import com.cookingrecipe.entity.Category;
import com.cookingrecipe.model.category.PureCategory;

@Service
@Transactional(readOnly = true)
public class CategoryServiceImp implements ICategoryService{
	@Autowired
	private ICategoryDAO categoryDAO;
	
	@Override
	public List<PureCategory> findAll() {
		List<Category> categories;
		try {
			categories = categoryDAO.findAll();
			if (categories == null || categories.isEmpty())
				return null;
			List<PureCategory> pureCategories = new ArrayList<PureCategory>();
			for (Category c : categories) {
				PureCategory pureCategory = new PureCategory();
				BeanUtils.copyProperties(c, pureCategory);
				pureCategories.add(pureCategory);
			}
			return pureCategories;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
