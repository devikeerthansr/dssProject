package com.amazonaws.lambda.thalia.model;

import java.sql.Date;

public class Comment {
	
	public String commentId;
	public String commentText;
	public Date commentDate;
	public int regionStart;
	public int regionEnd;
	public String snippetId;
	
	public Comment(String commentId, String commentText, Date commentDate, int regionStart,int regionEnd, String snippetId) {
		super();
		this.commentId = commentId;
		this.commentText = commentText;
		this.commentDate = commentDate;
		this.regionStart = regionStart;
		this.regionEnd = regionEnd;
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
	
	public String getCommentId() {
		return commentId;
	}
	public void setCommentId(String commentId) {
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
	public int getRegionStart() {
		return regionStart;
	}
	public void setRegionStart(int regionStart) {
		this.regionStart = regionStart;
	}
	public int getRegionEnd() {
		return regionEnd;
	}
	public void setRegionEnd(int regionEnd) {
		this.regionEnd = regionEnd;
	}
	public String getSnippetId() {
		return snippetId;
	}
	public void setSnippetId(String snippetId) {
		this.snippetId = snippetId;
	}
	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", commentText=" + commentText + ", commentDate=" + commentDate
				+ ", regionStart=" + regionStart + ", regionEnd=" + regionEnd+ ", snippetId=" + snippetId + "]";
	}
}
