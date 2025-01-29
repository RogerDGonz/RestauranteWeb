/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controladores;



/**
 *
 * @author roger
 *
@WebServlet(name = "RealizarReservasServlet", urlPatterns = {"/reservar"})
public class RealizarReservasServlet extends HttpServlet {

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int personas = Integer.parseInt(request.getParameter("personas"));
        LocalDateTime.
        ReservaDB.mesaDisponible(personas);
        ReservaDB.
        
        String contrasena = request.getParameter("contraseina");
        
        Usuario user = new Usuario();
        user.setEmail(email);
        user.setNombre(nombre);
        user.setContrasena(contrasena);
        user.setTipoUsuario(false);
        String url = "";
        if (UserDB.emailExists(user.getEmail())) {
            url = "/iniciar_sesion.html"; // mismo html pero con mensaje de error
        } else {
            UserDB.insertCliente(user);
            url = "/seleccion_restaurante.html";
// store the user in the session
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
        }
// forward the request and response to the view
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
*/