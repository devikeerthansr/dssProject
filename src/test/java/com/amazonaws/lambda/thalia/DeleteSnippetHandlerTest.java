package com.amazonaws.lambda.thalia;

import java.sql.Date;

import org.junit.Assert;
import org.junit.Test;

import com.amazonaws.lambda.thalia.http.AllSnippetsResponse;
import com.amazonaws.lambda.thalia.http.CreateSnippetRequest;
import com.amazonaws.lambda.thalia.http.DeleteSnippetRequest;
import com.amazonaws.lambda.thalia.http.SingleSnippetResponse;


/**
 * A simple test harness for locally invoking your Lambda function handler.
 */
public class DeleteSnippetHandlerTest extends LambdaTest {

    @Test
    public void testCreate() {
    	        
        CreateSnippetRequest ccr = new CreateSnippetRequest("abcd", "some code", "info", "120.26.56.23",
    			"Java", 0, new Date(123456));
        
        SingleSnippetResponse resp = new CreateSnippetHandler().handleRequest(ccr, createContext("createSnippet"));
        Assert.assertEquals(200, resp.response);
        
    }
    
    @Test
    public void testCreateAndDeleteConstant() {
    	        
           
        // now delete
        DeleteSnippetRequest dcr = new DeleteSnippetRequest("abcd", "120.26.56.23",false);
        AllSnippetsResponse d_resp = new DeleteSnippetHandler().handleRequest(dcr, createContext("deleteSnippet"));
        Assert.assertEquals(200, d_resp.statusCode);
        
        // try again and this should fail
        d_resp = new DeleteSnippetHandler().handleRequest(dcr, createContext("deleteSnippet"));
        Assert.assertEquals(422, d_resp.statusCode);
    }
   
}
