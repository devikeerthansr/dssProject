package com.amazonaws.lambda.thalia.model;
import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;
public class TestComment {
	@Test
	public void test() {
	Comment ar = new Comment();
	ar.setCommentId("id1");
	assertEquals("id1", ar.commentId);
	
	ar.setRegionStart(0);
	assertEquals(0, ar.regionStart);
	
	ar.setRegionEnd(1);
	assertEquals(1, ar.regionEnd);
	
	Date date = new Date(12345);
	ar.setCommentDate(date);
	assertEquals(date, ar.commentDate);	
		
	ar.setCommentText("some code");
	assertEquals("some code", ar.commentText);
	
	ar.setSnippetId("sid1");
	assertEquals("sid1", ar.snippetId);
	
	ar = new Comment("id1", "some code", date, 0,1, "sid1");
	assertEquals("id1", ar.getCommentId());
	
	
	assertEquals("some code", ar.getCommentText());
	
	
	assertEquals(date, ar.getCommentDate());
	
	
	assertEquals(0, ar.getRegionStart());
	
	
	assertEquals(1, ar.getRegionEnd());
	
	
	assertEquals("sid1", ar.getSnippetId());
	
	assertTrue(ar.toString().startsWith("Comment"));
	
	Comment ar1 = new Comment("id1", "some code", date, 0,1, "sid1");
	Comment ar2 = new Comment("id1", "some code", date, 0,1, "sid1");
	assertTrue(ar1.equals(ar2));
}
}
