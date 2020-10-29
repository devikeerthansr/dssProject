package com.amazonaws.lambda.thalia.http;

public class UpdateSnippetRequest {
	public String snippetId;
	public String snippetText;
	
	public UpdateSnippetRequest() {
		
	}

	public UpdateSnippetRequest(String snippetId, String snippetText) {
		super();
		this.snippetId = snippetId;
		this.snippetText = snippetText;
	}

	@Override
	public String toString() {
		return "UpdateSnippetRequest [snippetId=" + snippetId + ", snippetText=" + snippetText + "]";
	}
	
	public String getSnippetId() {
		return snippetId;
	}
	public void setSnippetId(String snippetId) {
		this.snippetId = snippetId;
	}
	public String getSnippetText() {
		return snippetText;
	}
	public void setSnippetText(String snippetText) {
		this.snippetText = snippetText;
	}
}
