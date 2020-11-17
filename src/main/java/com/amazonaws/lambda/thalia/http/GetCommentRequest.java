package com.amazonaws.lambda.thalia.http;

public class GetCommentRequest {
	public String snippetId;
	public String commentId;
	

	public GetCommentRequest(String snippetId, String commentId) {
		super();
		this.snippetId = snippetId;
		this.commentId = commentId;
	}


	@Override
	public String toString() {
		return "GetCommentRequest [snippetId=" + snippetId + ", commentId=" + commentId + "]";
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


	public GetCommentRequest() {
		
	}
}
