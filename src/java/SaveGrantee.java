/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
//import backend.DbConn;

/**
 *
 * @author kimaiga
 */
public class SaveGrantee extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, InstantiationException, SQLException {
        response.setContentType("text/html;charset=UTF-8");

        String sFullName = request.getParameter("grantee-name");
        String sYear = request.getParameter("year");
        String iIssue = request.getParameter("issue");
        String iProgram = request.getParameter("programme");
        String amount = request.getParameter("amount");

        //form validation
        if ("".equals(sFullName) || "".equals(sYear) || "".equals(iIssue) || "".equals(iProgram) || "".equals(amount)) {
            response.sendRedirect("google.com");

        } else {
            
            try {
                //attempt to save data to database
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/grantsdb", "root", "303seminarian");
                String sql = "INSERT into grantees VALUES('" + sFullName + "','" + sYear + "','" + iIssue + "','" + iProgram + "', '"+ amount +"', 0)";
                Statement st = conn.createStatement();
                //change type of Resultset
                boolean rs;
                rs = st.execute(sql);

                request.setAttribute("grantee-name", sFullName);
                request.setAttribute("year", sYear);
                request.setAttribute("issue", iIssue);
                request.setAttribute("programme", iProgram);
                request.setAttribute("amount", amount);

                //forward data to next jsp page
                RequestDispatcher rd = request.getRequestDispatcher("index.html");
                rd.forward(request, response);

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(SaveGrantee.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(SaveGrantee.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(SaveGrantee.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
