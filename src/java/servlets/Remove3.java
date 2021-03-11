/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import models.Model;
import models.Reservation;

/**
 *
 * @author Predrag
 */
public class Remove3 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String address = "error.jsp";
        
        HttpSession session = request.getSession();
        ArrayList<Model> reservations = Reservation.all(Reservation.class);
            for (Model reservation : reservations) {
                Reservation r = (Reservation) reservation;
                if (r.getId() == Integer.parseInt(request.getParameter("reservation_id")) 
                        && r.getUsername().equals((String)session.getAttribute("username"))) {
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
                    address = "events_logged_in.jsp";
                    r.delete();
                    RequestDispatcher rd = request.getRequestDispatcher(address);
                    rd.forward(request, response);
                }
            }
            String message = "Incorrect reservation ID";
            request.setAttribute("message", message);
            RequestDispatcher rd = request.getRequestDispatcher(address);
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
