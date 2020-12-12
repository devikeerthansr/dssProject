package com.amazonaws.lambda.thalia.http;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;

import com.amazonaws.lambda.thalia.model.Comment;
public class GetCommentResponseTest {
	
	@Test
	public void test() {
		GetCommentResponse ar = new GetCommentResponse (new Comment("id", "comment Text", new Date(12345), 0, 1, "sid"), 200,"");
		assertEquals(ar.httpCode,200);
		
		ar = new GetCommentResponse(null, 403,"error");		
		assertEquals(ar.httpCode,403);
		assertTrue(ar.toString().startsWith("GetCommentResponse"));
	}
}
