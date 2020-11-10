package com.amazonaws.lambda.thalia.http;

public class DeleteCommentRequest {
	String snippetId;
	String commentId;
	String password;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "DeleteCommentRequest [snippetId=" + snippetId + ", commentId=" + commentId + ", password=" + password
				+ "]";
	}
	public String getSnippetId() {
		return snippetId;
	}
	public void setSnippetId(String snippetId) {
		this.snippetId = snippetId;
	}
	public String getCommentId() {
		return commentId;
	}
	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}
	
	public DeleteCommentRequest() {
		
	}
	
	
}
