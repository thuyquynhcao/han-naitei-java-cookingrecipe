package com.cookingrecipe.dao.user;

import com.cookingrecipe.entity.User;

public interface UserDao {
	public void createAccount(User p);
	public User getById(Integer id);
}
