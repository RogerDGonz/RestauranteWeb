package controladores;

import persistencia.RestauranteDB;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import modelos.Usuario;
import persistencia.UsuarioDB;
import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;
import modelos.Restaurante;
import persistencia.CategoriaDB;

@WebServlet(name = "FiltradoCategoriaServlet", urlPatterns = {"/filtrado"})
public class FiltradoCategoriaServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            
            throws ServletException, IOException {
        ArrayList<String> categorias = new ArrayList<>();
        String url = "";
        ArrayList<String> nombresCategorias = CategoriaDB.getNombresCategorias();
        for (int i = 0; i < nombresCategorias.size(); i++) {
            String nombre = request.getParameter(nombresCategorias.get(i));
            if(nombre !=null){
                categorias.add(nombresCategorias.get(i));
            }
        }

        ArrayList<Restaurante> restaurantes = RestauranteDB.getRestaurantesPorCategoria(categorias);
       /* int[] contador= new int[restaurantes.size()]; 
        for (int i = 0; i < contador.length; i++) {
            contador[i]=restaurantes.get(i).getId();
        }
        contador.*/
    RequestDispatcher dispatcher;
        if (restaurantes == null) {
                
             dispatcher = request.getRequestDispatcher("/seleccionRestauranteServlet");
             url="/seleccion_restaurante.jsp";
        } else {
            request.setAttribute("categoriasCheck", categorias);
            request.setAttribute("categorias", CategoriaDB.getNombresCategorias());
            request.setAttribute("restaurantes", restaurantes);
            url = "/seleccion_restaurante_filtrada.jsp";
        }

// forward the request and response to the view
         dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);

    }
}
