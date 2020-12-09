package com.amazonaws.lambda.thalia;
import com.amazonaws.lambda.thalia.http.UpdateSnippetInfoRequest;
import com.amazonaws.lambda.thalia.http.UpdateSnippetResponse;
import com.google.gson.Gson;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
public class UpdateSnippetInfoHandlerTest extends LambdaTest{
	void testSuccessInput(String incoming) throws IOException {
		UpdateSnippetInfoHandler handler = new UpdateSnippetInfoHandler();
		UpdateSnippetInfoRequest req = new Gson().fromJson(incoming, UpdateSnippetInfoRequest.class);
       
		UpdateSnippetResponse resp = handler.handleRequest(req, createContext("updateSnippetInfo"));
    	System.out.println("updated snippet info" + resp.message);
        
        Assert.assertEquals(200, resp.httpCode);
    }
	
    @Test
    public void testShouldBeOk() {
    	    	
    	UpdateSnippetInfoRequest ccr = new UpdateSnippetInfoRequest("abcd","updated info");
        String SAMPLE_INPUT_STRING = new Gson().toJson(ccr);  
        
        try {
        	testSuccessInput(SAMPLE_INPUT_STRING);
        } catch (IOException ioe) {
        	Assert.fail("Invalid:" + ioe.getMessage());
        }
        
        
    }
}
