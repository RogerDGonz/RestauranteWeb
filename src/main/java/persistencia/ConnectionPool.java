package persistencia;

import java.sql.*;
import javax.sql.DataSource;
import javax.naming.InitialContext;

public class ConnectionPool {

    private static ConnectionPool pool = null;
    private static DataSource dataSource = null;

    public static ConnectionPool getInstance() {
        if (pool == null) {
            pool = new ConnectionPool();
        }
        return pool;
    }

    public Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        }
    }

    public void freeConnection(Connection c) {
        try {
            c.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }

    private ConnectionPool() {
        try {
            InitialContext ic = new InitialContext();
            dataSource = (DataSource) ic.lookup("java:/comp/env/jdbc/famelico");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
