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
import models.Reservation;
import models.User;

public class ReservationInputServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        Reservation reservation = new Reservation();
        String address = "events_logged_in.jsp";

        try {
            ArrayList<Model> users = User.all(User.class);
            for (Model user : users) {
                User u = (User) user;
                if (session.getAttribute("username").equals(u.getUsername())) {
                    ArrayList<Model> events = Event.all(Event.class);
                    for (Model event : events) {
                        Event e = (Event) event;
                        if (request.getParameter("event_name").equals(e.getName())) {
                            reservation.setUsername((String) session.getAttribute("username"));
                            reservation.setEvent_name(request.getParameter("event_name"));
                            reservation.setGfloor_tickets(Long.parseLong(request.getParameter("gfloor_tickets")));
                            long res_gfloor_tickets = reservation.getGfloor_tickets(); //new
                            reservation.setBalcony_tickets(Long.parseLong(request.getParameter("balcony_tickets")));
                            long res_balcony_tickets = reservation.getBalcony_tickets(); //new

                            if (res_gfloor_tickets < 0 || res_balcony_tickets < 0) {
                                String message = "The number of tickets must be a positive integer.";
                                request.setAttribute("message", message);
                                address = "error.jsp";
                                RequestDispatcher rd = request.getRequestDispatcher(address);
                                rd.forward(request, response);
                            }
                            long e_gfloor_tickets = e.getGfloor_tickets() - res_gfloor_tickets;
                            long e_balcony_tickets = e.getBalcony_tickets() - res_balcony_tickets;
                            e.setGfloor_tickets(e_gfloor_tickets);
                            e.setBalcony_tickets(e_balcony_tickets);
                            e = (Event) e.save();

                            reservation = (Reservation) reservation.save();
//                        response.sendRedirect(address);
                            RequestDispatcher rd = request.getRequestDispatcher(address);
                            rd.forward(request, response);
                        }
                    }
                } else {
                    String message = "Event name is not correct.";
                    request.setAttribute("message", message);
                    address = "error.jsp";
                    RequestDispatcher rd = request.getRequestDispatcher(address);
                    rd.forward(request, response);
                }

            }
        } catch (NumberFormatException ex) {
            String message = "The number of tickets must be an integer.";
            request.setAttribute("message", message);
            address = "error.jsp";
            RequestDispatcher rd = request.getRequestDispatcher(address);
            rd.forward(request, response);
        }

//        HttpSession session = request.getSession();
//        Reservation reservation = new Reservation();
//        
//        reservation.setUsername((String) session.getAttribute("username"));
//        reservation.setEvent_name((String) session.getAttribute("event_name"));
//        reservation.setGfloor_tickets(Long.parseLong(request.getParameter("gfloor_tickets")));
//        long res_gfloor_tickets = reservation.getGfloor_tickets(); //new
//        reservation.setBalcony_tickets(Long.parseLong(request.getParameter("balcony_tickets")));
//        long res_balcony_tickets = reservation.getBalcony_tickets(); //new
//        
//        // new from here...
//        ArrayList<Model> events = Event.all(Event.class);
//        for(Model event : events) {
//            Event e = (Event) event;
//            if(reservation.getEvent_name().equals(e.getName())) {
//                long e_gfloor_tickets = e.getGfloor_tickets() - res_gfloor_tickets;
//                long e_balcony_tickets = e.getBalcony_tickets() - res_balcony_tickets;
//                e.setGfloor_tickets(e_gfloor_tickets);
//                e.setBalcony_tickets(e_balcony_tickets);
//                e = (Event)e.save();  
//            }
//        }
//        // ... to here!
//        
//        reservation = (Reservation) reservation.save();
//
//        session.setAttribute("reservation", reservation);
//
//        if (reservation.getId() > 0) {
//            response.sendRedirect("events_logged_in.jsp");
//        } else {
//            String message = "Error, could not save reservation.";
//            session.setAttribute("message", message);
//            response.sendRedirect("error.jsp");
//        }
//
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
