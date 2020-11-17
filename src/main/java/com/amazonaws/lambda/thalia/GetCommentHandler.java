package com.amazonaws.lambda.thalia;


import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.lambda.thalia.db.MainDAO;
import com.amazonaws.lambda.thalia.http.GetCommentRequest;
import com.amazonaws.lambda.thalia.http.GetCommentResponse;
import com.amazonaws.lambda.thalia.model.Comment;
import com.amazonaws.services.lambda.runtime.Context;

public class GetCommentHandler implements RequestHandler<GetCommentRequest,GetCommentResponse>{

	@Override
	public GetCommentResponse handleRequest(GetCommentRequest input, Context context) {
		GetCommentResponse response;
		try {			
				Comment comment = getComment(input.snippetId,input.commentId);
				if (comment != null) {
					response = new GetCommentResponse(comment,200,"Success");
				} else {
					response = new GetCommentResponse(null, 422,"Failed to get comment"+input.snippetId+","+input.commentId);
				}
			
		} catch (Exception e) {
			response = new GetCommentResponse(null, 400,"Failed to get Snippet");
		}

		return response;
	}
	
	Comment getComment(String snippetId,String commentId) throws Exception { 
		
		MainDAO dao = new MainDAO();
		return dao.getComment(snippetId,commentId);
		
	}

}