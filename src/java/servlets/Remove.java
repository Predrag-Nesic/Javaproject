package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Employee;
import models.Model;
import models.User;

@WebServlet(name = "Remove", urlPatterns = {"/remove"})
public class Remove extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        boolean check = true;
        String address = "admin.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(address);
        while (check) {
            ArrayList<Model> users = User.all(User.class);
            for (Model user : users) {
                User u = (User) user;
                if (u.getUsername().equals(request.getParameter("username"))) {
                    u.delete();
                    rd.forward(request, response);
                }
            }
            check = false;
        }

        while (!check) {
            ArrayList<Model> employees = Employee.all(Employee.class);
            for (Model employee : employees) {
                Employee e = (Employee) employee;
                if (e.getUsername().equals(request.getParameter("username")) && e.getIs_admin().equals("0")) {
                    e.delete();
                    rd.forward(request, response);
                }
            }
            check = true;
        }
        rd.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
