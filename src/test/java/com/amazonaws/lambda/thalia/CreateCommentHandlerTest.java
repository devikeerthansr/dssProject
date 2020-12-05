package com.amazonaws.lambda.thalia;

import java.io.IOException;
import java.sql.Date;

import org.junit.Assert;
import org.junit.Test;

import com.amazonaws.lambda.thalia.http.AllCommentsResponse;
import com.amazonaws.lambda.thalia.http.CreateCommentRequest;
import com.amazonaws.lambda.thalia.http.DeleteCommentRequest;
import com.google.gson.Gson;


/**
 * A simple test harness for locally invoking your Lambda function handler.
 */
public class CreateCommentHandlerTest extends LambdaTest {

    void testSuccessInput(String incoming) throws IOException {
    	CreateCommentHandler handler = new CreateCommentHandler();
    	CreateCommentRequest req = new Gson().fromJson(incoming, CreateCommentRequest.class);
       
    	AllCommentsResponse resp = handler.handleRequest(req, createContext("createComment"));
        Assert.assertEquals(200, resp.statusCode);
    }
	
    void testFailInput(String incoming, int failureCode) throws IOException {
    	CreateCommentHandler handler = new CreateCommentHandler();
    	CreateCommentRequest req = new Gson().fromJson(incoming, CreateCommentRequest.class);

    	AllCommentsResponse resp = handler.handleRequest(req, createContext("createComment"));
        Assert.assertEquals(failureCode, resp.statusCode);
    }

   
    // NOTE: this proliferates large number of constants! Be mindful
    @Test
    public void testShouldBeOk() {
    	    	
    	CreateCommentRequest ccr = new CreateCommentRequest("abcd", "test comment", new Date(123456), 0, 1,
    			"2");
        String SAMPLE_INPUT_STRING = new Gson().toJson(ccr);  
        
        try {
        	testSuccessInput(SAMPLE_INPUT_STRING);
        } catch (IOException ioe) {
        	Assert.fail("Invalid:" + ioe.getMessage());
        }
        
        DeleteCommentRequest dcr = new DeleteCommentRequest("2", "abcd");
        AllCommentsResponse d_resp = new DeleteCommentHandler().handleRequest(dcr, createContext("deleteComment"));
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
