package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class add_002dnew_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Grantee Data</title>\n");
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
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"large-12 columns\">\n");
      out.write("                    <h4>Add new grantee Data</h4>\n");
      out.write("                    <hr>\n");
      out.write("                    <form action=\"save-grantee.jsp\" method=\"POST\" autocomplete=\"off\" name=\"grantees\">\n");
      out.write("                        <fieldset>\n");
      out.write("                            <label>Full Names</label>\n");
      out.write("                            <input type=\"text\" name=\"grantee-name\" placeholder=\"Names\">\n");
      out.write("                        </fieldset>\n");
      out.write("                        <fieldset>\n");
      out.write("                            <label>Country of Origin</label>\n");
      out.write("                            <script type= \"text/javascript\" src = \"js/countries.js\"></script>\n");
      out.write("                            <select id=\"country\" name=\"country\"></select>                             \n");
      out.write("                        </fieldset>\n");
      out.write("                        <fieldset>\n");
      out.write("                            <label>Year</label>\n");
      out.write("                            <select id=\"selectElementId\" name=\"year\"></select>\n");
      out.write("                        </fieldset>\n");
      out.write("                        <fieldset>\n");
      out.write("                            <label>Issue</label>\n");
      out.write("                            <input type=\"text\" name=\"issue\" placeholder=\"Names\">\n");
      out.write("                        </fieldset>\n");
      out.write("                        <fieldset>\n");
      out.write("                            <label>Program</label>\n");
      out.write("                            <select name=\"program\">\n");
      out.write("                                <option value=\"-1\">Select Program</option>\n");
      out.write("                                <option value=\"Grand Challenges Africa\">Grand Challenges Africa</option>\n");
      out.write("                                <option value=\"H3-Africa\">H3-Africa</option>\n");
      out.write("                                <option value=\"Deltas Africa\">Deltas Africa</option>\n");
      out.write("                                <option value=\"Circle Africa\">Circle Africa</option>\n");
      out.write("                            </select>\n");
      out.write("                        </fieldset>\n");
      out.write("                        <fieldset>\n");
      out.write("                            <label>Institution</label>\n");
      out.write("                            <select name=\"institute\">\n");
      out.write("                                <option value=\"-1\">Select Institution</option>\n");
      out.write("                                <option value=\"African Academy of Sciences\">African Academy of Sciences</option>\n");
      out.write("                            </select>\n");
      out.write("                        </fieldset>\n");
      out.write("                        <fieldset>\n");
      out.write("                            <label>Amount</label>\n");
      out.write("                            <input type=\"number\" name=\"amount\" placeholder=\"Amount\">\n");
      out.write("                        </fieldset>\n");
      out.write("                        <button type=\"submit\" class=\"button primary\">Submit</button>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <script>\n");
      out.write("            var min = new Date().getFullYear(),\n");
      out.write("                    max = min + 9,\n");
      out.write("                    select = document.getElementById('selectElementId');\n");
      out.write("\n");
      out.write("            for (var i = min; i <= max; i++) {\n");
      out.write("                var opt = document.createElement('option');\n");
      out.write("                opt.value = i;\n");
      out.write("                opt.innerHTML = i;\n");
      out.write("                select.appendChild(opt);\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("        <script language=\"javascript\">\n");
      out.write("            populateCountries(\"country\"); // first parameter is id of country drop-down and second parameter is id of state drop-down\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
