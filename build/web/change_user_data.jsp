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
        <div id="change">
            <h2>Change data</h2>
            <form action="change1" method="get">
                <input type="text" name="username" id="username" placeholder="Change username"><br>
                <input type="password" name="password" id="password" placeholder="Change password"><br>
                <input type="text" name="email" id="email" placeholder="Change email"><br>
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
