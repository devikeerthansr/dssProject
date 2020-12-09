package com.amazonaws.lambda.thalia.http;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestAllCommentsRespose {

	@Test
	public void test() {
		AllCommentsResponse error = new AllCommentsResponse(null, 403, "Some error");
		assertEquals(403, error.statusCode);
		assertTrue(error.list == null);
		assertEquals("Some error", error.toString());
		assertTrue(error.toString().startsWith("AllCommentsResponse"));
	}

}
