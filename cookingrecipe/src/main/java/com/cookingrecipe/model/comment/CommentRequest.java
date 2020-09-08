package com.cookingrecipe.model.comment;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentRequest {
	private Integer id;
	
	@NotBlank(message = "{error.notBlank.newComment}")
	private String content;
	
	private Integer userId;
	
	private Integer recipeId;

}
