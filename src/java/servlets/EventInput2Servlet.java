package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Event;
import models.Location;
import models.Model;

public class EventInput2Servlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        Location location = new Location();
        location = (Location) location.find((Integer) session.getAttribute("location_id"));
        Event event = new Event();
        event = (Event) event.find((Integer) session.getAttribute("event_id"));

        if (event.getBalcony_tickets() <= location.getBalcony_capacity()
                && event.getGfloor_tickets() <= location.getGfloor_capacity()) {
            ArrayList<Model> events = Event.all(Event.class);
            session.setAttribute("events", events);
            response.sendRedirect("ticket_agent.jsp");

        } else {
            event.delete();
            String message = "Cannot add event, the total number of tickets exceeds ground floor or balcony capacity.";
            request.setAttribute("message", message);
            String address = "error.jsp";
            RequestDispatcher rd = request.getRequestDispatcher(address);
            rd.forward(request, response);

//            String address = "ticket_agent.jsp";
//            session.setAttribute("address", address);
////            session.setAttribute("address", address);
//            response.sendRedirect("redirect.jsp");
        }
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
