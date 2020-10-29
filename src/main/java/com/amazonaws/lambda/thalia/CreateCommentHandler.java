package com.amazonaws.lambda.thalia;

import java.util.List;

import com.amazonaws.lambda.thalia.db.MainDAO;
import com.amazonaws.lambda.thalia.http.AllCommentsResponse;
import com.amazonaws.lambda.thalia.http.CreateCommentRequest;
import com.amazonaws.lambda.thalia.model.Comment;
import com.amazonaws.lambda.thalia.model.Snippet;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class CreateCommentHandler implements RequestHandler<CreateCommentRequest,AllCommentsResponse>{

	@Override
	public AllCommentsResponse handleRequest(CreateCommentRequest input, Context context) {
		AllCommentsResponse response;
		try {			
				if (createComment(input.comment)) {
					response = new AllCommentsResponse(getComments(input.comment.snippetId),200);
				} else {
					response = new AllCommentsResponse(null, 422,"Could not create a comment");
				}
			
		} catch (Exception e) {
			response = new AllCommentsResponse(null, 400,"Could not create a comment");
		}

		return response;
	}
	
	boolean createSnippet(Snippet snippet) throws Exception { 
		
		MainDAO dao = new MainDAO();
		return dao.addSnippet(snippet);
		
	}
	boolean createComment(Comment comment) throws Exception { 
		
		MainDAO dao = new MainDAO();
		return dao.addComment(comment);
		
	}
	
	List<Comment> getComments(String snippetId) throws Exception {
		
		MainDAO dao = new MainDAO();
		
		return dao.getAllComments(snippetId);
	}

}

