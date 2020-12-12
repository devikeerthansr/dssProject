package com.amazonaws.lambda.thalia.model;
import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;
public class TestSnippet {
	@Test
	public void test() {
		Snippet ar = new Snippet();
		ar.setSnippetId("id1");
		assertEquals("id1", ar.snippetId);
		
		ar.setCodingLanguage("Java");
		assertEquals("Java", ar.codingLanguage);
		
		Date date = new Date(12345);
		ar.setCreateDate(date);
		assertEquals(date, ar.createDate);
		
		ar.setSnippetInfo("info");
		assertEquals("info", ar.snippetInfo);
		
		ar.setSnippetPassword("120.15.20.25");
		assertEquals("120.15.20.25", ar.snippetPassword);
		
		ar.setSnippetText("some code");
		assertEquals("some code", ar.snippetText);
		
		ar = new Snippet("id1", "some code", "info", "120.15.20.25",
				"Java", date);
		assertEquals("id1", ar.getSnippetId());
		
		
		assertEquals("Java", ar.getCodingLanguage());
		
		
		assertEquals(date, ar.getCreateDate());
		
		
		assertEquals("info", ar.getSnippetInfo());
		
		
		assertEquals("120.15.20.25", ar.getSnippetPassword());
		
		
		assertEquals("some code", ar.getSnippetText());
		assertTrue(ar.toString().startsWith("Snippet"));
		
		Snippet ar1 = new Snippet("id1", "some code", "info", "120.15.20.25",
				"Java", date);
		Snippet ar2 = new Snippet("id1", "some code", "info", "120.15.20.25",
				"Java", date);
		assertTrue(ar1.equals(ar2));
	}
}
