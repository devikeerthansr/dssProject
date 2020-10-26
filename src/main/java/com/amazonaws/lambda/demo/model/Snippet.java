package com.amazonaws.lambda.demo.model;

import java.util.Date;

public class Snippet {
	
	public int snippetId;
	public String snippetText;
	public String snippetInfo;
	public String snippetPassword;
	public String codingLanguage;
	public int numComments;
	public Date createDate;
	
	public Snippet(int snippetId, String snippetText, String snippetInfo, String snippetPassword, String codingLanguage,
			Date createDate) {
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
		return "Snippet [snippetId=" + snippetId + ", snippetText=" + snippetText + ", snippetInfo=" + snippetInfo
				+ ", snippetPassword=" + snippetPassword + ", codingLanguage=" + codingLanguage + ", numComments="
				+ numComments + ", createDate=" + createDate + "]";
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
	public int getSnippetId() {
		return snippetId;
	}
	public void setSnippetId(int snippetId) {
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
	public int getNumComments() {
		return numComments;
	}
	public void setNumComments(int numComments) {
		this.numComments = numComments;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}
