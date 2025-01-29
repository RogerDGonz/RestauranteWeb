package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import jdk.internal.org.jline.terminal.Size;
import modelos.Categoria;
import modelos.Restaurante;
import modelos.Mesa;
import modelos.Reserva;
import modelos.Usuario;
//import negocio.categoria;

public class RestauranteDB {

    public static ArrayList<Restaurante> getRestaurantesPorCategoria(ArrayList<String> categorias) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT DISTINCT(R.idRestaurante), R.nombre, R.direccion, R.descripcion FROM RESTAURANTE R, CATEGORIA C WHERE R.idRestaurante=C.idRestaurante and C.nombreCategoria = ?";
        ArrayList<Restaurante> res = new ArrayList<>();
        try {
            for (int i = 0; categorias.size() > i; i++) {
                ps = connection.prepareStatement(query);
                ps.setString(1, categorias.get(i));
                rs = ps.executeQuery();
                while (rs.next()) {
                    Restaurante rest = new Restaurante();
                    rest.setId(rs.getInt("idRESTAURANTE"));
                    rest.setNombre(rs.getString("nombre"));
                    rest.setDireccion(rs.getString("direccion"));
                    rest.setDescripcion(rs.getString("descripcion"));
                    res.add(rest);
                    
                }
            }
            rs.close();
            ps.close();
            pool.freeConnection(connection);
            return res;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
     public static ArrayList<Restaurante> getRestaurantes() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT R.* FROM RESTAURANTE R";
        ArrayList<Restaurante> res = new ArrayList<>();
        try {
                ps = connection.prepareStatement(query);
               
                rs = ps.executeQuery();
                while (rs.next()) {
                    Restaurante rest = new Restaurante();
                    rest.setId(rs.getInt("idRESTAURANTE"));
                    rest.setNombre(rs.getString("nombre"));
                    rest.setDireccion(rs.getString("direccion"));
                    rest.setDescripcion(rs.getString("descripcion"));
                    res.add(rest);
                }
            
            rs.close();
            ps.close();
            pool.freeConnection(connection);
            return res;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static int insertaRestaurante(Restaurante restaurante, Usuario user) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        String query ="INSERT INTO RESTAURANTE (idRESTAURANTE, nombre, direccion, descripcion, usuarioEmail) VALUES( ?,  ?,  ?, ?, ?)";

        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, restaurante.getId());
            ps.setString(2, restaurante.getNombre());
            ps.setString(3, restaurante.getDireccion());
            ps.setString(4, restaurante.getDescripcion());
            ps.setString(5, user.getEmail());
            int res = ps.executeUpdate();
            ps.close();
            pool.freeConnection(connection);
            return res;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static boolean compruebaExistenciaNombre(String nombre) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT nombre FROM Restaurante  WHERE nombre = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, nombre);
            rs = ps.executeQuery();
            boolean res = rs.next();
            rs.close();
            ps.close();
            pool.freeConnection(connection);
            return res;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }    

    public static Restaurante getRestaurante(int id) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query ="SELECT R.* FROM RESTAURANTE R WHERE R.idRestaurante= ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            Restaurante restaurante = null;
            if (rs.next()) {
                restaurante = new Restaurante();
                restaurante.setId(rs.getInt("idRestaurante"));
                restaurante.setNombre(rs.getString("nombre"));
                restaurante.setDireccion(rs.getString("direccion"));
                restaurante.setDescripcion(rs.getString("descripcion"));
            }
            rs.close();
            ps.close();
            pool.freeConnection(connection);
            return restaurante;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static Restaurante getRestaurantePorReserva(Reserva reserva) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query ="SELECT R.* FROM RESTAURANTE R, RESERVA S, MESA M WHERE R.idRestaurante = M.idRestaurante and M.idMesa = S.Mesa and S.idReserva = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, reserva.getId());
            rs = ps.executeQuery();
            Restaurante restaurante = null;
            if (rs.next()) {
                restaurante = new Restaurante();
              
                
                restaurante.setId(rs.getInt("idRESTAURANTE"));
                restaurante.setNombre(rs.getString("nombre"));
                restaurante.setDireccion(rs.getString("direccion"));
                restaurante.setDescripcion(rs.getString("descripcion"));
            }
            rs.close();
            ps.close();
            pool.freeConnection(connection);
            return restaurante;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
     public static ArrayList<Restaurante> getRestaurantePorUsuario(Usuario usuario) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query ="SELECT R.* FROM RESTAURANTE R WHERE  R.usuarioEmail = ?";
        ArrayList<Restaurante> restaurantes= new ArrayList<> ();
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, usuario.getEmail());
            rs = ps.executeQuery();
            Restaurante restaurante = null;
            while (rs.next()) {
                restaurante = new Restaurante();
              
                
                restaurante.setId(rs.getInt("idRESTAURANTE"));
                restaurante.setNombre(rs.getString("nombre"));
                restaurante.setDireccion(rs.getString("direccion"));
                restaurante.setDescripcion(rs.getString("descripcion"));
                restaurantes.add(restaurante);
            }
            rs.close();
            ps.close();
            pool.freeConnection(connection);
            return restaurantes;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
     
     public static Restaurante getRestaurantePorNombre(String nombre) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query ="SELECT R.* FROM RESTAURANTE R WHERE R.nombre= ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, nombre);
            rs = ps.executeQuery();
            Restaurante restaurante = null;
            if (rs.next()) {
                restaurante = new Restaurante();
                restaurante.setId(rs.getInt("idRestaurante"));
                restaurante.setNombre(rs.getString("nombre"));
                restaurante.setDireccion(rs.getString("direccion"));
                restaurante.setDescripcion(rs.getString("descripcion"));
            }
            rs.close();
            ps.close();
            pool.freeConnection(connection);
            return restaurante;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
     
     public static int getRestauranteLastIndex() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query ="SELECT R.* FROM RESTAURANTE R";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            Restaurante restaurante = null;
            int lastIndex=-1;
            while (rs.next()) {
                lastIndex=rs.getInt("idRESTAURANTE");
            }
            rs.close();
            ps.close();
            pool.freeConnection(connection);
            return lastIndex+1;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
    
}
