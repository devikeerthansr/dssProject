package com.amazonaws.lambda.thalia.http;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestDeleteSnippetRequest {

	@Test
	public void test() {
		DeleteSnippetRequest dcr = new DeleteSnippetRequest();
		dcr.setAdmin(true);
		assertEquals(true, dcr.isAdmin);
		dcr.setSnippetId("snippetId");
		assertEquals("snippetId", dcr.snippetId);
		dcr.setSnippetPassword("120.35.56.78");
		assertEquals("120.35.56.78", dcr.snippetPassword);
		
		DeleteSnippetRequest dcr2 = new DeleteSnippetRequest("snippetId","120.35.56.78",true);
		assertEquals(true, dcr.isAdmin());		
		assertEquals("snippetId", dcr.getSnippetId());		
		assertEquals("120.35.56.78", dcr.getSnippetPassword());
		
		assertTrue(dcr2.toString().startsWith("DeleteSnippetRequest"));
	}

}
