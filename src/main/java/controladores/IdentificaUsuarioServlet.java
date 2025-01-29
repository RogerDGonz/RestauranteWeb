package controladores;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import modelos.Usuario;
import persistencia.UsuarioDB;
import javax.servlet.annotation.WebServlet;
import persistencia.CategoriaDB;
import persistencia.RestauranteDB;

@WebServlet(name = "IdentificaUsuarioServlet", urlPatterns = {"/iniciarsesion"})
public class IdentificaUsuarioServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String contrasena = request.getParameter("con");
        Usuario user = new Usuario();
        String url = "";
        if (UsuarioDB.compruebaExistenciaEmail(email)) {
           
            user = UsuarioDB.getUsuario(email, contrasena);
            if (user == null) {
                request.setAttribute("fallo", "yes");
                url = "/iniciar_sesion.jsp";
            } else {
                if (user.isTipoUsuario()) {// si es admin
                    url = "/seleccionRestauranteAdmin.jsp";
                    HttpSession session = request.getSession();
                    session.setAttribute("usuario", user);
                } else {
                    request.setAttribute("categorias", CategoriaDB.getNombresCategorias());
                    request.setAttribute("restaurantes", RestauranteDB.getRestaurantes());
                    url = "/seleccion_restaurante.jsp";
                    HttpSession session = request.getSession();
                    session.setAttribute("usuario", user);
                }
            }

        } else {
            request.setAttribute("fallo", "yes");
            url = "/iniciar_sesion.jsp";

// store the user in the session
        }
// forward the request and response to the view
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        if (user!=null && user.isTipoUsuario()) {
            dispatcher = request.getRequestDispatcher("VerRestaurantesAdminServlet");
        }
        dispatcher.forward(request, response);
    }
}
