package com.amazonaws.lambda.thalia;
import com.amazonaws.lambda.thalia.db.MainDAO;
import com.amazonaws.lambda.thalia.http.CreateSnippetRequest;
import com.amazonaws.lambda.thalia.http.SingleSnippetResponse;
import com.amazonaws.lambda.thalia.model.Snippet;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class CreateSnippetHandler implements RequestHandler<CreateSnippetRequest,SingleSnippetResponse>{

	@Override
	public SingleSnippetResponse handleRequest(CreateSnippetRequest input, Context context) {
		SingleSnippetResponse response;
		Snippet snippet = new Snippet(input.snippetId,input.snippetText,input.snippetInfo,input.snippetPassword, input.codingLanguage,input.createDate);
		try {			
				if (createSnippet(snippet)) {
					response = new SingleSnippetResponse(snippet);
				} else {
					response = new SingleSnippetResponse(snippet, 422);
				}
			
		} catch (Exception e) {
			response = new SingleSnippetResponse(null, 400);
			System.err.println(e.toString()+e.getMessage());
		}

		return response;
	}
	
	boolean createSnippet(Snippet snippet) throws Exception { 
		
		MainDAO dao = new MainDAO();
		return dao.addSnippet(snippet);
		
	}

}
