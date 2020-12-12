package com.amazonaws.lambda.thalia.http;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;

import com.amazonaws.lambda.thalia.model.Snippet;
public class GetSnippetResponseTest {

	@Test
	public void test() {
		GetSnippetResponse ar = new GetSnippetResponse (new Snippet("id", "snippetText", "snippetInfo", "snippetPassword", "java", new Date(12345)), 200,"Success");
		assertEquals(ar.httpCode,200);
		
		ar = new GetSnippetResponse (null, 403,"Error");		
		assertEquals(ar.httpCode,403);
		assertTrue(ar.toString().startsWith("GetSnippetResponse"));
	}
}
