package com.amazonaws.lambda.thalia.http;

import static org.junit.Assert.*;


import org.junit.Test;
public class GetSnippetRequestTest {
	@Test
	public void test() {
		GetSnippetRequest ar = new GetSnippetRequest();
		ar.setSnippetId("id1");
		assertEquals("id1", ar.snippetId);
		
		ar = new GetSnippetRequest("id1");
		assertEquals("id1", ar.getSnippetId());		
		
		assertTrue(ar.toString().startsWith("GetSnippetRequest"));	
	}
}
