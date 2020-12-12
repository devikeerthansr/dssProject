package com.amazonaws.lambda.thalia.http;

import static org.junit.Assert.*;


import org.junit.Test;
public class UpdateSnippetRequestTest {
	@Test
	public void test() {
		UpdateSnippetRequest ar = new UpdateSnippetRequest();
		ar.setSnippetId("id1");
		assertEquals("id1", ar.snippetId);
		
		ar.setCodingLanguage("Java");
		assertEquals("Java", ar.codingLanguage);
		
		
		ar.setPassword("120.15.20.25");
		assertEquals("120.15.20.25", ar.password);
		
		ar.setSnippetText("some code");
		assertEquals("some code", ar.snippetText);
		
		ar = new UpdateSnippetRequest("id1", "some code", "120.15.20.25","Java");
		assertEquals("id1", ar.getSnippetId());
		
		
		assertEquals("Java", ar.getCodingLanguage());
		
			
		assertEquals("120.15.20.25", ar.getPassword());
		
		
		assertEquals("some code", ar.getSnippetText());
		assertTrue(ar.toString().startsWith("UpdateSnippetRequest"));
	}
}
