package com.amazonaws.lambda.thalia.model;

import java.sql.Date;

public class Snippet {
	
	public String snippetId;
	public String snippetText;
	public String snippetInfo;
	public String snippetPassword;
	public String codingLanguage;
	public Date createDate;
	
	public Snippet(String snippetId, String snippetText, String snippetInfo, String snippetPassword, String codingLanguage,
			Date createDate) {
		super();
		this.snippetId = snippetId;
		this.snippetText = snippetText;
		this.snippetInfo = snippetInfo;
		this.snippetPassword = snippetPassword;
		this.codingLanguage = codingLanguage;
		this.createDate = createDate;		
	}
	public Snippet() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Snippet [snippetId=" + snippetId + ", snippetText=" + snippetText + ", snippetInfo=" + snippetInfo
				+ ", snippetPassword=" + snippetPassword + ", codingLanguage=" + codingLanguage + ", createDate=" + createDate + "]";
	}
	/**
	 * Equality of Constants determined by snippetId alone.
	 */
	public boolean equals (Object o) {
		if (o == null) { return false; }
		
		if (o instanceof Snippet) {
			Snippet other = (Snippet) o;
			return snippetId == other.snippetId;
		}
		
		return false;  // not a Snippet
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
