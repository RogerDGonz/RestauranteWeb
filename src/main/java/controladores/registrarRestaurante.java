/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelos.Categoria;
import modelos.Restaurante;
import modelos.Usuario;
import persistencia.CategoriaDB;
import persistencia.RestauranteDB;
import persistencia.UsuarioDB;

/**
 *
 * @author roger
 */
@WebServlet(name = "registrarRestaurante", urlPatterns = {"/registroRestaurante"})
public class registrarRestaurante extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String nombre = request.getParameter("nombre");
        String categorias = request.getParameter("categorias");
        String direccion = request.getParameter("direccion");
         response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        ArrayList<Restaurante> restaurantes = new ArrayList<>();
        Restaurante restaurante = new Restaurante();
        restaurante.setId(RestauranteDB.getRestauranteLastIndex());
        restaurante.setDireccion(direccion);
        restaurante.setNombre(nombre);
        RestauranteDB.insertaRestaurante(restaurante, usuario);
        String [] cats = categorias.split(",");
        for (int i = 0; i < cats.length; i++) {
            Categoria c =new Categoria();
            c.setId(CategoriaDB.getCategoriaLastIndex());
            c.setNombre(cats[i]);
            CategoriaDB.insertaCategoria(c, restaurante);
        }
    
        
        String url = "/seleccionRestauranteAdmin.jsp";
        RequestDispatcher dispatcher ;
        restaurantes.add(restaurante);
        request.setAttribute("restaurantes", restaurantes);
        dispatcher = request.getRequestDispatcher("VerRestaurantesAdminServlet");
         dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
