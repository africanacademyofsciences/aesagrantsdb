package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Connection;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.sql.*;
import backend.DbConn;;

public final class save_002dgrantee_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");


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

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Saved</title>\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"https://cdnjs.cloudflare.com/ajax/libs/foundation/6.3.1/css/foundation.css\">\n");
      out.write("        <!--fonts-->\n");
      out.write("        <link href='https://fonts.googleapis.com/css?family=Raleway' rel='stylesheet' type='text/css'>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/app.css\">\n");
      out.write("        <!--font-awesome-->\n");
      out.write("        <link href=\"https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("        <script src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <p>Entry has been made!</p>\n");
      out.write("            <a href=\"add-new.html\">Back to data table</a>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
