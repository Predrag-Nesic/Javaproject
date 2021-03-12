<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administrator</title>
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
            <h2>Add user</h2>
            <form action="admin_registrates_user" method="post">
                <input type="text" name="username" placeholder="Username"><br>
                <input type="password" name="password" placeholder="Password"><br>
                <input type="password" name="password_repeat" placeholder="Ponovi password"><br>
                <input type="text" name="first_name" placeholder="First name"><br>
                <input type="text" name="last_name" placeholder="Last name"><br>        
                <input type="text" name="address" placeholder="Address"><br>
                <input type="text" name="city" placeholder="City"><br>
                <input type="text" name="telephone" placeholder="Telephone"><br>
                <input type="text" name="email" placeholder="Email"><br>
                <input type="submit" value="Submit"><br><br>
            </form>
            <form action="remove" method="post">
                <h2>Remove user</h2>
                <input type="text" name="username" placeholder="Username"><br>
                <input type="submit" value="Submit"><br>
            </form>
            <hr>

            <h2>Add ticket agent</h2>
            <form action="emp_registration" method="post">
                <input type="text" name="username" placeholder="Username"><br>
                <input type="password" name="password" placeholder="Password"><br>
                <input type="password" name="password_repeat" placeholder="Ponovi password"><br>
                <input type="text" name="first_name" placeholder="First name"><br>
                <input type="text" name="last_name" placeholder="Last name"><br>        
                <input type="text" name="location" placeholder="Location"><br>
                <input type="submit" value="Submit"><br><br>
            </form>
            <h2>Remove ticket agent</h2>
            <form action="remove" method="post">
                <input type="text" name="username" placeholder="Username"><br>
                <input type="submit" value="Submit"><br>
            </form>
        </div>
    </div

    <footer>
        <address>
            Predrag Nesic, <br>Delovi 12, <br>Belgrade 11231 Rakovica <br>Republic of Serbia
        </address>
    </footer>

</body>
</html>

