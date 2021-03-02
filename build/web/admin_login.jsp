<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin login</title>
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
        <div id="admin_registration">
            <h2>Admin registration</h2>
            <form action="emp_login" method="get">
                <input type="text" name="username" id="username" placeholder="Enter username"><br>
                <input type="password" name="password" id="password" placeholder="Enter password"><br>
                <label for="is_admin">Admin:</label>
                <input type="text" name="is_admin" id="is_admin" placeholder="Enter '1' or '0'"><br>
<!--                <select name="is_admin" id="is_admin">
				<option value="yes" selsected>Yes</option>
				<option value="no">No</option>
                </select><br>-->
<!--                <input type="number" name="is_admin" id="is_admin" placeholder="Type 1 for 'yes', 0 for 'no'">-->
                <input type="submit"value="Submit">
            </form>
        </div>
        <footer>
            <address>
                Predrag Nesic, <br>Delovi 12, <br>Belgrade 11231 Rakovica <br>Republic of Serbia
            </address>
        </footer>
    </body>
</html>
