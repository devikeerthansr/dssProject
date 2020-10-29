package com.amazonaws.lambda.thalia;

import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.List;

import com.amazonaws.lambda.thalia.db.MainDAO;
import com.amazonaws.lambda.thalia.http.AllCommentsResponse;
import com.amazonaws.lambda.thalia.http.GetCommentsRequest;
import com.amazonaws.lambda.thalia.model.Comment;
import com.amazonaws.services.lambda.runtime.Context;

public class GetAllCommentsHandler implements RequestHandler<GetCommentsRequest,AllCommentsResponse> {

	@Override
	public AllCommentsResponse handleRequest(GetCommentsRequest input, Context context)  {
		
		AllCommentsResponse response;
		try {
			List<Comment> list = getComments(input.snippetId);
			if (list!=null) {
			  response = new AllCommentsResponse(list, 200);
			} else {
			  response = new AllCommentsResponse(null,400, "Could not retrieve comments");	
			}
		} catch (Exception e) {
			response = new AllCommentsResponse(null,403, e.getMessage());
		}
		
		return response;
	}
	
	List<Comment> getComments(String snippetId) throws Exception {
		MainDAO dao = new MainDAO();		
		return dao.getAllComments(snippetId);
	}
	
}
