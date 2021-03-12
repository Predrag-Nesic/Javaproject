<%@page import="java.util.ArrayList"%>
<%@page import="models.Model"%>
<%@page import="models.Model"%>
<%@page import="models.Event"%>
<%@page import="models.Location"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="models.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% User user = (User) request.getAttribute("user");%>
<% Location location = (Location) request.getAttribute("location");%>
<% ArrayList<Model> events = (ArrayList<Model>) session.getAttribute("events");%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Events</title>
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
                        <th>Event</th>
                        <th>Date</th>
                        <th>Location</th>
                        <th>Reserve tickets</th>
                    </tr>
                </thead>
                <tbody>

                    <% for (Model event : events) {
                            session = request.getSession();
                            Event e = (Event) event;%>
                    <tr>
                        <td><%= e.getName()%></td>
                        <td><%= e.getDate()%></td>
                        <td><%= e.getLocation()%></td>
                        <td>
                            <form action="reservation_input" id="input">
                                <% session.setAttribute("event_name", e.getName());%>
                                <input type="number" name="gfloor_tickets" placeholder="Ground floor">
                                <input type="number" name="balcony_tickets" placeholder="Balcony">
                                <input type="submit" value="Reserve">
<!--                            I have yet to figure out a way to make reservation of tickets possible in
                                the table, for now it can be done using input forms below the script tag.
                                If the user tries to do so in the table it will make reservation always for
                                the last event, because it is the last event that is situated in the session.-->
                            </form>
                        </td>
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

            <h2>Reservation input</h2>
            <form action="reservation_input" method="post">
                <input type="text" name="event_name" placeholder="Event name"><br>
                <input type="text" name="gfloor_tickets" placeholder="Ground floor tickets"><br>
                <input type="text" name="balcony_tickets" placeholder="Balcony tickets"><br>
                <input type="submit" value="Submit"><br><br>
            </form>
            <!--            
                    I've made an additional page reservation_list.jsp to ensure that only the logged in user
                    can erase his/her respectful reservation
            
                        <h2>Erase reservation</h2>
                        <form action="remove3" method="post">
                            <input type="number" name="reservation_id" placeholder="Reservation ID"><br>
                            <input type="submit" value="Submit"><br><br><hr>
                        </form>-->
            <hr>
            <a href="reservations">List of user's reservations</a>
            <hr>
            <a href="change_user_data.jsp">Change user data</a>

        </div>
        
        <footer>
            <address>
                Predrag Nesic, <br>Delovi 12, <br>Belgrade 11231 Rakovica <br>Republic of Serbia
            </address>
        </footer>


    </body>
</html>
