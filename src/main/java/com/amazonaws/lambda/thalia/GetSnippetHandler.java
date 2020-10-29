package com.amazonaws.lambda.thalia;

import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.lambda.thalia.db.MainDAO;
import com.amazonaws.lambda.thalia.http.GetSnippetRequest;
import com.amazonaws.lambda.thalia.http.GetSnippetResponse;
import com.amazonaws.lambda.thalia.model.Snippet;
import com.amazonaws.services.lambda.runtime.Context;

public class GetSnippetHandler implements RequestHandler<GetSnippetRequest,GetSnippetResponse>{

	@Override
	public GetSnippetResponse handleRequest(GetSnippetRequest input, Context context) {
		GetSnippetResponse response;
		try {			
				Snippet snippet = getSnippet(input.snippetId);
				if (snippet != null) {
					response = new GetSnippetResponse(snippet,200,"Success");
				} else {
					response = new GetSnippetResponse(null, 422,"Failed to get Snippet");
				}
			
		} catch (Exception e) {
			response = new GetSnippetResponse(null, 400,"Failed to get Snippet");
		}

		return response;
	}
	
	Snippet getSnippet(String snippetId) throws Exception { 
		
		MainDAO dao = new MainDAO();
		return dao.getSnippet(snippetId);
		
	}

}