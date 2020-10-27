package com.amazonaws.lambda.demo.db;

import java.nio.charset.CodingErrorAction;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.amazonaws.lambda.demo.model.Snippet;



/**
 * 
 * 
 * @author keerthan
 *
 */
public class MainDAO { 

	java.sql.Connection conn;
	
	final String tblSnippet = "Snippets";   
	final String tblComment = "Comments";

    public MainDAO() {
    	try  {
    		conn = DatabaseUtil.connect();
    	} catch (Exception e) {
    		conn = null;
    	}
    }

    public Snippet getSnippet(String snippetId) throws Exception {
        
        try {
        	Snippet snippet = null;
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + tblSnippet + " WHERE SnippetId=?;");
            ps.setString(1,  snippetId);
            ResultSet resultSet = ps.executeQuery();
            
            while (resultSet.next()) {
            	snippet = generateSnippet(resultSet);
            }
            resultSet.close();
            ps.close();
            
            return snippet;

        } catch (Exception e) {
        	e.printStackTrace();
            throw new Exception("Failed in getting snippet: " + e.getMessage());
        }
    }
    
    public boolean updateSnippet(Snippet snippet) throws Exception {
        try {
        	String query = "UPDATE " + tblSnippet + " SET SnippetText=? WHERE SnippetId=?;";
        	PreparedStatement ps = conn.prepareStatement(query);
        	
            ps.setString(1, snippet.snippetText);
            ps.setString(2, snippet.snippetId);
            int numAffected = ps.executeUpdate();
            ps.close();
            
            return (numAffected == 1);
        } catch (Exception e) {
            throw new Exception("Failed to update report: " + e.getMessage());
        }
    }
    
    public boolean deleteSnippet(Snippet snippet) throws Exception {
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM " + tblSnippet + " WHERE SnippetId = ?;");
            ps.setString(1, snippet.snippetId);
            int numAffected = ps.executeUpdate();
            ps.close();
            
            return (numAffected == 1);

        } catch (Exception e) {
            throw new Exception("Failed to delete snippet: " + e.getMessage());
        }
    }


    public boolean addSnippet(Snippet snippet) throws Exception {
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + tblSnippet + " WHERE SnippetId = ?;");
            ps.setString(1, snippet.snippetId);
            ResultSet resultSet = ps.executeQuery();
            
            // already present?
            while (resultSet.next()) {
                Snippet sni = generateSnippet(resultSet);
                resultSet.close();
                return false;
            }

            ps = conn.prepareStatement("INSERT INTO " + tblSnippet + " (SnippetId,TimeStamp,SnippetInfo,SnippetText,Password,NumComments,CodingLanguage) values(?,?,?,?,?,?,?);");
            ps.setString(1,  snippet.snippetId);
            ps.setDate(2,  snippet.createDate);
            ps.setString(3,  snippet.snippetInfo);
            ps.setString(4,  snippet.snippetText);
            ps.setString(5,  snippet.snippetPassword);
            ps.setInt(6,  snippet.numComments);
            ps.setString(7, snippet.codingLanguage);
            
            ps.execute();
            return true;

        } catch (Exception e) {
            throw new Exception("Failed to insert constant: " + e.getMessage());
        }
    }

    public List<Snippet> getAllSnippets() throws Exception {
        
        List<Snippet> allConstants = new ArrayList<>();
        try {
            Statement statement = conn.createStatement();
            String query = "SELECT * FROM " + tblSnippet + ";";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
            	Snippet c = generateSnippet(resultSet);
                allConstants.add(c);
            }
            resultSet.close();
            statement.close();
            return allConstants;

        } catch (Exception e) {
            throw new Exception("Failed in getting snippets: " + e.getMessage());
        }
    }
    private Snippet generateSnippet(ResultSet resultSet) throws Exception {
    	String snippetId  = resultSet.getString("SnippetId");
    	String snippetText = resultSet.getString("SnippetText");
    	String snippetInfo = resultSet.getString("SnippetInfo");
    	String snippetPassword = resultSet.getString("Password");
    	String codingLanguage = resultSet.getString("CodingLanguage");
    	Date createDate = resultSet.getDate("TimeStamp");
    	      return new Snippet(snippetId,snippetText,snippetInfo,snippetPassword, codingLanguage,createDate);
    }
    

}