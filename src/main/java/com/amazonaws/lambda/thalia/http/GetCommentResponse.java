package com.amazonaws.lambda.thalia.http;

import com.amazonaws.lambda.thalia.model.Comment;

public class GetCommentResponse {
	public final int httpCode;
	public final String message;
	public final Comment comment;
	
	@Override
	public String toString() {
		return "GetCommentResponse [httpCode=" + httpCode + ", message=" + message + ", comment=" + comment + "]";
	}	

	public GetCommentResponse(Comment comment,int httpCode, String message) {
		this.httpCode = httpCode;
		this.message = message;
		this.comment = comment;
	}
}
