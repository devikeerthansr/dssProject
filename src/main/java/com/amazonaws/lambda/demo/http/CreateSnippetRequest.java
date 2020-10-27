package com.amazonaws.lambda.demo.http;

import com.amazonaws.lambda.demo.model.Snippet;

public class CreateSnippetRequest {
	
	public Snippet snippet;
	public boolean system;
	
	public CreateSnippetRequest(Snippet snippet) {
		super();
		this.snippet = snippet;
	}

	public CreateSnippetRequest(Snippet snippet, boolean system) {
		super();
		this.snippet = snippet;
		this.system = system;
	}

	public Snippet getSnippet() {
		return snippet;
	}

	public void setSnippet(Snippet snippet) {
		this.snippet = snippet;
	}

	public boolean isSystem() {
		return system;
	}

	public void setSystem(boolean system) {
		this.system = system;
	}
	
	@Override
	public String toString() {
		return "CreateSnippetRequest [snippet=" + snippet + ", system=" + system + "]";
	}
	
	public CreateSnippetRequest() {
	}
}
