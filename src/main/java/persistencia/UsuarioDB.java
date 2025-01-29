package persistencia;

import java.sql.*;
import modelos.Reserva;
import modelos.Usuario;

public class UsuarioDB {

    public static int insertaCliente(Usuario user) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        String query ="INSERT INTO USUARIO (email, nombre, contrasena, tipoUsuario) VALUES( ?,  ?,  ?, ?)";

        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getNombre());
            ps.setString(3, user.getContrasena());
            ps.setBoolean(4, user.isTipoUsuario());
            int res = ps.executeUpdate();
            ps.close();
            pool.freeConnection(connection);
            return res;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static boolean compruebaExistenciaEmail(String emailAddress) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT email FROM Usuario  WHERE email = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, emailAddress);
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
    
    public static boolean compruebaExistenciaUsuario(String username) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT nombre FROM Usuario  WHERE email = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, username);
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
    

    public static Usuario getUsuario(String emailAddress, String contrasena) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query ="SELECT U.* FROM USUARIO U WHERE U.email= ? and U.contrasena= ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, emailAddress);
            ps.setString(2, contrasena);
            rs = ps.executeQuery();
            Usuario user = null;
            if (rs.next()) {
                user = new Usuario();
                user.setEmail(rs.getString("email"));
                user.setNombre(rs.getString("nombre"));
                user.setContrasena(rs.getString("contrasena"));
                user.setTipoUsuario(rs.getBoolean("tipoUsuario"));
            }
            rs.close();
            ps.close();
            pool.freeConnection(connection);
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static Usuario getUsuarioPorReserva(Reserva reserva) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query ="SELECT U.* FROM USUARIO U, RESERVA R WHERE U.email=R.email and R.idReserva=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, reserva.getId());
            rs = ps.executeQuery();
            Usuario user = null;
            if (rs.next()) {
                user = new Usuario();
                user.setEmail(rs.getString("email"));
                user.setNombre(rs.getString("nombre"));
                user.setContrasena(rs.getString("contrasena"));
                user.setTipoUsuario(rs.getBoolean("tipoUsuario"));
            }
            rs.close();
            ps.close();
            pool.freeConnection(connection);
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
