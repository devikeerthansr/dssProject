package com.amazonaws.lambda.thalia.http;

public class DeleteSnippetRequest {
	String snippetId;
	String snippetPassword;
	boolean isAdmin;
	
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	public String getSnippetId() {
		return snippetId;
	}
	public void setSnippetId(String snippetId) {
		this.snippetId = snippetId;
	}
	
	public DeleteSnippetRequest() {
		
	}
	public DeleteSnippetRequest(String snippetId, String snippetPassword,boolean isAdmin) {
		this.snippetId = snippetId;
		this.snippetPassword = snippetPassword;
		this.isAdmin = isAdmin;
	}
	public String getSnippetPassword() {
		return snippetPassword;
	}
	public void setSnippetPassword(String snippetPassword) {
		this.snippetPassword = snippetPassword;
	}
	@Override
	public String toString() {
		return "DeleteSnippetRequest [snippetId=" + snippetId + ", snippetPassword=" + snippetPassword + ", isAdmin="
				+ isAdmin + "]";
	}	

}
