package com.amazonaws.lambda.thalia.http;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;

public class TestCreateSnippetRequest {

	@Test
	public void test() {
		CreateSnippetRequest ar = new CreateSnippetRequest();
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
		
		ar = new CreateSnippetRequest("id1", "some code", "info", "120.15.20.25",
				"Java", 0, date);
		assertEquals("id1", ar.getSnippetId());
		
		
		assertEquals("Java", ar.getCodingLanguage());
		
		
		assertEquals(date, ar.getCreateDate());
		
		
		assertEquals("info", ar.getSnippetInfo());
		
		
		assertEquals("120.15.20.25", ar.getSnippetPassword());
		
		
		assertEquals("some code", ar.getSnippetText());
		assertTrue(ar.toString().startsWith("CreateSnippetRequest"));
	}
}
