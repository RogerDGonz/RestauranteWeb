<!DOCTYPE html>

<html>
    <head>
        <title>Famélico</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon" href="Imagenes\iconoFamelico.png">
        <link href="css/inicioSesion.css" rel="stylesheet" type="text/css">
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
            <div id="sesion">
                <h1>Iniciar sesión</h1>

                <form method="post" action="iniciarsesion">
                    <p>Email:</p>
                    <%
                        
                        if(request.getAttribute("fallo")=="yes")
                            out.print("<H3> ERROR AL INICIAR SESION</H3>");
                        
                        
                        if(request.getAttribute("fallo")=="existe")
                            out.print("<H3> ERROR AL USUARIO O EMAIL YA EXISTEN</H3>");
                        %>
                    <p><input name="email" type="text" size="25" maxlength="30"></p>
                    <p>Contraseña:</p>
                    <p><input name="con" type="text" size="25" maxlength="30"></p>
                    <input id="boton_identificarse" type="submit" value="Confirmar">
                </form>
                
            </div>
        </div>
    </body>
</html>
