package com.amazonaws.lambda.demo.http;

import com.amazonaws.lambda.demo.model.Comment;

public class CreateCommentRequest {
	public Comment comment;
	public int snippetId;
	public boolean system;
	
	public CreateCommentRequest(Comment comment, int snippetId) {
		super();
		this.comment = comment;
		this.snippetId = snippetId;
	}
	public CreateCommentRequest(Comment comment, int snippetId, boolean system) {
		super();
		this.comment = comment;
		this.snippetId = snippetId;
		this.system = system;
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
	public boolean isSystem() {
		return system;
	}
	public void setSystem(boolean system) {
		this.system = system;
	}
	@Override
	public String toString() {
		return "CreateCommentRequest [comment=" + comment + ", snippetId=" + snippetId + ", system=" + system + "]";
	}	

}
