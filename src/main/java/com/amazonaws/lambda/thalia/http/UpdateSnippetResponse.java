package com.amazonaws.lambda.thalia.http;

public class UpdateSnippetResponse {	
	public final int httpCode;
	public final String message;

	public UpdateSnippetResponse(int httpCode, String message) {
		this.httpCode = httpCode;
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "UpdateSnippetResponse [httpCode=" + httpCode + ", message=" + message + "]";
	}
}
