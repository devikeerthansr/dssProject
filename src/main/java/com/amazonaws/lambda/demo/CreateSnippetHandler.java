package com.amazonaws.lambda.demo;
import com.amazonaws.lambda.demo.db.MainDAO;
import com.amazonaws.lambda.demo.http.CreateSnippetRequest;
import com.amazonaws.lambda.demo.http.SingleSnippetResponse;
import com.amazonaws.lambda.demo.model.Snippet;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class CreateSnippetHandler implements RequestHandler<CreateSnippetRequest,SingleSnippetResponse>{

	@Override
	public SingleSnippetResponse handleRequest(CreateSnippetRequest input, Context context) {
		SingleSnippetResponse response;
		try {			
				if (createSnippet(input.snippet)) {
					response = new SingleSnippetResponse(input.snippet);
				} else {
					response = new SingleSnippetResponse(input.snippet, 422);
				}
			
		} catch (Exception e) {
			response = new SingleSnippetResponse(null, 400);
		}

		return response;
	}
	
	boolean createSnippet(Snippet snippet) throws Exception { 
		
		MainDAO dao = new MainDAO();
		return dao.addSnippet(snippet);
		
	}

}
