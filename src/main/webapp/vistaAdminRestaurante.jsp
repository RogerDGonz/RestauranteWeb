<%@page import="persistencia.RestauranteDB"%>
<%@page import="modelos.Restaurante"%>
<%@page import="modelos.Usuario"%>
<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
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
        <div class="contenedor">
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
               
                <a href="index.jsp"><h2>Cerrar sesión</h2></a>
            </div>

            <div class="busquedas">
                <form method="post" action="procesarbusqueda"> 
                    <p>busqueda por nombre:  <input name="nombrerestaurante" type="text" size="25" maxlength="50"></p> 
                    <p>busqueda por localización    :  <input name="localizacion" type="text" size="25" maxlength="50"></p>     
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
                     <% out.print("<h4>" + restaurante.getDireccion() + "</h4>" ); %>
                    <input type="submit" value="editar fotos">
                 </div>
                 <div class="imagenes">
                    <figure>
                        <img src="Imagenes\italiano.jpg" width="240" height="200">
                    </figure>
                 </div>
                 <div class="descripcion">
                    <h4>Descripción: </h4> 
                    <input type="submit" value="Editar descripción">
                    <textarea name="comentarioUsuario" rows="10" cols="50"><%= restaurante.getDescripcion() %></textarea>
                 </div>   
             </div>
                          <div class="mesas">
                 <h4>mesas</h4> 
                 <input type="submit" value="añadir mesa">
                 <ul>
                    
                   <li>    
                           <h5>2 sillas: 4</h5>
                   </li>
                   <li>    
                           <h5>4 sillas: 8</h5>
                   </li>
                   <li>    
                           <h5>8 sillas: 3</h5>
                   </li>
                   <li>    
                           <h5>10 sillas: 1</h5>
                   </li>
                </<ul>
                    
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
                        <input type="submit" value="responder comentario">
                    </li>

                    <li><h5>UsuarioHater</h5> 
                        <figure>
                            <img src="Imagenes\stars.png" width="150" height="50">
                        </figure> 
                        <p>como odio la comida italiana</p>
                        <input type="submit" value="responder comentario">
                    </li>

                    <li><h5>ItalianLover</h5> 
                        <figure>
                            <img src="Imagenes\stars.png" width="150" height="50">
                        </figure> 
                        <p>La comida Italiana es la molto mejor del mundo mamma mia</p>
                        <input type="submit" value="responder comentario">
                    </li>
                </ul>
             </div>
             <div  class="carta">
                <h5>Carta: </h5>
                <p>Nombre ........ Precio</p>

                <ul>
                    <li>
                        <h6>Pizza Margarita</h6> 
                        <p>.......</p>
                        <input type="number"  name="precio" min="1" max="999" value="8">
                        <p>?</p>
                        <input type="submit" value="editar">
                        <input type="submit" value="eliminar">
                    </li>

                    <li>
                        <h6>Pasta carbonara</h6> 
                        <p>.......</p>
                        <input type="number"  name="precio" min="1" max="999" value="15">
                        <p>?</p>
                        <input type="submit" value="editar">
                        <input type="submit" value="eliminar">
                    </li>

                    <li><h6>limonada</h6> 
                        <p>.......</p>
                        <input type="number"  name="precio" min="1" max="999" value="2">
                        <p>?</p>
                        <input type="submit" value="editar">
                        <input type="submit" value="eliminar">
                    </li>
                </ul>

                <input type="submit" value="añadir Producto">
            </div>

        </div>
    </body>
</html>
