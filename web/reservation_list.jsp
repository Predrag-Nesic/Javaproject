<%@page import="models.Reservation"%>
<%@page import="java.util.ArrayList"%>
<%@page import="models.Model"%>
<%@page import="models.Model"%>
<%@page import="models.Event"%>
<%@page import="models.Location"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="models.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% User user = (User) session.getAttribute("user");%>
<% ArrayList<Model> reservations = (ArrayList<Model>) session.getAttribute("reservations");%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reservations</title>
        <link rel="stylesheet" type="text/css" href="styles.css">
        <link href="https://cdn.datatables.net/1.10.23/css/jquery.dataTables.min.css" type="text/css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdn.datatables.net/1.10.23/js/jquery.dataTables.min.js"></script>
    </head>
    <body>
        <header>
            <h1>Cultural institute "ARTerie"</h1>
            <nav class="nav">
                <div class="list">
                    <div><a href="index.jsp">Homepage</a></div>
                    <div><a href="events">Events</a></div>
                    <div><a href="contact.jsp">Contact</a></div>
                    <div><a href="registration.jsp">Sign up</a></div>
                    <div><a href="login.jsp">Login</a></div>
                    <div><a href="admin_login.jsp">Admin login</a></div>
                    <div id="logout"><a href="logout">Logout</a></div>
                </div>
            </nav>
        </header>

        <div id="events">
            <h2>Events</h2>
            <table id="myTable">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Event</th>
                        <th>Ground floor tickets</th>
                        <th>Balcony tickets</th>
                    </tr>
                </thead>
                <tbody>

                    <% for (Model reservation : reservations) {
                            session = request.getSession();
                            Reservation r = (Reservation) reservation;
                            if(user.getUsername().equals(r.getUsername())) {%>
                    <tr>
                        <td><%= r.getId()%></td>
                        <td><%= r.getEvent_name()%></td>
                        <td><%= r.getGfloor_tickets()%></td>
                        <td><%= r.getBalcony_tickets()%></td>
                        <% }%>
                    </tr>
                    <% }%>

                </tbody>
            </table>             
            <script>
                $(document).ready(function () {
                    $('#myTable').DataTable({
                        "paging": true,
                        "pagingType": "full_numbers"
                    });
                });
            </script>
            
            <h2>Erase reservation</h2>
            <form action="remove3" method="post">
                <input type="number" name="reservation_id" placeholder="Reservation ID"><br>
                <input type="submit" value="Submit"><br><br><hr>
            </form>
            
            <a href="events_logged_in.jsp">Back to events</a>
        </div>

        <footer>
            <address>
                Predrag Nesic, <br>Delovi 12, <br>Belgrade 11231 Rakovica <br>Republic of Serbia
            </address>
        </footer>


    </body>
</html>
