package com.amazonaws.lambda.thalia;

import java.sql.Date;

import org.junit.Assert;
import org.junit.Test;

import com.amazonaws.lambda.thalia.http.AllCommentsResponse;
import com.amazonaws.lambda.thalia.http.CreateCommentRequest;
import com.amazonaws.lambda.thalia.http.DeleteCommentRequest;


/**
 * A simple test harness for locally invoking your Lambda function handler.
 */
public class DeleteCommentHandlerTest extends LambdaTest {

    @Test
    public void testCreateAndDeleteConstant() {
    	
        CreateCommentRequest ccr = new CreateCommentRequest("abcd", "test comment", new Date(123456), 0, 1,
    			"2");
        
        AllCommentsResponse resp = new CreateCommentHandler().handleRequest(ccr, createContext("createComment"));
        Assert.assertEquals(200, resp.statusCode);
        
        // now delete
        DeleteCommentRequest dcr = new DeleteCommentRequest("2", "abcd");
        AllCommentsResponse d_resp = new DeleteCommentHandler().handleRequest(dcr, createContext("deleteComment"));
        Assert.assertEquals(200, d_resp.statusCode);
        
        // try again and this should fail
        d_resp = new DeleteCommentHandler().handleRequest(dcr, createContext("deleteComment"));
        Assert.assertEquals(422, d_resp.statusCode);
    }
   
}
