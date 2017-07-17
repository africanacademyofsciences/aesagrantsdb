/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import backend.dbProperties;

/**
 *
 * @author kimaiga
 */
@WebServlet(name = "SaveGrantee", urlPatterns = {"/SaveGrantee"})
public class SaveGrantee extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, InstantiationException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
//<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
//<jsp:useBean id="dbConn" scope="request" class="com.villa.db.DBProperties"/>
//<%
		Connection conn=null;
        try {
            //    conn=dbConn.getConnection();
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SaveGrantee.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(SaveGrantee.class.getName()).log(Level.SEVERE, null, ex);
        }
    conn = DriverManager.getConnection("jdbc:mysql://localhost/grantsdb","root","303seminarian");
		
		PreparedStatement psInsert=null;
		
		String sFullName=request.getParameter("grantee-name");
		String sYear=request.getParameter("year");
		String iIssue=request.getParameter("issue");
		String iProgram=request.getParameter("programme");
		String amount=request.getParameter("amount");
		
		
		String sqlInsertregistration=null;
		
		try{
			sqlInsertregistration="insert into grantees (fullnames, year, issue, program, amount, 0)" +"values(?, ?, ?, ?, ?, ?, ?";
                        
			psInsert=conn.prepareStatement(sqlInsertregistration);
			psInsert.setString(1,sFullName);
			psInsert.setString(2,sYear);
			psInsert.setString(3,iIssue);
			psInsert.setString(4,iProgram);
			psInsert.setString(5,amount);
			
			
			psInsert.executeUpdate();
		}
		catch(Exception e)
		{
		   e.printStackTrace();
		   request.setAttribute("error","<span class='sSError'>&nbsp; Registration is not successful, May be User ID already Exists &nbsp; </span>");
		   RequestDispatcher dispatch = request.getRequestDispatcher("/add-new-html");
		   dispatch.forward(request, response);
		}



	try{
		 if(psInsert!=null){
			 psInsert.close();
		 }
		 		 
		 if(conn!=null){
		  conn.close();
		 }
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
     
        
    }

   
}
