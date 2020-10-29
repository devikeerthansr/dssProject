package com.amazonaws.lambda.thalia;
import com.amazonaws.lambda.thalia.db.MainDAO;
import com.amazonaws.lambda.thalia.http.UpdateSnippetInfoRequest;
import com.amazonaws.lambda.thalia.http.UpdateSnippetResponse;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class UpdateSnippetInfoHandler implements RequestHandler<UpdateSnippetInfoRequest,UpdateSnippetResponse>{

	@Override
	public UpdateSnippetResponse handleRequest(UpdateSnippetInfoRequest input, Context context) {
		UpdateSnippetResponse response;
		try {			
				if (updateSnippetInfo(input.snippetId,input.snippetInfo)) {
					response = new UpdateSnippetResponse(200,"Update successful");
				} else {
					response = new UpdateSnippetResponse(422, "Update failed");
				}
			
		} catch (Exception e) {
			response = new UpdateSnippetResponse(400, "Update failed");
		}
		return response;
	}
	
	boolean updateSnippetInfo(String snippetId,String snippetInfo) throws Exception { 		
		MainDAO dao = new MainDAO();
		return dao.updateSnippetInfo(snippetId,snippetInfo);		
	}

}


