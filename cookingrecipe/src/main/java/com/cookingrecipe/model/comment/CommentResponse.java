package com.cookingrecipe.model.comment;

import com.cookingrecipe.entity.Recipe;
import com.cookingrecipe.entity.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentResponse {
	private Integer id;
	
	private String content;
	
	private User user;
	
	private Recipe recipe;
}
