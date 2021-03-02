package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import models.Model;
import models.Model;
import models.Event;
import models.Location;
import java.io.PrintWriter;
import models.User;

public final class events_005flogged_005fin_jsp extends org.apache.jasper.runtime.HttpJspBase
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
 User user = (User) request.getAttribute("user");
      out.write('\n');
 Location location = (Location) request.getAttribute("location");
      out.write('\n');
 ArrayList<Model> events = (ArrayList<Model>) session.getAttribute("events");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Events</title>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\">\n");
      out.write("        <link href=\"https://cdn.datatables.net/1.10.23/css/jquery.dataTables.min.css\" type=\"text/css\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\n");
      out.write("        <script src=\"https://cdn.datatables.net/1.10.23/js/jquery.dataTables.min.js\"></script>\n");
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
      out.write("                    <div id=\"logout\"><a href=\"logout\">Logout</a></div>\n");
      out.write("                </div>\n");
      out.write("            </nav>\n");
      out.write("        </header>\n");
      out.write("\n");
      out.write("        <div id=\"events\">\n");
      out.write("            <h2>Events</h2>\n");
      out.write("            <table id=\"myTable\">\n");
      out.write("                <thead>\n");
      out.write("                    <tr>\n");
      out.write("                        <th>Event</th>\n");
      out.write("                        <th>Date</th>\n");
      out.write("                        <th>Location</th>\n");
      out.write("                        <th>Reserve tickets</th>\n");
      out.write("                    </tr>\n");
      out.write("                </thead>\n");
      out.write("                <tbody>\n");
      out.write("\n");
      out.write("                    ");
 for (Model event : events) {
                            session = request.getSession();
                            Event e = (Event) event;
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                        <td>");
      out.print( e.getName());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print( e.getDate());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print( e.getLocation());
      out.write("</td>\n");
      out.write("                        <td>\n");
      out.write("                            <form action=\"reservation_input\" id=\"input\">\n");
      out.write("                                ");
 session.setAttribute("event_name", e.getName());
      out.write("\n");
      out.write("                                <input type=\"number\" name=\"gfloor_tickets\" placeholder=\"Ground floor\">\n");
      out.write("                                <input type=\"number\" name=\"balcony_tickets\" placeholder=\"Balcony\">\n");
      out.write("                                <input type=\"submit\" value=\"Reserve\">\n");
      out.write("                            </form>\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    ");
 }
      out.write("\n");
      out.write("\n");
      out.write("                </tbody>\n");
      out.write("            </table>             \n");
      out.write("            <script>\n");
      out.write("                $(document).ready(function () {\n");
      out.write("                    $('#myTable').DataTable({\n");
      out.write("                        \"paging\": true,\n");
      out.write("                        \"pagingType\": \"full_numbers\"\n");
      out.write("                    });\n");
      out.write("                });\n");
      out.write("            </script>\n");
      out.write("            \n");
      out.write("            <h2>Reservation input</h2>\n");
      out.write("            <form action=\"reservation_input\" method=\"post\">\n");
      out.write("                <input type=\"text\" name=\"event_name\" placeholder=\"Event name\"><br>\n");
      out.write("                <input type=\"text\" name=\"gfloor_tickets\" placeholder=\"Ground floor tickets\"><br>\n");
      out.write("                <input type=\"text\" name=\"balcony_tickets\" placeholder=\"Balcony tickets\"><br>\n");
      out.write("                <input type=\"submit\" value=\"Submit\"><br><br><hr>\n");
      out.write("            </form>\n");
      out.write("            <hr>\n");
      out.write("            <a href=\"change_user_data.jsp\">Change user data</a>\n");
      out.write("        </div>\n");
      out.write("                    \n");
      out.write("                    \n");
      out.write("                    \n");
      out.write("                    \n");
      out.write("        <!--        <div id=\"events\">\n");
      out.write("                    <h2>Events</h2>\n");
      out.write("        \n");
      out.write("                    <div>\n");
      out.write("        \n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("                <div id=\"event_one\">Event 1</div>\n");
      out.write("                <div>Event 2</div>\n");
      out.write("                <div>Event 3</div>\n");
      out.write("                <div>Event 4</div>\n");
      out.write("                <div>Event 5</div>\n");
      out.write("                <div>Event 6</div>\n");
      out.write("                <div>Event 7</div>\n");
      out.write("                <div>Event 8</div>\n");
      out.write("                <div>Event 9</div>\n");
      out.write("                <div>Event 10</div>\n");
      out.write("                <div>Event 11</div>\n");
      out.write("                <div>Event 12</div>\n");
      out.write("</div>-->\n");
      out.write("\n");
      out.write("        <footer>\n");
      out.write("            <address>\n");
      out.write("                Predrag Nesic, <br>Delovi 12, <br>Belgrade 11231 Rakovica <br>Republic of Serbia\n");
      out.write("            </address>\n");
      out.write("        </footer>\n");
      out.write("\n");
      out.write("\n");
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
