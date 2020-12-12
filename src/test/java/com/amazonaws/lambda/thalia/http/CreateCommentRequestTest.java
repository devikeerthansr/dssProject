package com.amazonaws.lambda.thalia.http;
import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;
public class CreateCommentRequestTest {
	@Test
	public void test() {
		CreateCommentRequest ar = new CreateCommentRequest();
		ar.setSnippetId("sid");
		assertEquals("sid", ar.snippetId);
		
		ar.setCommentId("id");
		assertEquals("id", ar.commentId);
		
		ar.setRegionStart(0);
		assertEquals(0, ar.regionStart);
		
		ar.setRegionEnd(1);
		assertEquals(1, ar.regionEnd);
		
		Date date = new Date(12345);
		ar.setCommentDate(date);
		assertEquals(date, ar.commentDate);
		
		ar.setCommentText("comment Text");
		assertEquals("comment Text", ar.commentText);
		
		ar = new CreateCommentRequest("id", "comment Text",date,0,1,"sid");
		assertEquals("sid", ar.getSnippetId());
		assertEquals("id", ar.getCommentId());
		assertEquals("comment Text", ar.getCommentText());
		assertEquals(date, ar.getCommentDate());		
		
		assertEquals(0, ar.getRegionStart());
		
		assertEquals(1, ar.getRegionEnd());
			
		
		
		assertTrue(ar.toString().startsWith("CreateCommentRequest"));
	}
}
