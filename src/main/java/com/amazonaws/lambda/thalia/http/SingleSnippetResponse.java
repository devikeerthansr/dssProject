package com.amazonaws.lambda.thalia.http;

import com.amazonaws.lambda.thalia.model.Snippet;

public class SingleSnippetResponse {
	public final Snippet response;
	public final int httpCode;
	
	public SingleSnippetResponse(Snippet response) {
		super();
		this.response = response;
		this.httpCode = 200;
	}

	public SingleSnippetResponse(Snippet response, int httpCode) {
		super();
		this.response = response;
		this.httpCode = httpCode;
	}

	@Override
	public String toString() {
		return "SingleSnippetResponse [response=" + response + ", httpCode=" + httpCode + "]";
	}
	
}
