package com.amazonaws.lambda.thalia.http;

public class DeleteSnippetRequest {
	String snippetId;

	@Override
	public String toString() {
		return "DeleteSnippetRequest [snippetId=" + snippetId + "]";
	}

	public DeleteSnippetRequest() {
		
	}

	public DeleteSnippetRequest(String snippetId) {
		this.snippetId = snippetId;
	}

	public String getSnippetId() {
		return snippetId;
	}

	public void setSnippetId(String snippetId) {
		this.snippetId = snippetId;
	}

}
