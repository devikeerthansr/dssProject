package com.amazonaws.lambda.thalia.http;

import com.amazonaws.lambda.thalia.model.Snippet;

public class GetSnippetResponse {	
	public final int httpCode;
	public final String message;
	public final Snippet snippet;
	
	@Override
	public String toString() {
		return "GetSnippetResponse [httpCode=" + httpCode + ", message=" + message + ", snippet=" + snippet + "]";
	}	

	public GetSnippetResponse(Snippet snippet,int httpCode, String message) {
		this.httpCode = httpCode;
		this.message = message;
		this.snippet = snippet;
	}
	
	
}