package com.amazonaws.lambda.thalia;

import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.List;

import com.amazonaws.lambda.thalia.db.MainDAO;
import com.amazonaws.lambda.thalia.http.AllSnippetsResponse;
import com.amazonaws.lambda.thalia.model.Snippet;
import com.amazonaws.services.lambda.runtime.Context;

public class GetAllSnippetsHandler implements RequestHandler<Object,AllSnippetsResponse> {

	@Override
	public AllSnippetsResponse handleRequest(Object input, Context context)  {
		
		AllSnippetsResponse response;
		try {
			List<Snippet> list = getSnippets();
			response = new AllSnippetsResponse(list, 200);
		} catch (Exception e) {
			response = new AllSnippetsResponse(null,403, e.getMessage());
		}
		
		return response;
	}
	
	List<Snippet> getSnippets() throws Exception {
		MainDAO dao = new MainDAO();		
		return dao.getAllSnippets();
	}
	
}
