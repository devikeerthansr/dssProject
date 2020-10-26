package com.amazonaws.lambda.demo.model;

import java.util.Date;

public class Comment {
	
	public int commentId;
	public String commentText;
	public Date commentDate;
	public int region;
	public int snippetId;
	
	public Comment(int commentId, String commentText, Date commentDate, int region, int snippetId) {
		super();
		this.commentId = commentId;
		this.commentText = commentText;
		this.commentDate = commentDate;
		this.region = region;
		this.snippetId = snippetId;
	}
	
	/**
	 * Equality of Constants determined by snippetId and commentId.
	 */
	public boolean equals (Object o) {
		if (o == null) { return false; }
		
		if (o instanceof Comment) {
			Comment other = (Comment) o;
			return snippetId == other.snippetId && commentId == other.commentId;
		}
		
		return false;  // not a Comment
	}
	
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public String getCommentText() {
		return commentText;
	}
	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}
	public Date getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	public int getRegion() {
		return region;
	}
	public void setRegion(int region) {
		this.region = region;
	}
	public int getSnippetId() {
		return snippetId;
	}
	public void setSnippetId(int snippetId) {
		this.snippetId = snippetId;
	}
	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", commentText=" + commentText + ", commentDate=" + commentDate
				+ ", region=" + region + ", snippetId=" + snippetId + "]";
	}
}
