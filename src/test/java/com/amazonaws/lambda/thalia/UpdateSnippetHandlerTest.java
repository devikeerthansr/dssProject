package com.amazonaws.lambda.thalia;
import com.amazonaws.lambda.thalia.http.UpdateSnippetRequest;
import com.amazonaws.lambda.thalia.http.UpdateSnippetResponse;
import com.google.gson.Gson;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
public class UpdateSnippetHandlerTest extends LambdaTest{
	void testSuccessInput(String incoming) throws IOException {
		UpdateSnippetHandler handler = new UpdateSnippetHandler();
		UpdateSnippetRequest req = new Gson().fromJson(incoming, UpdateSnippetRequest.class);
       
		UpdateSnippetResponse resp = handler.handleRequest(req, createContext("updateSnippet"));
    	System.out.println("updated snippet " + resp.message);
        
        Assert.assertEquals(200, resp.httpCode);
    }
	
    @Test
    public void testShouldBeOk() {
    	    	
    	UpdateSnippetRequest ccr = new UpdateSnippetRequest("abcd", "some code", "120.26.56.23","Java");
        String SAMPLE_INPUT_STRING = new Gson().toJson(ccr);  
        
        try {
        	testSuccessInput(SAMPLE_INPUT_STRING);
        } catch (IOException ioe) {
        	Assert.fail("Invalid:" + ioe.getMessage());
        }
        
        
    }
}
