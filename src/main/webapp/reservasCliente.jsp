<%@page import="modelos.Restaurante"%>
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
                    <buttom>
                        <input type=image src="Imagenes\logo_provi.png" height="97" width="415">
                    </buttom>
              
                    </form>
                    <!-- esto deberia estar arriba a la derecha -->
                    <div id="opcionessesion">
                        <%
                            String nombre = (String) request.getAttribute("nombreUsuario");
                            out.print("<h2>" + nombre + "</h2>");
                            //out.print("<h2>" + reservas.get(0).getEmailUsuario() + "</h2>");
                        %>
                        <form method="post" action="VerReservas">
                            

                            <input type="submit" value="mis reservas" id="misreservas"  >
                        </form>
                        <a href="index.jsp"><h2 id="cerrarsesion">Cerrar sesión</h2></a>
                    </div>
            </div>

            <div id="cuadroreservas_restaurante">

                <div id="listareservas">
                    <ul id="lista">
                        <%
                            ArrayList<Reserva> reservas = (ArrayList<Reserva>) request.getAttribute("reservas");
                            ArrayList<Restaurante> restaurantes = (ArrayList<Restaurante>) request.getAttribute("restaurantes");
                            for (int i = 0; i < reservas.size(); i++) {
                                out.print("<li> <p> " + restaurantes.get(i).getNombre() + "</p> "
                                        + "<p> " + reservas.get(i).getFecha() + "</p>"
                                        + "<p> " + reservas.get(i).getHora() + "</p>");
                        %>
                        <input type="submit" value="cancelar reserva"></li> 
                        <%
                            }
                            //  for (int i=0; i<y; i++){
                            // String Sreserva = "<li> <p> "+ reservas.get(i).getEmailUsuario() + "</p> "

                            //out.print("<li><p>Maria</p> <p>Restaurante Italiani</p> <p>7/10/22</p>  <p>15:30</p>  <p>4 personas  </p><input type="submit" value="cancelar reserva"></li>"); 
%>
                    </ul>
                </div>
            </div>
        </div>
    </body>
</html>
