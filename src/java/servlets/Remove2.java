package servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Event;
import models.Model;
import models.Reservation;

public class Remove2 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        boolean check = true;
        String address = "ticket_agent.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(address);
        while (check) {
            ArrayList<Model> events = Event.all(Event.class);
            for (Model event : events) {
                Event e = (Event) event;
                if (e.getName().equals(request.getParameter("name"))) {
                    e.delete();
                    rd.forward(request, response);
                }
            }
            check = false;
        }

        while (!check) {
            ArrayList<Model> reservations = Reservation.all(Reservation.class);
            for (Model reservation : reservations) {
                Reservation r = (Reservation) reservation;
                if (r.getId() == Integer.parseInt(request.getParameter("reservation_id"))) {
                    long r_gfloor_tickets = r.getGfloor_tickets();
                    long r_balcony_tickets = r.getBalcony_tickets();
                    
                    ArrayList<Model> events = Event.all(Event.class);
                    for(Model event : events) {
                        Event e = (Event)event;
                        if(r.getEvent_name().equals(e.getName())) {
//                            long e_gfloor_tickets = e.getGfloor_tickets() + r_gfloor_tickets;
//                            long e_balcony_tickets = e.getBalcony_tickets() + r_balcony_tickets;
                            e.setGfloor_tickets(e.getGfloor_tickets() + r_gfloor_tickets);
                            e.setBalcony_tickets(e.getBalcony_tickets() + r_balcony_tickets);
                            e.save();
                        }
                    }
                    
                    r.delete();
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
