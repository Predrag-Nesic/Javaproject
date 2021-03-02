package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import models.Message;
import java.util.ArrayList;
import models.Model;
import models.User;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
 User user = (User) request.getAttribute("user"); 
      out.write('\n');
 ArrayList<Model> messages = (ArrayList<Model>) request.getAttribute("messages");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Homepage</title>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\">\n");
      out.write("    </head>\n");
      out.write("    <header>\n");
      out.write("        <h1>Cultural institute \"ARTerie\"</h1>\n");
      out.write("        <nav class=\"nav\">\n");
      out.write("            <div class=\"list\">\n");
      out.write("                <div><a href=\"index.jsp\">Homepage</a></div>\n");
      out.write("                <div><a href=\"events\">Events</a></div>\n");
      out.write("                <div><a href=\"contact.jsp\">Contact</a></div>\n");
      out.write("                <div><a href=\"registration.jsp\">Sign up</a></div>\n");
      out.write("                <div><a href=\"login.jsp\">Login</a></div>\n");
      out.write("                <div><a href=\"admin_login.jsp\">Admin login</a></div>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("    </header>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"main\">\n");
      out.write("            <h2>Main</h2>\n");
      out.write("            <div id=\"text\">\n");
      out.write("                <p>\n");
      out.write("                    Lorem ipsum, dolor sit amet consectetur adipisicing elit. Nostrum, quod reiciendis, blanditiis maxime eveniet laudantium sapiente possimus libero maiores aspernatur natus reprehenderit aliquam cum sint incidunt aliquid excepturi repudiandae officiis?\n");
      out.write("                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptates cumque vitae tempora, unde accusamus obcaecati sapiente natus modi explicabo facere soluta quam praesentium neque. Iusto fugiat architecto ducimus ut beatae?\n");
      out.write("                    Lorem ipsum dolor sit, amet consectetur adipisicing elit. Quidem nam est nesciunt explicabo qui laboriosam? In officia, magni earum maxime mollitia cum dolorem, assumenda, quod voluptas illum libero id repudiandae!\n");
      out.write("                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Dignissimos doloribus quibusdam accusantium aperiam quasi quam nisi, quae iste, vitae molestias facere necessitatibus provident blanditiis nostrum explicabo laudantium incidunt molestiae?\n");
      out.write("                </p>\n");
      out.write("            </div>\n");
      out.write("            <h2>News</h2>\n");
      out.write("            <div id=\"news\">\n");
      out.write("                <p>\n");
      out.write("                <ul>\n");
      out.write("                    <li>\n");
      out.write("                        <h3>Lorem</h3>\n");
      out.write("                        <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Labore quia soluta nesciunt eveniet aspernatur voluptas ipsa dignissimos debitis ea. Molestias ut at tenetur aliquid aperiam commodi vero officia dolorem excepturi!</p>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <h3>Lorem</h3>\n");
      out.write("                        <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Expedita culpa illo incidunt nisi totam, aliquid consequuntur voluptas maiores nesciunt nihil dolor, dolore tenetur, natus sed! Doloremque quis harum nostrum, culpa?</p>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <h3>Lorem</h3>\n");
      out.write("                        <p>Lorem ipsum dolor sit amet, consectetur, adipisicing elit. Enim, reiciendis ducimus deserunt fugit quisquam odio sunt a facere, nulla adipisci consequatur totam quidem ea molestias repudiandae perspiciatis quam assumenda quos.</p>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                </p>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <footer>\n");
      out.write("            <address>\n");
      out.write("                Predrag Nesic, <br>Delovi 12, <br>Belgrade 11231 Rakovica <br>Republic of Serbia\n");
      out.write("            </address>\n");
      out.write("        </footer>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("\n");
      out.write("<!--        <h2>Vas id: ");
      out.write("</h2>-->\n");
      out.write("\n");
      out.write("<!-- <h1>Dobro dosao ");
      out.write("</h1>\n");
      out.write("\n");
      out.write("<h2>Unesi poruku</h2>\n");
      out.write("\n");
      out.write("<form action=\"send_message\" method=\"post\">\n");
      out.write("    <input type=\"text\" name=\"poruka\" placeholder=\"Unesite Vasu poruku\">\n");
      out.write("    <input type=\"submit\" value=\"Posalji\">\n");
      out.write("</form>\n");
      out.write("\n");
      out.write("    ");
      out.write("\n");
      out.write("        <h2>");
      out.write(" /\n");
      out.write("    ");
      out.write("</h2>\n");
      out.write("<p>");
      out.write("</p>\n");
      out.write("<hr> \n");
      out.write("   ");
      out.write("\n");
      out.write("    \n");
      out.write("    -->\n");
      out.write("\n");
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
