package servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;
import models.Model;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Model> users = User.all(User.class);
        for (Model user : users) {
            User u = (User) user;
            if (u.getUsername().equals(request.getParameter("username"))
                    && u.getPassword().equals(request.getParameter("password"))) {

                HttpSession session = request.getSession();
                session.setAttribute("user_id", u.getId());
                session.setAttribute("username", u.getUsername());
                response.sendRedirect("logged_in");
                return;
            }

        }
        String message = "Username or password is not correct.";
        request.setAttribute("message", message);
        String address = "error.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(address);
        rd.forward(request, response);
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

}
