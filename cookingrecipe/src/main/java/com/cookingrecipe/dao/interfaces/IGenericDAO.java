package com.cookingrecipe.dao.interfaces;

import java.io.Serializable;
import java.util.List;

public interface IGenericDAO<E, Id extends Serializable> {
	E getById(Id id);
	List<E> findAll() throws Exception;
	E save(E entity) throws Exception;
}
