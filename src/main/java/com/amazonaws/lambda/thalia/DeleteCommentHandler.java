package com.amazonaws.lambda.thalia;
import java.util.List;

import com.amazonaws.lambda.thalia.db.MainDAO;
import com.amazonaws.lambda.thalia.http.AllCommentsResponse;
import com.amazonaws.lambda.thalia.http.DeleteCommentRequest;
import com.amazonaws.lambda.thalia.model.Comment;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.Context;

public class DeleteCommentHandler implements RequestHandler<DeleteCommentRequest,AllCommentsResponse>{
	@Override
	public AllCommentsResponse handleRequest(DeleteCommentRequest req, Context context) {
		AllCommentsResponse response = null;
		
		MainDAO dao = new MainDAO();	
		
		try {
			if (dao.deleteComment(req.getSnippetId(),req.getCommentId())) {
				response = new AllCommentsResponse(getComments(req.getSnippetId()), 200);
			} else {
				response = new AllCommentsResponse(null, 422, "Unable to delete comment.");
			}
		} catch (Exception e) {
			response = new AllCommentsResponse(null, 403, "Unable to delete comment: " + req.getCommentId() + "(" + e.getMessage() + ")");
		}

		return response;
	}
	
	List<Comment> getComments(String snippetId) throws Exception {
		
		MainDAO dao = new MainDAO();
		
		return dao.getAllComments(snippetId);
	}
}
