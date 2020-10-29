package com.amazonaws.lambda.thalia.http;

public class GetSnippetRequest {
	public String snippetId;
	
	public GetSnippetRequest(String snippetId) {
		this.snippetId = snippetId;
	}

	@Override
	public String toString() {
		return "GetSnippetRequest [snippetId=" + snippetId + "]";
	}

	public String getSnippetId() {
		return snippetId;
	}

	public void setSnippetId(String snippetId) {
		this.snippetId = snippetId;
	}

	public GetSnippetRequest() {
		
	}

}
