<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ticket agent</title>
        <link rel="stylesheet" type="text/css" href="styles.css">
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

        <div id="event_input">
            <h2>Event input</h2><br>
            <form action="event_input" method="post">
                <input type="text" name="name" placeholder="Event name"><br>
                <input type="date" name="date" placeholder="Event date"><br>
                <input type="number" name="gfloor_tickets" placeholder="Ground floor tickets"><br>
                <input type="number" name="balcony_tickets" placeholder="Balcony tickets"><br>
                <input type="submit" value="Submit"><br><br><hr>
            </form>

            <h2>Erase event</h2><br>
            <form action="remove2" method="post">
                <input type="text" name="name" placeholder="Event name"><br>
                <input type="submit" value="Submit"><br><br><hr>
            </form>
            
            <h2>Reservation input</h2>
            <form action="reservation_input2" method="post">
                <input type="text" name="username" placeholder="Username"><br>
                <input type="text" name="event_name" placeholder="Event name"><br>
                <input type="number" name="gfloor_tickets" placeholder="Ground floor tickets"><br>
                <input type="number" name="balcony_tickets" placeholder="Balcony tickets"><br>
                <input type="submit" value="Submit"><br><br><hr>
            </form>
            
            <h2>Erase reservation</h2><br>
            <form action="remove2" method="post">
                <input type="number" name="reservation_id" placeholder="Reservation ID"><br>
                <input type="submit" value="Submit"><br><br>
            </form>
        </div>

        <footer>
            <address>
                Predrag Nesic, <br>Delovi 12, <br>Belgrade 11231 Rakovica <br>Republic of Serbia
            </address>
        </footer>
    </body>
</html>
