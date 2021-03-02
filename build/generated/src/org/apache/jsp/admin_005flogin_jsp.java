package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class admin_005flogin_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Admin login</title>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <header>\n");
      out.write("            <h1>Cultural institute \"ARTerie\"</h1>\n");
      out.write("            <nav class=\"nav\">\n");
      out.write("                <div class=\"list\">\n");
      out.write("                    <div><a href=\"index.jsp\">Homepage</a></div>\n");
      out.write("                    <div><a href=\"events.jsp\">Events</a></div>\n");
      out.write("                    <div><a href=\"contact.jsp\">Contact</a></div>\n");
      out.write("                    <div><a href=\"registration.jsp\">Sign up</a></div>\n");
      out.write("                    <div><a href=\"login.jsp\">Login</a></div>\n");
      out.write("                    <div><a href=\"admin_login.jsp\">Admin login</a></div>\n");
      out.write("                </div>\n");
      out.write("            </nav>\n");
      out.write("        </header>\n");
      out.write("        <div id=\"admin_registration\">\n");
      out.write("            <h2>Admin registration</h2>\n");
      out.write("            <form action=\"emp_login\" method=\"get\">\n");
      out.write("                <input type=\"text\" name=\"username\" id=\"username\" placeholder=\"Enter username\"><br>\n");
      out.write("                <input type=\"password\" name=\"password\" id=\"password\" placeholder=\"Enter password\"><br>\n");
      out.write("                <label for=\"is_admin\">Admin:</label>\n");
      out.write("                <input type=\"text\" name=\"is_admin\" id=\"is_admin\" placeholder=\"Enter '1' or '0'\"><br>\n");
      out.write("<!--                <select name=\"is_admin\" id=\"is_admin\">\n");
      out.write("\t\t\t\t<option value=\"yes\" selsected>Yes</option>\n");
      out.write("\t\t\t\t<option value=\"no\">No</option>\n");
      out.write("                </select><br>-->\n");
      out.write("<!--                <input type=\"number\" name=\"is_admin\" id=\"is_admin\" placeholder=\"Type 1 for 'yes', 0 for 'no'\">-->\n");
      out.write("                <input type=\"submit\"value=\"Submit\">\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("        <footer>\n");
      out.write("            <address>\n");
      out.write("                Predrag Nesic, <br>Delovi 12, <br>Belgrade 11231 Rakovica <br>Republic of Serbia\n");
      out.write("            </address>\n");
      out.write("        </footer>\n");
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
