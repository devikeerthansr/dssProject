package com.amazonaws.lambda.thalia.http;

public class UpdateSnippetInfoRequest {
	public String snippetId;
	public String snippetInfo;
	
	public UpdateSnippetInfoRequest() {
		
	}

	public UpdateSnippetInfoRequest(String snippetId, String snippetText) {
		super();
		this.snippetId = snippetId;
		this.snippetInfo = snippetText;
	}

	@Override
	public String toString() {
		return "UpdateSnippetRequest [snippetId=" + snippetId + ", snippetInfo=" + snippetInfo + "]";
	}
	
	public String getSnippetId() {
		return snippetId;
	}
	public void setSnippetId(String snippetId) {
		this.snippetId = snippetId;
	}
	public String getSnippetInfo() {
		return snippetInfo;
	}
	public void setSnippetInfo(String snippetInfo) {
		this.snippetInfo = snippetInfo;
	}
}
