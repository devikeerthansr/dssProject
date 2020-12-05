package com.amazonaws.lambda.thalia;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.amazonaws.lambda.thalia.http.AllSnippetsResponse;
import com.amazonaws.lambda.thalia.model.Snippet;


/**
 * A simple test harness for locally invoking your Lambda function handler.
 */
public class ListSnippetsTest extends LambdaTest {
	
    @Test
    public void testGetList() throws IOException {
    	GetAllSnippetsHandler handler = new GetAllSnippetsHandler();

    	AllSnippetsResponse resp = handler.handleRequest(null, createContext("snippetlist"));
        
        boolean hasE = false;
        for (Snippet s : resp.list) {
        	System.out.println("found snippet " + s);
        }
        Assert.assertEquals(200, resp.statusCode);
    }

}
