/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;


public class AdminRegistratesUserServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = new User();
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        user.setFirst_name(request.getParameter("first_name"));
        user.setLast_name(request.getParameter("last_name"));
        user.setAddress(request.getParameter("address"));
        user.setCity(request.getParameter("city"));
        user.setTelephone(Long.parseLong(request.getParameter("telephone")));
        user.setEmail(request.getParameter("email"));
        user = (User)user.save();
        
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        
        if (user.getId() > 0) {
            response.sendRedirect("admin.jsp");
        } else {
            response.sendRedirect("registration.jsp");
        }
    }

}
