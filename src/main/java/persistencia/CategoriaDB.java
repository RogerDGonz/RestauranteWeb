package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelos.Categoria;
import modelos.Restaurante;

public class CategoriaDB {
    
    public static int insertaCategoria(Categoria categoria, Restaurante restaurante) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        String query ="INSERT INTO CATEGORIA (idCategoria, idRestaurante, nombreCategoria ) VALUES( ?,  ?,  ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, categoria.getId());
            ps.setInt(2, restaurante.getId());
            ps.setString(3, categoria.getNombre());
            int res = ps.executeUpdate();
            ps.close();
            pool.freeConnection(connection);
            return res;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public static int getCategoriaLastIndex() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query ="SELECT C.* FROM CATEGORIA C";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            Restaurante restaurante = null;
            int lastIndex=-1;
            while (rs.next()) {
                lastIndex=rs.getInt("idCATEGORIA");
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
    
    public static boolean compruebaExistenciaCategoria(String nombreCategoria) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT C.nombre FROM Categoria WHERE C.nombre = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, nombreCategoria);
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
    
    public static Categoria getCategoria(int idCategoria) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query ="SELECT C.* FROM Categoria C WHERE C.id=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, idCategoria);
            rs = ps.executeQuery();
            Categoria categoria = null;
            if (rs.next()) {
                categoria = new Categoria();
                categoria.setId(rs.getInt("idCategoria"));
                categoria.setNombre(rs.getString("nombre"));
            }
            rs.close();
            ps.close();
            pool.freeConnection(connection);
            return categoria;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static ArrayList<String> getNombresCategorias() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT DISTINCT (C.nombreCategoria) FROM Categoria C ";
        ArrayList<String> res = new ArrayList<>();
        try {
                ps = connection.prepareStatement(query);
               
                rs = ps.executeQuery();
                while (rs.next()) {
                   
                    res.add( rs.getString("nombreCategoria"));
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
    public static ArrayList<String> getNombresCategoriasRestaurante(Restaurante restaurante) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT C.* FROM CATEGORIA C WHERE C.idRestaurante=? ";
        ArrayList<String> res = new ArrayList<>();
        try {
                ps = connection.prepareStatement(query);
                rs = ps.executeQuery();
                while (rs.next()) {
                    res.add( rs.getString("nombreCategoria"));
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
}
