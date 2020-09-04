package com.cookingrecipe.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.cookingrecipe.dao.interfaces.IGenericDAO;

public class GenericDAOImp<E, Id extends Serializable> implements IGenericDAO<E, Id> {
	private Class<E> entityClass;
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public GenericDAOImp(Class<E> entityClass) {
		this.entityClass = entityClass;
	}
	
	public Class<E> getEntityClass(){
		return entityClass;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public E getById(Id id) {
		DetachedCriteria criteria = DetachedCriteria.forClass(entityClass);
		criteria.add(Restrictions.eq("id", id));
		return (E) DataAccessUtils.uniqueResult(hibernateTemplate.findByCriteria(criteria));
	}
	
	
	@Override
	public List<E> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
