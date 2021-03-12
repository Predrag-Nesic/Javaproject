<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String message = (String)request.getAttribute("message");%>
<% String back = (String)request.getAttribute("back");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error page</title>
        <link rel="stylesheet" type="text/css" href="styles.css">
    </head>
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
    <body>
        <div id="error">
            <h2>Error</h2><br>
            <p>${message}</p><br>
<!--            <a href="${back}" style="color: #0000EE"><--Back</a>-->
        </div>

        <footer>
            <address>
                Predrag Nesic, <br>Delovi 12, <br>Belgrade 11231 Rakovica <br>Republic of Serbia
            </address>
        </footer>

    </body>

</html>
