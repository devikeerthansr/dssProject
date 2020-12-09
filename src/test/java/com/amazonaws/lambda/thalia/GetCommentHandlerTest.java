package com.amazonaws.lambda.thalia;

import java.io.IOException;

import com.amazonaws.lambda.thalia.http.GetCommentRequest;
import com.amazonaws.lambda.thalia.http.GetCommentResponse;
import com.google.gson.Gson;

import org.junit.Assert;
import org.junit.Test;

public class GetCommentHandlerTest extends LambdaTest{
	void testSuccessInput(String incoming) throws IOException {
		GetCommentHandler handler = new GetCommentHandler();
		GetCommentRequest req = new Gson().fromJson(incoming, GetCommentRequest.class);
       
		GetCommentResponse resp = handler.handleRequest(req, createContext("getComment"));
    	System.out.println("found comment " + resp.comment);
        
        Assert.assertEquals(200, resp.httpCode);
    }
	
    @Test
    public void testShouldBeOk() {
    	    	
    	GetCommentRequest ccr = new GetCommentRequest("abcd","abcd");
        String SAMPLE_INPUT_STRING = new Gson().toJson(ccr);  
        
        try {
        	testSuccessInput(SAMPLE_INPUT_STRING);
        } catch (IOException ioe) {
        	Assert.fail("Invalid:" + ioe.getMessage());
        }
        
        
    }
}
