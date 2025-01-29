<%@page import="modelos.Usuario"%>
<%@page import="modelos.Restaurante"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Famélico</title>
        <meta charset="UTF-8">
        <link rel="icon" href="Imagenes\iconoFamelico.png">
        <link href="css/opciones.css" rel="stylesheet" type="text/css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/vistaRestaurante.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <div id="contenedor">
        <div class="logo">        
                <form action="seleccionRestauranteServlet" method="post">
                    <figure>
                        <input type=image src="Imagenes\logo_provi.png" height="97" width="415">
                    </figure>
              
                    </form>
                  
        </div>
        
        <div id="opcionessesion">
             <%
                    Usuario usuario = (Usuario) session.getAttribute("usuario");
                    out.print("<h2>" + usuario.getNombre() + "</h2>");

                %>
            <a href="reservas_clientes.html"><h2>mis reservas</h2></a>
            <a href="index.jsp"><h2>Cerrar sesión</h2></a>
        </div>
        
        <div class="busquedas" >
            <form method="post" action="procesarbusqueda" id="busquedas"> 
                <p id="busquedaNombre">busqueda por nombre:  <input name="nombrerestaurante" type="text" size="25" maxlength="50"></p> 
                <p id="busquedaLocalizacion">busqueda por localización    :  <input name="localizacion" type="text" size="25" maxlength="50"></p>     
            </form>
        </div>
        
        <!-- información del restaurante -->
        <div class="datos_restaurantes">
            <div class="informacion_general">
                <%
                        Restaurante restaurante = (Restaurante) request.getAttribute("restaurante");
                        out.print("<h1>" + restaurante.getNombre() + "</h1>");
                     
                  %>     
                 <figure>
                        <img src="Imagenes\stars.png" width="150" height="50">
                </figure>
              <%
                    out.print("<h4>" + restaurante.getDireccion() + "</h4>"  );
                            %>

            </div>
            <div class="imagenes">
                <figure>
                    <img src="Imagenes\italiano.jpg" width="240" height="200">
                </figure>
            </div>
            <div class="descripcion">
                <h4>Descripción: 
                <% 
                    out.print("<p>" + restaurante.getDescripcion() + "</p>");
                            %>
                </h4>

            <%
                 
                    %>
            </div>
        </div>
       <!-- -->
       <!-- comentarios y menú-->
        <div class="botones_rapidos">
            <input type="submit" value="comentarios">
            <input type="submit" value="ver Carta">
        </div>
        <!-- lista de comentarios -->
        <div class="comentarios">
            <ul>
                <li>
                    <h5>UsuarioComentando</h5> 
                    <figure>
                        <img src="Imagenes\stars.png" width="150" height="50">
                    </figure> 
                    <p>Hola soy un comentario</p>
                </li>

                <li><h5>UsuarioHater</h5> 
                    <figure>
                        <img src="Imagenes\stars.png" width="150" height="50">
                    </figure> 
                    <p>como odio la comida italiana</p>
                </li>

                <li><h5>ItalianLover</h5> 
                    <figure>
                        <img src="Imagenes\stars.png" width="150" height="50">
                    </figure> 
                    <p>La comida Italiana es la molto mejor del mundo mamma mia</p>
                </li>
            </ul>
        </div>
        
        <div class="comentar">
            <textarea name="comentarioUsuario" rows="10" cols="50">Write something here</textarea>
            <form>
                <p class="clasificacion">
                <!-- valoracion en 5 estrellas dependiendo de la posición del button ratio  -->
                 <input id="radio1" type="radio" name="estrellas" value="5"><!--
                 --><label for="radio1">?</label><!--
                 --><input id="radio2" type="radio" name="estrellas" value="4"><!--
                 --><label for="radio2">?</label><!--
                 --><input id="radio3" type="radio" name="estrellas" value="3"><!--
                 --><label for="radio3">?</label><!--
                 --><input id="radio4" type="radio" name="estrellas" value="2"><!--
                 --><label for="radio4">?</label><!--
                 --><input id="radio5" type="radio" name="estrellas" value="1"><!--
                 --><label for="radio5">?</label>
               </p>
            </form>
            <input type="submit" value="añadir comentario">
        </div>
        
        <div class="menu">

            <ul>
                <li>
                    <h6>Pizza Margarita.......8?</h6> 
                </li>

                <li>
                    <h6>Pasta carbonara.......15?</h6> 
                </li>

                <li><h6>limonada.......2?</h6> 
                </li>
            </ul>
        </div>
        
        <div class="reservar">
            
            <form action="reservar" method="post"> 
            <input type="datetime-local" id="reserva" name="fecha" required="required"> 
            <p>número personas</p>
                <select name="personas">
                    <option>1</option>
                    <option>2</option>
                    <option>4</option>
                    <option>6</option>
                    <option>8</option>
                    <option>10</option>
                </select>

            <input type="submit" value="RESERVAR">

            </form>
        </div>
        </div>
    </body>
</html>
