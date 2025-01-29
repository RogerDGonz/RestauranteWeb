package controladores;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import modelos.Usuario;
import persistencia.UsuarioDB;
import javax.servlet.annotation.WebServlet;
@WebServlet(name = "RegistraUsuarioClienteServlet", urlPatterns = {"/registrocliente"})
public class RegistraUsuarioClienteServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String nombre = request.getParameter("nombre");
        String contrasena = request.getParameter("contrasena");
        
        Usuario user = new Usuario();
        user.setEmail(email);
        user.setNombre(nombre);
        user.setContrasena(contrasena);
        user.setTipoUsuario(false);
        String url = "";
        if (UsuarioDB.compruebaExistenciaEmail(user.getEmail())) {
            url = "/iniciar_sesion.jsp"; // mismo html pero con mensaje de error
        } else {
            UsuarioDB.insertaCliente(user);
            url = "/seleccion_restaurante.jsp";
// store the user in the session
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
        }
// forward the request and response to the view
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
