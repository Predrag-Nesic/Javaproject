package servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Event;
import models.Location;
import models.Model;

public class EventInputServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        Event event = new Event();
        event.setName(request.getParameter("name"));
        event.setDate(request.getParameter("date"));
        event.setGfloor_tickets(Long.parseLong(request.getParameter("gfloor_tickets")));
        event.setBalcony_tickets(Long.parseLong(request.getParameter("balcony_tickets")));
        event.setLocation((String) session.getAttribute("employee_location"));

        event = (Event) event.save();

        session.setAttribute("event_id", event.getId());
        session.setAttribute("event", event);

        ArrayList<Model> locations = Location.all(Location.class);
        for (Model location : locations) {
            Location l = (Location) location;
            if (event.getLocation().equals(l.getName())) {
                session.setAttribute("location_id", l.getId());
            }
        }

        if (event.getId() > 0) {
            response.sendRedirect("event_input2");
        } else {
                response.sendRedirect("event_input");
        }
    }
}
