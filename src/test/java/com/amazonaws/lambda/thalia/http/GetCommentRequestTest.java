package com.amazonaws.lambda.thalia.http;

import static org.junit.Assert.*;


import org.junit.Test;
public class GetCommentRequestTest {
	@Test
	public void test() {		
		GetCommentRequest ar = new GetCommentRequest();
			ar.setSnippetId("id1");
			assertEquals("id1", ar.snippetId);
			
			ar.setCommentId("cid1");
			assertEquals("cid1", ar.commentId);
			
			ar = new GetCommentRequest("id1", "cid1");
			assertEquals("id1", ar.getSnippetId());
			assertEquals("cid1", ar.getCommentId());
			
			
			assertTrue(ar.toString().startsWith("GetCommentRequest"));		
	}
}
