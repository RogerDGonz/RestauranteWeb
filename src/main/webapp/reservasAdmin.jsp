<%@page import="modelos.Usuario"%>
<%@page import="persistencia.MesaDB"%>
<%@page import="persistencia.UsuarioDB"%>
<%@page import="persistencia.ReservaDB"%>
<%@page import="persistencia.RestauranteDB"%>
<%@page import="modelos.Restaurante"%>
<%@page import="modelos.Reserva"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelos.Reserva" %>
<html>
    <head>
        <title>Famélico</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon" href="Imagenes\iconoFamelico.png">
         <link href="css/opciones.css" rel="stylesheet" type="text/css">
        <link href="css/reservas.css" rel="stylesheet" type="text/css">
    </head>


    <body>
        <div id="contenedor">
            <div id="logo">        
               <form action="seleccionRestauranteServlet" method="post">
                    <figure>
                        <input type=image src="Imagenes\logo_provi.png" height="97" width="415">
                    </figure>
              
                    </form>
                <!-- esto deberia estar arriba a la derecha -->
                <div id="opcionessesion">
                     <% 
                Usuario usuario = (Usuario) session.getAttribute("usuario");
                    out.print("<h2>" + usuario.getNombre() + "</h2>");
                %>
                    <a href="reservas_admin.html"><h2 id="misreservas">mis reservas</h2></a>
                    <a href="index.jsp"><h2 id="cerrarsesion">Cerrar sesión</h2></a>
                </div>
            </div>

                    
            <div id="cuadroreservas_restaurante">
                
                <div id="listareservas">
                    <%
                        Restaurante restaurante = RestauranteDB.getRestaurante(Integer.parseInt(request.getParameter("id")));
                        out.print("<h1>" +  restaurante.getNombre()+ "</h1>");
                        %>
                    <ul id="lista">
                        <%
                            ArrayList<Reserva> reservas = ReservaDB.getReservasDeRestaurante( restaurante );
                            for (int i = 0; i < reservas.size(); i++) {
                                out.print("<li><p>"+ UsuarioDB.getUsuarioPorReserva(reservas.get(i)).getNombre() + "</p>"
                                + "<p>" + reservas.get(i).getFecha() +"</p>"
                                + "<p>" + reservas.get(i).getHora() +"</p>"//);
                                + "<p>" + MesaDB.mesaPorIdReserva(reservas.get(i)).getCapacidad()+ " personas</p>" );
                                    %>
                                    <input type="submit" value="cancelar reserva"></li>
                                    <%
                                }
                          %>
                          
                          <%       
                            //out.print("<li><p>Maria</p> <p>Restaurante Italiani</p> <p>7/10/22</p>  <p>15:30</p>  <p>4 personas  </p><input type="submit" value="cancelar reserva"></li>"); 
                            %>
                     </ul>
                </div>
            </div>
        </div>
    </body>
</html>
