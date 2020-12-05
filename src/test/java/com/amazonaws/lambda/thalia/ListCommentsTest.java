package com.amazonaws.lambda.thalia;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.amazonaws.lambda.thalia.http.AllCommentsResponse;
import com.amazonaws.lambda.thalia.http.GetCommentsRequest;
import com.amazonaws.lambda.thalia.model.Comment;
import com.google.gson.Gson;


/**
 * A simple test harness for locally invoking your Lambda function handler.
 */
public class ListCommentsTest extends LambdaTest {
	
    void testSuccessInput(String incoming) throws IOException {
    	GetAllCommentsHandler handler = new GetAllCommentsHandler();
    	GetCommentsRequest req = new Gson().fromJson(incoming, GetCommentsRequest.class);
       
    	AllCommentsResponse resp = handler.handleRequest(req, createContext("commentlist"));
    	for (Comment c : resp.list) {
        	System.out.println("found comment " + c);
        }
        Assert.assertEquals(200, resp.statusCode);
    }
	
    @Test
    public void testShouldBeOk() {
    	    	
    	GetCommentsRequest ccr = new GetCommentsRequest("abcd");
        String SAMPLE_INPUT_STRING = new Gson().toJson(ccr);  
        
        try {
        	testSuccessInput(SAMPLE_INPUT_STRING);
        } catch (IOException ioe) {
        	Assert.fail("Invalid:" + ioe.getMessage());
        }
        
        
    }
}
