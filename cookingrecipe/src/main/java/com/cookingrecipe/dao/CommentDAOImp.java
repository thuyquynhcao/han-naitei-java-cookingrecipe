package com.cookingrecipe.dao;

import com.cookingrecipe.dao.interfaces.ICommentDAO;
import com.cookingrecipe.entity.Comment;

public class CommentDAOImp extends GenericDAOImp<Comment, Integer> implements ICommentDAO{

	public CommentDAOImp() {
		super(Comment.class);
		// TODO Auto-generated constructor stub
	}

}
