package com.amazonaws.lambda.demo;
import com.amazonaws.lambda.demo.http.CreateSnippetRequest;
import com.amazonaws.lambda.demo.http.SingleSnippetResponse;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class CreateSnippetHandler implements RequestHandler<CreateSnippetRequest,SingleSnippetResponse>{

	@Override
	public SingleSnippetResponse handleRequest(CreateSnippetRequest input, Context context) {
		// TODO Auto-generated method stub
		return null;
	}

}
