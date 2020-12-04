package com.amazonaws.lambda.thalia;
import java.util.List;

import com.amazonaws.lambda.thalia.db.MainDAO;
import com.amazonaws.lambda.thalia.http.AllSnippetsResponse;
import com.amazonaws.lambda.thalia.http.DeleteSnippetRequest;
import com.amazonaws.lambda.thalia.model.Snippet;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.Context;

public class DeleteSnippetHandler implements RequestHandler<DeleteSnippetRequest,AllSnippetsResponse>{
	@Override
	public AllSnippetsResponse handleRequest(DeleteSnippetRequest req, Context context) {
		AllSnippetsResponse response = null;
		
		MainDAO dao = new MainDAO();	
		
		try {
			if(req.isAdmin()) {
				if (dao.deleteSnippetAdmin(req.getSnippetId())) {
					response = new AllSnippetsResponse(getSnippets(), 200);
				} else {
					response = new AllSnippetsResponse(null, 422, "Unable to delete Snippet.");
				}
			} else {
				if (dao.deleteSnippet(req.getSnippetId(),req.getSnippetPassword())) {
					response = new AllSnippetsResponse(getSnippets(), 200);
				} else {
					response = new AllSnippetsResponse(null, 422, "Unable to delete Snippet.");
				}
			}
			
		} catch (Exception e) {
			response = new AllSnippetsResponse(null, 403, "Unable to delete Snippet: " + req.getSnippetId() + "(" + e.getMessage() + ")");
		}

		return response;
	}
	
	List<Snippet> getSnippets() throws Exception {
		MainDAO dao = new MainDAO();		
		return dao.getAllSnippets();
	}
}
