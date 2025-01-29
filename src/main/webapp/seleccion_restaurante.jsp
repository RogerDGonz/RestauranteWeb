<%@page import="modelos.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelos.Restaurante"%>
<%@page import="persistencia.ConnectionPool"%>
<!DOCTYPE html>

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

            <!-- esto deberia estar arriba a la derecha -->
            <div id="opcionessesion">
                 <%
                    Usuario usuario = (Usuario) session.getAttribute("usuario");
                    out.print("<h2>" + usuario.getNombre() + "</h2>");

                %>
                
                 <form method="post" action="VerReservas">
               
                
                <input type="submit" value="mis reservas" id="misreservas"  >
                </form>
                <a href="index.jsp" id="cerrasesion"><h2>Cerrar sesión</h2></a>
            </div>    

            <div class="busquedas" >   
                <div method="post" action="procesarbusqueda" id="busquedas"> 
                    <p id="busquedaNombre">busqueda por nombre:  <input name="nombrerestaurante" type="text" size="25" maxlength="50"></p> 
                    <p id="busquedaLocalizacion">busqueda por localización    :  <input name="localizacion" type="text" size="25" maxlength="50"></p>     
                </form>
            </div> 
            <div id="contenidoBusqueda">
                <div class="filtro" id="filtroNav">
                    <form method="post" action="filtrado">
                        <p>filtrar resultados por</p>
                        <div class="categoriaas">
                            <p>Categorías: </p>
                            <% 
                            ArrayList<String> categorias = (ArrayList<String>)request.getAttribute("categorias");
                                for (int i = 0; i < categorias.size(); i++) {
                                        out.print("<p>"+ categorias.get(i) + ""
                                        + "<input name=" + '"' +  categorias.get(i) +'"' +
                                        "type=" + '"' + "checkbox" + '"' + "</p>");
                                    }
                            %>
                            
                        </div>
                        <div class="precios">
                            <p>precio</p>
                            <select>
                                <option>10?</option>
                                <option>15?</option>
                                <option>30?</option>
                                <option>80?</option>
                                <option>100?</option>
                                <option>+500?</option>
                            </select>
                        </div>

                        <div class="opciones_reservas">
                            <p>día: <input type="date"></p>
                            <p>hora: <input type="time"></p>
                            <p>número personas</p>

                            <select>
                                <option>1</option>
                                <option>2</option>
                                <option>4</option>
                                <option>6</option>
                                <option>8</option>
                                <option>10</option>
                            </select>
                        </div>    
                        <div class="botones_filtro">
                            <input type="submit" value="quitar filtros">
                            <p><a href=seleccion_restaurante.html><input type= "submit" value= "Filtar"></a></p>
                        </div>
                    </form>
                </div>
                <%@page import="java.sql.*"%>
            <div   class="respuesta" >
                  
                <% 
                        ArrayList<Restaurante> restaurantes = (ArrayList<Restaurante>) request.getAttribute("restaurantes");
                           
                           for (int i = 0; i < restaurantes.size(); i++) {
                                   out.println("<li> "
                                + "<h4>" + restaurantes.get(i).getNombre() + "<h4>");
                               
                                
                                
                                 out.print(" <a  href= " + '"' + "verRestauranteCliente?name=" +  restaurantes.get(i).getNombre() + '"' + ">"); %>
           
                         
                            <figure >
                                <img src="Imagenes\italiano.jpg" width="240" height="200">
                             </figure>
                                      </a> 
                          <figure>
                                 <img src="Imagenes\stars.png" width="150" height="50">
                            </figure>
                            </li>
                         <%
                            }
                        %>
                        <%
                            
                        
                   
                    
                   %>
            </div>
            </div>
        </div>
    </body>
</html>
