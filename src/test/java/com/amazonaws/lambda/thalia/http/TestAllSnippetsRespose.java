package com.amazonaws.lambda.thalia.http;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestAllSnippetsRespose {

	@Test
	public void test() {
		AllSnippetsResponse error = new AllSnippetsResponse(null, 403, "Some error");
		assertEquals(403, error.statusCode);
		assertTrue(error.list == null);
		assertEquals("Some error", error.toString());
		assertTrue(error.toString().startsWith("AllSnippetsResponse"));
	}

}
