package com.amazonaws.lambda.thalia.http;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;

import com.amazonaws.lambda.thalia.model.Snippet;

public class TestCreateSnippetResponse {

	@Test
	public void test() {
		SingleSnippetResponse ar = new SingleSnippetResponse (new Snippet("id", "snippetText", "snippetInfo", "snippetPassword", "java", new Date(12345)), 200);
		assertEquals(ar.httpCode,200);
		
		ar = new SingleSnippetResponse (null, 403);		
		assertEquals(ar.httpCode,403);
		assertTrue(ar.toString().startsWith("SingleSnippetResponse"));
	}

}
