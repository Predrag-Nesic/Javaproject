<%@page import="models.Message"%>
<%@page import="java.util.ArrayList"%>
<%@page import="models.Model"%>
<%@page import="models.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% User user = (User) request.getAttribute("user"); %>
<% ArrayList<Model> messages = (ArrayList<Model>) request.getAttribute("messages");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Homepage</title>
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
        <div id="main">
            <h2>Main</h2>
            <div id="text">
                <p>
                    Lorem ipsum, dolor sit amet consectetur adipisicing elit. Nostrum, quod reiciendis, blanditiis maxime eveniet laudantium sapiente possimus libero maiores aspernatur natus reprehenderit aliquam cum sint incidunt aliquid excepturi repudiandae officiis?
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptates cumque vitae tempora, unde accusamus obcaecati sapiente natus modi explicabo facere soluta quam praesentium neque. Iusto fugiat architecto ducimus ut beatae?
                    Lorem ipsum dolor sit, amet consectetur adipisicing elit. Quidem nam est nesciunt explicabo qui laboriosam? In officia, magni earum maxime mollitia cum dolorem, assumenda, quod voluptas illum libero id repudiandae!
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Dignissimos doloribus quibusdam accusantium aperiam quasi quam nisi, quae iste, vitae molestias facere necessitatibus provident blanditiis nostrum explicabo laudantium incidunt molestiae?
                </p>
            </div>
            <h2>News</h2>
            <div id="news">
                <p>
                <ul>
                    <li>
                        <h3>Lorem</h3>
                        <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Labore quia soluta nesciunt eveniet aspernatur voluptas ipsa dignissimos debitis ea. Molestias ut at tenetur aliquid aperiam commodi vero officia dolorem excepturi!</p>
                    </li>
                    <li>
                        <h3>Lorem</h3>
                        <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Expedita culpa illo incidunt nisi totam, aliquid consequuntur voluptas maiores nesciunt nihil dolor, dolore tenetur, natus sed! Doloremque quis harum nostrum, culpa?</p>
                    </li>
                    <li>
                        <h3>Lorem</h3>
                        <p>Lorem ipsum dolor sit amet, consectetur, adipisicing elit. Enim, reiciendis ducimus deserunt fugit quisquam odio sunt a facere, nulla adipisci consequatur totam quidem ea molestias repudiandae perspiciatis quam assumenda quos.</p>
                    </li>
                </ul>





                </p>
            </div>
        </div>

        <footer>
            <address>
                Predrag Nesic, <br>Delovi 12, <br>Belgrade 11231 Rakovica <br>Republic of Serbia
            </address>
        </footer>

    </body>


<!--        <h2>Vas id: <%--${korisnik.getId()}--%></h2>-->

<!-- <h1>Dobro dosao <%--<%= user.getFirst_name()%>--%></h1>

<h2>Unesi poruku</h2>

<form action="send_message" method="post">
    <input type="text" name="poruka" placeholder="Unesite Vasu poruku">
    <input type="submit" value="Posalji">
</form>

    <%--<% for (Model message : messages) {%>--%>
        <h2><%--<%= ((Message) message).getKorisnik().getFirst_name()%>--%> /
    <%--<%= ((Message)message).getTime()%>--%></h2>
<p><%--<%= ((Message)message).getMessage()%>--%></p>
<hr> 
   <%-- <% }%>--%>
    
    -->

</html>
