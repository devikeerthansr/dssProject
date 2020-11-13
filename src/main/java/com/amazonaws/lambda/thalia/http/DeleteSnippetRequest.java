package com.amazonaws.lambda.thalia.http;

public class DeleteSnippetRequest {
	String snippetId;
	String snippetPassword;
	
	public String getSnippetId() {
		return snippetId;
	}
	public void setSnippetId(String snippetId) {
		this.snippetId = snippetId;
	}
	
	public DeleteSnippetRequest() {
		
	}
	public DeleteSnippetRequest(String snippetId, String snippetPassword) {
		this.snippetId = snippetId;
		this.snippetPassword = snippetPassword;
	}
	public String getSnippetPassword() {
		return snippetPassword;
	}
	public void setSnippetPassword(String snippetPassword) {
		this.snippetPassword = snippetPassword;
	}
	@Override
	public String toString() {
		return "DeleteSnippetRequest [snippetId=" + snippetId + ", snippetPassword=" + snippetPassword + "]";
	}
	
	

}
