package com.amazonaws.lambda.demo.http;

import com.amazonaws.lambda.demo.model.Comment;

public class CreateCommentRequest {
	public Comment comment;
	public int snippetId;
	
	
	public CreateCommentRequest(Comment comment, int snippetId) {
		super();
		this.comment = comment;
		this.snippetId = snippetId;
	}
	
	
	public CreateCommentRequest() {
		
	}
	public Comment getComment() {
		return comment;
	}
	public void setComment(Comment comment) {
		this.comment = comment;
	}
	public int getSnippetId() {
		return snippetId;
	}
	public void setSnippetId(int snippetId) {
		this.snippetId = snippetId;
	}
	
	@Override
	public String toString() {
		return "CreateCommentRequest [comment=" + comment + ", snippetId=" + snippetId + "]";
	}	

}
