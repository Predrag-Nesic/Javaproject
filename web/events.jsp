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
                            Event e = (Event) event;%>
                    <tr>
                        <td><%= e.getName()%></td>
                        <td><%= e.getDate()%></td>
                        <td><%= e.getLocation()%></td>
                        <td>
                            <form action="#" id="input">
                                <input type="number" name="gfloor_tickets"
                                       placeholder="Ground floor" disabled="Login to continue">
                                <input type="number" name="balcony_tickets"
                                       placeholder="Balcony" disabled="Login to continue">
                                <input type="submit" value="Reserve" onclick="openAlert('Login to continue')">
                            </form>
                            <script>
                                function openAlert(message) {
                                    alert(message);
                                }
                            </script>
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
        </div>
        <!-- all the events can also be displayed using standard divs, instead of the table above-->
        <!--        <div id="events">
                    <h2>Events</h2>
        
                    <div>
        

    </div>
                <div id="event_one">Event 1</div>
                <div>Event 2</div>
                <div>Event 3</div>
                <div>Event 4</div>
                <div>Event 5</div>
                <div>Event 6</div>
                <div>Event 7</div>
                <div>Event 8</div>
                <div>Event 9</div>
                <div>Event 10</div>
                <div>Event 11</div>
                <div>Event 12</div>
</div>-->

        <footer>
            <address>
                Predrag Nesic, <br>Delovi 12, <br>Belgrade 11231 Rakovica <br>Republic of Serbia
            </address>
        </footer>


    </body>
</html>
