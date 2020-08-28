package com.cookingrecipe.dao.user;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import com.cookingrecipe.entity.User;

public class UserDaoImpl implements UserDao{

	private static Logger log = LoggerFactory.getLogger(UserDaoImpl.class);
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory){
	     this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void createAccount(User p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(p);
		log.info("Create account successful!");
	}

	@Override
	public User getById(Integer id) {
		Session session = this.sessionFactory.getCurrentSession();
		User p = (User)(session.get(User.class, id));
		return p;
	}

}
