package com.cookingrecipe.service.comment;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cookingrecipe.dao.interfaces.ICommentDAO;
import com.cookingrecipe.dao.interfaces.IRecipeDAO;
import com.cookingrecipe.entity.Comment;
import com.cookingrecipe.entity.Recipe;
import com.cookingrecipe.entity.User;
import com.cookingrecipe.model.comment.CommentRequest;
import com.cookingrecipe.model.comment.CommentResponse;

@Service
@Transactional(readOnly = true)
public class CommentServiceImp implements ICommentService {
	@Autowired
	private ICommentDAO commentDAO;

	@Autowired
	private IRecipeDAO recipeDAO;

	@Override
	@Transactional(readOnly = false)
	public CommentResponse save(CommentRequest commentRequest) throws Exception{
		try {
			Comment comment = new Comment();
			Recipe recipe = new Recipe();
			recipe.setId(commentRequest.getRecipeId());
			comment.setRecipe(recipe);
			User user = new User();
			user.setId(commentRequest.getUserId());
			comment.setUser(user);
			comment.setContent(commentRequest.getContent());
			comment = commentDAO.save(comment);
			CommentResponse commentResponse = new CommentResponse();
			BeanUtils.copyProperties(comment, commentResponse);
			return commentResponse;
		} catch (Exception e) {
			e.getCause();
			throw e;
		}
	}

}
