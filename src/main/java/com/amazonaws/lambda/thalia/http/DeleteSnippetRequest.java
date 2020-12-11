package com.amazonaws.lambda.thalia.http;

public class DeleteSnippetRequest {
	String snippetId;
	String snippetPassword;
	boolean isAdmin;
	public String getSnippetId() {
		return snippetId;
	}
	public void setSnippetId(String snippetId) {
		this.snippetId = snippetId;
	}
	public String getSnippetPassword() {
		return snippetPassword;
	}
	public void setSnippetPassword(String snippetPassword) {
		this.snippetPassword = snippetPassword;
	}
	public boolean getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	public DeleteSnippetRequest(String snippetId, String snippetPassword, boolean isAdmin) {
		super();
		this.snippetId = snippetId;
		this.snippetPassword = snippetPassword;
		this.isAdmin = isAdmin;
	}
	public DeleteSnippetRequest() {
		
	}
	@Override
	public String toString() {
		return "DeleteSnippetRequest [snippetId=" + snippetId + ", snippetPassword=" + snippetPassword + ", isAdmin="
				+ isAdmin + "]";
	}
	


}
