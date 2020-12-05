package com.amazonaws.lambda.thalia;

import java.io.IOException;
import java.sql.Date;

import org.junit.Assert;
import org.junit.Test;

import com.amazonaws.lambda.thalia.http.AllSnippetsResponse;
import com.amazonaws.lambda.thalia.http.CreateSnippetRequest;
import com.amazonaws.lambda.thalia.http.DeleteSnippetRequest;
import com.amazonaws.lambda.thalia.http.SingleSnippetResponse;
import com.google.gson.Gson;


/**
 * A simple test harness for locally invoking your Lambda function handler.
 */
public class CreateSnippetHandlerTest extends LambdaTest {

    void testSuccessInput(String incoming) throws IOException {
    	CreateSnippetHandler handler = new CreateSnippetHandler();
    	CreateSnippetRequest req = new Gson().fromJson(incoming, CreateSnippetRequest.class);
       
    	SingleSnippetResponse resp = handler.handleRequest(req, createContext("createSnippet"));
        Assert.assertEquals(200, resp.httpCode);
    }
	
    void testFailInput(String incoming, int failureCode) throws IOException {
    	CreateSnippetHandler handler = new CreateSnippetHandler();
    	CreateSnippetRequest req = new Gson().fromJson(incoming, CreateSnippetRequest.class);

    	SingleSnippetResponse resp = handler.handleRequest(req, createContext("createSnippet"));
        Assert.assertEquals(failureCode, resp.httpCode);
    }

   
    // NOTE: this proliferates large number of constants! Be mindful
    @Test
    public void testShouldBeOk() {
    	    	
    	CreateSnippetRequest ccr = new CreateSnippetRequest("abcd", "some code", "info", "120.26.56.23",
    			"Java", 0, new Date(123456));
        String SAMPLE_INPUT_STRING = new Gson().toJson(ccr);  
        
        try {
        	testSuccessInput(SAMPLE_INPUT_STRING);
        } catch (IOException ioe) {
        	Assert.fail("Invalid:" + ioe.getMessage());
        }
        
        DeleteSnippetRequest dcr = new DeleteSnippetRequest("abcd", "120.26.56.23",false);
        AllSnippetsResponse d_resp = new DeleteSnippetHandler().handleRequest(dcr, createContext("deleteSnippet"));
        Assert.assertEquals(200, d_resp.statusCode);
    }
    
    
    @Test
    public void testGarbageInput() {
    	String SAMPLE_INPUT_STRING = "{\"sdsd\": \"e3\", \"hgfgdfgdfg\": \"this is not a number\"}";
        
        try {
        	testFailInput(SAMPLE_INPUT_STRING, 400);
        } catch (IOException ioe) {
        	Assert.fail("Invalid:" + ioe.getMessage());
        }
    }
    
    
}
