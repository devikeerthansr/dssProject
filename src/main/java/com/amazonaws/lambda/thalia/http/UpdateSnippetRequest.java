package com.amazonaws.lambda.thalia.http;

public class UpdateSnippetRequest {
	public String snippetId;
	public String snippetText;
	public String password;
	public String codingLanguage;
	
	public UpdateSnippetRequest(String snippetId, String snippetText, String password, String codingLanguage) {
		super();
		this.snippetId = snippetId;
		this.snippetText = snippetText;
		this.password = password;
		this.codingLanguage = codingLanguage;
	}
	@Override
	public String toString() {
		return "UpdateSnippetRequest [snippetId=" + snippetId + ", snippetText=" + snippetText + ", password="
				+ password + ", codingLanguage=" + codingLanguage + "]";
	}
	public String getSnippetId() {
		return snippetId;
	}
	public void setSnippetId(String snippetId) {
		this.snippetId = snippetId;
	}
	public String getSnippetText() {
		return snippetText;
	}
	public void setSnippetText(String snippetText) {
		this.snippetText = snippetText;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCodingLanguage() {
		return codingLanguage;
	}
	public void setCodingLanguage(String codingLanguage) {
		this.codingLanguage = codingLanguage;
	}
	public UpdateSnippetRequest() {
		
	}
	
}
