package com.amazonaws.lambda.demo.http;

import com.amazonaws.lambda.demo.model.Snippet;

public class CreateSnippetRequest {
	
	public Snippet snippet;
	
	
	public CreateSnippetRequest(Snippet snippet) {
		super();
		this.snippet = snippet;
	}

	public Snippet getSnippet() {
		return snippet;
	}

	public void setSnippet(Snippet snippet) {
		this.snippet = snippet;
	}

		
	@Override
	public String toString() {
		return "CreateSnippetRequest [snippet=" + snippet + "]";
	}
	
	public CreateSnippetRequest() {
	}
}
