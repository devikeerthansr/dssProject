package com.amazonaws.lambda.thalia.db;


import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;

import com.amazonaws.lambda.thalia.model.Comment;
import com.amazonaws.lambda.thalia.model.Snippet;



public class DBTest {

		
	@Test
	public void testCreateSnippet() {
		MainDAO cd = new MainDAO();
	    try {
	    	Date date = new Date(12345);
	    	Snippet ar = new Snippet("id1", "some code", "info", "120.15.20.25",
					"Java", date);
	    	
	    	boolean b = cd.addSnippet(ar);
	    	System.out.println("add snippet: " + b);
	    	
	    	// can retrieve it
	    	Snippet s2 = cd.getSnippet("id1");
	    	System.out.println("s2:" + s2.snippetId);
	    	
	    	// can delete it
	    	assertTrue (cd.deleteSnippet("id1", "120.15.20.25"));
	    } catch (Exception e) {
	    	fail ("didn't work:" + e.getMessage());
	    }
	}
	
	@Test
	public void testCreateComment() {
		MainDAO cd = new MainDAO();
	    try {
	    	Date date = new Date(12345);
	    	Comment ar = new Comment("id1", "some code", date, 0,1, "sid1");
	    	
	    	boolean b = cd.addComment(ar);
	    	System.out.println("add comment: " + b);
	    	
	    	// can retrieve it
	    	Comment c2 = cd.getComment("sid1","id1");
	    	System.out.println("c2:" + c2.commentId);
	    	
	    	// can delete it
	    	assertTrue (cd.deleteComment("sid1","id1"));
	    } catch (Exception e) {
	    	fail ("didn't work:" + e.getMessage());
	    }
	}
}
