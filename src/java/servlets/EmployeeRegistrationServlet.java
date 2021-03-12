package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Employee;

public class EmployeeRegistrationServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        Employee employee = new Employee();
        
        employee.setUsername(request.getParameter("username"));
        employee.setPassword(request.getParameter("password"));
        employee.setFirst_name(request.getParameter("first_name"));
        employee.setLast_name(request.getParameter("last_name"));
        employee.setLocation(request.getParameter("location"));
        employee = (Employee)employee.save();
        
        session.setAttribute("employee", employee);
        
        if (employee.getId() > 0) {
            response.sendRedirect("admin.jsp");
        } else {
            response.sendRedirect("registration.jsp");
        }
    }
}

      
    

