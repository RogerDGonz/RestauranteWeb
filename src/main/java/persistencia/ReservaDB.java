package persistencia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import modelos.Mesa;
import modelos.Reserva;
import modelos.Restaurante;
import modelos.Usuario;


public class ReservaDB {
    
     public static int insertaReserva(Reserva reserva, Usuario usuario, Mesa mesa) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        String query ="INSERT INTO RESERVA (idReserva, email, idMesa, fecha, hora) VALUES( ?, ?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, reserva.getId());
            ps.setString(2, usuario.getEmail());
            ps.setInt(3, mesa.getId());
            ps.setDate(4, reserva.getFecha());
            ps.setTime(5, reserva.getHora());
            int res = ps.executeUpdate();
            ps.close();
            pool.freeConnection(connection);
            return res;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static ArrayList<Reserva> getReservasPorUsuario(Usuario usuario) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT R.* FROM RESERVA R WHERE R.email = ?";
        ArrayList<Reserva> res = new ArrayList<>();
        try {
                ps = connection.prepareStatement(query);
                ps.setString(1, usuario.getEmail());
                rs = ps.executeQuery();
                while(rs.next()) {
                    Reserva reserva = new Reserva();
                    reserva.setId(rs.getInt("idReserva"));
                    reserva.setFecha(rs.getDate("fecha"));
                    reserva.setHora(rs.getTime("hora"));
                    res.add(reserva);
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
    
    public static ArrayList<Reserva> getReservasDisponiblesEnFechaYHora(Restaurante restaurante, Date fechaBuscada, Time horaBuscada) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT S.* FROM Mesa M, Restaurante R, Reserva S WHERE R.idRestaurante = ? and R.idRestaurante = M.idRestaurante and M.idMesa = S.idMesa";
        ArrayList<Reserva> res = new ArrayList<>();
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, restaurante.getId());
            rs = ps.executeQuery();
            while(rs.next()){
                Reserva reserva = new Reserva();
                reserva.setId(rs.getInt("idReserva"));
                reserva.setFecha(rs.getDate("fecha"));
                reserva.setHora(rs.getTime("hora"));
                if(fechaBuscada.compareTo(reserva.getFecha())==0 && Math.abs(horaBuscada.getTime()-reserva.getHora().getTime())>3600000){
                    res.add(reserva);
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
    
    public static ArrayList<Reserva> getReservasDeRestaurante(Restaurante restaurante) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT S.* FROM Mesa M, Restaurante R, Reserva S WHERE R.idRestaurante = ? and R.idRestaurante = M.idRestaurante and M.idMesa = S.mesa";
        ArrayList<Reserva> res = new ArrayList<>();
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, restaurante.getId());
            rs = ps.executeQuery();
            while(rs.next()){
                Reserva reserva = new Reserva();
                reserva.setId(rs.getInt("idReserva"));
                reserva.setFecha(rs.getDate("fecha"));
                reserva.setHora(rs.getTime("hora"));
                res.add(reserva);
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
