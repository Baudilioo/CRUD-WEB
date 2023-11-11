<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h2>Login</h2>
    <form action="LoginServlet" method="post">
        Nombre de usuario: <input type="text" name="nombreUsuario" required><br>
        Contraseña: <input type="password" name="contrasena" required><br>
        <input type="submit" value="Login">
    </form>

    <% if (request.getParameter("error") != null) { %>
        <p style="color: red;">Error de autenticaciÃ³n. Por favor, intentelo de nuevo.</p>
    <% } %>
</body>
</html>
