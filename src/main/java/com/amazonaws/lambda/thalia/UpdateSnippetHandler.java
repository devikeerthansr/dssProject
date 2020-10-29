package com.amazonaws.lambda.thalia;
import com.amazonaws.lambda.thalia.db.MainDAO;
import com.amazonaws.lambda.thalia.http.UpdateSnippetRequest;
import com.amazonaws.lambda.thalia.http.UpdateSnippetResponse;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class UpdateSnippetHandler implements RequestHandler<UpdateSnippetRequest,UpdateSnippetResponse>{

	@Override
	public UpdateSnippetResponse handleRequest(UpdateSnippetRequest input, Context context) {
		UpdateSnippetResponse response;
		try {			
				if (updateSnippet(input.snippetId,input.snippetText)) {
					response = new UpdateSnippetResponse(200,"Update successful");
				} else {
					response = new UpdateSnippetResponse(422, "Update failed");
				}
			
		} catch (Exception e) {
			response = new UpdateSnippetResponse(400, "Update failed");
		}

		return response;
	}
	
	boolean updateSnippet(String snippetId,String snippetText) throws Exception { 		
		MainDAO dao = new MainDAO();
		return dao.updateSnippet(snippetId,snippetText);		
	}

}

