package com.amazonaws.lambda.thalia.http;

public class GetCommentsRequest {
	public String snippetId;
	
	public GetCommentsRequest(String snippetId) {
		this.snippetId = snippetId;
	}

	@Override
	public String toString() {
		return "GetCommentsRequest [snippetId=" + snippetId + "]";
	}

	public String getSnippetId() {
		return snippetId;
	}

	public void setSnippetId(String snippetId) {
		this.snippetId = snippetId;
	}

	public GetCommentsRequest() {
		
	}
}
