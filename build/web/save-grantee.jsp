<%-- 
    Document   : save-grantee
    Created on : Jul 27, 2017, 9:48:13 AM
    Author     : kimaiga
--%>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.logging.Logger"%>
<%@page import="java.util.logging.Level"%>
<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.*, backend.DbConn;"%>
<%

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
            String sql = "INSERT into grantees VALUES('" + sFullName + "','" + sYear + "','" + iIssue + "','" + iProgram + "', '" + amount + "', 0)";
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
            RequestDispatcher rd = request.getRequestDispatcher("save-grantee.jsp");
            rd.forward(request, response);

        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(SaveGrantee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Saved</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/foundation/6.3.1/css/foundation.css">
        <!--fonts-->
        <link href='https://fonts.googleapis.com/css?family=Raleway' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" type="text/css" href="css/app.css">
        <!--font-awesome-->
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    </head>
    <body>
        <div class="container">
            <p>Entry has been made!</p>
            <a href="add-new.jsp">Back to data table</a>
        </div>
    </body>
</html>