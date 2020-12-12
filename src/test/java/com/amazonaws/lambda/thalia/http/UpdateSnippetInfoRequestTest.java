package com.amazonaws.lambda.thalia.http;

import static org.junit.Assert.*;


import org.junit.Test;
public class UpdateSnippetInfoRequestTest {
	@Test
	public void test() {
		UpdateSnippetInfoRequest ar = new UpdateSnippetInfoRequest();
		ar.setSnippetId("id1");
		assertEquals("id1", ar.snippetId);		
		
		ar.setSnippetInfo("info");
		assertEquals("info", ar.snippetInfo);
		
				
		ar = new UpdateSnippetInfoRequest("id1", "info");
		assertEquals("id1", ar.getSnippetId());		
		
		assertEquals("info", ar.getSnippetInfo());		
		
		assertTrue(ar.toString().startsWith("UpdateSnippetInfoRequest"));
	}
}
