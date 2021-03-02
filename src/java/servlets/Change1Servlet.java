package servlets;

import base.Database;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Model;
import models.User;

public class Change1Servlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        ArrayList<Model> users = User.all(User.class);
        for (Model us : users) {
            User u = (User) us;
            if (u.getUsername().equals(user.getUsername())) {
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                String email = request.getParameter("email");

                user.setUsername(username);
                user.setPassword(password);
                user.setEmail(email);
                
                user = (User)user.save();
                String address = "events_logged_in.jsp";
                RequestDispatcher rd = request.getRequestDispatcher(address);
                rd.forward(request, response);
                break;
            }
        }

//            String username = request.getParameter("username");
//            String password = request.getParameter("password");
//            String email = request.getParameter("email");
//
//            user.setUsername(username);
//            user.setPassword(password);
//            user.setEmail(email);
//
//            String upit = "UPDATE set users set username ='" + username + "', password ='" + password + "',"
//                    + " email ='" + email + "';'";
//
//            Connection con = null;
//            Statement st = null;
//            ResultSet rs = null;
//
//            String adresa = "";
//
//            try {
//                con = Database.getInstance().getConnection();
//                st = con.createStatement();
//                st.executeQuery(upit);
//                st.close();
//                con.close();
//            } catch (SQLException ex) {
//                sesija.invalidate();
//                sesija.setAttribute("poruka", "Poruka o gresci: " + ex);
//                adresa = "greska.jsp";
//            } finally {
//                DB.getInstance().putConnection(con);
//            }
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
