package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class admin_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Events</title>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <header>\n");
      out.write("            <h1>Cultural institute \"ARTerie\"</h1>\n");
      out.write("            <nav class=\"nav\">\n");
      out.write("                <div class=\"list\">\n");
      out.write("                    <div><a href=\"index.jsp\">Homepage</a></div>\n");
      out.write("                    <div><a href=\"events\">Events</a></div>\n");
      out.write("                    <div><a href=\"contact.jsp\">Contact</a></div>\n");
      out.write("                    <div><a href=\"registration.jsp\">Sign up</a></div>\n");
      out.write("                    <div><a href=\"login.jsp\">Login</a></div>\n");
      out.write("                    <div><a href=\"admin_login.jsp\">Admin login</a></div>\n");
      out.write("                </div>\n");
      out.write("            </nav>\n");
      out.write("        </header>\n");
      out.write("        <div id=\"form_registration\">\n");
      out.write("            <h2>Add user</h2>\n");
      out.write("            <form action=\"admin_registrates_user\" method=\"post\">\n");
      out.write("                <input type=\"text\" name=\"username\" placeholder=\"Username\"><br>\n");
      out.write("                <input type=\"password\" name=\"password\" placeholder=\"Password\"><br>\n");
      out.write("                <input type=\"password\" name=\"password_repeat\" placeholder=\"Ponovi password\"><br>\n");
      out.write("                <input type=\"text\" name=\"first_name\" placeholder=\"First name\"><br>\n");
      out.write("                <input type=\"text\" name=\"last_name\" placeholder=\"Last name\"><br>        \n");
      out.write("                <input type=\"text\" name=\"address\" placeholder=\"Address\"><br>\n");
      out.write("                <input type=\"text\" name=\"city\" placeholder=\"City\"><br>\n");
      out.write("                <input type=\"text\" name=\"telephone\" placeholder=\"Telephone\"><br>\n");
      out.write("                <input type=\"text\" name=\"email\" placeholder=\"Email\"><br>\n");
      out.write("                <input type=\"submit\" value=\"Submit\"><br><br>\n");
      out.write("            </form>\n");
      out.write("            <form action=\"remove\" method=\"post\">\n");
      out.write("                <h2>Remove user</h2>\n");
      out.write("                <input type=\"text\" name=\"username\" placeholder=\"Username\"><br>\n");
      out.write("                <input type=\"submit\" value=\"Submit\"><br>\n");
      out.write("            </form>\n");
      out.write("            <hr>\n");
      out.write("\n");
      out.write("            <h2>Add ticket agent</h2>\n");
      out.write("            <form action=\"emp_registration\" method=\"post\">\n");
      out.write("                <input type=\"text\" name=\"username\" placeholder=\"Username\"><br>\n");
      out.write("                <input type=\"password\" name=\"password\" placeholder=\"Password\"><br>\n");
      out.write("                <input type=\"password\" name=\"password_repeat\" placeholder=\"Ponovi password\"><br>\n");
      out.write("                <input type=\"text\" name=\"first_name\" placeholder=\"First name\"><br>\n");
      out.write("                <input type=\"text\" name=\"last_name\" placeholder=\"Last name\"><br>        \n");
      out.write("                <input type=\"text\" name=\"location\" placeholder=\"Location\"><br>\n");
      out.write("                <input type=\"submit\" value=\"Submit\"><br><br>\n");
      out.write("            </form>\n");
      out.write("            <form action=\"remove\" method=\"post\">\n");
      out.write("                <h2>Remove ticket agent</h2>\n");
      out.write("                <input type=\"text\" name=\"username\" placeholder=\"Username\"><br>\n");
      out.write("                <input type=\"submit\" value=\"Submit\"><br>\n");
      out.write("            </form>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("    </div\n");
      out.write("\n");
      out.write("    <footer>\n");
      out.write("        <address>\n");
      out.write("            Predrag Nesic, <br>Delovi 12, <br>Belgrade 11231 Rakovica <br>Republic of Serbia\n");
      out.write("        </address>\n");
      out.write("    </footer>\n");
      out.write("\n");
      out.write("</body>\n");
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
