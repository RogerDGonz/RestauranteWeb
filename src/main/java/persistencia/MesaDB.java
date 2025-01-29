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

public class MesaDB {
    
    public static int insertaMesaRestaurante(Mesa mesa, Restaurante restaurante) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        String query ="INSERT INTO Mesa (idMesa, idRestaurante, capacidad) VALUES( ?,  ?,  ?)";

        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, mesa.getId());            
            ps.setInt(2, restaurante.getId());
            ps.setInt(3, mesa.getCapacidad());
            int res = ps.executeUpdate();
            ps.close();
            pool.freeConnection(connection);
            return res;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
        
        
    }
    
    
    public static Mesa mesaPorIdReserva(Reserva reserva){
     ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query ="SELECT M.* FROM MESA M, RESERVA R WHERE R.mesa=M.idMesa and R.idReserva=?";
        Mesa mesa = new Mesa();
         try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, reserva.getId());
            rs = ps.executeQuery();
            while(rs.next()){
                mesa.setId(rs.getInt("idMesa"));
                mesa.setCapacidad(rs.getInt("capacidad"));
                
            }
            rs.close();
            ps.close();
            pool.freeConnection(connection);
            return mesa;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    
    }
    
    
}
