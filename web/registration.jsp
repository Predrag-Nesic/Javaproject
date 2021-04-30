<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration</title>
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
        <div id="form_registration">
            <h2>Registration</h2>
            <form action="register" method="post">
                <input type="text" name="username" 
                       placeholder="Username"><br>
                <input type="password" name="password" 
                       placeholder="Password"><br>
                <input type="password" name="password_repeat" 
                       placeholder="Password repeat"><br>
                <input type="text" name="first_name"
                       placeholder="First name"><br>
                <input type="text" name="last_name"
                       placeholder="Last name"><br>        
                <input type="text" name="address"
                       placeholder="Address"><br>
                <input type="text" name="city"
                       placeholder="City"><br>
                <input type="number" name="telephone"
                       placeholder="Telephone"><br>
                <input type="text" name="email"
                       placeholder="Email"><br>

                <input type="submit" value="Submit">
            </form>
        </div>

        <footer>
            <address>
                Predrag Nesic, <br>Delovi 12, <br>Belgrade 11231 Rakovica <br>Republic of Serbia
            </address>
        </footer>
    </body>
</html>
