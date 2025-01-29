<%@page import="sun.security.provider.certpath.ResponderId"%>
<%@page import="java.util.ArrayList"%>
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
        <link href="css/seleccionRestaurante.css" rel="stylesheet" type="text/css">
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
            <div class="restaurantes">
                <div class="lista_restaurantes">
                    
                        <ul>
                            <%  ArrayList<Restaurante> restaurantes = (ArrayList<Restaurante>) request.getAttribute("restaurantes");
                                for (int i = 0; i < restaurantes.size(); i++) {
                                    out.print("<li> <figure>");
                                    //?name=Italiani
                            %>
                            <img src="Imagenes\italiano.jpg" width="240" height="200">
                            <% out.print("</figure> ");%>
                            <a href="verRestauranteDeAdmin?id=<%=restaurantes.get(i).getId()%>" ><!-- cambiar -->
                               <%
                                   out.print("<p>    " + restaurantes.get(i).getNombre() + "</p></a>"
                                           + "");
                                   request.setAttribute("restaurante", restaurantes.get(i).getId());
                                   
                                   
                               %>
                               <img src="Imagenes\stars.png" width="150" height="40">
                                <%
                                    out.print("<p>" + restaurantes.get(i).getDireccion() + "</p>");
                                    
                                %>
                                <a href="reservasAdmin.jsp?id=<%=restaurantes.get(i).getId()%>"><input type="submit" value="gestionar reserva" ></a>
                                </li>
                                <% }   %>

                        </ul>
                </div>
                <a href="registro_restaurante.html"><input type="submit" value="agregar restaurante"></a>
            </div>
        </div>
    </body>

</html>
