<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registracija</title>
    </head>
    <body>
     
            <h1>Registruj se</h1>
            
            <form action="registrujse" method="post">
                <input type="text" name="username" 
                       placeholder="Username"><br>
                <input type="password" name="password" 
                       placeholder="Password"><br>
                <input type="password" name="password_repeat" 
                       placeholder="Ponovi password"><br>
                <input type="text" name="ime"
                       placeholder="Ime"><br>
                <input type="text" name="prezime"
                       placeholder="Prezime"><br>        
                <input type="text" name="adresa"
                       placeholder="Adresa"><br>
                <input type="text" name="grad"
                       placeholder="Grad"><br>
                <input type="text" name="telefon"
                       placeholder="Telefon"><br>
                <input type="text" name="email"
                       placeholder="Email"><br>

                <input type="submit" value="Registruj se">
            </form>
        </div>

        <footer>
            <address>
                Predrag Nesic, <br>Delovi 12, <br>Belgrade 11231 Rakovica <br>Republic of Serbia
            </address>
        </footer>
    </body>
</html>
