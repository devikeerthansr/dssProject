package com.amazonaws.lambda.thalia.http;

import static org.junit.Assert.*;


import org.junit.Test;
public class GetCommentsRequestTest {
	@Test
	public void test() {
		GetCommentsRequest ar = new GetCommentsRequest();
		ar.setSnippetId("id1");
		assertEquals("id1", ar.snippetId);
		
		ar = new GetCommentsRequest("id1");
		assertEquals("id1", ar.getSnippetId());
				
		
		assertTrue(ar.toString().startsWith("GetCommentsRequest"));
	}
}
