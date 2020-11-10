package com.amazonaws.lambda.thalia.http;

import java.sql.Date;



public class CreateSnippetRequest {
	public String snippetId;
	public String snippetText;
	public String snippetInfo;
	public String snippetPassword;
	public String codingLanguage;
	public Date createDate;
	
	public CreateSnippetRequest() {
		
	}


	public CreateSnippetRequest(String snippetId, String snippetText, String snippetInfo, String snippetPassword,
			String codingLanguage, int numComments, Date createDate) {
		super();
		this.snippetId = snippetId;
		this.snippetText = snippetText;
		this.snippetInfo = snippetInfo;
		this.snippetPassword = snippetPassword;
		this.codingLanguage = codingLanguage;
		this.createDate = createDate;
	}


	@Override
	public String toString() {
		return "CreateSnippetRequest [snippetId=" + snippetId + ", snippetText=" + snippetText + ", snippetInfo="
				+ snippetInfo + ", snippetPassword=" + snippetPassword + ", codingLanguage=" + codingLanguage
				+ ", createDate=" + createDate + "]";
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
	public String getSnippetInfo() {
		return snippetInfo;
	}
	public void setSnippetInfo(String snippetInfo) {
		this.snippetInfo = snippetInfo;
	}
	public String getSnippetPassword() {
		return snippetPassword;
	}
	public void setSnippetPassword(String snippetPassword) {
		this.snippetPassword = snippetPassword;
	}
	public String getCodingLanguage() {
		return codingLanguage;
	}
	public void setCodingLanguage(String codingLanguage) {
		this.codingLanguage = codingLanguage;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	
}
