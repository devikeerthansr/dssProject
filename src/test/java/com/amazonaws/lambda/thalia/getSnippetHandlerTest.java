package com.amazonaws.lambda.thalia;

import com.amazonaws.lambda.thalia.http.GetSnippetRequest;
import com.amazonaws.lambda.thalia.http.GetSnippetResponse;
import com.google.gson.Gson;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class getSnippetHandlerTest extends LambdaTest{
	void testSuccessInput(String incoming) throws IOException {
		GetSnippetHandler handler = new GetSnippetHandler();
		GetSnippetRequest req = new Gson().fromJson(incoming, GetSnippetRequest.class);
       
		GetSnippetResponse resp = handler.handleRequest(req, createContext("getSnippet"));
    	System.out.println("found snippet " + resp.snippet);
        
        Assert.assertEquals(200, resp.httpCode);
    }
	
    @Test
    public void testShouldBeOk() {
    	    	
    	GetSnippetRequest ccr = new GetSnippetRequest("abcd");
        String SAMPLE_INPUT_STRING = new Gson().toJson(ccr);  
        
        try {
        	testSuccessInput(SAMPLE_INPUT_STRING);
        } catch (IOException ioe) {
        	Assert.fail("Invalid:" + ioe.getMessage());
        }
        
        
    }
}
