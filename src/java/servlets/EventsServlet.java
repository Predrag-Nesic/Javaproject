package servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Event;
import models.Model;
import models.User;

public class EventsServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        ArrayList<Model> events = Event.all(Event.class);
        session.setAttribute("events", events);
        String address = null;
        
        if (session.getAttribute("user") != null) {
            address = "events_logged_in.jsp";
            RequestDispatcher rd = request.getRequestDispatcher(address);
            rd.forward(request, response);
        } else {
            address = "events.jsp";
            RequestDispatcher rd = request.getRequestDispatcher(address);
            rd.forward(request, response);
        }
        
// MOZE I OVAKO!!!
        
        
//        ArrayList<Model> users = User.all(User.class);
//
//        for (Model user : users) {
//            User u = (User) user;
//            if (session.getAttribute("username").equals(u.getUsername())) {
//                address = "events_logged_in.jsp";
//            } else {
//                address = "events.jsp";
//            }
//        }
//
//        rd.forward(request, response);
        
        
        
        


// SKLEPANO, ALI MOGLO BI I OVAKO
//        boolean check = true;
//        
//
//        while (check) {
//            for (Model user : users) {
//                User u = (User)user;
//                if(session.getAttribute("username") == null) {
//                    break;
//                }
//                if (session.getAttribute("username").equals(u.getUsername())) {
//                    address = "events_logged_in.jsp";
//                    rd.forward(request, response);
//                }
//            }
//            check = false;
//        }
//        
//        check = false;
//        //SKLEPANO, MORAS DA PROVERIS DA LI JE DOBRO!
//        ArrayList<Model> employees = Employee.all(Employee.class);
//        
//        while (!check) {
//            for (Model employee : employees) {
//                Employee e = (Employee)employee;
//                if (session.getAttribute("employee_username").equals(e.getUsername()) &&
//                        session.getAttribute("employee_is_admin").equals
//                        (e.getIs_admin())) {
//                    address = "index.jsp";
//                    response.sendRedirect(address);
////                    rd.forward(request, response);
//                }
//            }
//            check = true;
//        }
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
