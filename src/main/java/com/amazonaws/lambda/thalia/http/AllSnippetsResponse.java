package com.amazonaws.lambda.thalia.http;

import java.util.List;

import com.amazonaws.lambda.thalia.model.Snippet;

public class AllSnippetsResponse {
	public final List<Snippet> list;
	public final int statusCode;
	public final String error;
	
	public AllSnippetsResponse(List<Snippet> list, int statusCode) {
		super();
		this.list = list;
		this.statusCode = statusCode;
		this.error = "";
	}
	public AllSnippetsResponse(List<Snippet> list, int statusCode, String error) {
		super();
		this.list = list;
		this.statusCode = statusCode;
		this.error = error;
	}
	@Override
	public String toString() {
		return "AllSnippetsResponse [list=" + list + ", statusCode=" + statusCode + ", error=" + error + "]";
	}
}
