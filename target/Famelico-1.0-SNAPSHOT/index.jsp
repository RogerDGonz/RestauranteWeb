<!DOCTYPE html>
<html>
    <head>
        <title>Famélico</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" href="Imagenes\iconoFamelico.png">
        <link href="css/principal.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <div id="contenedor">
            <div id = "banner" >
                <img alt = "logo" src="Imagenes/logo_provi.png" height="97" width="415">
            </div>
            
            <div id="opciones">
                <a href="registro_cliente.html">
                    <input id=boton_reg_user value="Registrarse como usuario" type =submit>
                </a>
                <a href="registroAdmin.jsp">
                    <input id=boton_reg_admin value="Registrarse como admin" type =submit>
                </a>
                <a href="iniciar_sesion.jsp">
                    <input id=boton_log value="Iniciar sesion" type =submit>
                </a>
            </div>
            
            <div id = "busqueda">
                
                    <h1>Encuentra tu restaurante</h1>
                    <p>Localización:</p>
                    <p><input name ="localización" type="text" size="50" maxlength="100"></p>
                    <p>Nombre:</p>
                    <p><input name ="nombre" type="text" size="50" maxlength="100"></p>
                    <a href="seleccion_restaurante.html">
                        <p><input id=boton_buscar value="Buscar" name = "boton_buscar" type =button></p>
                    </a>
            </div>
        </div>
        
    </body>
</html>
