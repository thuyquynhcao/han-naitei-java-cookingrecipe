package com.cookingrecipe.service.comment;

import com.cookingrecipe.model.comment.CommentRequest;
import com.cookingrecipe.model.comment.CommentResponse;

public interface ICommentService {
	CommentResponse save(CommentRequest commentRequest) throws Exception;
}
