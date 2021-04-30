package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;

public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = new User();
      
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        if (!user.getPassword().equals(request.getParameter("password_repeat"))) {
            String message = "Repeated password is incorrect.";
            request.setAttribute("message", message);
            String address = "error.jsp";
            RequestDispatcher rd = request.getRequestDispatcher(address);
            rd.forward(request, response);
        }
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
            response.sendRedirect("login.jsp");
        } else {
            response.sendRedirect("registration.jsp");
        }
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    public int power(int broj, int eksp) {
        if (eksp > 1)
            return broj * power(broj, eksp-1);
        else
            return broj;
    }

}
