package servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Employee;
import models.Model;

public class EmpLoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        ArrayList<Model> employees = Employee.all(Employee.class);
        for (Model employee : employees) {
            Employee e = (Employee)employee;
            if (e.getUsername().equals(request.getParameter("username"))
                    && e.getPassword().equals(request.getParameter("password"))
                    && e.getIs_admin().equals(request.getParameter("is_admin"))) {
                if(e.getIs_admin().equals("0")) {
                    session.setAttribute("employee_location", e.getLocation());
                    session.setAttribute("employee_username", e.getUsername()); //new
                    session.setAttribute("employee_is_admin", e.getIs_admin()); // new
                    response.sendRedirect("ticket_agent.jsp");
                    break;
                } else if (e.getIs_admin().equals("1")) {
                    session.setAttribute("employee_location", e.getLocation());
                    response.sendRedirect("admin.jsp");
                    break;
                }

//                HttpSession session = request.getSession();
//                session.setAttribute("employee_id", e.getId());
//                response.sendRedirect("admin.jsp");
//                return;
            
            
            } else if(!request.getParameter("is_admin").equals("0") 
                    && !request.getParameter("is_admin").equals("1")) {
                response.sendRedirect("admin_login.jsp");
                break;
            } 
            
        }
//        response.sendRedirect("ticket_agent.jsp");
    }

}
