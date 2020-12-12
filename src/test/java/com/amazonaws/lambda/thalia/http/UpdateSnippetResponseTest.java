package com.amazonaws.lambda.thalia.http;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;
public class UpdateSnippetResponseTest {

	@Test
	public void test() {
		UpdateSnippetResponse ar = new UpdateSnippetResponse (200,"Snippet updated");
		assertEquals(ar.httpCode,200);
		
		ar = new UpdateSnippetResponse (403,"Error while updating");		
		assertEquals(ar.httpCode,403);
		assertTrue(ar.toString().startsWith("UpdateSnippetResponse"));
	}
}
