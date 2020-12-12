package com.amazonaws.lambda.thalia.http;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestAllCommentsRespose {

	@Test
	public void test() {
		AllCommentsResponse error = new AllCommentsResponse(null, 403, "Some error");
		assertEquals(403, error.statusCode);
		assertTrue(error.list == null);
		assertEquals("Some error", error.error);
		assertTrue(error.toString().startsWith("AllCommentsResponse"));
		
		AllCommentsResponse resp = new AllCommentsResponse(null, 200);
		assertEquals(200, resp.statusCode);
		assertTrue(resp.list == null);
		assertTrue(resp.toString().startsWith("AllCommentsResponse"));
	}

}
