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
import modelos.Restaurante;
import modelos.Usuario;
import persistencia.CategoriaDB;
import persistencia.RestauranteDB;

/**
 *
 * @author roger
 */
@WebServlet(name = "seleccionRestauranteServlet", urlPatterns = {"/seleccionRestauranteServlet"})
public class seleccionRestauranteServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        String url ="";
         RequestDispatcher dispatcher = null;
        ArrayList<Restaurante> restaurantes = RestauranteDB.getRestaurantes();
        if(usuario.isTipoUsuario()){
            //VerRestaurantesAdminServlet
            dispatcher = request.getRequestDispatcher("/VerRestaurantesAdminServlet");
            
            url="/seleccionRestauranteAdmin.jsp";
        }else{
            url="/seleccion_restaurante.jsp";
            request.setAttribute("categorias", CategoriaDB.getNombresCategorias());
            request.setAttribute("restaurantes", restaurantes);
            
        } 
            
        if(!usuario.isTipoUsuario())
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
