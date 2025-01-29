<%-- 
    Document   : registroCliente
    Created on : 2 jul. 2022, 19:22:37
    Author     : roger
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Famélico</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon" href="Imagenes\iconoFamelico.png">
        <link href="css/registros.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <div id="contenedor">
            <div id="logo">        
                <a href=index.jsp>
                    <figure>
                        <img alt="logo" src="Imagenes\logo_provi.png" height="97" width="415">
                    </figure>
                </a>
            </div>

            <div id="registro_Cliente">
                <h2>Registrarse como cliente</h2>
                <form method= "post" action="registrocliente">
                    <%
                        
                        if(request.getAttribute("fallo")=="yes")
                            out.print("<H3> ERROR AL INICIAR SESION</H3>");
                        
                        
                        if(request.getAttribute("fallo")=="existe")
                            out.print("<H3> ERROR USUARIO O EMAIL YA EXISTEN</H3>");
                        %>
                    <p>Email:</p>
                    <p><input name="email" type="text" size="25" maxlength="30"></p>
                    <p>Usuario:</p>
                    <p><input name="nombre" type="text" size="25" maxlength="30"></p>
                    <p>Contraseña:</p>
                    <p><input name="contrasena" type="text" size="25" maxlength="30"></p>
                    <a> <input id="boton_registroUser" type= "submit" value= "Registrarse"> </a>
                </form>
                
                
            </div>
        </div>
    </body>
</html>